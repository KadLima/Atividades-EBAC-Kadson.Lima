package br.com.ebac.memelandia.services;

import br.com.ebac.memelandia.config.ClienteServicoUsuarios;
import br.com.ebac.memelandia.entities.CategoriaMeme;
import br.com.ebac.memelandia.repositories.RepositorioCategoriaMeme;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class ServicoCategoria {

    private static final Logger log = LoggerFactory.getLogger(ServicoCategoria.class);

    private final RepositorioCategoriaMeme repositorio;
    private final ClienteServicoUsuarios clienteUsuarios;
    private final Counter categoriasCriadasCounter;
    private final Counter buscarTodasCounter;
    private final Counter usuarioInvalidoCounter;

    @Autowired
    public ServicoCategoria(RepositorioCategoriaMeme repositorio,
                            ClienteServicoUsuarios clienteUsuarios,
                            MeterRegistry meterRegistry) {
        this.repositorio = repositorio;
        this.clienteUsuarios = clienteUsuarios;
        this.categoriasCriadasCounter = Counter.builder("memelandia.categorias.criadas")
                .description("Total de categorias cadastradas")
                .register(meterRegistry);
        this.buscarTodasCounter = Counter.builder("memelandia.categorias.buscas.todas")
                .description("Total de listagens de categorias")
                .register(meterRegistry);
        this.usuarioInvalidoCounter = Counter.builder("memelandia.categorias.usuario_invalido")
                .description("Tentativas com usuário inexistente")
                .register(meterRegistry);
    }

    public List<CategoriaMeme> listaTodasCategorias() {
        log.info("Listando todas as categorias");
        buscarTodasCounter.increment();
        List<CategoriaMeme> categorias = repositorio.findAll();
        log.info("Total de categorias encontradas: {}", categorias.size());
        return categorias;
    }

    public CategoriaMeme buscaPorId(Long id) {
        log.info("Buscando categoria id={}", id);
        return repositorio.findById(id)
                .orElseThrow(() -> {
                    log.warn("Categoria não encontrada: id={}", id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "Categoria não encontrada: id=" + id);
                });
    }

    public CategoriaMeme novaCategoria(CategoriaMeme categoria) {
        log.info("Criando nova categoria: nome='{}', usuarioId={}",
                categoria.getNome(), categoria.getUsuarioId());

        if (categoria.getUsuarioId() == null) {
            log.warn("usuarioId não informado ao criar categoria");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "usuarioId é obrigatório");
        }

        if (!clienteUsuarios.usuarioExiste(categoria.getUsuarioId())) {
            usuarioInvalidoCounter.increment();
            log.warn("Categoria rejeitada: usuário id={} não existe", categoria.getUsuarioId());
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Usuário não encontrado: id=" + categoria.getUsuarioId());
        }

        if (categoria.getDataCadastro() == null) {
            categoria.setDataCadastro(Date.valueOf(LocalDate.now()));
        }

        CategoriaMeme salva = repositorio.save(categoria);
        categoriasCriadasCounter.increment();
        log.info("Categoria criada com sucesso: id={}, nome='{}'", salva.getId(), salva.getNome());
        return salva;
    }
}

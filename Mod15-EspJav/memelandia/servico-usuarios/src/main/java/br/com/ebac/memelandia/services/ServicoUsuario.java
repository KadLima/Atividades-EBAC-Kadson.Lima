package br.com.ebac.memelandia.services;

import br.com.ebac.memelandia.entities.Usuario;
import br.com.ebac.memelandia.repositories.RepositorioUsuario;
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
public class ServicoUsuario {

    private static final Logger log = LoggerFactory.getLogger(ServicoUsuario.class);

    private final RepositorioUsuario repositorioUsuario;
    private final Counter usuariosCriadosCounter;
    private final Counter buscarTodosCounter;
    private final Counter buscarPorIdCounter;

    @Autowired
    public ServicoUsuario(RepositorioUsuario repositorioUsuario, MeterRegistry meterRegistry) {
        this.repositorioUsuario = repositorioUsuario;
        this.usuariosCriadosCounter = Counter.builder("memelandia.usuarios.criados")
                .description("Total de usuários cadastrados")
                .register(meterRegistry);
        this.buscarTodosCounter = Counter.builder("memelandia.usuarios.buscas.todos")
                .description("Total de listagens de todos os usuários")
                .register(meterRegistry);
        this.buscarPorIdCounter = Counter.builder("memelandia.usuarios.buscas.por_id")
                .description("Total de buscas por ID de usuário")
                .register(meterRegistry);
    }

    public List<Usuario> listaTodosUsuarios() {
        log.info("Listando todos os usuários");
        buscarTodosCounter.increment();
        List<Usuario> usuarios = repositorioUsuario.findAll();
        log.info("Total de usuários encontrados: {}", usuarios.size());
        return usuarios;
    }

    public Usuario buscaPorId(Long id) {
        log.info("Buscando usuário com id={}", id);
        buscarPorIdCounter.increment();
        return repositorioUsuario.findById(id)
                .orElseThrow(() -> {
                    log.warn("Usuário não encontrado: id={}", id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "Usuário não encontrado: id=" + id);
                });
    }

    public Usuario novoUsuario(Usuario usuario) {
        log.info("Criando novo usuário: email={}", usuario.getEmail());

        if (repositorioUsuario.findByEmail(usuario.getEmail()).isPresent()) {
            log.warn("Tentativa de cadastro com e-mail já existente: {}", usuario.getEmail());
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "E-mail já cadastrado: " + usuario.getEmail());
        }

        if (usuario.getDataCadastro() == null) {
            usuario.setDataCadastro(Date.valueOf(LocalDate.now()));
        }

        Usuario salvo = repositorioUsuario.save(usuario);
        usuariosCriadosCounter.increment();
        log.info("Usuário criado com sucesso: id={}, email={}", salvo.getId(), salvo.getEmail());
        return salvo;
    }
}

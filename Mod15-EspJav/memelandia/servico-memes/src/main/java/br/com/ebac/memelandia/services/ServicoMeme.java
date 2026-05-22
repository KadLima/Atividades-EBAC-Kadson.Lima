package br.com.ebac.memelandia.services;

import br.com.ebac.memelandia.config.ClientesServicosExternos;
import br.com.ebac.memelandia.entities.Meme;
import br.com.ebac.memelandia.repositories.RepositorioMeme;
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
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ServicoMeme {

    private static final Logger log = LoggerFactory.getLogger(ServicoMeme.class);

    private final RepositorioMeme repositorio;
    private final ClientesServicosExternos clientesExternos;

    private final Counter memesCriadosCounter;
    private final Counter buscarTodosCounter;
    private final Counter memesDoDiaCounter;
    private final Counter validacaoFalhouCounter;

    @Autowired
    public ServicoMeme(RepositorioMeme repositorio,
                       ClientesServicosExternos clientesExternos,
                       MeterRegistry meterRegistry) {
        this.repositorio = repositorio;
        this.clientesExternos = clientesExternos;
        this.memesCriadosCounter = Counter.builder("memelandia.memes.criados")
                .description("Total de memes cadastrados")
                .register(meterRegistry);
        this.buscarTodosCounter = Counter.builder("memelandia.memes.buscas.todos")
                .description("Total de listagens de memes")
                .register(meterRegistry);
        this.memesDoDiaCounter = Counter.builder("memelandia.memes.meme_do_dia")
                .description("Total de requisições ao meme do dia")
                .register(meterRegistry);
        this.validacaoFalhouCounter = Counter.builder("memelandia.memes.validacao_falhou")
                .description("Tentativas de criação com usuário ou categoria inválidos")
                .register(meterRegistry);
    }

    public List<Meme> listaTodosMemes() {
        log.info("Listando todos os memes");
        buscarTodosCounter.increment();
        List<Meme> memes = repositorio.findAll();
        log.info("Total de memes encontrados: {}", memes.size());
        return memes;
    }

    public Meme buscaPorId(Long id) {
        log.info("Buscando meme id={}", id);
        return repositorio.findById(id)
                .orElseThrow(() -> {
                    log.warn("Meme não encontrado: id={}", id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "Meme não encontrado: id=" + id);
                });
    }

    /**
     * Bônus: retorna um meme aleatório da base — o "Meme do Dia".
     */
    public Meme memeDodia() {
        log.info("Sorteando meme do dia");
        memesDoDiaCounter.increment();

        List<Meme> todos = repositorio.findAll();
        if (todos.isEmpty()) {
            log.warn("Meme do dia solicitado mas não há memes cadastrados");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Nenhum meme cadastrado ainda. Seja o primeiro! 🐸");
        }

        int indice = ThreadLocalRandom.current().nextInt(todos.size());
        Meme sorteado = todos.get(indice);
        log.info("Meme do dia sorteado: id={}, nome='{}'", sorteado.getId(), sorteado.getNome());
        return sorteado;
    }

    public Meme novoMeme(Meme meme) {
        log.info("Criando novo meme: nome='{}', usuarioId={}, categoriaId={}",
                meme.getNome(), meme.getUsuarioId(), meme.getCategoriaId());

        validarCamposObrigatorios(meme);

        // Valida usuário no servico-usuarios
        if (!clientesExternos.usuarioExiste(meme.getUsuarioId())) {
            validacaoFalhouCounter.increment();
            log.warn("Meme rejeitado: usuário id={} não existe", meme.getUsuarioId());
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Usuário não encontrado: id=" + meme.getUsuarioId());
        }

        // Valida categoria no servico-categorias
        if (!clientesExternos.categoriaExiste(meme.getCategoriaId())) {
            validacaoFalhouCounter.increment();
            log.warn("Meme rejeitado: categoria id={} não existe", meme.getCategoriaId());
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Categoria não encontrada: id=" + meme.getCategoriaId());
        }

        if (meme.getDataCadastro() == null) {
            meme.setDataCadastro(Date.valueOf(LocalDate.now()));
        }

        Meme salvo = repositorio.save(meme);
        memesCriadosCounter.increment();
        log.info("Meme criado com sucesso: id={}, nome='{}'", salvo.getId(), salvo.getNome());
        return salvo;
    }

    private void validarCamposObrigatorios(Meme meme) {
        if (meme.getUsuarioId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "usuarioId é obrigatório");
        }
        if (meme.getCategoriaId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "categoriaId é obrigatório");
        }
        if (meme.getUrlMidia() == null || meme.getUrlMidia().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "urlMidia é obrigatória");
        }
    }
}

package br.com.ebac.memelandia.controllers;

import br.com.ebac.memelandia.entities.Meme;
import br.com.ebac.memelandia.services.ServicoMeme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/memes")
public class ControllerMeme {

    private static final Logger log = LoggerFactory.getLogger(ControllerMeme.class);

    @Autowired
    private ServicoMeme servicoMeme;

    @GetMapping
    public List<Meme> listarMemes() {
        MDC.put("requestId", UUID.randomUUID().toString());
        log.info("GET /memes - iniciando listagem");
        try {
            List<Meme> resultado = servicoMeme.listaTodosMemes();
            log.info("GET /memes - retornando {} memes", resultado.size());
            return resultado;
        } finally {
            MDC.clear();
        }
    }

    @GetMapping("/{id}")
    public Meme buscarPorId(@PathVariable Long id) {
        MDC.put("requestId", UUID.randomUUID().toString());
        log.info("GET /memes/{} - buscando meme", id);
        try {
            Meme meme = servicoMeme.buscaPorId(id);
            log.info("GET /memes/{} - meme encontrado: nome='{}'", id, meme.getNome());
            return meme;
        } finally {
            MDC.clear();
        }
    }

    /**
     * Bônus: GET /memes/meme-do-dia — retorna um meme aleatório.
     * Mapeado ANTES de /{id} para não ser tratado como ID de path.
     */
    @GetMapping("/meme-do-dia")
    public Meme memeDodia() {
        MDC.put("requestId", UUID.randomUUID().toString());
        log.info("GET /memes/meme-do-dia - sorteando meme");
        try {
            Meme sorteado = servicoMeme.memeDodia();
            log.info("GET /memes/meme-do-dia - meme sorteado: id={}", sorteado.getId());
            return sorteado;
        } finally {
            MDC.clear();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Meme criarMeme(@RequestBody Meme meme) {
        MDC.put("requestId", UUID.randomUUID().toString());
        log.info("POST /memes - criando meme: nome='{}', usuarioId={}, categoriaId={}",
                meme.getNome(), meme.getUsuarioId(), meme.getCategoriaId());
        try {
            Meme salvo = servicoMeme.novoMeme(meme);
            log.info("POST /memes - meme criado: id={}", salvo.getId());
            return salvo;
        } finally {
            MDC.clear();
        }
    }
}

package br.com.ebac.memelandia.controllers;

import br.com.ebac.memelandia.entities.CategoriaMeme;
import br.com.ebac.memelandia.services.ServicoCategoria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categorias")
public class ControllerCategoria {

    private static final Logger log = LoggerFactory.getLogger(ControllerCategoria.class);

    @Autowired
    private ServicoCategoria servicoCategoria;

    @GetMapping
    public List<CategoriaMeme> listarCategorias() {
        MDC.put("requestId", UUID.randomUUID().toString());
        log.info("GET /categorias - iniciando listagem");
        try {
            List<CategoriaMeme> resultado = servicoCategoria.listaTodasCategorias();
            log.info("GET /categorias - retornando {} categorias", resultado.size());
            return resultado;
        } finally {
            MDC.clear();
        }
    }

    @GetMapping("/{id}")
    public CategoriaMeme buscarPorId(@PathVariable Long id) {
        MDC.put("requestId", UUID.randomUUID().toString());
        log.info("GET /categorias/{} - buscando categoria", id);
        try {
            CategoriaMeme categoria = servicoCategoria.buscaPorId(id);
            log.info("GET /categorias/{} - categoria encontrada: nome='{}'", id, categoria.getNome());
            return categoria;
        } finally {
            MDC.clear();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaMeme criarCategoria(@RequestBody CategoriaMeme categoriaMeme) {
        MDC.put("requestId", UUID.randomUUID().toString());
        log.info("POST /categorias - criando categoria: nome='{}', usuarioId={}",
                categoriaMeme.getNome(), categoriaMeme.getUsuarioId());
        try {
            CategoriaMeme salva = servicoCategoria.novaCategoria(categoriaMeme);
            log.info("POST /categorias - categoria criada: id={}", salva.getId());
            return salva;
        } finally {
            MDC.clear();
        }
    }
}

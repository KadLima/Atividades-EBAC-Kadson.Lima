package br.com.ebac.memelandia.controllers;

import br.com.ebac.memelandia.entities.Usuario;
import br.com.ebac.memelandia.services.ServicoUsuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class ControllerUsuario {

    private static final Logger log = LoggerFactory.getLogger(ControllerUsuario.class);

    @Autowired
    private ServicoUsuario servicoUsuario;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        MDC.put("requestId", UUID.randomUUID().toString());
        log.info("GET /usuarios - iniciando listagem");
        try {
            List<Usuario> resultado = servicoUsuario.listaTodosUsuarios();
            log.info("GET /usuarios - retornando {} usuários", resultado.size());
            return resultado;
        } finally {
            MDC.clear();
        }
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        MDC.put("requestId", UUID.randomUUID().toString());
        log.info("GET /usuarios/{} - buscando usuário", id);
        try {
            Usuario usuario = servicoUsuario.buscaPorId(id);
            log.info("GET /usuarios/{} - usuário encontrado: email={}", id, usuario.getEmail());
            return usuario;
        } finally {
            MDC.clear();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        MDC.put("requestId", UUID.randomUUID().toString());
        log.info("POST /usuarios - criando usuário: email={}", usuario.getEmail());
        try {
            Usuario salvo = servicoUsuario.novoUsuario(usuario);
            log.info("POST /usuarios - usuário criado: id={}", salvo.getId());
            return salvo;
        } finally {
            MDC.clear();
        }
    }
}

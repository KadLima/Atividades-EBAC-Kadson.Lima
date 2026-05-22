package br.com.ebac.memelandia;

import br.com.ebac.memelandia.entities.Usuario;
import br.com.ebac.memelandia.services.ServicoUsuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServicoUsuariosApplicationTests {

    @Autowired
    private ServicoUsuario servicoUsuario;

    @Test
    void contextLoads() {
    }

    @Test
    void deveCriarUsuarioComSucesso() {
        Usuario u = new Usuario();
        u.setNome("Meme Lord");
        u.setEmail("memelord@memelandia.com");
        u.setDataCadastro(Date.valueOf(LocalDate.now()));

        Usuario salvo = servicoUsuario.novoUsuario(u);

        assertNotNull(salvo.getId());
        assertEquals("memelord@memelandia.com", salvo.getEmail());
    }

    @Test
    void deveRejeitarEmailDuplicado() {
        Usuario u1 = new Usuario();
        u1.setNome("Primeiro");
        u1.setEmail("duplicado@memelandia.com");
        u1.setDataCadastro(Date.valueOf(LocalDate.now()));
        servicoUsuario.novoUsuario(u1);

        Usuario u2 = new Usuario();
        u2.setNome("Segundo");
        u2.setEmail("duplicado@memelandia.com");
        u2.setDataCadastro(Date.valueOf(LocalDate.now()));

        ResponseStatusException ex = assertThrows(ResponseStatusException.class,
                () -> servicoUsuario.novoUsuario(u2));
        assertEquals(HttpStatus.CONFLICT, ex.getStatusCode());
    }

    @Test
    void deveLancarNotFoundParaIdInexistente() {
        ResponseStatusException ex = assertThrows(ResponseStatusException.class,
                () -> servicoUsuario.buscaPorId(99999L));
        assertEquals(HttpStatus.NOT_FOUND, ex.getStatusCode());
    }
}

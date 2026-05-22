package br.com.ebac.memelandia;

import br.com.ebac.memelandia.config.ClienteServicoUsuarios;
import br.com.ebac.memelandia.entities.CategoriaMeme;
import br.com.ebac.memelandia.services.ServicoCategoria;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class ServicoCategoriasApplicationTests {

    @Autowired
    private ServicoCategoria servicoCategoria;

    // Mock do cliente REST para não precisar do servico-usuarios rodando nos testes
    @MockBean
    private ClienteServicoUsuarios clienteServicoUsuarios;

    @Test
    void contextLoads() {
    }

    @Test
    void deveCriarCategoriaComUsuarioValido() {
        when(clienteServicoUsuarios.usuarioExiste(1L)).thenReturn(true);

        CategoriaMeme c = new CategoriaMeme();
        c.setNome("Memes de Programação");
        c.setDescricao("Para quem sofre com NullPointerException");
        c.setUsuarioId(1L);
        c.setDataCadastro(Date.valueOf(LocalDate.now()));

        CategoriaMeme salva = servicoCategoria.novaCategoria(c);

        assertNotNull(salva.getId());
        assertEquals("Memes de Programação", salva.getNome());
    }

    @Test
    void deveRejeitarCategoriaComUsuarioInexistente() {
        when(clienteServicoUsuarios.usuarioExiste(anyLong())).thenReturn(false);

        CategoriaMeme c = new CategoriaMeme();
        c.setNome("Categoria Órfã");
        c.setDescricao("Sem dono");
        c.setUsuarioId(999L);
        c.setDataCadastro(Date.valueOf(LocalDate.now()));

        ResponseStatusException ex = assertThrows(ResponseStatusException.class,
                () -> servicoCategoria.novaCategoria(c));
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, ex.getStatusCode());
    }

    @Test
    void deveLancarNotFoundParaCategoriaInexistente() {
        ResponseStatusException ex = assertThrows(ResponseStatusException.class,
                () -> servicoCategoria.buscaPorId(99999L));
        assertEquals(HttpStatus.NOT_FOUND, ex.getStatusCode());
    }
}

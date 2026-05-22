package br.com.ebac.memelandia;

import br.com.ebac.memelandia.config.ClientesServicosExternos;
import br.com.ebac.memelandia.entities.Meme;
import br.com.ebac.memelandia.services.ServicoMeme;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ServicoMemesApplicationTests {

    @Autowired
    private ServicoMeme servicoMeme;

    @MockBean
    private ClientesServicosExternos clientesServicosExternos;

    @Test
    void contextLoads() {
    }

    @Test
    void deveCriarMemeComDadosValidos() {
        when(clientesServicosExternos.usuarioExiste(1L)).thenReturn(true);
        when(clientesServicosExternos.categoriaExiste(1L)).thenReturn(true);

        Meme m = buildMeme("Drakeposting", 1L, 1L);
        Meme salvo = servicoMeme.novoMeme(m);

        assertNotNull(salvo.getId());
        assertEquals("Drakeposting", salvo.getNome());
    }

    @Test
    void deveRejeitarMemeComUsuarioInexistente() {
        when(clientesServicosExternos.usuarioExiste(99L)).thenReturn(false);
        when(clientesServicosExternos.categoriaExiste(1L)).thenReturn(true);

        ResponseStatusException ex = assertThrows(ResponseStatusException.class,
                () -> servicoMeme.novoMeme(buildMeme("Meme sem dono", 99L, 1L)));
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, ex.getStatusCode());
    }

    @Test
    void deveRejeitarMemeComCategoriaInexistente() {
        when(clientesServicosExternos.usuarioExiste(1L)).thenReturn(true);
        when(clientesServicosExternos.categoriaExiste(99L)).thenReturn(false);

        ResponseStatusException ex = assertThrows(ResponseStatusException.class,
                () -> servicoMeme.novoMeme(buildMeme("Meme sem categoria", 1L, 99L)));
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, ex.getStatusCode());
    }

    @Test
    void deveLancarNotFoundNoMemeDodiaSemMemes() {
        ResponseStatusException ex = assertThrows(ResponseStatusException.class,
                () -> servicoMeme.memeDodia());
        assertEquals(HttpStatus.NOT_FOUND, ex.getStatusCode());
    }

    @Test
    void deveRetornarMemeDodiaCom1Meme() {
        when(clientesServicosExternos.usuarioExiste(1L)).thenReturn(true);
        when(clientesServicosExternos.categoriaExiste(1L)).thenReturn(true);

        servicoMeme.novoMeme(buildMeme("This is fine", 1L, 1L));

        Meme sorteado = servicoMeme.memeDodia();
        assertNotNull(sorteado);
        assertEquals("This is fine", sorteado.getNome());
    }

    private Meme buildMeme(String nome, Long usuarioId, Long categoriaId) {
        Meme m = new Meme();
        m.setNome(nome);
        m.setDescricao("Descrição de " + nome);
        m.setUrlMidia("https://i.imgur.com/exemplo.jpg");
        m.setUsuarioId(usuarioId);
        m.setCategoriaId(categoriaId);
        m.setDataCadastro(Date.valueOf(LocalDate.now()));
        return m;
    }
}

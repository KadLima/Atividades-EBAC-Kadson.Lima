package br.com.kadson.vendas_online;

import br.com.kadson.dao.IProdutoDAO;
import br.com.kadson.dao.ProdutoDAO;
import domain.Produto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {

    private IProdutoDAO produtoDAO;

    @Test
    public void cadastrarTest() throws Exception {

        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Notebook");
        produto.setValor(3500.0);

        Integer countCad = produtoDAO.cadastrar(produto);

        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("10");

        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getValor(), produtoBD.getValor());

        Integer countDel = produtoDAO.excluir(produtoBD);

        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTest() throws Exception {

        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Notebook");
        produto.setValor(3500.0);

        Integer countCad = produtoDAO.cadastrar(produto);

        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("10");

        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getValor(), produtoBD.getValor());

        Integer countDel = produtoDAO.excluir(produtoBD);

        assertTrue(countDel == 1);
    }

    @Test
    public void excluirTest() throws Exception {

        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Notebook");
        produto.setValor(3500.0);

        Integer countCad = produtoDAO.cadastrar(produto);

        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("10");

        assertNotNull(produtoBD);

        Integer countDel = produtoDAO.excluir(produtoBD);

        assertTrue(countDel == 1);

        Produto produtoExcluido = produtoDAO.buscar("10");

        assertNull(produtoExcluido);
    }

    @Test
    public void buscarTodosTest() throws Exception {

        produtoDAO = new ProdutoDAO();

        Produto produto1 = new Produto();
        produto1.setCodigo("10");
        produto1.setNome("Notebook");
        produto1.setValor(3500.0);

        Integer countCad1 = produtoDAO.cadastrar(produto1);

        assertTrue(countCad1 == 1);

        Produto produto2 = new Produto();
        produto2.setCodigo("20");
        produto2.setNome("Mouse");
        produto2.setValor(150.0);

        Integer countCad2 = produtoDAO.cadastrar(produto2);

        assertTrue(countCad2 == 1);

        List<Produto> list = produtoDAO.buscarTodos();

        assertNotNull(list);
        assertEquals(2, list.size());

        int countDel = 0;

        for (Produto prod : list) {
            produtoDAO.excluir(prod);
            countDel++;
        }

        assertEquals(list.size(), countDel);

        list = produtoDAO.buscarTodos();

        assertEquals(0, list.size());
    }

    @Test
    public void atualizarTest() throws Exception {

        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Notebook");
        produto.setValor(3500.0);

        Integer countCad = produtoDAO.cadastrar(produto);

        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("10");

        assertNotNull(produtoBD);

        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getValor(), produtoBD.getValor());

        produtoBD.setCodigo("20");
        produtoBD.setNome("Teclado");
        produtoBD.setValor(250.0);

        Integer countUpdate = produtoDAO.atualizar(produtoBD);

        assertTrue(countUpdate == 1);

        Produto produtoBD1 = produtoDAO.buscar("10");

        assertNull(produtoBD1);

        Produto produtoBD2 = produtoDAO.buscar("20");

        assertNotNull(produtoBD2);

        assertEquals(produtoBD.getId(), produtoBD2.getId());
        assertEquals(produtoBD.getCodigo(), produtoBD2.getCodigo());
        assertEquals(produtoBD.getNome(), produtoBD2.getNome());
        assertEquals(produtoBD.getValor(), produtoBD2.getValor());

        List<Produto> list = produtoDAO.buscarTodos();

        for (Produto prod : list) {
            produtoDAO.excluir(prod);
        }
    }
}


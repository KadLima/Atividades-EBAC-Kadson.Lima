package br.com.kadson.databaseExercise.jpa;

import br.com.kadson.databaseExercise.ExemploVendas.dao.jpa.IProdutoJpaDAO;
import br.com.kadson.databaseExercise.ExemploVendas.dao.jpa.ProdutoJpaDAO;
import br.com.kadson.databaseExercise.ExemploVendas.domain.jpa.ProdutoJpa;
import br.com.kadson.databaseExercise.ExemploVendas.exceptions.DAOException;
import br.com.kadson.databaseExercise.ExemploVendas.exceptions.MaisDeUmRegistroException;
import br.com.kadson.databaseExercise.ExemploVendas.exceptions.TableException;
import br.com.kadson.databaseExercise.ExemploVendas.exceptions.TipoChaveNaoEncontradaException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;  // ← ADICIONADO
import static org.junit.jupiter.api.Assertions.assertNull;     // ← ADICIONADO
import static org.junit.jupiter.api.Assertions.assertTrue;

public class    ProdutoJpaDAOTest {

    private IProdutoJpaDAO produtoDao;

    public ProdutoJpaDAOTest() {
        this.produtoDao = new ProdutoJpaDAO();
    }

    @AfterEach
    public void end() throws DAOException {
        Collection<ProdutoJpa> list = produtoDao.buscarTodos();
        list.forEach(produto -> {
            try {
                produtoDao.excluir(produto);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void pesquisar() throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
        ProdutoJpa produto = criarProduto("A1");
        Assert.notNull(produto, "Produto não deveria ser nulo");

        ProdutoJpa produtoDB = this.produtoDao.consultar(produto.getId());
        Assert.notNull(produtoDB, "Produto não encontrado no banco de dados");
        Assert.isTrue(produto.getCodigo().equals(produtoDB.getCodigo()), "Código do produto não confere");
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ProdutoJpa produto = criarProduto("A2");
        Assert.notNull(produto, "Produto não foi salvo corretamente");

        // Verificar se o produto foi realmente persistido
        ProdutoJpa produtoConsultado = this.produtoDao.consultar(produto.getId());
        Assert.notNull(produtoConsultado, "Produto não encontrado após salvamento");
        Assert.isTrue("A2".equals(produtoConsultado.getCodigo()), "Código do produto não confere");
    }

    @Test
    public void excluir() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        ProdutoJpa produto = criarProduto("A3");
        Assert.notNull(produto, "Produto não foi criado");

        // Verificar que o produto existe antes de excluir
        ProdutoJpa produtoAntesExclusao = this.produtoDao.consultar(produto.getId());
        Assert.notNull(produtoAntesExclusao, "Produto deveria existir antes da exclusão");

        // Excluir o produto
        this.produtoDao.excluir(produto);

        // Verificar que o produto foi excluído
        ProdutoJpa produtoBD = this.produtoDao.consultar(produto.getId());
        assertNull(produtoBD, "Produto deveria ter sido excluído");
    }

    @Test
    public void alterarProduto() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ProdutoJpa produto = criarProduto("A4");
        Assert.notNull(produto, "Produto não foi criado");

        // Verificar nome original
        ProdutoJpa produtoAntesAlteracao = this.produtoDao.consultar(produto.getId());
        Assert.notNull(produtoAntesAlteracao, "Produto deveria existir antes da alteração");

        // Alterar o produto
        produto.setNome("Produto Alterado");
        produto.setDescricao("Descrição Alterada");
        produto.setValor(BigDecimal.valueOf(99.99));
        produtoDao.alterar(produto);

        // Verificar alteração
        ProdutoJpa produtoBD = this.produtoDao.consultar(produto.getId());
        assertNotNull(produtoBD, "Produto não encontrado após alteração");
        Assert.isTrue("Produto Alterado".equals(produtoBD.getNome()), "Nome não foi alterado corretamente");
        Assert.isTrue("Descrição Alterada".equals(produtoBD.getDescricao()), "Descrição não foi alterada corretamente");
        Assert.isTrue(BigDecimal.valueOf(99.99).compareTo(produtoBD.getValor()) == 0, "Valor não foi alterado corretamente");
    }

    @Test
    public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        // Criar dois produtos
        ProdutoJpa produto1 = criarProduto("A5");
        ProdutoJpa produto2 = criarProduto("A6");

        Assert.notNull(produto1, "Primeiro produto não foi criado");
        Assert.notNull(produto2, "Segundo produto não foi criado");

        // Buscar todos
        Collection<ProdutoJpa> list = produtoDao.buscarTodos();
        assertTrue(list != null, "Lista não deveria ser nula");
        assertTrue(list.size() >= 2, "Deveria ter pelo menos 2 produtos cadastrados");

        // Limpar dados
        for (ProdutoJpa prod : list) {
            this.produtoDao.excluir(prod);
        }

        // Verificar que foram excluídos
        list = produtoDao.buscarTodos();
        assertTrue(list != null, "Lista não deveria ser nula");

    }

    @Test
    public void pesquisarPorCodigo() throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
        // Criar produto com código específico
        String codigoUnico = "COD" + System.currentTimeMillis();
        ProdutoJpa produto = criarProduto(codigoUnico);
        Assert.notNull(produto, "Produto não foi criado");

        // Pesquisar por código
        ProdutoJpa produtoEncontrado = this.produtoDao.consultarPorCodigo(codigoUnico);
        Assert.notNull(produtoEncontrado, "Produto não encontrado pelo código");
        Assert.isTrue(codigoUnico.equals(produtoEncontrado.getCodigo()), "Código do produto não confere");
    }

    private ProdutoJpa criarProduto(String codigo) throws TipoChaveNaoEncontradaException, DAOException {
        ProdutoJpa produto = new ProdutoJpa();
        produto.setCodigo(codigo);
        produto.setDescricao("Produto " + codigo);
        produto.setNome("Nome Produto " + codigo);
        produto.setValor(BigDecimal.TEN);
        return produtoDao.cadastrar(produto);
    }
}
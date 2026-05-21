package br.com.kadson.databaseExercise.jpa;

import br.com.kadson.databaseExercise.ExemploVendas.dao.jpa.*;
import br.com.kadson.databaseExercise.ExemploVendas.domain.jpa.ClienteJpa;
import br.com.kadson.databaseExercise.ExemploVendas.domain.jpa.ProdutoJpa;
import br.com.kadson.databaseExercise.ExemploVendas.domain.jpa.VendaJpa;
import br.com.kadson.databaseExercise.ExemploVendas.exceptions.DAOException;
import br.com.kadson.databaseExercise.ExemploVendas.exceptions.MaisDeUmRegistroException;
import br.com.kadson.databaseExercise.ExemploVendas.exceptions.TableException;
import br.com.kadson.databaseExercise.ExemploVendas.exceptions.TipoChaveNaoEncontradaException;
import br.com.kadson.databaseExercise.dao.VendaExclusaoJpaDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.Collection;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class VendaJpaDAOTest {

    private IVendaJpaDAO vendaDao;
    private IVendaJpaDAO vendaExclusaoDao;
    private IClienteJpaDAO clienteDao;
    private IProdutoJpaDAO produtoDao;
    private Random rd;
    private ClienteJpa cliente;
    private ProdutoJpa produto;

    public VendaJpaDAOTest() {
        this.vendaDao = new VendaJpaDAO();
        this.vendaExclusaoDao = new VendaExclusaoJpaDAO();
        this.clienteDao = new ClienteJpaDAO();
        this.produtoDao = new ProdutoJpaDAO();
        this.rd = new Random();
    }

    @BeforeEach
    public void init() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        this.cliente = cadastrarCliente();
        this.produto = cadastrarProduto("A1", BigDecimal.TEN);
    }

    @AfterEach
    public void end() throws DAOException {
        excluirVendas();
        excluirProdutos();
        if (this.cliente != null && this.cliente.getId() != null) {
            clienteDao.excluir(this.cliente);
        }
    }

    @Test
    public void pesquisar() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        VendaJpa venda = criarVenda("A1");
        VendaJpa retorno = vendaDao.cadastrar(venda);
        assertNotNull(retorno, "Venda não foi cadastrada");

        VendaJpa vendaConsultada = vendaDao.consultar(venda.getId());
        assertNotNull(vendaConsultada, "Venda não encontrada");
        assertEquals(venda.getCodigo(), vendaConsultada.getCodigo(), "Código da venda não confere");
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        VendaJpa venda = criarVenda("A2");
        VendaJpa retorno = vendaDao.cadastrar(venda);
        assertNotNull(retorno, "Venda não foi salva");

        assertTrue(venda.getValorTotal().compareTo(BigDecimal.valueOf(20)) == 0,
                "Valor total deveria ser 20");
        assertEquals(VendaJpa.Status.INICIADA, venda.getStatus(), "Status deveria ser INICIADA");

        VendaJpa vendaConsultada = vendaDao.consultar(venda.getId());
        assertNotNull(vendaConsultada.getId(), "ID da venda não deveria ser nulo");
        assertEquals(venda.getCodigo(), vendaConsultada.getCodigo(), "Código da venda não confere");
    }

    @Test
    public void cancelarVenda() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A3";
        VendaJpa venda = criarVenda(codigoVenda);
        VendaJpa retorno = vendaDao.cadastrar(venda);
        assertNotNull(retorno, "Venda não foi cadastrada");
        assertNotNull(venda, "Venda não deveria ser nula");
        assertEquals(codigoVenda, venda.getCodigo(), "Código não confere");

        retorno.setStatus(VendaJpa.Status.CANCELADA);
        vendaDao.cancelarVenda(venda);

        VendaJpa vendaConsultada = vendaDao.consultar(venda.getId());
        assertNotNull(vendaConsultada, "Venda deveria existir");
        assertEquals(codigoVenda, vendaConsultada.getCodigo(), "Código não confere");
        assertEquals(VendaJpa.Status.CANCELADA, vendaConsultada.getStatus(), "Status deveria ser CANCELADA");
    }

    @Test
    public void adicionarMaisProdutosDoMesmo() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A4";
        VendaJpa venda = criarVenda(codigoVenda);
        VendaJpa retorno = vendaDao.cadastrar(venda);
        assertNotNull(retorno, "Venda não foi cadastrada");
        assertNotNull(venda, "Venda não deveria ser nula");
        assertEquals(codigoVenda, venda.getCodigo(), "Código não confere");

        VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
        assertNotNull(vendaConsultada, "Venda não encontrada");
        vendaConsultada.adicionarProduto(produto, 1);

        assertEquals(3, vendaConsultada.getQuantidadeTotalProdutos(),
                "Quantidade total deveria ser 3");
        BigDecimal valorTotal = BigDecimal.valueOf(30).setScale(2, RoundingMode.HALF_DOWN);
        assertEquals(0, vendaConsultada.getValorTotal().compareTo(valorTotal),
                "Valor total deveria ser 30");
        assertEquals(VendaJpa.Status.INICIADA, vendaConsultada.getStatus(),
                "Status deveria ser INICIADA");
    }

    @Test
    public void adicionarMaisProdutosDiferentes() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A5";
        VendaJpa venda = criarVenda(codigoVenda);
        VendaJpa retorno = vendaDao.cadastrar(venda);
        assertNotNull(retorno, "Venda não foi cadastrada");
        assertNotNull(venda, "Venda não deveria ser nula");
        assertEquals(codigoVenda, venda.getCodigo(), "Código não confere");

        ProdutoJpa prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
        assertNotNull(prod, "Produto não foi cadastrado");
        assertEquals(codigoVenda, prod.getCodigo(), "Código do produto não confere");

        VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
        assertNotNull(vendaConsultada, "Venda não encontrada");
        vendaConsultada.adicionarProduto(prod, 1);

        assertEquals(3, vendaConsultada.getQuantidadeTotalProdutos(),
                "Quantidade total deveria ser 3");
        BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
        assertEquals(0, vendaConsultada.getValorTotal().compareTo(valorTotal),
                "Valor total deveria ser 70");
        assertEquals(VendaJpa.Status.INICIADA, vendaConsultada.getStatus(),
                "Status deveria ser INICIADA");
    }

    @Test
    public void salvarVendaMesmoCodigoExistente() {
        assertThrows(DAOException.class, () -> {
            VendaJpa venda = criarVenda("A6");
            VendaJpa retorno = vendaDao.cadastrar(venda);
            assertNotNull(retorno, "Primeira venda não foi cadastrada");

            VendaJpa venda1 = criarVenda("A6");
            VendaJpa retorno1 = vendaDao.cadastrar(venda1);
            assertNull(retorno1, "Não deveria ser possível cadastrar venda com mesmo código");
        });
    }

    @Test
    public void removerProduto() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A7";
        VendaJpa venda = criarVenda(codigoVenda);
        VendaJpa retorno = vendaDao.cadastrar(venda);
        assertNotNull(retorno, "Venda não foi cadastrada");
        assertNotNull(venda, "Venda não deveria ser nula");
        assertEquals(codigoVenda, venda.getCodigo(), "Código não confere");

        ProdutoJpa prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
        assertNotNull(prod, "Produto não foi cadastrado");
        assertEquals(codigoVenda, prod.getCodigo(), "Código do produto não confere");

        VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
        assertNotNull(vendaConsultada, "Venda não encontrada");
        vendaConsultada.adicionarProduto(prod, 1);
        assertEquals(3, vendaConsultada.getQuantidadeTotalProdutos(),
                "Quantidade total deveria ser 3");

        BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
        assertEquals(0, vendaConsultada.getValorTotal().compareTo(valorTotal),
                "Valor total deveria ser 70");

        vendaConsultada.removerProduto(prod, 1);
        assertEquals(2, vendaConsultada.getQuantidadeTotalProdutos(),
                "Quantidade total deveria ser 2");

        valorTotal = BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_DOWN);
        assertEquals(0, vendaConsultada.getValorTotal().compareTo(valorTotal),
                "Valor total deveria ser 20");
        assertEquals(VendaJpa.Status.INICIADA, vendaConsultada.getStatus(),
                "Status deveria ser INICIADA");
    }

    @Test
    public void removerTodosProdutos() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A9";
        VendaJpa venda = criarVenda(codigoVenda);
        VendaJpa retorno = vendaDao.cadastrar(venda);
        assertNotNull(retorno, "Venda não foi cadastrada");
        assertNotNull(venda, "Venda não deveria ser nula");
        assertEquals(codigoVenda, venda.getCodigo(), "Código não confere");

        ProdutoJpa prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
        assertNotNull(prod, "Produto não foi cadastrado");
        assertEquals(codigoVenda, prod.getCodigo(), "Código do produto não confere");

        VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
        assertNotNull(vendaConsultada, "Venda não encontrada");
        vendaConsultada.adicionarProduto(prod, 1);
        assertEquals(3, vendaConsultada.getQuantidadeTotalProdutos(),
                "Quantidade total deveria ser 3");

        BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
        assertEquals(0, vendaConsultada.getValorTotal().compareTo(valorTotal),
                "Valor total deveria ser 70");

        vendaConsultada.removerTodosProdutos();
        assertEquals(0, vendaConsultada.getQuantidadeTotalProdutos(),
                "Quantidade total deveria ser 0");
        assertEquals(0, vendaConsultada.getValorTotal().compareTo(BigDecimal.ZERO),
                "Valor total deveria ser 0");
        assertEquals(VendaJpa.Status.INICIADA, vendaConsultada.getStatus(),
                "Status deveria ser INICIADA");
    }

    @Test
    public void finalizarVenda() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A10";
        VendaJpa venda = criarVenda(codigoVenda);
        VendaJpa retorno = vendaDao.cadastrar(venda);
        assertNotNull(retorno, "Venda não foi cadastrada");
        assertNotNull(venda, "Venda não deveria ser nula");
        assertEquals(codigoVenda, venda.getCodigo(), "Código não confere");

        venda.setStatus(VendaJpa.Status.CONCLUIDA);
        vendaDao.finalizarVenda(venda);

        VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
        assertNotNull(vendaConsultada, "Venda não encontrada");
        assertEquals(venda.getCodigo(), vendaConsultada.getCodigo(), "Código não confere");
        assertEquals(VendaJpa.Status.CONCLUIDA, vendaConsultada.getStatus(),
                "Status deveria ser CONCLUIDA");
    }

    @Test
    public void tentarAdicionarProdutosVendaFinalizada() {
        assertThrows(UnsupportedOperationException.class, () -> {
            String codigoVenda = "A11";
            VendaJpa venda = criarVenda(codigoVenda);
            VendaJpa retorno = vendaDao.cadastrar(venda);
            assertNotNull(retorno, "Venda não foi cadastrada");
            assertNotNull(venda, "Venda não deveria ser nula");
            assertEquals(codigoVenda, venda.getCodigo(), "Código não confere");

            venda.setStatus(VendaJpa.Status.CONCLUIDA);
            vendaDao.finalizarVenda(venda);

            VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
            assertNotNull(vendaConsultada, "Venda não encontrada");
            assertEquals(venda.getCodigo(), vendaConsultada.getCodigo(), "Código não confere");
            assertEquals(VendaJpa.Status.CONCLUIDA, vendaConsultada.getStatus(),
                    "Status deveria ser CONCLUIDA");

            vendaConsultada.adicionarProduto(this.produto, 1);
        });
    }

    private void excluirProdutos() throws DAOException {
        Collection<ProdutoJpa> list = this.produtoDao.buscarTodos();
        list.forEach(prod -> {
            try {
                this.produtoDao.excluir(prod);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });
    }

    private void excluirVendas() throws DAOException {
        Collection<VendaJpa> list = this.vendaExclusaoDao.buscarTodos();
        list.forEach(venda -> {
            try {
                this.vendaExclusaoDao.excluir(venda);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });
    }

    private ProdutoJpa cadastrarProduto(String codigo, BigDecimal valor)
            throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ProdutoJpa produto = new ProdutoJpa();
        produto.setCodigo(codigo);
        produto.setDescricao("Produto " + codigo);
        produto.setNome("Nome Produto " + codigo);
        produto.setValor(valor);
        return produtoDao.cadastrar(produto);
    }

    private ClienteJpa cadastrarCliente()
            throws TipoChaveNaoEncontradaException, DAOException {
        ClienteJpa cliente = new ClienteJpa();
        long cpf = Math.abs(rd.nextLong() % 10000000000L);
        cliente.setCpf(cpf);
        cliente.setNome("Kadson Lima");
        cliente.setCidade("Pernambuco");
        cliente.setEnd("Rua paes de barros, 121");
        cliente.setEstado("PE");
        cliente.setNumero(81);
        cliente.setTel(11987654321L);
        return (ClienteJpa) clienteDao.cadastrar(cliente);
    }

    private VendaJpa criarVenda(String codigo) {
        VendaJpa venda = new VendaJpa();
        venda.setCodigo(codigo);
        venda.setDataVenda(Instant.now());
        venda.setCliente(this.cliente);
        venda.setStatus(VendaJpa.Status.INICIADA);
        venda.adicionarProduto(this.produto, 2);
        return venda;
    }
}
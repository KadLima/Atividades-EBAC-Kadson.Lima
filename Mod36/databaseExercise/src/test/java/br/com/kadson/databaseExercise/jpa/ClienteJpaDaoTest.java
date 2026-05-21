package br.com.kadson.databaseExercise.jpa;

import br.com.kadson.databaseExercise.ExemploVendas.dao.jpa.ClienteJpaDAO;
import br.com.kadson.databaseExercise.ExemploVendas.dao.jpa.IClienteJpaDAO;
import br.com.kadson.databaseExercise.ExemploVendas.domain.jpa.ClienteJpa;
import br.com.kadson.databaseExercise.ExemploVendas.exceptions.DAOException;
import br.com.kadson.databaseExercise.ExemploVendas.exceptions.MaisDeUmRegistroException;
import br.com.kadson.databaseExercise.ExemploVendas.exceptions.TableException;
import br.com.kadson.databaseExercise.ExemploVendas.exceptions.TipoChaveNaoEncontradaException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import java.util.Collection;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClienteJpaDaoTest {

    private IClienteJpaDAO<ClienteJpa> clienteDao;
    private Random rd;

    public ClienteJpaDaoTest() {
        this.clienteDao = new ClienteJpaDAO();
        this.rd = new Random();
    }

    @AfterEach
    public void end() throws DAOException {
        Collection<ClienteJpa> list = clienteDao.buscarTodos();
        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void pesquisarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ClienteJpa cliente = criarCliente();
        clienteDao.cadastrar(cliente);

        ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
        Assert.notNull(clienteConsultado, "Cliente não deveria ser nulo");
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = clienteDao.cadastrar(cliente);
        Assert.notNull(retorno, "Retorno do cadastro não deveria ser nulo");

        ClienteJpa clienteConsultado = clienteDao.consultar(retorno.getId());
        Assert.notNull(clienteConsultado, "Cliente consultado não deveria ser nulo");

        clienteDao.excluir(cliente);

        ClienteJpa clienteConsultado1 = clienteDao.consultar(retorno.getId());
        Assert.isNull(clienteConsultado1, "Cliente deveria ter sido excluído");
    }

    @Test
    public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = clienteDao.cadastrar(cliente);
        Assert.notNull(retorno, "Cadastro não deveria ser nulo");

        ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
        Assert.notNull(clienteConsultado, "Cliente deveria existir antes da exclusão");

        clienteDao.excluir(cliente);
        clienteConsultado = clienteDao.consultar(cliente.getId());
        Assert.isNull(clienteConsultado, "Cliente não deveria existir após exclusão");
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = clienteDao.cadastrar(cliente);
        Assert.notNull(retorno, "Cadastro falhou");

        ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
        Assert.notNull(clienteConsultado, "Cliente deveria existir");

        clienteConsultado.setNome("Rodrigo Pires");
        clienteDao.alterar(clienteConsultado);

        ClienteJpa clienteAlterado = clienteDao.consultar(clienteConsultado.getId());
        Assert.notNull(clienteAlterado, "Cliente alterado não deveria ser nulo");
        Assert.isTrue("Rodrigo Pires".equals(clienteAlterado.getNome()), "Nome não foi alterado corretamente");

        clienteDao.excluir(cliente);
        clienteConsultado = clienteDao.consultar(clienteAlterado.getId());
        Assert.isNull(clienteConsultado, "Cliente deveria ter sido excluído");
    }

    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = clienteDao.cadastrar(cliente);
        Assert.notNull(retorno, "Primeiro cliente não foi cadastrado");

        ClienteJpa cliente1 = criarCliente();
        ClienteJpa retorno1 = clienteDao.cadastrar(cliente1);
        Assert.notNull(retorno1, "Segundo cliente não foi cadastrado");

        Collection<ClienteJpa> list = clienteDao.buscarTodos();
        assertTrue(list != null, "Lista não deveria ser nula");
        assertTrue(list.size() >= 2, "Deveria ter pelo menos 2 clientes cadastrados");

        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });

        Collection<ClienteJpa> list1 = clienteDao.buscarTodos();
        assertTrue(list1 != null, "Lista não deveria ser nula");

    }

    private ClienteJpa criarCliente() {
        ClienteJpa cliente = new ClienteJpa();
        long cpf = Math.abs(rd.nextLong() % 10000000000L);
        cliente.setCpf(cpf);
        cliente.setNome("Kadson");
        cliente.setCidade("Pernambuco");
        cliente.setEnd("Rua A, 123");
        cliente.setEstado("PE");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        return cliente;
    }
}
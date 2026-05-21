package br.com.kadson.databaseExercise.jpa;

import br.com.kadson.databaseExercise.ExemploVendas.dao.jpa.ClienteJpaDAO;
import br.com.kadson.databaseExercise.ExemploVendas.dao.jpa.ClienteJpaDB2DAO;
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

public class ClienteJpaDao2BancosTest {

    private IClienteJpaDAO<ClienteJpa> clienteDao;
    private IClienteJpaDAO<ClienteJpa> clienteDB2Dao;
    private Random rd;

    public ClienteJpaDao2BancosTest() {
        this.clienteDao = new ClienteJpaDAO();
        this.clienteDB2Dao = new ClienteJpaDB2DAO();
        this.rd = new Random();
    }

    @AfterEach
    public void end() throws DAOException {
        Collection<ClienteJpa> list1 = clienteDao.buscarTodos();
        excluir1(list1);

        Collection<ClienteJpa> list2 = clienteDB2Dao.buscarTodos();
        excluir2(list2);
    }

    private void excluir1(Collection<ClienteJpa> list) {
        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });
    }

    private void excluir2(Collection<ClienteJpa> list) {
        list.forEach(cli -> {
            try {
                clienteDB2Dao.excluir(cli);
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

        ClienteJpa cliente2 = criarCliente();
        clienteDB2Dao.cadastrar(cliente2);

        ClienteJpa clienteConsultado2 = clienteDB2Dao.consultar(cliente2.getId());
        Assert.notNull(clienteConsultado2, "Cliente DB2 não deveria ser nulo");
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
        Assert.isNull(clienteConsultado1, "Cliente excluído ainda existe");
    }

    @Test
    public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = clienteDao.cadastrar(cliente);
        Assert.notNull(retorno, "Retorno do cadastro não deveria ser nulo");

        ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
        Assert.notNull(clienteConsultado, "Cliente consultado não deveria ser nulo");

        clienteDao.excluir(cliente);
        clienteConsultado = clienteDao.consultar(cliente.getId());
        Assert.isNull(clienteConsultado, "Cliente excluído ainda existe no banco");
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = clienteDao.cadastrar(cliente);
        Assert.notNull(retorno, "Retorno do cadastro não deveria ser nulo");

        ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
        Assert.notNull(clienteConsultado, "Cliente consultado não deveria ser nulo");

        clienteConsultado.setNome("Rodrigo Pires");
        clienteDao.alterar(clienteConsultado);

        ClienteJpa clienteAlterado = clienteDao.consultar(clienteConsultado.getId());
        Assert.notNull(clienteAlterado, "Cliente alterado não deveria ser nulo");
        Assert.isTrue("Rodrigo Pires".equals(clienteAlterado.getNome()), "Nome não foi alterado corretamente");

        clienteDao.excluir(cliente);
        clienteConsultado = clienteDao.consultar(clienteAlterado.getId());
        Assert.isNull(clienteConsultado, "Cliente ainda existe após exclusão");
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
        assertTrue(list.size() == 2, "Deveria ter 2 clientes na lista");

        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });

        Collection<ClienteJpa> list1 = clienteDao.buscarTodos();
        assertTrue(list1 != null, "Lista não deveria ser nula");
        assertTrue(list1.size() == 0, "Lista deveria estar vazia");
    }

    private ClienteJpa criarCliente() {
        ClienteJpa cliente = new ClienteJpa();
        cliente.setCpf(Math.abs(rd.nextLong() % 10000000000L));
        cliente.setNome("Kadson");
        cliente.setCidade("Pernambuco");
        cliente.setEnd("End");
        cliente.setEstado("PE");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        return cliente;
    }
}
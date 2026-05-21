package br.com.kadson.databaseExercise.jpa;

import br.com.kadson.databaseExercise.ExemploVendas.dao.jpa.ClienteJpaDAO;
import br.com.kadson.databaseExercise.ExemploVendas.dao.jpa.ClienteJpaDB2DAO;
import br.com.kadson.databaseExercise.ExemploVendas.dao.jpa.ClienteJpaDB3DAO;
import br.com.kadson.databaseExercise.ExemploVendas.dao.jpa.IClienteJpaDAO;
import br.com.kadson.databaseExercise.ExemploVendas.domain.jpa.ClienteJpa;
import br.com.kadson.databaseExercise.ExemploVendas.domain.jpa.ClienteJpa2;
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

public class ClienteJpaDao3BancosTest {

    private IClienteJpaDAO<ClienteJpa> clienteDao;
    private IClienteJpaDAO<ClienteJpa> clienteDB2Dao;
    private IClienteJpaDAO<ClienteJpa2> clienteDB3Dao;
    private Random rd;

    public ClienteJpaDao3BancosTest() {
        this.clienteDao = new ClienteJpaDAO();
        this.clienteDB2Dao = new ClienteJpaDB2DAO();
        this.clienteDB3Dao = new ClienteJpaDB3DAO();
        this.rd = new Random();
    }

    @AfterEach
    public void end() throws DAOException {
        // Limpar dados do primeiro banco
        Collection<ClienteJpa> list = clienteDao.buscarTodos();
        excluir(list, clienteDao);

        // Limpar dados do segundo banco
        Collection<ClienteJpa> list2 = clienteDB2Dao.buscarTodos();
        excluir(list2, clienteDB2Dao);

        // Limpar dados do terceiro banco
        Collection<ClienteJpa2> list3 = clienteDB3Dao.buscarTodos();
        excluir3(list3);
    }

    private void excluir(Collection<ClienteJpa> list, IClienteJpaDAO<ClienteJpa> clienteDao) {
        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });
    }

    private void excluir3(Collection<ClienteJpa2> list) {
        list.forEach(cli -> {
            try {
                clienteDB3Dao.excluir(cli);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void pesquisarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        // Teste no primeiro banco (PostgreSQL)
        ClienteJpa cliente = criarCliente();
        clienteDao.cadastrar(cliente);

        // Assumindo que o ID é gerado automaticamente após o cadastro
        ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
        Assert.notNull(clienteConsultado, "Cliente do primeiro banco não deveria ser nulo");

        // Teste no segundo banco (DB2)
        ClienteJpa cliente2 = criarCliente();
        clienteDB2Dao.cadastrar(cliente2);

        ClienteJpa clienteConsultado2 = clienteDB2Dao.consultar(cliente2.getId());
        Assert.notNull(clienteConsultado2, "Cliente do segundo banco não deveria ser nulo");

        // Teste no terceiro banco (MongoDB ou outro)
        ClienteJpa2 cliente3 = criarCliente2();
        clienteDB3Dao.cadastrar(cliente3);

        ClienteJpa2 clienteConsultado3 = clienteDB3Dao.consultar(cliente3.getId());
        Assert.notNull(clienteConsultado3, "Cliente do terceiro banco não deveria ser nulo");
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        // Teste de salvamento no primeiro banco
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = clienteDao.cadastrar(cliente);
        Assert.notNull(retorno, "Cadastro no primeiro banco falhou");

        ClienteJpa clienteConsultado = clienteDao.consultar(retorno.getId());
        Assert.notNull(clienteConsultado, "Cliente não encontrado no primeiro banco");

        clienteDao.excluir(cliente);

        ClienteJpa clienteConsultado1 = clienteDao.consultar(retorno.getId());
        Assert.isNull(clienteConsultado1, "Cliente ainda existe no primeiro banco após exclusão");

        // Teste de salvamento no segundo banco
        ClienteJpa cliente2 = criarCliente();
        ClienteJpa retorno2 = clienteDB2Dao.cadastrar(cliente2);
        Assert.notNull(retorno2, "Cadastro no segundo banco falhou");

        clienteDB2Dao.excluir(cliente2);

        // Teste de salvamento no terceiro banco
        ClienteJpa2 cliente3 = criarCliente2();
        ClienteJpa2 retorno3 = clienteDB3Dao.cadastrar(cliente3);
        Assert.notNull(retorno3, "Cadastro no terceiro banco falhou");

        clienteDB3Dao.excluir(cliente3);
    }

    @Test
    public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        // Teste de exclusão no primeiro banco
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = clienteDao.cadastrar(cliente);
        Assert.notNull(retorno, "Cadastro falhou");

        ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
        Assert.notNull(clienteConsultado, "Cliente deveria existir");

        clienteDao.excluir(cliente);
        clienteConsultado = clienteDao.consultar(cliente.getId());
        Assert.isNull(clienteConsultado, "Cliente deveria ter sido excluído");
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        // Teste de alteração no primeiro banco
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = clienteDao.cadastrar(cliente);
        Assert.notNull(retorno, "Cadastro falhou");

        ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
        Assert.notNull(clienteConsultado, "Cliente deveria existir");

        clienteConsultado.setNome("Rodrigo Pires");
        clienteDao.alterar(clienteConsultado);

        ClienteJpa clienteAlterado = clienteDao.consultar(clienteConsultado.getId());
        Assert.notNull(clienteAlterado, "Cliente alterado deveria existir");
        Assert.isTrue("Rodrigo Pires".equals(clienteAlterado.getNome()), "Nome não foi alterado corretamente");

        clienteDao.excluir(cliente);
        clienteConsultado = clienteDao.consultar(clienteAlterado.getId());
        Assert.isNull(clienteConsultado, "Cliente deveria ter sido excluído");
    }

    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
        // Teste de busca em todos os bancos
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = clienteDao.cadastrar(cliente);
        Assert.notNull(retorno, "Primeiro cliente não cadastrado");

        ClienteJpa cliente1 = criarCliente();
        ClienteJpa retorno1 = clienteDao.cadastrar(cliente1);
        Assert.notNull(retorno1, "Segundo cliente não cadastrado");

        Collection<ClienteJpa> list = clienteDao.buscarTodos();
        assertTrue(list != null, "Lista não deveria ser nula");
        assertTrue(list.size() >= 2, "Deveria ter pelo menos 2 clientes");

        // Limpar dados
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
        cliente.setEnd("End");
        cliente.setEstado("PE");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        return cliente;
    }

    private ClienteJpa2 criarCliente2() {
        ClienteJpa2 cliente = new ClienteJpa2();
        long cpf = Math.abs(rd.nextLong() % 10000000000L);
        cliente.setCpf(cpf);
        cliente.setNome("Kadson");
        cliente.setCidade("Pernambuco");
        cliente.setEnd("End");
        cliente.setEstado("PE");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        return cliente;
    }
}
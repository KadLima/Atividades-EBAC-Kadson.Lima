package Test;

import DAO.ClienteDAO;
import DAO.ClienteDAOMock;
import DAO.IClienteDAO;
import Service.ClienteService;
import org.junit.Assert;
import org.junit.Test;
/**
 * Created by Kadson Lima on 26/01/2025
 *
 * @author Kadson Lima
 */

public class ClienteServiceTest {

    @Test
    public void salvarTeste(){
        IClienteDAO mockDAO = new ClienteDAOMock();
        ClienteService service = new ClienteService(mockDAO);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarTest(){
        IClienteDAO mockDAO = new ClienteDAO();
        ClienteService service = new ClienteService(mockDAO);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }
}

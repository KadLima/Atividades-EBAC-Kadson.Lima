package Test;

import DAO.ContratoDAO;
import DAO.IContratoDAO;
import DAO.Mocks.ContradoDAOMock;
import Service.ContratoService;
import Service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Kadson Lima on 26/01/2025
 *
 * @author Kadson Lima
 */

public class ContratoServiceTeste {
    @Test
    public void salvarTeste() {
        IContratoDAO dao = new ContradoDAOMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test
    public void buscarTeste() {
        IContratoDAO dao = new ContradoDAOMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.buscar("123");
        Assert.assertEquals("Contrato encontrado com ID: 123", retorno);
    }

    @Test
    public void excluirTeste() {
        IContratoDAO dao = new ContradoDAOMock();
        IContratoService service = new ContratoService(dao);
        boolean retorno = service.excluir("123");
        Assert.assertFalse(retorno);
    }

    @Test
    public void atualizarTeste() {
        IContratoDAO dao = new ContradoDAOMock();
        IContratoService service = new ContratoService(dao);
        boolean retorno = service.atualizar("123");
        Assert.assertFalse(retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarComBancoDeDadosTest() {
        IContratoDAO dao = new ContratoDAO();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }
}

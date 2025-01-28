package Service;

import DAO.IClienteDAO;

/**
 * Created by Kadson Lima on 13/11/2024
 *
 * @author Kadson Lima
 */

public class ClienteService {
    private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO){
        this.clienteDAO = clienteDAO;
    }
    public String salvar(){
        clienteDAO.salvar();
        return "Sucesso";
    }
}

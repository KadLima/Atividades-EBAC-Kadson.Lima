package Service;

import DAO.IContratoDAO;

/**
 * Created by Kadson Lima on 26/01/2025
 *
 * @author Kadson Lima
 */
public class ContratoService implements IContratoService {

    private IContratoDAO contratoDAO;

    public ContratoService(IContratoDAO dao) {
        this.contratoDAO = dao;
    }

    @Override
    public String salvar() {
        contratoDAO.salvar();
        return "Sucesso";
    }

    @Override
    public String buscar(String id) {
        return contratoDAO.buscar(id);
    }

    @Override
    public boolean excluir(String id) {
        return contratoDAO.excluir(id);
    }

    @Override
    public boolean atualizar(String id) {
        return contratoDAO.atualizar(id);
    }
}

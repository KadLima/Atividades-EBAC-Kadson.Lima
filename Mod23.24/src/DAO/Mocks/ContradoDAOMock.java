package DAO.Mocks;

import DAO.IContratoDAO;

/**
 * Created by Kadson Lima on 13/11/2024
 *
 * @author Kadson Lima
 */
public class ContradoDAOMock implements IContratoDAO {
    @Override
    public void salvar() {

    }

    @Override
    public String buscar(String id) {
        return "Contrato encontrato com ID: " + id;
    }

    @Override
    public boolean excluir(String id) {
        return false;
    }

    @Override
    public boolean atualizar(String id) {
        return false;
    }
}

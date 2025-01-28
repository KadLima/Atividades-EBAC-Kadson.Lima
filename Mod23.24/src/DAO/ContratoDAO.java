package DAO;

/**
 * Created by Kadson Lima on 13/11/2024
 *
 * @author Kadson Lima
 */
public class ContratoDAO implements IContratoDAO{
    @Override
    public void salvar() {
        throw new UnsupportedOperationException("Não funciona com o banco");
    }

    @Override
    public String buscar(String id) {
        return "";
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

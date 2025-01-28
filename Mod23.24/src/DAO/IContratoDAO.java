package DAO;

/**
 * Created by Kadson Lima on 13/11/2024
 *
 * @author Kadson Lima
 */

public interface IContratoDAO {
    void salvar();

    String buscar(String id);

    boolean excluir(String id);

    boolean atualizar(String id);
}

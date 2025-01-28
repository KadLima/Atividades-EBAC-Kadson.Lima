package Service;

/**
 * Created by Kadson Lima on 26/01/2025
 *
 * @author Kadson Lima
 */
public interface IContratoService {
    String salvar();

    String buscar(String id);

    boolean excluir(String id);

    boolean atualizar(String id);
}

package Cliente;

/**
 * Created by Kadson Lima on 26/01/2025
 * @author Kadson Lima
 */

public class TesteCliente {
    String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarNome(String nome) {
        System.out.println("Chamando adicionarNome com: " + nome);
    }
}

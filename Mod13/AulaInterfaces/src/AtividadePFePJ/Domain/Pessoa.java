package AtividadePFePJ.Domain;

/**
 * Created by Kadson Lima on 25/09/2024
 *
 * @author Kadson Lima
 */

public abstract class Pessoa {
   private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalização() {
        return localização;
    }

    public void setLocalização(String localização) {
        this.localização = localização;
    }

    private String localização;
}

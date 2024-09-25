package AtividadePFePJ.SubClasses;

import AtividadePFePJ.Domain.Pessoa;

/**
 * Created by Kadson Lima on 25/09/2024
 *
 * @author Kadson Lima
 */

public class PessoaFísica extends Pessoa {
    private String numCPF;

    private int idade;

    public String getNumCPF() {
        return numCPF;
    }

    public void setNumCPF(String numCPF) {
        this.numCPF = numCPF;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}

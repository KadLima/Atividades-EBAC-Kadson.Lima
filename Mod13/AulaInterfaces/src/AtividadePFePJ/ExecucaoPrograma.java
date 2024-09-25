package AtividadePFePJ;

import AtividadePFePJ.SubClasses.PessoaFísica;
import AtividadePFePJ.SubClasses.PessoaJurídica;

/**
 * Created by Kadson Lima on 25/09/2024
 *
 * @author Kadson Lima
 */

public class ExecucaoPrograma {
    public static void main(String[] args) {
        PessoaFísica pessoaFísica = new PessoaFísica();

        pessoaFísica.setNome("Kadson");
        pessoaFísica.setLocalização("Recife - PE");
        pessoaFísica.setNumCPF("25789436547");
        pessoaFísica.setIdade(23);

        System.out.println("A Pessoa Física, " + pessoaFísica.getNome() + "," + " cujo Nº de CPF é: " + pessoaFísica.getNumCPF()
                + ", tem " + pessoaFísica.getIdade() + " anos, " + "e possui moradia em " + pessoaFísica.getLocalização() + "\n");


        PessoaJurídica pessoaJurídica = new PessoaJurídica();

        pessoaJurídica.setNome("Food in Time - LTA");
        pessoaJurídica.setLocalização("Guarulhos - SP");
        pessoaJurídica.setAnoDeCriacaoDaEmpresa(2001);
        pessoaJurídica.setClassificaçãoDePorte("Médio Porte");


        System.out.println("A Pessoa Jurídica, " + pessoaJurídica.getNome() + ", localizada em " + pessoaJurídica.getLocalização()
                + ", criada no ano de " + pessoaJurídica.getAnoDeCriacaoDaEmpresa() + ", possui " + pessoaJurídica.getClassificaçãoDePorte());

    }
}

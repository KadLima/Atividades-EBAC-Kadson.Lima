package AtividadePFePJ.SubClasses;

import AtividadePFePJ.Domain.Pessoa;

/**
 * Created by Kadson Lima on 25/09/2024
 *
 * @author Kadson Lima
 */

public class PessoaJurídica extends Pessoa {
    private int anoDeCriacaoDaEmpresa;

    public int getAnoDeCriacaoDaEmpresa() {
        return anoDeCriacaoDaEmpresa;
    }

    public void setAnoDeCriacaoDaEmpresa(int anoDeCriacaoDaEmpresa) {
        this.anoDeCriacaoDaEmpresa = anoDeCriacaoDaEmpresa;
    }

    public String getClassificaçãoDePorte() {
        return classificaçãoDePorte;
    }

    public void setClassificaçãoDePorte(String classificaçãoDePorte) {
        this.classificaçãoDePorte = classificaçãoDePorte;
    }

    private String classificaçãoDePorte;


}

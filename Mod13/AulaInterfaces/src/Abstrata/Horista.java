package Abstrata;

/**
 * Created by Kadson Lima on 17/09/2024
 *
 * @author Kadson Lima
 */
public class Horista extends Empregado {
    private Double preçoHora;

    private Double totalHorasTrabalhadas;

    public Double getPreçoHora() {
        return preçoHora;
    }

    public void setPreçoHora(Double preçoHora) {
        this.preçoHora = preçoHora;
    }

    public Double getTotalHorasTrabalhadas() {
        return totalHorasTrabalhadas;
    }

    public void setTotalHorasTrabalhadas(Double totalHorasTrabalhadas) {
        this.totalHorasTrabalhadas = totalHorasTrabalhadas;
    }

    @Override
    public Double vencimento() {
        return preçoHora*totalHorasTrabalhadas;
    }
}

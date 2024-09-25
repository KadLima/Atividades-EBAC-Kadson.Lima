package Abstrata;

/**
 * Created by Kadson Lima on 17/09/2024
 *
 * @author Kadson Lima
 */
public class Comissionado extends Empregado {
    private Double totalVenda;

    private Double taxaComissão;

    public Double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(Double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public Double getTaxaComissão() {
        return taxaComissão;
    }

    public void setTaxaComissão(Double taxaComissão) {
        this.taxaComissão = taxaComissão;
    }

    @Override
    public Double vencimento() {
        return totalVenda*taxaComissão;
    }
}

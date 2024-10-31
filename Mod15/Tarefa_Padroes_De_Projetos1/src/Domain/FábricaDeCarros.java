package Domain;

/**
 * Created by Kadson Lima on 15/10/2024
 *
 * @author Kadson Lima
 */
public abstract class FábricaDeCarros {
    public Carros criar(String categoriaSolicitada) {
        Carros carros = carrosRecuperados(categoriaSolicitada);
        carros = prepararOCarro(carros);
        return carros;
    }

    private Carros prepararOCarro(Carros carros){
        carros.verificaçãoDeLimpeza();
        carros.avaliaçãoMecânica();
        carros.abastecer();
        return carros;
    }

    abstract Carros carrosRecuperados(String categoriaSolicitada);

}

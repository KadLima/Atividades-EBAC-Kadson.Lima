package Domain;

/**
 * Created by Kadson Lima on 30/10/2024
 *
 * @author Kadson Lima
 */
public class ContratosDaFábrica extends FábricaDeCarros {

    @Override
    Carros carrosRecuperados(String categoriaSolicitada) {
        if("A".equals(categoriaSolicitada)){
            return new HondaCivic(200, "Tanque Cheio", "Preto");
        } else{
            return null;
        }

    }
}

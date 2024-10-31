package Domain;

/**
 * Created by Kadson Lima on 30/10/2024
 *
 * @author Kadson Lima
 */
public class SemContratoFábrica extends FábricaDeCarros{
    @Override
    Carros carrosRecuperados(String categoriaSolicitada) {
        if("A".equals(categoriaSolicitada)){
            return new FiatCronos(175, "Meio Tanque", "Prata");
        } else{
            return null;
        }

    }
}

package Repetição;

/**
 * Created by Kadson Lima on 30/08/2024
 *
 * @author Kadson Lima
 */
public class ContadorBreak {

    public static void main(String[] args) {
        for (int contador=1; contador<=1000; contador++){
            System.out.println("Está é a repetição Nº " + contador);
            if (contador == 25)
                break;

        }
    }

}

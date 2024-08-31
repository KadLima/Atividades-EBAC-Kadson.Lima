package Repetição;

/**
 * Created by Kadson Lima on 30/08/2024
 *
 * @author Kadson Lima
 */
public class Continue {
    public static void main(String[] args) {
        for (int contador=1; contador<=100; contador++) {
            if (contador%24 != 0){
                continue;
            }
            System.out.println("Contador "+contador);
        }
    }
}

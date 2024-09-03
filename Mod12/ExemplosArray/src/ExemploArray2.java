import java.sql.SQLOutput;

/**
 * Created by Kadson Lima on 02/09/2024
 *
 * @author Kadson Lima
 */
public class ExemploArray2 {
    public static void main(String[] args) {
        int[] array = {5, 233, 456, 789, 25, 2019, 23, 53, 98, 12 };

        System.out.printf("%s%9s%n", "Index", "Valor");

        for (int counter =0; counter < array.length; counter++) {
            System.out.printf("%2d%8d%n", counter, array[counter]);
        }
    }
}

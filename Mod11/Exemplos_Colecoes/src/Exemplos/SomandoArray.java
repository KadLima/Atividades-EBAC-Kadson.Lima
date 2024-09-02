package Exemplos;

/**
 * Created by Kadson Lima on 01/09/2024
 *
 * @author Kadson Lima
 */

public class SomandoArray {
    public static void main(String[] args) {
        int[] array = {34, 89, 74, 87, 32, 91, 41, 312, 442, 25 };
        int total = 0;
        for (int counter = 0; counter < array.length; counter++) total += array[counter];

        System.out.println("Total de elementos na Array: " + total);
    }
}

/**
 * Created by Kadson Lima on 02/09/2024
 *
 * @author Kadson Lima
 */

public class ExemploArray1 {


    public static void main(String[] args) {
        arrayBidimensional();
    }
    private static void arrayBidimensional() {
        System.out.println("***** Array Bidimensional *****");
        System.out.println(" ");
        int [] [] array1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int [] [] array2 = {{1, 2, 3}, {4, 5, 6}};

        System.out.println("Os Valores no Array1 passados na linha são: ");
        outputArray(array1);

        System.out.println(" ");

        System.out.println("Os Valores no Array2 passados na linha são: ");
        outputArray(array2);

    }

    private static void outputArray(int[][] array) {
        for(int linha = 0; linha < array.length; linha++) {
            for(int coluna = 0; coluna < array[0].length; coluna++) {
                System.out.printf("%d ", array[linha][coluna]);
            }
        }
    }

}

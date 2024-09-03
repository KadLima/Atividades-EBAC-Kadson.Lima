import java.util.Scanner;


/**
 * Created by Kadson Lima on 02/09/2024
 *
 * @author Kadson Lima
 */

public class ExemploArrayBubbleSortDinamico {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite os valores separados por vírgula: ");

        String valor = sc.next();
        String[] vetStr = valor.split(",");
        int[] vet = convert(vetStr);

        int aux;

        System.out.printf("%s%14s%n", "Vetor Desordenado", "Vetor Ordenado");
        for (int i = 0; i < vet.length; i++) {
            System.out.println(" " + vet[i]);
        }
        System.out.println();


        for (int i = 0; i < vet.length; i++) {
            for (int j = 0; j < vet.length - 1; j++) {
                if (vet[j] > vet[j + 1]) {
                    aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                }
            }
        }


        for (int i = 0; i < vet.length; i++) {
            System.out.printf("%25d ", vet[i]);
        }
        System.out.println();
    }

       private static int[] convert(String[] vetStr) {
        int[] numbers = new int[vetStr.length];
        for (int i = 0; i < vetStr.length; i++) {
            numbers[i] = Integer.parseInt(vetStr[i]);
        }
        return numbers;
    }
}


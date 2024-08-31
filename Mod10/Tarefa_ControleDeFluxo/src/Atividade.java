import java.util.Scanner;

/**
 * Created by Kadson Lima on 31/08/2024
 *
 * @author Kadson Lima
 */

public class Atividade {

    static float N1 = 7.5f;
    static float N2 = 8.8f;
    static float N3 = 9.1f;
    static float N4 = 6.0f;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float media = ((N1 + N2 + N3 + N4) / 4);
        if (media >= 7) {
            System.out.println("Parabéns! Você foi aprovado!");
        } else if (media >= 5 && media < 7) {
            System.out.println("Foi quase. Você está na recuperação.");
        } else {
            System.out.println("Infelizmente, você foi reprovado.");
        }

    }
}



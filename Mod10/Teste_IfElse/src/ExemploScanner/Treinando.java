package TreinandoScanner;

/**
 * Created by Kadson Lima on 30/08/2024
 *
 * @author Kadson Lima
 */

import java.util.Scanner;

class TreinandoScanner {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite sua idade: ");
        int idade = s.nextInt();
        System.out.println("Você tem " + idade + " anos");
    }
}
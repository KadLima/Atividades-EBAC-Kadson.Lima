package ExemploScanner;

import java.util.Scanner;

/**
 * Created by Kadson Lima on 30/08/2024
 *
 * @author Kadson Lima
 */

public class ExemploScanner2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite sua idade: ");
        int idade = sc.nextInt();

        System.out.println("Digite seu sexo: ");
        String genero = sc.nextLine();

        System.out.println("Digite Altura: ");
        double altura = sc.nextDouble();

        System.out.println("Seu nome é " + nome);
        System.out.println(" ");
        System.out.println("Sua idade é " + idade + " anos");
        System.out.println(" ");
        System.out.println("Seu sexo é " + genero);
        System.out.println(" ");
        System.out.println("Sua altura é " + altura + "m");

    }
}

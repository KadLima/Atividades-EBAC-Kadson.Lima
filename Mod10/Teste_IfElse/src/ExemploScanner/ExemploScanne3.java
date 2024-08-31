package ExemploScanner;

import java.util.Scanner;

/**
 * Created by Kadson Lima on 30/08/2024
 *
 * @author Kadson Lima
 */
public class ExemploScanne3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Por favor, digite a sua idade: ");
        int idade = sc.nextInt();

        if (idade >= 0 && idade <= 5) {
            System.out.println("Você é apenas um bebê!");
        } else if (idade >= 6 && idade <= 11) {
            System.out.println("Você é uma criança!");
        } else if (idade >= 12 && idade <= 18) {
            System.out.println("Você é um adolescente!");
        }else if (idade >= 19 && idade <= 30) {
            System.out.println("Você é um jovem adulto!");
        }else if (idade >= 32 && idade <= 55) {
            System.out.println("Você é um adulto!");
        }else {
            System.out.println("Você é um idoso!");
        }
    }
}
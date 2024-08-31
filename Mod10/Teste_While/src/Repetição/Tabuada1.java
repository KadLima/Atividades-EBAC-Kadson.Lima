package Repetição;

import java.util.Scanner;

/**
 * Created by Kadson Lima on 30/08/2024
 *
 * @author Kadson Lima
 */

public class Tabuada1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Escolha um número para gerar a tabuada: ");
        int tab = sc.nextInt();
        for (int i = 0; i <= 10 ; i++) {
            System.out.println(tab + " x " + i + " = " + tab * i);
        }
    }
}

package Repetição;

import java.util.Scanner;

/**
 * Created by Kadson Lima on 30/08/2024
 *
 * @author Kadson Lima
 */


public class Treino_While1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Deseja gerar a tabuada de algum número? (Sim/Não)");
        String resposta = s.next();

        // Bloco de controle principal
        if (resposta.equalsIgnoreCase("Sim")) {
            while (resposta.equalsIgnoreCase("Sim")) {
                System.out.println(" ");
                System.out.print("Digite um número para gerar a tabuada: ");
                int num = s.nextInt();

                // Gerar a tabuada do número digitado
                for (int i = 0; i <= 10; i++) {
                    System.out.println(num + " x " + i + " = " + (num * i));
                }

                System.out.println("");
                System.out.println("Deseja gerar novamente a tabuada de algum número? (Sim/Não)");
                resposta = s.next();
            }

            } else if (resposta.equalsIgnoreCase("Não")) {
                System.out.println("Tem certeza? Sim/Não");
                resposta = s.next();


        } else {
            System.out.println("Operação Cancelada. Obrigado.");
        }

        System.out.println(" ");
        System.out.println("Obrigado.");
        s.close();
    }
}


package Atividades;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 * Created by Kadson Lima on 01/09/2024
 *
 * @author Kadson Lima
 */
public class Parte2 {

    public static void main(String[] args) {
        List<String> listaMasculinos = new ArrayList<String>();
        List<String> listaFemininos = new ArrayList<String>();

        Scanner sc = new Scanner(System.in);
        String entrada;



        while (true) {
            System.out.println(" ");
            System.out.print("Digite o nome e o gênero (Masculino/Feminino) que você gostaria de inserir | Ex.: Kadson - Masculino | (Ou digite Sair):  ");
            entrada = sc.nextLine();

            if (entrada.equalsIgnoreCase("Sair")) {
                System.out.println(" ");
                System.out.println("Okay. Finalizando o programa.");
                break;
            }

            String[] partes = entrada.split(" - ");
            if (partes.length !=2) {
                System.out.println(" ");
                System.out.println("Formato inválido. Use o formato: Nome - Gênero ");
                System.out.println(" ");
                continue;
            }

            String nome = partes[0].trim();
            String genero = partes[1].trim();

            if (genero.equalsIgnoreCase("Masculino")) {
                listaMasculinos.add(nome);
                System.out.println(" ");
                System.out.println("Nome Masculino adicionado com Sucesso!");

            }else if (genero.equalsIgnoreCase("Feminino")) {
                listaFemininos.add(nome);
                System.out.println(" ");
                System.out.println("Nome Feminino adicionado com Sucesso!");
            }else {
                System.out.println(" ");
                System.out.println("Opções inválida. Use Masculino ou Feminino. ");
                System.out.println(" ");
                continue;
            }

            System.out.println(" ");
            System.out.println("Você gostaria de ver os dados armazenados? (Sim/Não) ");
            String resposta = sc.nextLine();

            if (resposta.equalsIgnoreCase("Sim")) {
                System.out.println(" ");
                System.out.println("Nomes Masculinos: ");
                for (String nomeMasculino : listaMasculinos) {
                    System.out.println(nomeMasculino);
                    System.out.println(" ");
                }

                System.out.println("Nomes Femininos: ");
                for (String nomeFeminino : listaFemininos) {
                    System.out.println(nomeFeminino);
                    System.out.println(" ");
                }

                System.out.println(" ");

                System.out.println("Você gostaria de inserir mais algum? (Sim/Não) ");
                    if (sc.nextLine().equalsIgnoreCase("Não")) {
                    System.out.println(" ");
                    System.out.println("Okay. Finalizando o programa. ");

                    break;

                    }

                System.out.println(" ");
            }
        }


    }
}
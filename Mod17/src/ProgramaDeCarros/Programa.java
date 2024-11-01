package ProgramaDeCarros;

import Domain.Carros;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Kadson Lima on 31/10/2024
 *
 * @author Kadson Lima
 */

public class Programa {
    public static void main(String[] args) {
        Scanner respostas = new Scanner(System.in);
        List<Carros> listaDeCarros = new ArrayList<>();
        int opcao;

        do {

            System.out.println("1 - Adicionar um carro");
            System.out.println("2 - Mostrar lista de carros");
            System.out.println("3 - Sair");
            System.out.print("\nEscolha uma opção: ");
            opcao = respostas.nextInt();
            respostas.nextLine();

            switch (opcao) {
                case 1:
                    Carros carros = new Carros();

                    System.out.print("Digite a marca do carro que você gostaria de adicionar: ");
                    String marca = respostas.nextLine();
                    carros.setMarca(marca);

                    System.out.print("Digite a modelo do carro que você gostaria de adicionar: ");
                    String modelo = respostas.nextLine();
                    carros.setModelo(modelo);

                    System.out.print("Digite o ano do carro que você gostaria de adicionar: ");
                    int ano = respostas.nextInt();
                    carros.setAno(ano);

                    listaDeCarros.add(carros);
                    System.out.println("\nCarro adicionado com sucesso!");
                    System.out.println();
                    break;

                case 2:
                    if (listaDeCarros.isEmpty()) {
                        System.out.println("\nNenhum carro cadastrado");
                        System.out.println();
                    } else {
                        System.out.println("\n|Lista de Carros|");
                        System.out.println("----------------------");
                        for (Carros lista : listaDeCarros) {
                            System.out.println("Marca: " + lista.getMarca());
                            System.out.println("Modelo: " + lista.getModelo());
                            System.out.println("Ano: " + lista.getAno());
                            System.out.println("----------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("\nOpção inválida");
            }
        } while (opcao != 3);

        respostas.close();
    }
}



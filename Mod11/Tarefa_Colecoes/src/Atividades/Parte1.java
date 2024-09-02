package Atividades;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Kadson Lima on 01/09/2024
 *
 * @author Kadson Lima
 */

public class Parte1 {
    public static void main(String[] args) {
        String nomes = "Kadson Guilherme, Will Smith, Alfonso Ribeiro, Marcus Smart, Kevin Hart";

        String[] nomesArray = nomes.split(", ");

        List<String> listaNomes = new ArrayList<>();
        Collections.addAll(listaNomes, nomesArray);

        Collections.sort(listaNomes);

        System.out.println("Lista de Nomes: ");
        System.out.println(" ");
        for (String nome : listaNomes) {
            System.out.println(nome);
        }
        System.out.println(" ");

    }
}

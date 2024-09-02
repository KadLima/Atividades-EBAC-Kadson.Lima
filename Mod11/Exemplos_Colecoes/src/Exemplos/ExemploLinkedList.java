package Exemplos;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kadson Lima on 01/09/2024
 *
 * @author Kadson Lima
 */
public class ExemploLinkedList {

    public static void main(String[] args) {
        exemploListaSimples2();
        exemploListaOrdenadaAscendente2();
    }

    private static void exemploListaSimples2() {
        System.out.println("***** Exemplo Lista Simples *****");
        List<String> listal = new LinkedList<String>();
        listal.add("Carne");
        listal.add("Leite");
        listal.add("Ovos");
        listal.add("Melão");
        listal.add("Abacate");
        System.out.println(listal);
        System.out.println(" ");

        listal.remove(0);
        System.out.println(listal);
        System.out.println(" ");
        boolean contem = listal.contains("Carne");
        System.out.println(contem);
        System.out.println(" ");
        System.out.println(listal.get(0));
        System.out.println(" ");
    }

    private static void exemploListaOrdenadaAscendente2() {
        System.out.println("***** Exemplo Lista Ordenada Ascendente2 *****");
        List<String> lista2 = new LinkedList<String>();
        lista2.add("Carne");
        lista2.add("Leite");
        lista2.add("Ovos");
        lista2.add("Melão");
        lista2.add("Abacate");
        Collections.sort(lista2);
        System.out.println("Com o Collections " + lista2);

    }
}

package Exemplos;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


/**
 * Created by Kadson Lima on 01/09/2024
 *
 * @author Kadson Lima
 */


public class ExemploArrayLIst {
    public static void main(String[] args) {
        exemploListaSimples();
        exemploListaOrdemAscendente();
        exemploNúmeros();
    }
    private static void exemploListaSimples()   {
        System.out.println("***** Exemplo Lista Simples *****");
        List<String> lista1 = new ArrayList<String>();
        lista1.add("Kadson Lima");
        lista1.add("Adiel Macedo");
        lista1.add("Mayara Letícia");
        lista1.add("Kauã Pereira");
        System.out.println(lista1);
        System.out.println(" ");
    }

    private static void exemploListaOrdemAscendente() {
        System.out.println("***** Exemplo Lista OrdemAscendente *****");
        List<String> lista2 = new ArrayList<String>();
        lista2.add("Kadson Lima");
        lista2.add("Adiel Macedo");
        lista2.add("Mayara Letícia");
        lista2.add("Kauã Pereira");
        Collections.sort(lista2);
        System.out.println(lista2);
        System.out.println(" ");
    }

    private static void exemploNúmeros(){
        System.out.println("***** Exemplo Números *****");
        List<Integer> lista3 = new ArrayList<Integer>();
        lista3.add(1);
        lista3.add(2);
        lista3.add(3);
        lista3.add(4);
        lista3.add(5);
        lista3.add(6);
        lista3.add(7);
        lista3.add(8);
        lista3.add(9);
        System.out.println(lista3);
        System.out.println(" ");
    }

}

package Exercicio01;

import java.util.ArrayList;
import java.util.List;

public class SubconjuntosBacktracking {

    public static List<List<Integer>> gerarSubconjuntos(int[] conjunto, int n) {
        List<List<Integer>> resultado = new ArrayList<>();
        List<Integer> subconjuntoAtual = new ArrayList<>();

        backtracking(conjunto, n, 0, subconjuntoAtual, resultado);

        return resultado;
    }

    private static void backtracking(int[] conjunto, int n, int inicio,
                                     List<Integer> subconjuntoAtual,
                                     List<List<Integer>> resultado) {

        if (subconjuntoAtual.size() == n) {
            resultado.add(new ArrayList<>(subconjuntoAtual));
            return;
        }

        for (int i = inicio; i < conjunto.length; i++) {
            subconjuntoAtual.add(conjunto[i]);
            backtracking(conjunto, n, i + 1, subconjuntoAtual, resultado);
            subconjuntoAtual.remove(subconjuntoAtual.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] conjunto1 = {1, 2, 3};
        int n1 = 2;

        List<List<Integer>> resultado1 = gerarSubconjuntos(conjunto1, n1);
        System.out.println("Subconjuntos de tamanho " + n1 + ": " + resultado1);

        int[] conjunto2 = {1, 2, 3, 4};
        int n2 = 1;

        List<List<Integer>> resultado2 = gerarSubconjuntos(conjunto2, n2);
        System.out.println("Subconjuntos de tamanho " + n2 + ": " + resultado2);
    }
}
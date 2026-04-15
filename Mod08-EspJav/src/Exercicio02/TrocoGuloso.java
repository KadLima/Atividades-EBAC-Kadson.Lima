package Exercicio02;

public class TrocoGuloso {

    public static void calcularTroco(int quantia, int[] moedas) {
        int totalMoedas = 0;

        for (int moeda : moedas) {
            int quantidade = quantia / moeda;

            if (quantidade > 0) {
                System.out.println(quantidade + " moeda(s) de " + moeda);
                totalMoedas += quantidade;
                quantia = quantia % moeda;
            }
        }

        System.out.println("Total de moedas usadas: " + totalMoedas);
    }

    public static void main(String[] args) {
        int quantia = 25;
        int[] moedas = {5, 2, 1};

        calcularTroco(quantia, moedas);
    }
}
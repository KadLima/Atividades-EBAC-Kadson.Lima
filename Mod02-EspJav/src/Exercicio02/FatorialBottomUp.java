package Exercicio02;

public class FatorialBottomUp {

    public static long calcularFatorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Não existe fatorial para números negativos.");
        }

        long resultado = 1;

        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }

        return resultado;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Fatorial de " + n + " = " + calcularFatorial(n));
    }
}

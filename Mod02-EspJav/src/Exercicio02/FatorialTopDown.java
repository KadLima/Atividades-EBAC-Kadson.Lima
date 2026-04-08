package Exercicio02;

import java.util.Arrays;

public class FatorialTopDown {

    private static long[] memo;

    public static long calcularFatorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Não existe fatorial para números negativos.");
        }

        memo = new long[n + 1];
        Arrays.fill(memo, -1);

        return fatorial(n);
    }

    private static long fatorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        memo[n] = n * fatorial(n - 1);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 30;
        System.out.println("Fatorial de " + n + " = " + calcularFatorial(n));
    }
}

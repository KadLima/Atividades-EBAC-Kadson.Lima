package Exercicio01;

public class FatorialRecursivo {

    public static long calcularFatorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Não existe fatorial para números negativos.");
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        return n * calcularFatorial(n - 1);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Fatorial de " + n + " = " + calcularFatorial(n));
    }
}

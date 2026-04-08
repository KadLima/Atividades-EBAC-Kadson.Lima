package Exercicio01;

/**
 * Classe responsável por realizar operações matemáticas básicas.
 *
 * <p>Esta classe possui métodos privados para as operações internas
 * e métodos públicos auxiliares para permitir sua utilização e teste.</p>
 *
 * @author Kadson
 */
public class Calculadora {

    /**
     * Soma dois números inteiros.
     *
     * @param a primeiro número
     * @param b segundo número
     * @return resultado da soma entre a e b
     */
    private int adicionar(int a, int b) {
        return a + b;
    }

    /**
     * Subtrai dois números inteiros.
     *
     * @param a primeiro número
     * @param b segundo número
     * @return resultado da subtração de a por b
     */
    private int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dois números inteiros.
     *
     * @param a primeiro número
     * @param b segundo número
     * @return resultado da multiplicação entre a e b
     */
    private int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide dois números inteiros.
     *
     * @param a dividendo
     * @param b divisor
     * @return resultado da divisão inteira entre a e b
     * @throws ArithmeticException se o divisor for zero
     */
    private int dividir(int a, int b) {
        return a / b;
    }

    // Métodos públicos auxiliares para testes

    public int executarAdicao(int a, int b) {
        return adicionar(a, b);
    }

    public int executarSubtracao(int a, int b) {
        return subtrair(a, b);
    }

    public int executarMultiplicacao(int a, int b) {
        return multiplicar(a, b);
    }

    public int executarDivisao(int a, int b) {
        return dividir(a, b);
    }
}

package Exercicio02;

import ExercicioFibonacci.Fibonacci;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    @Test
    void deveRetornarZeroQuandoNForZero() {
        assertEquals(0, Fibonacci.encontrarElementoPD(0));
    }

    @Test
    void deveRetornarUmQuandoNForUm() {
        assertEquals(1, Fibonacci.encontrarElementoPD(1));
    }

    @Test
    void deveRetornarValorCorretoParaNDois() {
        assertEquals(1, Fibonacci.encontrarElementoPD(2));
    }

    @Test
    void deveRetornarValorCorretoParaNCinco() {
        assertEquals(5, Fibonacci.encontrarElementoPD(5));
    }

    @Test
    void deveRetornarValorCorretoParaNSeis() {
        assertEquals(8, Fibonacci.encontrarElementoPD(6));
    }

    @Test
    void deveRetornarValorCorretoParaNDez() {
        assertEquals(55, Fibonacci.encontrarElementoPD(10));
    }
}
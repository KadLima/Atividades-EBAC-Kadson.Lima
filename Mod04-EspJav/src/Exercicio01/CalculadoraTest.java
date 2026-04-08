package Exercicio01;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private final Calculadora calculadora = new Calculadora();

    @Test
    void deveSomarDoisNumerosCorretamente() {
        int resultado = calculadora.executarAdicao(5, 3);
        assertEquals(8, resultado);
    }

    @Test
    void deveSubtrairDoisNumerosCorretamente() {
        int resultado = calculadora.executarSubtracao(10, 4);
        assertEquals(6, resultado);
    }

    @Test
    void deveMultiplicarDoisNumerosCorretamente() {
        int resultado = calculadora.executarMultiplicacao(6, 7);
        assertEquals(42, resultado);
    }

    @Test
    void deveDividirDoisNumerosCorretamente() {
        int resultado = calculadora.executarDivisao(10, 2);
        assertEquals(5, resultado);
    }

    @Test
    void deveRetornarDivisaoInteira() {
        int resultado = calculadora.executarDivisao(7, 2);
        assertEquals(3, resultado);
    }

    @Test
    void deveLancarExcecaoAoDividirPorZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculadora.executarDivisao(10, 0);
        });
    }

    @Test
    void deveDividirNumeroNegativoCorretamente() {
        int resultado = calculadora.executarDivisao(-12, 3);
        assertEquals(-4, resultado);
    }
}

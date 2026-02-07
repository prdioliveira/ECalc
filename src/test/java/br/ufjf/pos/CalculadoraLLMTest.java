package br.ufjf.pos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraLLMTest {

    private Calculadora calc;

    // Margem de erro aceitável para operações com ponto flutuante (double)
    private static final double DELTA = 0.000001;

    @Before
    public void setUp() {
        calc = new Calculadora();
    }

    // --------------------------------------------------------------------------
    // TESTES DE SOMA (2 argumentos)
    // --------------------------------------------------------------------------

    @Test
    public void testSomarPositivos() {
        Assert.assertEquals(10.5, calc.somar(5.2, 5.3), DELTA);
    }

    @Test
    public void testSomarNegativos() {
        Assert.assertEquals(-5.0, calc.somar(-2.0, -3.0), DELTA);
    }

    @Test
    public void testSomarPositivoComNegativo() {
        Assert.assertEquals(0.0, calc.somar(5.0, -5.0), DELTA);
    }

    @Test
    public void testSomarExtremos() {
        // Testa se a soma ultrapassa o limite do Double (gera Infinity)
        Assert.assertEquals(Double.POSITIVE_INFINITY, calc.somar(Double.MAX_VALUE, Double.MAX_VALUE), DELTA);
    }

    // --------------------------------------------------------------------------
    // TESTES DE SOMA (Varargs)
    // --------------------------------------------------------------------------

    @Test
    public void testSomarVarargsMultiplos() {
        Assert.assertEquals(15.0, calc.somar(1.0, 2.0, 3.0, 4.0, 5.0), DELTA);
    }

    @Test
    public void testSomarVarargsUnico() {
        Assert.assertEquals(10.0, calc.somar(10.0), DELTA);
    }

    @Test
    public void testSomarVarargsVazio() {
        // Deve retornar 0.0 (valor inicial da variável resultado no seu código)
        Assert.assertEquals(0.0, calc.somar(), DELTA);
    }

    // --------------------------------------------------------------------------
    // TESTES DE SUBTRAÇÃO
    // --------------------------------------------------------------------------

    @Test
    public void testSubtrairSimples() {
        Assert.assertEquals(5.0, calc.subtrair(10.0, 5.0), DELTA);
    }

    @Test
    public void testSubtrairGerandoNegativo() {
        Assert.assertEquals(-5.0, calc.subtrair(5.0, 10.0), DELTA);
    }

    @Test
    public void testSubtrairNegativos() {
        // -5 - (-5) = 0
        Assert.assertEquals(0.0, calc.subtrair(-5.0, -5.0), DELTA);
    }

    // --------------------------------------------------------------------------
    // TESTES DE MULTIPLICAÇÃO (2 argumentos)
    // --------------------------------------------------------------------------

    @Test
    public void testMultiplicarSimples() {
        Assert.assertEquals(20.0, calc.multiplicar(4.0, 5.0), DELTA);
    }

    @Test
    public void testMultiplicarPorZero() {
        Assert.assertEquals(0.0, calc.multiplicar(100.0, 0.0), DELTA);
    }

    @Test
    public void testMultiplicarSinaisDiferentes() {
        Assert.assertEquals(-20.0, calc.multiplicar(4.0, -5.0), DELTA);
    }

    // --------------------------------------------------------------------------
    // TESTES DE MULTIPLICAÇÃO (Varargs)
    // --------------------------------------------------------------------------

    @Test
    public void testMultiplicarVarargs() {
        Assert.assertEquals(24.0, calc.multiplicar(2.0, 3.0, 4.0), DELTA);
    }

    @Test
    public void testMultiplicarVarargsComZero() {
        // Se houver um zero na lista, o resultado deve ser zero
        Assert.assertEquals(0.0, calc.multiplicar(2.0, 3.0, 0.0, 4.0), DELTA);
    }

    @Test
    public void testMultiplicarVarargsVazio() {
        // Deve retornar 1.0 (elemento neutro definido no seu código)
        Assert.assertEquals(1.0, calc.multiplicar(), DELTA);
    }

    // --------------------------------------------------------------------------
    // TESTES DE DIVISÃO (Com Exceções e Edge Cases)
    // --------------------------------------------------------------------------

    @Test
    public void testDividirExato() {
        Assert.assertEquals(2.0, calc.dividir(10.0, 5.0), DELTA);
    }

    @Test
    public void testDividirDizimaPeriodica() {
        // 10 / 3 = 3.3333...
        Assert.assertEquals(3.333333, calc.dividir(10.0, 3.0), DELTA);
    }

    @Test
    public void testDividirZeroPorAlgo() {
        Assert.assertEquals(0.0, calc.dividir(0.0, 5.0), DELTA);
    }

    @Test
    public void testDividirNegativos() {
        Assert.assertEquals(2.0, calc.dividir(-10.0, -5.0), DELTA);
    }

    // Teste de caso de borda CRÍTICO: Divisão por Zero
    @Test(expected = ArithmeticException.class)
    public void testDividirPorZeroDeveLancarExcecao() {
        // O JUnit espera que este método lance a exceção. Se não lançar, o teste falha.
        calc.dividir(10.0, 0.0);
    }

    // Teste de caso de borda: O que acontece se passar null no varargs?
    // Como seu código faz um foreach (for (double n : numeros)), isso gera NullPointerException.
    // É bom ter um teste que documente esse comportamento.
    @Test(expected = NullPointerException.class)
    public void testSomarVarargsNull() {
        calc.somar((double[]) null);
    }
}
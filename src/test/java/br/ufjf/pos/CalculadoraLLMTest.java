package br.ufjf.pos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraLLMTest {

    private Calculadora calc;
    // Delta de precisão para comparações de double (padrão para evitar erros de arredondamento)
    private static final double DELTA = 0.000001;

    @Before
    public void setUp() {
        calc = new Calculadora();
    }

    // --- TESTES DE SOMA ---

    @Test
    public void testSomarDoisNumeros() {
        Assert.assertEquals(10.5, calc.somar(5.2, 5.3), DELTA);
    }

    @Test
    public void testSomarNegativos() {
        Assert.assertEquals(-2.0, calc.somar(5.0, -7.0), DELTA);
    }

    @Test
    public void testSomarVarargsVarios() {
        Assert.assertEquals(15.0, calc.somar(1.0, 2.0, 3.0, 4.0, 5.0), DELTA);
    }

    @Test
    public void testSomarVarargsVazio() {
        // Verifica o estado inicial (neutro) da soma
        Assert.assertEquals(0.0, calc.somar(), DELTA);
    }

    @Test
    public void testSomarEstouroDouble() {
        // Verifica comportamento com valores máximos (deve resultar em Infinity)
        double resultado = calc.somar(Double.MAX_VALUE, Double.MAX_VALUE);
        Assert.assertTrue(Double.isInfinite(resultado));
    }

    // --- TESTES DE SUBTRAÇÃO ---

    @Test
    public void testSubtrairPositivos() {
        Assert.assertEquals(2.5, calc.subtrair(5.0, 2.5), DELTA);
    }

    @Test
    public void testSubtrairResultandoEmNegativo() {
        Assert.assertEquals(-10.0, calc.subtrair(5.0, 15.0), DELTA);
    }

    // --- TESTES DE MULTIPLICAÇÃO ---

    @Test
    public void testMultiplicarDoisNumeros() {
        Assert.assertEquals(12.0, calc.multiplicar(3.0, 4.0), DELTA);
    }

    @Test
    public void testMultiplicarPorZero() {
        Assert.assertEquals(0.0, calc.multiplicar(50.0, 0.0), DELTA);
    }

    @Test
    public void testMultiplicarVarargsVazio() {
        // Verifica o elemento neutro da multiplicação (1.0) conforme definido no código
        Assert.assertEquals(1.0, calc.multiplicar(), DELTA);
    }

    @Test
    public void testMultiplicarComNaN() {
        // Multiplicar por NaN (Not a Number) deve resultar em NaN
        Assert.assertTrue(Double.isNaN(calc.multiplicar(Double.NaN, 5.0)));
    }

    // --- TESTES DE DIVISÃO ---

    @Test
    public void testDividirNormal() {
        Assert.assertEquals(2.0, calc.dividir(10.0, 5.0), DELTA);
    }

    @Test
    public void testDividirDizima() {
        // 10 / 3 = 3.333333...
        Assert.assertEquals(3.3333333333333335, calc.dividir(10.0, 3.0), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void testDividirPorZeroDeveLancarExcecao() {
        // Valida se a exceção customizada é lançada corretamente
        calc.dividir(10.0, 0.0);
    }

    @Test
    public void testDividirZeroPorAlgo() {
        Assert.assertEquals(0.0, calc.dividir(0.0, 5.0), DELTA);
    }
}
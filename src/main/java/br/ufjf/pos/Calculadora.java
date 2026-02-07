package br.ufjf.pos;

public class Calculadora {
    /**
     * Realiza a soma de dois números
     *
     * @param a primeiro operando
     * @param b sengundo operando
     * @return resultado da soma
     */
    public double somar(double a, double b){
        return a + b;
    }

    /**
     * Realiza a subtração de dois números
     *
     * @param a primeiro operando
     * @param b sengundo operando
     * @return resultado da subtração
     */
    public double subtrair(double a, double b){
        return a - b;
    }

    /**
     * Realiza a multiplicação de dois números
     *
     * @param a primeiro fator
     * @param b sengundo fator
     * @return resultado da multiplicação
     */
    public double multiplicar(double a, double b){
        return a * b;
    }

    /**
     * Realiza a divisão de dois números
     *
     * @param a dividendo
     * @param b divisor
     * @return resultado da divisção
     * @throws ArithmeticException se o divisor for zero
     */
    public double dividir(double a, double b){
        if (b == 0.0){
            throw new ArithmeticException("Divisão por zero não permitida");
        }
        return a / b;
    }

    // Versões de sobrecarga

    public double somar(double... numeros){
        double resultado = 0.0;
        for (double n : numeros){
            resultado += n;
        }
        return resultado;
    }

    public double multiplicar(double... numeros){
        double resultado = 1.0;
        for (double n : numeros){
            resultado *= n;
        }
        return resultado;
    }
}

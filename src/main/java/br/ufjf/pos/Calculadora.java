package br.ufjf.pos;

public class Calculadora {
    /**
     * Realiza a soma de dois números
     *
     * @param a primeiro operando
     * @param b sengundo operando
     * @return resultado da soma
     */
    public float somar(float a, float b){
        return a + b;
    }

    /**
     * Realiza a subtração de dois números
     *
     * @param a primeiro operando
     * @param b sengundo operando
     * @return resultado da subtração
     */
    public float subtrair(float a, float b){
        return a - b;
    }

    /**
     * Realiza a multiplicação de dois números
     *
     * @param a primeiro fator
     * @param b sengundo fator
     * @return resultado da multiplicação
     */
    public float multiplicar(float a, float b){
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
    public float dividir(float a, float b){
        if (b == 0.0f){
            throw new ArithmeticException("Divisão por zero não permitida");
        }
        return a / b;
    }

    // Versões de sobrecarga

    public float somar(float... numeros){
        float resultado = 0.0f;
        for (float n : numeros){
            resultado += n;
        }
        return resultado;
    }

    public float multiplicar(float... numeros){
        float resultado = 1.0f;
        for (float n : numeros){
            resultado *= n;
        }
        return resultado;
    }
}

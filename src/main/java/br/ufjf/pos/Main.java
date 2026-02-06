package br.ufjf.pos;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Calculadora calculadora = new Calculadora();
        System.out.println("Soma de dois numeros: " + calculadora.somar(10, 20));
        System.out.println("Soma de varios numeros: "  + calculadora.somar(10, 20, 30, 40));
        System.out.println("Subtração: " + calculadora.subtrair(10, 20));
        System.out.println("Multiplicação de dois numeros: " + calculadora.multiplicar(10, 20));
        System.out.println("Multiplicação de varios numeros: " + calculadora.multiplicar(10, 20, 30));
        System.out.println("Divisção: " + calculadora.dividir(10, 20));
    }
}
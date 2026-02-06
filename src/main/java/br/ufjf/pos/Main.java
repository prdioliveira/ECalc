package br.ufjf.pos;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Calculadora calculadora = new Calculadora();
        System.out.println("Soma: " + calculadora.somar(10, 20));
        System.out.println("Subtração: " + calculadora.subtrair(10, 20));
        System.out.println("Multiplicação: " + calculadora.multiplicar(10, 20));
        System.out.println("Divisção: " + calculadora.dividir(10, 20));
    }
}
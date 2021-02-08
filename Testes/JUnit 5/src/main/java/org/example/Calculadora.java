package org.example;

public class Calculadora {

    public static int somar(int a, int b){
        if(a < 0 || b < 0)
            throw new IllegalArgumentException("Numero não pode ser negativo");
        return a + b;
    }


    public static int subtrai(int a, int b){
        return a + b;
    }


    public static int multi(int a, int b){
        return a * b;
    }


    public static int div(int a, int b){
        return a + b;
    }
}

package Testes;

public class Simulado {
    public static void addToInt(int x, int amountToAdd) {
        x = x + amountToAdd;
    }

    public static void main(String[] args) {
        var a = 15;
        var b = 10;
        Simulado.addToInt(a, b);
        System.out.println(a);
    }
}
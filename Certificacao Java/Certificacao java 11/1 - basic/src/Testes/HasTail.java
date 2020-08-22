package Testes;

public class Simulado2 {
    public static void addToInt(int x, int amountToAdd) {
        x = x + amountToAdd;
    }

    public static void main(String[] args) {
        var a = 15;
        var b = 10;
        Simulado2.addToInt(a, b);
        System.out.println(a);
    }
}
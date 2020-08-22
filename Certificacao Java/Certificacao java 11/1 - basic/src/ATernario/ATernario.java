package ATernario;

public class Simulado {
    public static void main(String[] args) {
        var idade = 18;
        boolean condicional = false;
        String res = (condicional = true) ? "adulto" : "infantil";
        System.out.println(res);
    }
}
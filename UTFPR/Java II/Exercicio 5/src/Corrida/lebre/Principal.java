package Corrida.lebre;

public class Principal {

    public static void main(String[] args) {

        for (int i = 1; i < 6; i++) {
            Lebre lebre = new Lebre("Lebre #" + i);
            System.out.println(lebre);
        }
        System.out.println("----------------------------------------------------------------------");
    }
}

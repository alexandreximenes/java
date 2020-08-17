package Corrida.motocicletas;

import Corrida.motocicletas.Motocicleta;

public class Principal {

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            Motocicleta motocicleta = new Motocicleta("Motocicleta #" + i);
            System.out.println(motocicleta);
            Thread thread = new Thread(motocicleta);
            thread.start();
        }
        System.out.println("----------------------------------------------------------------------");
    }
}

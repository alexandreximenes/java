package Corrida.lebre;

import java.util.Random;

public class Corrida {

    private static long limite = 20;

    public synchronized Lebre correr(Lebre lebre) {

        if (lebre.getTotal() <= limite) {
            long pulo = pular();
            lebre.setPulos(lebre.getPulos() + 1L);
            lebre.setSalto(pulo);
            lebre.setTotal(lebre.getTotal() + pulo);
            if(lebre.getTotal() > limite)
                lebre.setTotal(limite);
            System.out.println(lebre);
        }
        return lebre;
    }

    public static long pular() {
        return new Random().longs(1, 4).findFirst().getAsLong();
    }

}

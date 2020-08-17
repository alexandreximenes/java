package Corrida.motocicletas;

import Corrida.motocicletas.Motocicleta;

import java.util.Random;

public class Corrida {

    private static long limite = 20;

    public synchronized Motocicleta correr(Motocicleta motocicleta) {

        if (motocicleta.getTotal() <= limite) {
            long pulo = pular();
            motocicleta.setPulos(motocicleta.getPulos() + 1L);
            motocicleta.setSalto(pulo);
            motocicleta.setTotal(motocicleta.getTotal() + pulo);
            if(motocicleta.getTotal() > limite)
                motocicleta.setTotal(limite);
            System.out.println(motocicleta);
        }
        return motocicleta;
    }

    public static long pular() {
        return new Random().longs(1, 4).findFirst().getAsLong();
    }

}

package Corrida.motocicletas;

import Corrida.motocicletas.Motocicleta;

import java.util.LinkedList;
import java.util.List;

public class Motocicleta extends Thread {

    private static volatile int cont = 0;
    private String nome;
    private long salto = 0;
    private long pulos = 0;
    private long total = 0;
    private Corrida corrida = new Corrida();
    private List<Motocicleta> motocicletas = new LinkedList<>();

    public Motocicleta(String name) {
        super(name);
        this.nome = name;
    }

    @Override
    public void run() {
        Motocicleta motocicleta = null;
        do {
            motocicleta = corrida.correr(this);
            try {
                if (motocicleta.getTotal() >= 20) {
                    cont++;
                    System.out.println(motocicleta.getNome().toUpperCase() +" CHEGOU EM " + cont + " LUGAR");
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (motocicleta.getTotal() < 20);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getSalto() {
        return salto;
    }

    public void setSalto(long salto) {
        this.salto = salto;
    }

    public long getPulos() {
        return pulos;
    }

    public void setPulos(long pulos) {
        this.pulos = pulos;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return nome + ", deu " + pulos + " pulo, saltou " + salto + " metros, total é: " + total;
    }

}

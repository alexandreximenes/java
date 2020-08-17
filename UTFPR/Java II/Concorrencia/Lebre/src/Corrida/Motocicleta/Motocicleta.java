package Corrida.Motocicleta;

import java.util.Random;

//motocicleta - Classe principal para gerar 10 Threads e ja executar.
//classe principal para rodar o projeto
class Principal {
    public static void main(String[] args) {

        for (int i = 1; i < 11; i++) {
            Motocicleta motocicleta = new Motocicleta("Motocicle #"+i);
            motocicleta.start();
        }


    }

    public static long range() {
        return new Random().longs(11, 15).findFirst().getAsLong();
    }
}

/**
 * Classe corrida, responsável por controlar o acesso crítico
 * de cada thread para correr e contabilizar a posição de cada uma.
 */

//classe motocicleta que é uma Thread
public class Motocicleta extends Thread {
    //nome da thread
    private String nome;
    //inicia salto com 0
    private long pontos = 0;
    //inicia total com 0
    private long total = 0;
    //instancia da classe corrida

    private Corrida corrida = new Corrida();

    //construtor que recebe o nome da thread (motocicleta) e starta cada uma delas
    public Motocicleta(String name) {
        this.nome = name;
    }

    //metodo run da super class thread
    @Override
    public void run() {

            Motocicleta motocicleta = null;
            for (int i = 1; i <= 15; i++) {
                try {
                    System.out.println("------------------------------------------------------------------------------------------------------------------");
                    motocicleta = new Motocicleta(this.getName());
                    //cada uma das threads corre, como o metodo correr de Corrida é sincronizado, cada uma delas corre e espera as demais fazer o mesmo fluxo
                    Integer correr = corrida.correr(this);
                    motocicleta.setPontos(correr);
                    motocicleta.setTotal(motocicleta.getPontos() + motocicleta.getTotal());
                    System.out.println(motocicleta.getNome().toUpperCase() + " GANHOU " + motocicleta.getTotal() + " PONTO");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {

                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Corrida getCorrida() {
        return corrida;
    }

    public void setCorrida(Corrida corrida) {
        this.corrida = corrida;
    }

    public long getPontos() {
        return pontos;
    }

    public void setPontos(long pontos) {
        this.pontos = pontos;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    //imprime na tela a cada ato de correr
    @Override

    public String toString() {
        return nome + ", pontos " + pontos + " total é: " + total;
    }


}

//classe Corrida
class Corrida {

    //usado para contabilizar a colocação de cada uma
    private static volatile Integer cont = 11;

    public Corrida() {

    }

    //metodo correr - acesso sincronizado que será utilizado por todas as threads
    public synchronized Integer correr(Motocicleta motocicleta) {

        cont--;

        if(cont == 0){
            cont = 10;
        }
        return cont;
    }
}



package Corrida.Lebre;
import java.util.Random;

//Lebre - Classe principal para gerar 5 Threads e ja executar.
//classe principal para rodar o projeto
class Principal {
    public static void main(String[] args) {
//cria 5 threads
        for (int i = 1; i < 6; i++) {
            Lebre lebre = new Lebre("Lebre #" + i);
            System.out.println(lebre);
        }
        System.out.println("----------------------------------------------------------------------");
    }
}
/**
 * Classe corrida, responsável por controlar o acesso crítico
 * de cada thread para correr e contabilizar o metrô que cada uma pulou,
 * e quantos metros que cada uma somou na corrida até chegar no final dos 20 metros.
 */

//classe lebre que é uma Thread
public class Lebre extends Thread {
    //usado para contabilizar a colocação de cada uma
    private static volatile Integer cont = 0;
    //nome da thread
    private String nome;
    //inicia salto com 0
    private long salto = 0;
    //inicia pulos com 0
    private long pulos = 0;
    //inicia total com 0
    private long total = 0;
    //instancia da classe corrida
    private Corrida corrida = new Corrida();

    //construtor que recebe o nome da thread (lebre) e starta cada uma delas
    public Lebre(String name) {
        super(name);
        this.nome = name;
        this.start();
    }

    //metodo run da super class thread
    @Override
    public void run() {
        Lebre lebre = null;
        do {
            //cada uma das threads corre, como o metodo correr de Corrida é sincronizado, cada uma delas corre e espera as demais fazer o mesmo fluxo
            lebre = corrida.correr(this);
            try {
                if (lebre.getTotal() >= 20) {
                    synchronized (cont) {
                        cont++;
                    }
                    System.out.println(lebre.getNome().toUpperCase() + " CHEGOU EM " + cont + " LUGAR");
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (lebre.getTotal() < 20);
    }

    public static Integer getCont() {
        return cont;
    }
    public static void setCont(Integer cont) {
        Lebre.cont = cont;
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
    public Corrida getCorrida() {
        return corrida;
    }
    public void setCorrida(Corrida corrida) {
        this.corrida = corrida;
    }
    //imprime na tela a cada ato de correr
    @Override

    public String toString() {
        return nome + ", deu " + pulos + " pulo, saltou " + salto + " metros, total é: " + total;
    }


}
//classe Corrida
class Corrida {
    //limita o final da corrida em 20 metros
    private static long limite = 20;

    //metodo correr - acesso sincronizado que será utilizado por todas as threads
    public synchronized Lebre correr(Lebre lebre) {
        //contabiliza a quantidade de pulos, o total de cada uma até chegar aos 20 metros
        if (lebre.getTotal() <= limite) {
            long pulo = pular();
            lebre.setPulos(lebre.getPulos() + 1L);
            lebre.setSalto(pulo);
            lebre.setTotal(lebre.getTotal() + pulo);
            if (lebre.getTotal() > limite)
                lebre.setTotal(limite);
            System.out.println(lebre);
        }
        return lebre;
    }
    //Sorteia um numero de 1 a 3
    public static long pular() {
        return new Random().longs(1, 4).findFirst().getAsLong();
    }
}



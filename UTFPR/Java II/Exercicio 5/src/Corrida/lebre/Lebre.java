package Corrida.lebre;

public class Lebre extends Thread {

    private static volatile Integer cont = 0;
    private String nome;
    private long salto = 0;
    private long pulos = 0;
    private long total = 0;
    private Corrida corrida = new Corrida();

    public Lebre(String name) {
        super(name);
        this.nome = name;
        this.start();
    }

    @Override
    public void run() {
        Lebre lebre = null;
        do {
            lebre = corrida.correr(this);
            try {
                if (lebre.getTotal() >= 20) {
                    synchronized (cont){
                        cont++;
                    }
                    System.out.println(lebre.getNome().toUpperCase() +" CHEGOU EM " + cont + " LUGAR");
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (lebre.getTotal() < 20);
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

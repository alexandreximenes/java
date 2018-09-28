package Collections;

import java.util.Optional;

public class Aula implements Comparable<Aula>{

    private String titulo;
    private int tempo;

    public Aula(String titulo, int tempo) {
        if(titulo == null || tempo <=0) throw new RuntimeException("valores nulos");
        this.titulo = titulo;
        this.tempo = tempo;
    }

    @Override
    public String toString() {
        return "Aula{" +
                "titulo='" + titulo + '\'' +
                ", tempo=" + tempo +
                '}';
    }

    @Override
    public int compareTo(Aula o) {
        /*if(this.tempo < o.tempo) return -1;*/
        /*if(this.tempo > o.tempo)*/
        /*    return 1;*/
        /*else return 0;*/
        return this.titulo.compareTo(o.titulo);
    }

    public int getTempo() {
        return tempo;
    }

    public String getTitulo() {
        return titulo;
    }
}

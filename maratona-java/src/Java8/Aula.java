package Java8;

public class Aula implements Comparable<Aula>{

    private String titulo;
    private int tempo;

    public Aula(String titulo, int tempo) {
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
        if(!(o instanceof Aula))
            throw new RuntimeException("Não é uma instancia da mesma classe");
        return this.titulo.compareTo(o.titulo);
        /*if(this.tempo < o.tempo) return -1;*/
        /*if(this.tempo > o.tempo)*/
        /*    return 1;*/
        /*else return 0;*/
    }

    public int getTempo() {
        return tempo;
    }

    public String getTitulo() {
        return titulo;
    }
}

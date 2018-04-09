package br.com.alura.collections;

public class Aula implements Comparable<Aula> {

	private String		titulo;
	private Integer	tempo;

	public Aula(String titulo, int tempo) {
		this.titulo = titulo;
		this.tempo = tempo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	@Override
	public int compareTo(Aula oAula) {
		return this.titulo.compareTo(oAula.titulo);

	}

	@Override
	public String toString() {
		return titulo + " : " + tempo + " minutos";
	}

}

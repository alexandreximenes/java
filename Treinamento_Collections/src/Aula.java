/**
 * @autor Alexandre Ximenes
 */
public class Aula implements Comparable<Aula>{
	
	private String nome;
	private double preco;
	private int tempo;
	
	public Aula(String nome, double preco, int tempo) {
		this.nome = nome;
		this.preco = preco;
		this.tempo = tempo;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return nome +", "+ preco + " - " + tempo;
	}

	@Override
	public int compareTo(Aula o) {
		if(this.preco < o.preco) return -1;
		if(this.preco > o.preco) return 1;
		return 0;
		//return this.nome.compareTo(o.nome);
	}
	
	

}

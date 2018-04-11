package TrabalhandoComSTREAM;

public class Curso {

	private String nome;
	private int alunos;
	
	
	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAlunos() {
		return alunos;
	}
	public void setAlunos(int alunos) {
		this.alunos = alunos;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + nome + ", com " + alunos + " alunos]";
	}
}

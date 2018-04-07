/**
 * @autor Alexandre Ximenes
 */
public class Aluno implements Comparable<Aluno>{
	private String nome;
	private Integer nota;
	private Integer matricula;
	
	/** Constructor
	 * @param nome
	 * @param nota
	 */
	public Aluno(String nome, Integer nota, Integer matricula) {
		if(nome == null) throw new NullPointerException("Nome não pode ser nulo!");
		this.nome = nome;
		this.nota = nota;
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public Integer getMatricula() {
		return matricula;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Aluno)) 
			return false;
		
		Aluno outro = (Aluno) obj;
		
		//if(this.matricula.equals(outro.matricula) && this.nome.equals(outro.nome)) {
		if(this.matricula.equals(outro.matricula)) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.nome.hashCode();
	}
	
	public String toString() {
		return nome +", com matricula : " + matricula + ", tirou "+ nota; 

	}

	@Override
	public int compareTo(Aluno o) {
		// TODO Auto-generated method stub
		return this.nome.compareTo(o.nome);
	}

	public Integer getNota() {
		return nota;
	}
	
	

}

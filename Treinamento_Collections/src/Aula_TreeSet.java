/**
 * @autor Alexandre Ximenes
 * Aula de LinkedHashSet
 * Pertence ao conjunto Set, mas com ordenação, diferentemente do HashSet
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Aula_TreeSet {

	private String nome;
	private String instrutor;
	private List<Aula> aulas = new ArrayList<>();
	private Set<Aluno> alunos = new TreeSet<>(Comparator.comparing(Aluno::getNota));
	
	public Aula_TreeSet(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getInstrutor() {
		return instrutor;
	}
	public void setInstrutor(String instrutor) {
		this.instrutor = instrutor;
	}
	public List<Aula> getAulas() {
		//return aulas;
		return Collections.unmodifiableList(aulas);
	}
	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}
	
	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}
	
	public int tempoTotalAulas() {
		//NOVA FORMA DE SOMAR O TEMPO DAS AULAS.
		return aulas.stream().mapToInt(Aula::getTempo).sum();
		/**
		 * for TRADICIONAL ABAIXO
		 */
//		int tempo = 0;
//		for(Aula a : aulas) {
//			tempo += a.getTempo();
//		}
//		return tempo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[Curso : "+ nome + "[" + aulas +"]]";
	}
	
	public void matricula(Aluno aluno) {
		// set
		alunos.add(aluno);
	}
	
	public Set<Aluno> getAlunos(){
		return Collections.unmodifiableSet(alunos);
	}
	public boolean estaMatriculado(Aluno aluno) {
		return this.alunos.contains(aluno);
	}
	
	
}

/**
 * @autor Alexandre Ximenes
 * 
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestaCurso {

	public static void main(String[] args) {
		
		Curso c1 = new Curso("java", "instrutor 1");
		Curso c2 = new Curso("javascript", "instrutor 2");
		Curso c3 = new Curso("python", "instrutor 3");

		Aluno a1 = new Aluno("alexandre", 5, 123456);
		Aluno a2 = new Aluno("day", 9, 5465465);
		Aluno a3 = new Aluno("arthur", 10, 6666);
		Aluno a4 = new Aluno("alexandre Ximenes", 5, 122223456);
		
		c1.matricula(a1);
		c1.matricula(a2);
		c1.matricula(a3);
		c1.matricula(a4);
		
		System.out.println("Set | quantidade de alunos : " +c1.getAlunos().size());
		
		// Recebendo uma estrutura de dados do tipo Set no construtor, pois os dois herdam de Collection e são compativeis
		List<Aluno> alunos = new ArrayList<>(c1.getAlunos());
		System.out.println("List | quantidade de alunos : " +alunos.size());
		
		//Nova forma de ordenar com Java 8
		alunos.sort(Comparator.comparing(Aluno::getNota));
		System.out.println("\nOrdenado por Nota");
		alunos.forEach(aluno -> System.out.println(aluno));
		
//		System.out.println("\nSoma das notas : "+ alunos.stream().mapToInt(Aluno::getNota).sum());
//		System.out.println("Media das notas : "+ alunos.stream().mapToDouble(Aluno::getNota).average());
//		
		System.out.print("\n" + a1.getNome() +" - Matricula: [" + a1.getNome() +" "+  a1.getMatricula() + "] é o mesmo que ["+ a4.getNome() +" "+ a4.getMatricula() + "] = ");
		System.out.println(a1.equals(a4));
		
		System.out.print("\nO aluno " + a4.getNome() + " esta matriculado ?");
		System.out.println(c1.estaMatriculado(a4));
	}

}

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author Alexandre Ximenes
 * Testando LinkedHashSet
 *
 */
public class Testa_Aula_LinkedHashSet {

	public static void main(String[] args) {
		
		Aula_LinkedHashSet c1 = new Aula_LinkedHashSet("java", "instrutor 1");
		
		Aluno a1 = new Aluno("alexandre", 5, 123456);
		Aluno a2 = new Aluno("day", 9, 5465465);
		Aluno a3 = new Aluno("arthur", 10, 6666);
		Aluno a4 = new Aluno("alexandre Ximenes", 5, 122223456);
		
		c1.matricula(a1);
		c1.matricula(a2);
		c1.matricula(a3);
		c1.matricula(a4);
		c1.matricula(a4);
		
		// Não aceita elementos repetidos
		System.out.println(c1.getAlunos().size());
		
		// Testando aluno
		System.out.println(c1.estaMatriculado(new Aluno("a", 5, 3)));

		List<Aluno> alunos = new ArrayList<>(c1.getAlunos());
		/**
		 * Percorre alunos com Java 8
		 */
		alunos.forEach(aluno -> System.out.println(aluno));
		
		/**
		 * Ordena com Java 8
		 */
		System.out.println("\n");
		alunos.sort(Comparator.comparing(Aluno::getMatricula));
		alunos.forEach(aluno -> System.out.println(aluno));
		
		/**
		 * Soma as notas com Java 8
		 */
		System.out.println("\nSoma das notas : " + 
			 alunos.stream()
			.mapToInt(Aluno::getNota)
			.sum()
		);
		
	}

}

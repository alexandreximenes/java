import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author Alexandre Ximenes
 * Testando LinkedHashSet
 *
 */
public class Testa_Aula_TreeSet {

	public static void main(String[] args) {
		
		Aula_TreeSet treeSet = new Aula_TreeSet("java", "instrutor 1");
		
		Aluno a1 = new Aluno("alexandre", 5, 123456);
		Aluno a2 = new Aluno("day", 9, 5465465);
		Aluno a3 = new Aluno("arthur", 10, 6666);
		Aluno a4 = new Aluno("alexandre Ximenes", 5, 122223456);
		
		treeSet.matricula(a1);
		treeSet.matricula(a2);
		treeSet.matricula(a3);
		treeSet.matricula(a4);
		treeSet.matricula(a4);
		
		// Não aceita elementos repetidos
		System.out.println(treeSet.getAlunos().size());
		
		// Testando aluno
		System.out.println(treeSet.estaMatriculado(new Aluno("a", 5, 3)));

		Set<Aluno> sAlunos = new TreeSet<>(treeSet.getAlunos());
		/**
		 * Percorre alunos com Java 8
		 */
		sAlunos.forEach(aluno -> System.out.println(aluno));
		
		
		List<Aluno> cAlunos = new ArrayList<>(treeSet.getAlunos());
		/**
		 * Ordena com Java 8
		 */
		System.out.println("\n");
		cAlunos.sort(Comparator.comparing(Aluno::getMatricula));
		cAlunos.forEach(aluno -> System.out.println(aluno));
		
		/**
		 * Soma as notas com Java 8
		 */
		System.out.println("\nSoma das notas : " + 
			 cAlunos.stream()
			.mapToInt(Aluno::getNota)
			.sum()
		);
		
	}

}

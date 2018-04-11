package TrabalhandoComSTREAM;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class PrincipalCursos {

	public static void main(String[] args) {
		
		List<Curso> cursos = new ArrayList<>();
		//Numeros aleatorios, sem embasamento
		cursos.add(new Curso("Python", 900));
		cursos.add(new Curso("JavaScript", 1500));
		cursos.add(new Curso("Java", 1030));
		cursos.add(new Curso("C#", 1029));
		
		//Ordenando por alunos
		cursos.sort(Comparator.comparing(Curso::getAlunos));

		//imprime os cursos
		cursos.forEach(s -> System.out.println(s));
		
		//Trabalhando com Strem
		Optional<Curso> first = cursos.stream().findFirst();
		
		//Imprimindo o primeiro curso
		imprime(first);
		
		//Quantidade de cursos
		long count = cursos.stream().count();
		imprime(count);
		
		//Filtrar por cursos com mais de 1000 alunos
		Stream<Curso> filter = cursos.stream()
		.filter(c -> c.getAlunos() >= 1000);
		
		//imprime o filtro
		filter.forEach(f -> System.out.println(f));
	}

	private static void imprime(Object s) {
		System.out.println(s);
	}

}

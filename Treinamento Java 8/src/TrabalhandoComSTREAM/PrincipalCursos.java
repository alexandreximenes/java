package TrabalhandoComSTREAM;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
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
		
		//1 forma - Filtrar por cursos com mais de 1000 alunos
		Stream<Curso> filterStream = cursos.stream()
		.filter(c -> c.getAlunos() >= 1000);
		filterStream.forEach(f -> System.out.println(f));
	
		//2 forma - Filtrar por cursos com mais de 1000 alunos
		cursos.stream()
		.filter(c -> c.getAlunos() >= 1000)
		.forEach(c -> System.out.println(c.getNome()));
		
		//Usando map para saber quanto 
		cursos.stream()
		.filter(c -> c.getAlunos() >= 1000)
		.map(Curso::getAlunos)
		.forEach(System.out::println);
				
		
		//Somando todos os alunos
		int sum = cursos.stream().mapToInt(Curso::getAlunos).sum();
		System.out.println("\nSoma total de alunos : " +sum);
		
		//Media dos alunos
		OptionalDouble average = cursos.stream().mapToDouble(Curso::getAlunos).average();
		System.out.println("\nMedia total de alunos : "+ average);
	
		//Pegando soma total dos alunos com um filtro
		// deve retornar java e javascript
		System.out.println("\nPercorrendo o array e procurando por nome de cursos que contenham AV");
		cursos.stream()
		.filter(c -> c.getNome().contains("av"))
		.forEach(System.out::println);
	}

	private static void imprime(Object s) {
		System.out.println(s);
	}

}

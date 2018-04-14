package TrabalhandoComSTREAM;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContinuandoComStream {

	public static void main(String[] args) {
		
		List<Curso> cursos = new ArrayList<>();
		//Numeros aleatorios, sem embasamento
		
		cursos.add(new Curso("Python", 900));
		cursos.add(new Curso("JavaScript", 1500));
		cursos.add(new Curso("Java", 1030));
		cursos.add(new Curso("C#", 1029));
		
		
		//Ordena por nome
		
		cursos.sort(Comparator.comparing(Curso::getNome));
		
		//Mostra os cursos com mais de 1000 alunos e que começam com Java
		
		cursos.stream()
			.filter( c -> c.getAlunos() >= 1000 && c.getNome().startsWith("Java") )
			.forEach(System.out::println);
		
		
		//Mostra o primeiro curso com mais de 1000 alunos
		Optional<Curso> first = cursos.stream()
			.filter(c -> c.getAlunos() > 1000)
			.findFirst();
		//imprime(first);
		
		
		cursos.stream()
				.filter(c -> c.getAlunos() > 1029)
				.findAny()
				.ifPresent(c -> System.out.println(c));
		
		//Fazendo filtro nos cursos e devolvendo uma nova lista atribuindo a cursos
		
		cursos = cursos.stream()
				.filter(c -> c.getAlunos() > 1000)
				.collect(Collectors.toList());
		
		// Fazendo filtro nos cursos e devolvendo um Set de cursos
		
		Set<Curso> setCursos = cursos.stream()
				.filter(c -> c.getAlunos() > 1000)
				.collect(Collectors.toSet());
		//setCursos.forEach(c -> System.out.println(c));
		
		
		
		System.out.println("\nFiltrando alunos com mais de 3 caracteres");
		// fazendo um filtro para os cursos com nome com mais de tres caracteres
		//Map<String, Integer> collect = 
			 
		cursos.stream()
			.filter(c -> c.getNome().length() >= 3)
			.collect(Collectors.toMap(
					c -> c.getNome(), 
					c -> c.getAlunos()))
		.forEach( (nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos.") );
		
		//collect.forEach((nome, alunos) -> System.out.println(nome + " -- "+ alunos));
		
		// Em paralelo
		cursos.parallelStream()
		.filter(c -> c.getNome().length() >= 3)
		.collect(Collectors.toMap(
				c -> c.getNome(), 
				c -> c.getAlunos()))
	.forEach( (nome, alunos) -> System.out.println(nome + "[ tem " + alunos + " alunos].") );
	
		
	}

	private static void imprime(Object s) {
		System.out.println(s);
	}

}

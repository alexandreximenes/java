/**
 * @autor Alexandre Ximenes
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AulaArrayList {

	public static void main(String[] args) {
		
		// Adiciona aulas na lista
		
		List<Aula> aulas = new ArrayList<>();
		aulas.add(new Aula("aula 2", 20.0, 20));
		aulas.add(new Aula("aula 1", 50.0, 30));
		aulas.add(new Aula("aula 5", 30.0, 100));
		aulas.add(new Aula("aula 3", 40.0, 5));
		aulas.add(new Aula("aula 4", 100.0, 9));
		
		
		System.out.println("sem ordenação : "+aulas);
		
		// Ordenação da forma antiga
		
		Collections.sort(aulas);
		System.out.println("com ordenação por preco: "+aulas);
		
		//Ordenação com Java 8
		// A lista aulas, recebe um comparator que é metodo da classe aula referente ao atributo que se quer ordenar, neste caso, Nome 
		
		aulas.sort(Comparator.comparing(Aula::getNome));
		System.out.println("com ordenação por nome: "+aulas);
		
		//Ordenação com Java 8
		// A lista aulas, recebe um comparator que é metodo da classe aula referente ao atributo que se quer ordenar, neste caso, tempo 
		
		aulas.sort(Comparator.comparing(Aula::getTempo));
		System.out.println("com ordenação por tempo: "+aulas);
		
		// Nova forma de percorrer um array no Java 8
		aulas.forEach(aula -> System.out.println(aula));
		
		//Ordenação com Java 8
		// A lista aulas, recebe um comparator que é metodo da classe aula referente ao atributo que se quer ordenar, neste caso, preço 
				
		aulas.sort(Comparator.comparing(Aula::getPreco));
		System.out.println("com ordenação por preco: "+aulas);
		
		//aulas.forEach(aula -> System.out.println(aula));
		
		Curso curso = new Curso("jair", "jair instrutor");
		
		//Não funciona porque a lista é imutavel Collections.unmofiableList(aula)
		//curso.getAulas().add(new Aula("", 1.1, 1));
		
		curso.adiciona(new Aula("java", 1.1, 1));
		curso.adiciona(new Aula("java", 1.1, 10));
		System.out.println(curso);
		
		System.out.println(curso.getAulas());
		
		System.out.println("tempo total de aulas : "+curso.tempoTotalAulas());
		
		// Metodos novos do Java 8 usando uma forma parecida com o reduce do javascript
		System.out.println("findAny : "+aulas.stream().mapToDouble(Aula::getPreco).findAny());
		System.out.println("findFirst : "+aulas.stream().mapToDouble(Aula::getPreco).findFirst());
		System.out.println("disrinct : "+aulas.stream().mapToDouble(Aula::getPreco).distinct());
		System.out.println("boxed : "+aulas.stream().mapToDouble(Aula::getPreco).boxed());
		System.out.println("quantidade : "+aulas.stream().mapToDouble(Aula::getPreco).count());
		System.out.println("minimo : "+aulas.stream().mapToDouble(Aula::getPreco).min());
		System.out.println("maximo : "+aulas.stream().mapToDouble(Aula::getPreco).max());
		System.out.println("soma : "+aulas.stream().mapToDouble(Aula::getPreco).sum());
		System.out.println("media : "+aulas.stream().mapToDouble(Aula::getPreco).average());
		System.out.println("max : "+aulas.stream().max(Comparator.comparing(Aula::getPreco)));
		
	}

}

package br.com.alura.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestandoAula {

	public static void main(String[] args) {

		Aula a = new Aula("aula 1", 15);
		Aula c = new Aula("aula 3", 50);
		Aula b = new Aula("aula 2", 3);
		Aula d = new Aula("aula 4", 1);
		Aula e = new Aula("aula 2", 5);

		List<Aula> aulas = new ArrayList<>();
		aulas.add(a);
		aulas.add(b);
		aulas.add(c);
		aulas.add(d);
		aulas.add(e);

		System.out.println(aulas);

		Collections.sort(aulas);

		System.out.println(aulas);

		Collections.sort(aulas, Comparator.comparing(Aula::getTempo));

		System.out.println(aulas);

		aulas.sort(Comparator.comparing(Aula::getTempo));

		System.out.println(aulas);

		aulas.sort(Comparator.comparing(Aula::getTitulo));

		System.out.println(aulas);

	}

}

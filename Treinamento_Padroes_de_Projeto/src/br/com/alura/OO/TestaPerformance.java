package br.com.alura.OO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class TestaPerformance {
	public static void main(String[] args) {
		Collection<Integer> numeros = new HashSet<>();//new ArrayList<>();//new HashSet<>();
		
		int total = 200_000;
		
		long inicio = System.currentTimeMillis();
		
		for (int i = 0; i < total; i++) {
			numeros.add(i);
			///System.out.println(i);
        }
		
		for (int i = 0; i < total; i++) {
			numeros.contains(i);
        }
		
		long fim = System.currentTimeMillis();
        long tempo = fim - inicio;
        System.out.println("Tempo gasto: " + tempo );
		
	}

}

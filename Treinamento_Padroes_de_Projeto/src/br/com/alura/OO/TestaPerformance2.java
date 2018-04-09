package br.com.alura.OO;

import java.util.ArrayList;
import java.util.List;

public class TestaPerformance2 {
	

	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<>();//new LinkedList ArrayList<>();//new HashSet<>();
		
		int total = 300_000;
		
		long inicio = System.currentTimeMillis();
		
		for (int i = 0; i < total; i++) {
			numeros.add(0, i);
			
        }
		
		
		
		for (int i = 0; i < total; i++) {
			numeros.get(i);
			
        }
		
		long fim = System.currentTimeMillis();
        double tempo = (fim - inicio) / 1000.0;
        System.out.println("Tempo gasto: " + tempo);
		
	}



}

package br.com.alura.OO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TestaOrdenacao {

	public static void main(String[] args) {
		List<ContaPoupanca> lista = new LinkedList<>();//new ArrayList<>();
		Random r;
		ContaPoupanca cp1;
		
		for (int i = 0 ; i< 100 ; i++) {
			r = new Random();
			cp1 = new ContaPoupanca();
			cp1.depositar(r.nextInt(1000) + r.nextDouble() ) ;
			cp1.setNumero(r.nextInt(100));
			lista.add(cp1);
		}
		
		for(ContaPoupanca cp : lista) {
			System.out.println(cp);
		}
	
		System.out.println();
		
		//Collections.reverse(lista);
		Collections.sort(lista);
		
		for(ContaPoupanca cp : lista) {
			System.out.println(cp);
		}
		
	}
	
	

}

package br.com.alura.OO;

import java.util.HashMap;
import java.util.Map;

public class TestaMapa {
	
	public static void main(String[] args) {
		
		Conta c1 = new ContaCorrente();
        c1.depositar(10000);

        Conta c2 = new ContaCorrente();
        c2.depositar(3000);

        // cria o mapa
        Map map = new HashMap();
        map.put("diretor", c1);
        map.put("gerente", c2);
        
        System.out.println(map.size());
        
        Conta c3 = (Conta) map.get("gerentee");
        System.out.println(c3.getSaldo());
	}

}

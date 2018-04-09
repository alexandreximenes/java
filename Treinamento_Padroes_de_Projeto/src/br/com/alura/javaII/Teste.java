package br.com.alura.javaII;

public class Teste {
	public static void main(String[] args) {

		Conta c = new Conta();
		c.setNome("alexandre");
		c.setValor(1000);

		Conta c2 = new Conta();
		c2.setNome("dayane");
		c2.setValor(1000);

		System.out.println(c);

		if (c.equals(new Object())) {
			System.out.println("iguais");
		} else {
			System.out.println("diferente");
		}

	}

}

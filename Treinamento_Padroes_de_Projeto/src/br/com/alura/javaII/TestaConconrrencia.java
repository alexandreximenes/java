package br.com.alura.javaII;

public class TestaConconrrencia {
	public static void main(String[] args) throws InterruptedException {
		BarraDeProgresso progresso = new BarraDeProgresso();
		Thread t1 = new Thread(progresso);
		t1.start();

		CopiadorDeArquivo copiador = new CopiadorDeArquivo();
		Thread t2 = new Thread(copiador);
		t2.start();

		t1.join();
		t2.join();

	}

}

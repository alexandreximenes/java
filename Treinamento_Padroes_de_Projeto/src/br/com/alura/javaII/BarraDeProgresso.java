package br.com.alura.javaII;

public class BarraDeProgresso implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10_000; i++) {
			System.err.print(i + " ");
			System.out.println("barra de progresso");
		}

	}
}

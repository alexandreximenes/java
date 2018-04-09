package br.com.alura.OO;

class AtualizadorDeContas {
	private static double saldoTotal = 0;
	private double selic;

	public AtualizadorDeContas(double selic) {
		this.selic = selic;
	}

	public static double getSaldoTotal() {
		return saldoTotal;
	}

	public void roda(Conta c) {
		System.out.println("\nSaldo Atual: "+ c.getSaldo());
		c.atualiza(this.selic);
		saldoTotal += c.getSaldo();

		System.out.println("Saldo Atualizado: "+c.getSaldo());
		System.out.println("Total : "+AtualizadorDeContas.getSaldoTotal());
	}

}
package br.alura.refatoracao.cap1;

public class GeradorDeNotaFiscal {

	public NotaFiscal gera(Fatura fatura) {

		NotaFiscal nf = calculaImposto(fatura);

		EnviaEmail.send(nf);
		
		NFdao.insere(nf);

		return nf;
	}

	

	private NotaFiscal calculaImposto(Fatura fatura) {
		double valor = fatura.getValorMensal();
		double imposto = 0;
		if(valor < 200) {
			imposto = valor * 0.03;
		}
		else if(valor > 200 && valor <= 1000) {
			imposto = valor * 0.06;
		}
		else {
			imposto = valor * 0.07;
		}
		
		NotaFiscal nf = new NotaFiscal(valor, imposto);
		return nf;
	}

	
}
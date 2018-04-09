package Strategy;

public class TestaOrcamento {
	
	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento(150);
		
		Imposto icms = new ICMS();
		Imposto iss = new ISS();		
		
		CalculadorDeImposto calc = new CalculadorDeImposto();
		
		calc.realizaCalculo(orcamento, icms);
		calc.realizaCalculo(orcamento, iss);
	}

}

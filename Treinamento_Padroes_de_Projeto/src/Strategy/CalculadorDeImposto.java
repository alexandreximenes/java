package Strategy;

public class CalculadorDeImposto {
	public void realizaCalculo(Orcamento orcamento, Imposto imposto) {
		double valor = imposto.calcula(orcamento);
		System.out.println(valor);
	};
}

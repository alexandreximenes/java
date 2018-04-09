package br.com.alura.OO;

public class TestaTributavel {
	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente();
        cc.depositar(100);
        ContaCorrente cc2 = new ContaCorrente();
        cc2.depositar(100);
        System.out.println(cc2.calcularTributos());
        
        Tributavel tv = cc;
        Tributavel tv2 = cc2;
        System.out.println(tv.calcularTributos());
        System.out.println(tv2.calcularTributos());
        
        GerenciadorDeImpostos g = new GerenciadorDeImpostos();
        g.adiciona(cc);
        g.adiciona(cc2);
        
        g.getTotal();

	}
}

package br.com.alexandre.maven.Projeto;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProdutoTest {
	
	@Test
	public void verificaPrecoComImposto() {
		Produto bala = new Produto("bala", 0.10);
		assertEquals(0.10, bala.getPrecoProduto());
		
	}

}

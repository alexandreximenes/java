package br.com.alura.OO.avancado;

public class Cnpj {
	private String numero;

	public Cnpj(String numero) {
		this.numero = numero;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public boolean ehValido() {
        return primeiroDigitoVerificador() == primeiroDigitoCorreto()
                && segundoDigitoVerificador() == segundoDigitoCorreto();
    }
    private int primeiroDigitoVerificador() {
		return 0;
        // Extrai o primeiro d�gito verificador do CNPJ armazenado
        // no atributo valor
    }
    private int primeiroDigitoCorreto() {
		return 0;
        // Calcula o primeiro d�gito verificador correto para
        // o CNPJ armazenado no atributo valor
    }
    private int segundoDigitoVerificador() {
		return 0;
        // Extrai o segundo d�gito verificador do CNPJ armazenado
        // no atributo valor
    }
    private int segundoDigitoCorreto() {
		return 0;
        // Calcula o segundo d�gito verificador correto para
        // o CNPJ armazenado no atributo valor
    }
    
    @Override
    public String toString() {
    	return numero;
    }
	
	

}

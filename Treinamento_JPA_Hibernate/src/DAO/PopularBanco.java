package DAO;

import model.Conta;

public class PopularBanco {
	
	public static void start() {
		Conta conta = new Conta()
				.setTitular("Alexandre")
				.setNumero("00000")
				.setAgencia("001")
				.setBanco("Banco do Brasil");
		

		Conta conta2 = new Conta()
				.setTitular("Dayane")
				.setNumero("11111")
				.setAgencia("341")
				.setBanco("Banco Itau");
		

		Conta conta3 = new Conta()
				.setTitular("Arthur")
				.setNumero("22222")
				.setAgencia("002")
				.setBanco("Banco do Tata");
		

		Conta conta4 = new Conta()
				.setTitular("Amanda")
				.setNumero("33333")
				.setAgencia("003")
				.setBanco("Banco da Tata");
		

		Conta conta5 = new Conta()
				.setTitular("Marlene")
				.setNumero("44444")
				.setAgencia("004")
				.setBanco("Banco dos Ricos");
				
			ContaDAO dao = new ContaDAO();
			dao.salvar(conta);
			dao.salvar(conta2);
			dao.salvar(conta3);
			dao.salvar(conta4);
			dao.salvar(conta5);
	}

}

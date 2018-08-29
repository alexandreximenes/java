package DAO;

import model.ContaFisica;
import model.ContaJuridica;

public class PopularBanco {

	public static void start() {

		ContaFisica fisica1 = new ContaFisica();
		fisica1.setTitular("Alexandre");
		fisica1.setNumero("00000");
		fisica1.setAgencia("001");
		fisica1.setBanco("Banco do Brasil");
		fisica1.setCpf("00000000");

		ContaFisica fisica2 = new ContaFisica();
		fisica2.setTitular("Dayane");
		fisica2.setNumero("11111");
		fisica2.setAgencia("341");
		fisica2.setBanco("Banco Itau");
		fisica2.setCpf("11111111");

		ContaFisica fisica3 = new ContaFisica();
		fisica3.setTitular("Arthur");
		fisica3.setNumero("22222");
		fisica3.setAgencia("002");
		fisica3.setBanco("Banco do Tata");
		fisica3.setCpf("222222222");

		ContaFisica fisica4 = new ContaFisica();
		fisica4.setTitular("Arthur");
		fisica4.setNumero("22222");
		fisica4.setAgencia("002");
		fisica4.setBanco("Banco do Tata");
		fisica4.setCpf("33333333");

		ContaFisica fisica5 = new ContaFisica();
		fisica5.setTitular("Marlene");
		fisica5.setNumero("44444");
		fisica5.setAgencia("004");
		fisica5.setBanco("Banco dos Ricos");
		fisica5.setCpf("44444444");

		/**
		 * Conta juridica
		 */

		ContaJuridica juridica1 = new ContaJuridica();
		juridica1.setTitular("Alexandre");
		juridica1.setNumero("00000");
		juridica1.setAgencia("001");
		juridica1.setBanco("Banco do Brasil");
		juridica1.setCnpj("000000000-0001-00");

		ContaJuridica juridica2 = new ContaJuridica();
		juridica2.setTitular("Dayane");
		juridica2.setNumero("11111");
		juridica2.setAgencia("341");
		juridica2.setBanco("Banco Itau");
		juridica2.setCnpj("000000000-0001-00");

		ContaJuridica juridica3 = new ContaJuridica();
		juridica3.setTitular("Arthur");
		juridica3.setNumero("22222");
		juridica3.setAgencia("002");
		juridica3.setBanco("Banco do Tata");
		juridica3.setCnpj("000000000-0002-00");
		
		ContaJuridica juridica4 = new ContaJuridica();
		juridica4.setTitular("Arthur");
		juridica4.setNumero("22222");
		juridica4.setAgencia("002");
		juridica4.setBanco("Banco do Tata");
		juridica4.setCnpj("000000000-0003-00");
		
		ContaJuridica juridica5 = new ContaJuridica();
		juridica5.setTitular("Marlene");
		juridica5.setNumero("44444");
		juridica5.setAgencia("004");
		juridica5.setBanco("Banco dos Ricos");
		juridica5.setCnpj("000000000-0004-00");
	
		ContaFisicaDAO fisicaDAO = new ContaFisicaDAO();
		ContaJuridicaDAO juridicaDAO = new ContaJuridicaDAO();
		
		fisicaDAO.salvar(fisica1);
		fisicaDAO.salvar(fisica2);
		fisicaDAO.salvar(fisica3);
		fisicaDAO.salvar(fisica4);
		fisicaDAO.salvar(fisica5);
		
		juridicaDAO.salvar(juridica1);
		juridicaDAO.salvar(juridica2);
		juridicaDAO.salvar(juridica3);
		juridicaDAO.salvar(juridica4);
		juridicaDAO.salvar(juridica5);
		
	}

}

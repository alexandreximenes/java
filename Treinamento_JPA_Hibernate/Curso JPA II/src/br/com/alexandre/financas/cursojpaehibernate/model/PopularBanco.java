package br.com.alexandre.financas.cursojpaehibernate.model;

import br.com.alexandre.financas.cursojpaehibernate.dao.ClienteDAO;
import br.com.alexandre.financas.cursojpaehibernate.dao.ContaDAO;

public class PopularBanco {

	public static void start() {
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente1 = new Cliente("Alexandre Ximenes", "Analista de sistemas", "Rua X n Y", "222222222");
		clienteDAO.salvar(cliente1);

		Cliente cliente2 = new Cliente("Arthur Ximenes", "estudante", "Rua X n Y", "33333333");
		clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente2);

		Cliente cliente3 = new Cliente("Dayane Ximenes", "Promotora Senior Siemens", "Rua X n Y", "444444445");
		clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente3);

		Cliente cliente4 = new Cliente("Regina Ximenes", "Chefe de cozinha", "Rua X n Y", "00000000");
		clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente4);

		Cliente cliente5 = new Cliente("Vanderlei Ximenes", "Engenheiro Mecanico", "Rua X n Y", "11111111");
		clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente5);

		Conta fisica1 = new Conta();
		fisica1.setNumero("00000");
		fisica1.setAgencia("001");
		fisica1.setBanco("Banco do Brasil");
		fisica1.setCliente(cliente1);

		Conta fisica2 = new Conta();
		fisica2.setNumero("11111");
		fisica2.setAgencia("341");
		fisica2.setBanco("Banco Itau");
		fisica2.setCliente(cliente2);
		
		Conta fisica3 = new Conta();
		fisica3.setNumero("22222");
		fisica3.setAgencia("002");
		fisica3.setBanco("Banco do Tata");
		fisica3.setCliente(cliente3);
		
		Conta fisica4 = new Conta();
		fisica4.setNumero("22222");
		fisica4.setAgencia("002");
		fisica4.setBanco("Banco do Tata");
		fisica4.setCliente(cliente4);
		
		Conta fisica5 = new Conta();
		fisica5.setNumero("44444");
		fisica5.setAgencia("004");
		fisica5.setBanco("Banco dos Ricos");
		fisica5.setCliente(cliente5);
		/**
		 * Conta juridica
		 */
/*
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
	*/
		ContaDAO fisicaDAO = new ContaDAO();
//		ContaJuridicaDAO juridicaDAO = new ContaJuridicaDAO();
		
		fisicaDAO.salvar(fisica1);
		fisicaDAO.salvar(fisica2);
		fisicaDAO.salvar(fisica3);
		fisicaDAO.salvar(fisica4);
		fisicaDAO.salvar(fisica5);
		
//		juridicaDAO.salvar(juridica1);
//		juridicaDAO.salvar(juridica2);
//		juridicaDAO.salvar(juridica3);
//		juridicaDAO.salvar(juridica4);
//		juridicaDAO.salvar(juridica5);
//		
	}

}

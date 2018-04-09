package br.alura.refatoracao.cap2;

import java.util.List;

public class Trem {

	private List<Vagao> vagoes;
	private int capacidade;
	
	public boolean lugaresDisponiveis(int reservas) {
		
		int lugaresJaReservados = capacidade - lugaresJaReservados();
		return lugaresJaReservados > reservas; 
	}

	private int lugaresJaReservados() {
		int lugaresJaReservados = 0;
		for(Vagao vagao : vagoes) {
			lugaresJaReservados += vagao.reservados();
		}
		return lugaresJaReservados;
	}
	
}
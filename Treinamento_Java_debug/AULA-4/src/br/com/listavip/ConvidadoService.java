package br.com.listavip;

import java.sql.SQLException;
import java.util.List;

public class ConvidadoService {
	
	public List<Convidado> obterTodos(){
		return new ConvidadoRepository().obterTodos();
	}
	
	public void salvar(Convidado convidado) throws SQLException{
		new ConvidadoRepository().salvar(convidado);
		
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Aluno;

/**
 *
 * @author Programmer
 */
public class Cliente {
    /*
    public Aluno getAluno(){
        Client cliente = ClientBuilder.newClient();
        Aluno aluno = cliente.target("http://localhost:8080/WSAndroid/webresources/alunos/1").request(MediaType.APPLICATION_JSON).get(Aluno.class);
        
        return aluno;
    }
    
    public String getListAluno(){
        Client cliente = ClientBuilder.newClient();
        String alunos = cliente.target("http://localhost:8080/WSAndroid/webresources/alunos").request(MediaType.APPLICATION_JSON).get(String.class);
        
        return alunos;
    }
    
    public Response postAluno(Aluno aluno){
        Client cliente = ClientBuilder.newClient();
        Response retorno = cliente.target("http://localhost:8080/WSAndroid/webresources/alunos").request(MediaType.APPLICATION_JSON).post(Entity.json(aluno));
        
        return retorno;
    }
   */ 
}

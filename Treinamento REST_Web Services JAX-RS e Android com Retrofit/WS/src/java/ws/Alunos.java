/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dao.AlunoDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Aluno;


/**
 * REST Web Service
 *
 * @author Alexandre Ximenes
 */
@Path("/alunos")
public class Alunos {

    @Context
    private UriInfo context;
    private AlunoDAO dao;
    /**
     * Creates a new instance of Alunos
     */
    public Alunos() {
    }

    /**
     * Retrieves representation of an instance of ws.Alunos
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAlunos() {
        
        dao = new AlunoDAO();
        List<Aluno> alunos = dao.getAlunos();
        Gson g = new Gson();
        return g.toJson(alunos);
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String postAluno(String objeto){
        
        Gson g = new Gson();
        Aluno aluno = null;
        try{
            aluno = g.fromJson(objeto, Aluno.class);
        }catch(Exception e){
            return g.toJson("Dados recebidos são invalidos!");
        }
        
        dao = new AlunoDAO();
        
        String retorno = dao.salvar(aluno);
        
        return g.toJson(retorno);
 
    }
    
    @DELETE
    @Path("/{id}")
    public String deleteAluno(@PathParam("id") String id){
        dao = new AlunoDAO();
        Gson g = new Gson();
        String resposta = dao.excluir(id);
        return g.toJson(resposta);

    }    
    
    /**
     * PUT method for updating or creating an instance of Alunos
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String objeto) {
        
        dao = new AlunoDAO();
        Gson g = new Gson();
        Aluno aluno = g.fromJson(objeto, Aluno.class);
        
        String retorno = dao.salvar(aluno);

        return g.toJson(retorno);
  
        
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAluno(@PathParam("id") String id){
        dao = new AlunoDAO();
        Gson g = new Gson();
        try{
            Aluno aluno = dao.getAlunoID(id);
            if(aluno!=null){
                return g.toJson(aluno);
            }
        }catch(Exception e){
            return g.toJson("Dado recebido é invalido!");
        }
        return g.toJson("ID inexistente");
    }    
}

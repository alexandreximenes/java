/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.AlunoDAO;
import javax.ws.rs.core.Response;
import model.Aluno;
import model.Endereco;

/**
 *
 * @author Programmer
 */
public class Principal {
    
    public static void main(String [] args){
    
        AlunoDAO dao = new AlunoDAO();
        
        
        Aluno aluno = new Aluno();
        //aluno.setMatriculaID(11);
        aluno.setNome("Bryan");
        aluno.setCpf("999888999");
        aluno.setIdade(7);
        
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua BB");
        endereco.setNumero(15);
        endereco.setBairro("CIC");
        
        aluno.setEndereco(endereco);
        
        String retorno = dao.salvar(aluno);
        
        
        System.out.println("Retorno : " +retorno);
        
    }
    
    //public static void main(String [] args){
    
        
        //Cliente cliente = new Cliente();
        /*
        //POST
        Endereco endereco = new Endereco("rua nova aurora 1689", 1689, "casa", "sitio cercado", "81920650", "curitiba", "parana", 1);
        
        Aluno alunoPost = new Aluno("04002120996", "Alexandre tiago ximenes", 34, endereco);
        
        System.out.println(cliente.postAluno(alunoPost));
        //System.out.println(response.getStatus());
        
        */
        //GET
        //Aluno aluno = cliente.getAluno();
        //System.out.println(aluno);
        //GET LISTA TODOS
        //String alunos = cliente.getListAluno();
        //System.out.println(alunos);
  
    //}
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.basealunos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.ufpr.basealunos.infra.ConnectionFactory;
import org.ufpr.basealunos.model.Aluno;
import org.ufpr.basealunos.model.Endereco;

/**
 *
 * @author Alex
 */
public class AlunoDAO {
    private Connection connection;
    private final String GET_ALUNO_CPF = "SELECT matriculaID, cpf, nome, idade FROM aluno WHERE cpf = ?";
    private final String GET_ALUNO = "SELECT matriculaID, cpf, nome, idade FROM aluno WHERE matriculaID = ?";
    private final String INSERT = "INSERT INTO Aluno (cpf, nome, idade) values (?,?,?)";
    private final String UPDATE = "UPDATE aluno SET cpf = ?, nome = ?, idade = ? WHERE matriculaID = ?";
    private final String DELETE = "DELETE FROM aluno WHERE matriculaID = ?";
    private final String LIST = "SELECT matriculaID, cpf, nome, idade FROM aluno";
     
    private List<Aluno> alunos = new ArrayList<>();
    private ResultSet rs;

    public AlunoDAO() {
         this.connection = ConnectionFactory.getConnection();
    }
    
    
    public String salvar(Aluno aluno){
        if(aluno.getMatriculaID() > 0){
            System.out.println("[Atualizar] codido" + aluno);
            return atualizar(aluno);
        }else
        {
            System.out.println("[Adicionar] codigo " + aluno);
            return adicionar(aluno);
        }
    }
    public Aluno getAlunoPorCpf(String cpf){
        if(cpf == "" && cpf.isEmpty()){
            return null;
        }
        try{
            Aluno aluno = null;
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(GET_ALUNO_CPF)){
                ps.setString(1, cpf);
                try(ResultSet rs = ps.executeQuery()){
                    if(rs.next()){
                        aluno = new Aluno();
                        aluno.setMatriculaID(rs.getInt("matriculaID")); 
                        aluno.setCpf(rs.getString("cpf")); 
                        aluno.setNome(rs.getString("nome")); 
                        aluno.setIdade(rs.getInt("idade"));   
                    }
                }
            connection.commit();
            return aluno;
            }catch(Exception e){
                connection.rollback();
                System.out.println("Rollback efetuado!");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Aluno getAlunoID(int id){
        if(id==0){
            return null;
        }
        try{
            Aluno aluno = null;
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(GET_ALUNO)){
                ps.setInt(1, id);
                try(ResultSet rs = ps.executeQuery()){
                    if(rs.next()){
                        aluno = new Aluno();
                        aluno.setMatriculaID(rs.getInt("matriculaID")); 
                        aluno.setCpf(rs.getString("cpf")); 
                        aluno.setNome(rs.getString("nome")); 
                        aluno.setIdade(rs.getInt("idade"));   
                    }
                }
            connection.commit();
            return aluno;
            }catch(Exception e){
                connection.rollback();
                System.out.println("Rollback efetuado!");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    private String adicionar(Aluno aluno){
        Aluno consultaAluno = getAlunoPorCpf(aluno.getCpf());
        if(consultaAluno != null){
            return "Cliente já cadastrado no sistema";
        }
        try {
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(INSERT)){
                
                ps.setString(1, aluno.getCpf());
                ps.setString(2, aluno.getNome());
                ps.setInt(3, aluno.getIdade());
                ps.execute();
                connection.commit();
                if (aluno.getEndereco() != null){
                    Aluno a = new Aluno();
                    Endereco endereco = new Endereco();
                    endereco = aluno.getEndereco();
                    a = getAlunoPorCpf(aluno.getCpf());
                    endereco.setMatriculaID(a.getMatriculaID());
                    EnderecoDAO  enderecoDAO = new EnderecoDAO();
                    enderecoDAO.salvar(endereco);   
                }
                return "Aluno cadastrado com sucesso";
            }catch(Exception e){
                System.out.println(e);
                connection.rollback();
                System.out.println("Rollback efetuado!");
            }
         } catch (SQLException ex) {
            ex.getMessage(); 
        }
        return null;
    }
    private String atualizar(Aluno aluno){
        try {
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(UPDATE)){
                ps.setString(1, aluno.getCpf());
                ps.setString(2, aluno.getNome());
                ps.setInt(3, aluno.getIdade());
                ps.setInt(4, aluno.getMatriculaID());  
                int executeUpdate = ps.executeUpdate();
                System.out.println("executeUpdate " +executeUpdate);
                connection.commit();
                
            }catch(Exception e){
                connection.rollback();    
                System.out.println("Rollback efetuado!");
            }
         } catch (SQLException ex) {
            ex.getMessage(); 
        }
        return "Aluno atualizado com sucesso!";
    }
    public List<Aluno> getAlunos (){
        try {
            Aluno aluno = null;
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(LIST)){
                rs = ps.executeQuery();
                while(rs.next()){
                    aluno = new Aluno();
                      aluno.setMatriculaID(rs.getInt("matriculaID")); 
                      aluno.setNome(rs.getString("nome")); 
                      aluno.setCpf(rs.getString("cpf")); 
                      aluno.setIdade(rs.getInt("idade"));
                      alunos.add(aluno);
                }
            connection.commit();
            return alunos;
            }catch(Exception e){
                connection.rollback();
                System.out.println("Rollback efetuado!");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    public String excluir(String codigo){
        int code = 0;
        
        try{
            code = Integer.parseInt(codigo);
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        
        try {
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(DELETE)){
                ps.setInt(1, code);
                
                ps.executeUpdate();
                
                connection.commit();
                return "Cliente excluido com sucesso!";
            }catch(Exception e){
                connection.rollback();    
            }
         } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
             System.out.println("Rollback efetuado!");
        }
        return "Não foi possivel excluir esse cliente, porque ele já fez pedidos";
    }
    
}

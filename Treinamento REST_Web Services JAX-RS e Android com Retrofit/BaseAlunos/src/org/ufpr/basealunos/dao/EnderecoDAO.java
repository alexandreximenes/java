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
import java.util.List;
import org.ufpr.basealunos.infra.ConnectionFactory;
import org.ufpr.basealunos.model.Endereco;

/**
 *
 * @author alexsandro.luiz
 */
public class EnderecoDAO {
    private Connection connection;
    private final String GET_ENDERECO = "SELECT enderecoID, logradouro, numero, complemento, bairro, matriculaID FROM Endereco WHERE enderecoID = ?";
    private final String GET_MATRICULA = "SELECT enderecoID, logradouro, numero, complemento, bairro, matriculaID FROM Endereco WHERE matriculaID = ?";
    private final String INSERT = "INSERT INTO Endereco (logradouro, numero, complemento, bairro, matriculaID) values (?,?,?,?,?)";
    private final String UPDATE = "UPDATE Endereco SET logradouro = ?, numero = ?, complemento = ?, bairro = ?, matriculaID = ? WHERE enderecoID = ?";
    private final String DELETE = "DELETE FROM Endereco WHERE enderecoID = ?";
    private final String LIST = "SELECT enderecoID, logradouro, numero, complemento, bairro, matriculaID FROM Endereco";
     
    private List<Endereco> enderecos = new ArrayList<>();
    private ResultSet rs;

    public EnderecoDAO() {
           this.connection = ConnectionFactory.getConnection();
    }
    
    
    public String salvar(Endereco endereco){
        if(endereco.getEnderecoID()> 0){
            System.out.println("[Atualizar] codido" + endereco);
            return atualizar(endereco);
        }else
        {
            System.out.println("[Adicionar] codigo " + endereco);
            return adicionar(endereco);
        }
    }
    public Endereco getEnderecoPorID(int id){
        if(id==0){
            return null;
        }
        try{
            Endereco endereco = null;
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(GET_ENDERECO)){
                ps.setInt(1, id);
                try(ResultSet rs = ps.executeQuery()){
                    if(rs.next()){
                        endereco = new Endereco();
                        endereco.setEnderecoID(rs.getInt("enderecoID")); 
                        endereco.setLogradouro(rs.getString("logradouro")); 
                        endereco.setBairro(rs.getString("bairro"));
                        endereco.setComplemento(rs.getString("complemento"));
                        endereco.setNumero(rs.getInt("numero"));
                        endereco.setMatriculaID(rs.getInt("matriculaID")); 
                        ;   
                    }
                }
                return endereco;
            }catch(Exception e){
                connection.rollback();
                System.out.println("Rollback efetuado!");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Endereco getEnderecoPorMatricula(int id){
        if(id==0){
            return null;
        }
        try{
            Endereco endereco = null;
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(GET_MATRICULA)){
                ps.setInt(1, id);
                try(ResultSet rs = ps.executeQuery()){
                    if(rs.next()){
                        endereco = new Endereco();
                        endereco.setEnderecoID(rs.getInt("enderecoID")); 
                        endereco.setLogradouro(rs.getString("logradouro")); 
                        endereco.setBairro(rs.getString("bairro"));
                        endereco.setComplemento(rs.getString("complemento"));
                        endereco.setNumero(rs.getInt("numero"));
                        endereco.setMatriculaID(rs.getInt("matriculaID")); 
                        ;   
                    }
                }
                return endereco;
            }catch(Exception e){
                connection.rollback();
                System.out.println("Rollback efetuado!");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    private String adicionar(Endereco endereco){
        Endereco consultaEndereco = getEnderecoPorID(endereco.getEnderecoID());
        if(consultaEndereco != null){
            return "Endereço já cadastrado no sistema";
        }
        try {
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(INSERT)){
                
                ps.setString(1, endereco.getLogradouro());
                ps.setInt(2, endereco.getNumero());
                ps.setString(3, endereco.getComplemento());
                ps.setString(4, endereco.getBairro()); 
                ps.setInt(5, endereco.getMatriculaID());
                ps.execute();
                connection.commit();
                return "Endereco cadastrado com sucesso";
            }catch(Exception e){
                connection.rollback();
                System.out.println("Rollback efetuado!");
            }
         } catch (SQLException ex) {
            ex.getMessage(); 
        }
        return null;
    }
    private String atualizar(Endereco endereco){
        try {
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(UPDATE)){
                ps.setString(1, endereco.getLogradouro());
                ps.setInt(2, endereco.getNumero());
                ps.setString(3, endereco.getComplemento());
                ps.setString(4, endereco.getBairro());
                ps.setInt(5, endereco.getMatriculaID());
                ps.setInt(6, endereco.getEnderecoID());
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
    public List<Endereco> getEnderecos (){
        try {
            Endereco endereco = null;
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(LIST)){
                rs = ps.executeQuery();
                while(rs.next()){
                    endereco = new Endereco();
                      endereco.setEnderecoID(rs.getInt("enderecoID")); 
                      endereco.setLogradouro(rs.getString("logradouro")); 
                      endereco.setNumero(rs.getInt("numero")); 
                      endereco.setComplemento(rs.getString("complemento"));
                      endereco.setMatriculaID(rs.getInt("matriculaID"));
                      enderecos.add(endereco);
                }
            connection.commit();
            return enderecos;
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

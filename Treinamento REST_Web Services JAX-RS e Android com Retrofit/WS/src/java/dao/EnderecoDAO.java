/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import infra.ConnectionFactory;
import java.sql.Statement;
import model.Aluno;
import model.Endereco;

/**
 *
 * @author alexsandro.luiz
 */ 

public class EnderecoDAO {
    private Connection connection;
    private final String GET_ENDERECO = "SELECT enderecoID, logradouro, numero, complemento, bairro, cep, cidade, estado, matriculaID FROM Endereco WHERE enderecoID = ?";
    private final String GET_MATRICULA = "SELECT enderecoID, logradouro, numero, complemento, bairro, cep, cidade, estado, matriculaID FROM Endereco WHERE matriculaID = ?";
    private final String INSERT = "INSERT INTO Endereco (logradouro, numero, complemento, bairro, cep, cidade, estado, matriculaID) values (?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE Endereco SET logradouro = ?, numero = ?, complemento = ?, bairro = ?, matriculaID = ?, cep = ?, cidade = ?, estado = ? WHERE enderecoID = ?";
    private final String DELETE = "DELETE FROM Endereco WHERE enderecoID = ?";
    private final String LIST = "SELECT enderecoID, logradouro, numero, complemento, bairro, cep, cidade, estado, matriculaID FROM Endereco";
     
    private List<Endereco> enderecos = new ArrayList<>();
    private ResultSet rs;

    public EnderecoDAO() {
           this.connection = ConnectionFactory.getConnection();
    }
    
    
    public void salvar(Aluno aluno){
        if(aluno.getEndereco().getEnderecoID()> 0){
            System.out.println("[Atualizar] codido" + aluno.getEndereco());
            atualizar(aluno);
        }else
        {
            System.out.println("[Adicionar] codigo " + aluno.getEndereco());
            adicionar(aluno);
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
                        endereco.setNumero(rs.getInt("numero"));
                        endereco.setComplemento(rs.getString("complemento"));
                        endereco.setComplemento(rs.getString("bairro"));
                        endereco.setComplemento(rs.getString("cep"));
                        endereco.setComplemento(rs.getString("cidade"));
                        endereco.setComplemento(rs.getString("estado"));
                        endereco.setMatriculaID(rs.getInt("matriculaID"));   
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
    private void adicionar(Aluno aluno){
        Endereco consultaEndereco = getEnderecoPorID(aluno.getEndereco().getEnderecoID());
        if(consultaEndereco == null){
            
            Endereco endereco = new Endereco();
            endereco.setLogradouro(aluno.getEndereco().getLogradouro());
            endereco.setNumero(aluno.getEndereco().getNumero());
            endereco.setComplemento(aluno.getEndereco().getComplemento());
            endereco.setBairro(aluno.getEndereco().getBairro());
            endereco.setCep(aluno.getEndereco().getCep());
            endereco.setCidade(aluno.getEndereco().getCidade());
            endereco.setEstado(aluno.getEndereco().getEstado());
            endereco.setMatriculaID(aluno.getMatriculaID());
            
            try {
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)){
                
                ps.setString(1, endereco.getLogradouro());
                ps.setInt(2,    endereco.getNumero());
                ps.setString(3, endereco.getComplemento());
                ps.setString(4, endereco.getBairro()); 
                ps.setString(5, endereco.getCep()); 
                ps.setString(6, endereco.getCidade());
                ps.setString(7, endereco.getEstado());
                ps.setInt(8,    endereco.getMatriculaID());

                boolean bool = ps.execute();
                
                ResultSet rs = ps.getGeneratedKeys();
                int id = 0;
                if(rs.next()){
                    id = rs.getInt(1);
                    System.out.println("Id Endereco gerado : "+id);
                }else{
                    System.out.println("Não pegou a chave");
                }
                
                connection.commit();
         
            }catch(Exception e){
                connection.rollback();
                System.out.println("Rollback efetuado!");
            }
         } catch (SQLException ex) {
            ex.getMessage(); 
        }
        }

    }
    private void atualizar(Aluno aluno){
        try {
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(UPDATE)){
                ps.setString(1, aluno.getEndereco().getLogradouro());
                ps.setInt(2, aluno.getEndereco().getNumero());
                ps.setString(3, aluno.getEndereco().getComplemento());
                ps.setString(4, aluno.getEndereco().getBairro());
                ps.setInt(5, aluno.getEndereco().getMatriculaID());
                ps.setString(6, aluno.getEndereco().getCep());
                ps.setString(7, aluno.getEndereco().getCidade());
                ps.setString(8, aluno.getEndereco().getEstado());
                ps.setInt(9, aluno.getEndereco().getEnderecoID());
                int executeUpdate = ps.executeUpdate();
                System.out.println("executeUpdate " +executeUpdate);
                this.connection.commit();
                
            }catch(Exception e){
                connection.rollback();    
                System.out.println("Rollback efetuado!");
            }
         } catch (SQLException ex) {
            ex.getMessage(); 
        }
        
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
                      endereco.setBairro(rs.getString("bairro"));
                      endereco.setCep(rs.getString("cep"));
                      endereco.setCidade(rs.getString("cidade"));
                      endereco.setEstado(rs.getString("estado"));
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
                return "Endereco excluido com sucesso!";
            }catch(Exception e){
                connection.rollback();    
            }
         } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
             System.out.println("Rollback efetuado!");
        }
        return "Não foi possivel excluir esse endereco";
    }

    
}

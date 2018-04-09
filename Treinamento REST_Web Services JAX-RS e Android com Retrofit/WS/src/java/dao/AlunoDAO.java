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
 * @author Alex
 */
public class AlunoDAO {
    private Connection connection;
    private final String GET_ALUNO_CPF = "SELECT matriculaID, cpf, nome, idade FROM aluno WHERE cpf = ?";
    private final String GET_ALUNO = "SELECT a.matriculaID, a.cpf, a.nome, a.idade, e.enderecoID, e.logradouro, e.numero, e.complemento, e.bairro, e.cep, e.cidade, e.estado FROM aluno a left join Endereco e on a.matriculaID = e.matriculaID WHERE a.matriculaID = ?";
    private final String INSERT = "INSERT INTO Aluno (cpf, nome, idade) values (?,?,?)";
    private final String UPDATE = "UPDATE aluno SET cpf = ?, nome = ?, idade = ? WHERE matriculaID = ?";
    private final String DELETE = "DELETE FROM aluno WHERE matriculaID = ?";
    private final String LIST = "SELECT a.matriculaID, a.cpf, a.nome, a.idade, e.enderecoID, e.logradouro, e.numero, e.complemento, e.bairro, e.cep, e.cidade, e.estado FROM aluno a left join Endereco e on a.matriculaID = e.matriculaID";
     
    private List<Aluno> alunos = new ArrayList<>();
    private ResultSet rs;

    public AlunoDAO() {
         this.connection = ConnectionFactory.getConnection();
    }
    
    
    public String salvar(Aluno aluno){
        if(aluno.getMatriculaID() > 0){
            System.out.println("[Atualizar] aluno matricula : " + aluno.getMatriculaID());
            System.out.println("[Atualizar] codido" + aluno);
            return atualizar(aluno);
        }else
        {
            System.out.println("[Adicionar] aluno matricula : " + aluno.getMatriculaID());
            System.out.println("[Adicionar] codigo " + aluno);
            return adicionar(aluno);
        }
    }
    private String adicionar(Aluno aluno){
        Aluno consultaAluno = getAlunoPorCpf(aluno.getCpf());
        if(consultaAluno != null){
            return "CPF já cadastrado";
        }
        try {
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)){
                
                ps.setString(1, aluno.getCpf());
                ps.setString(2, aluno.getNome());
                ps.setInt(3, aluno.getIdade());
                
                boolean bool = ps.execute();
                
                this.connection.commit();
    
                ResultSet rs = ps.getGeneratedKeys();
                int id = 0;
                if(rs.next()){
                    id = rs.getInt(1);
                    System.out.println("Id gerado : "+id);
                    
                    if (aluno.getEndereco() != null){
                        aluno.setMatriculaID(id);
                        aluno.getEndereco().setMatriculaID(id);
                         new EnderecoDAO().salvar(aluno);
                    }
                }else{
                    System.out.println("Não pegou a chave");
                }
                
            
                return String.valueOf(id + " - inserido com sucesso!");
            
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
                
                System.out.println("executeUpdate : " +executeUpdate);
                this.connection.commit();
                
                if(aluno.getEndereco() != null){
                    new EnderecoDAO().salvar(aluno);
                }
                        
                
                
            }catch(Exception e){
                connection.rollback();    
                System.out.println("Rollback efetuado!");
            }
         } catch (SQLException ex) {
            ex.getMessage(); 
        }
        return "Aluno "+aluno.getMatriculaID() +" - " + aluno.getNome() +", atualizado com sucesso!";
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
    public Aluno getAlunoID(String alunoID){
        int id = 0;
        try{
            id = Integer.parseInt(alunoID);
        }catch(NumberFormatException n){
            System.out.println(n.getMessage());
        }
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
                        
                        Endereco endereco = new Endereco();
                        endereco.setEnderecoID(rs.getInt("enderecoID"));
                        endereco.setLogradouro(rs.getString("logradouro")); 
                        endereco.setNumero(rs.getInt("numero")); 
                        endereco.setComplemento(rs.getString("complemento"));
                        endereco.setBairro(rs.getString("bairro"));
                        endereco.setCep(rs.getString("cep"));
                        endereco.setCidade(rs.getString("cidade"));
                        endereco.setEstado(rs.getString("estado"));
                        endereco.setMatriculaID(rs.getInt("matriculaID"));
                        aluno.setEndereco(endereco);
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

                        Endereco endereco = new Endereco();
                        endereco.setEnderecoID(rs.getInt("enderecoID"));
                        endereco.setLogradouro(rs.getString("logradouro"));
                        endereco.setNumero(rs.getInt("numero")); 
                        endereco.setComplemento(rs.getString("complemento"));
                        endereco.setBairro(rs.getString("bairro"));
                        endereco.setCep(rs.getString("cep"));
                        endereco.setCidade(rs.getString("cidade"));
                        endereco.setEstado(rs.getString("estado"));
                        endereco.setMatriculaID(rs.getInt("matriculaID"));
                        aluno.setEndereco(endereco);
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
                Aluno aluno = getAlunoID(codigo);
                
                String retornoEndereco = null;
                if(aluno.getEndereco().getMatriculaID() > 0){
                    retornoEndereco = new EnderecoDAO().excluir(""+aluno.getEndereco().getEnderecoID());
                }
                
                int executeUpdate = ps.executeUpdate();
                connection.commit();
                
                
                
                if(executeUpdate > 0){
                    return "Aluno exlcuido com sucesso - ID : " +aluno.getMatriculaID() + " - Nome : " + aluno.getNome() + " - " + retornoEndereco;
                }
            }catch(Exception e){
                connection.rollback();    
            }
         } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
             System.out.println("[excluir Aluno] Rollback efetuado!");
        }
        return "ID Inexistente";
        
    }
    
}

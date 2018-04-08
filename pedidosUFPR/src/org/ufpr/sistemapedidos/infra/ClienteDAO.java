/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemapedidos.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.ufpr.sistemapedidos.model.Cliente;

/**
 *
 * @author Alexandre Ximenes
 */
public class ClienteDAO {
    
    private final String INSERT = "INSERT INTO cliente (cpf, nome, sobrenome) values (?,?,?)";
    private final String UPDATE = "UPDATE cliente SET cpf = ?, nome = ?, sobrenome = ? WHERE id = ?";
    private final String DELETE = "DELETE FROM cliente WHERE id = ?";
    private final String LIST = "SELECT id, cpf, nome, sobrenome FROM cliente";
    private final String GET_CLIENT = "SELECT id, cpf, nome, sobrenome FROM cliente WHERE cpf = ?";
    
    private List<Cliente> clientes = new LinkedList<>();
    private ResultSet rs;
    
    private Connection connection;
    public ClienteDAO(){
        this.connection = ConnectionFactory.getConnection();
    }
    
    public List<Cliente> getClientes (){
        try {
            Cliente cliente = null;
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(LIST)){
                rs = ps.executeQuery();
                while(rs.next()){
                    cliente = new Cliente(
                            rs.getInt("id"), 
                            rs.getString("cpf"), 
                            rs.getString("nome"), 
                            rs.getString("sobrenome")
                    );
                    clientes.add(cliente);
                }
            connection.commit();
            return clientes;
            }catch(Exception e){
                connection.rollback();
                System.out.println("Rollback efetuado!");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public Cliente getClientePorCPF(String cpf){
        if(cpf.length()==0){
            return null;
        }
        try{
            Cliente cliente = null;
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(GET_CLIENT)){
                ps.setString(1, cpf);
                try(ResultSet rs = ps.executeQuery()){
                    if(rs.next()){
                        cliente = new Cliente(
                        rs.getInt("id"), 
                        rs.getString("cpf"), 
                        rs.getString("nome"), 
                        rs.getString("sobrenome")
                        );   
                    }
                }
            connection.commit();
            return cliente;
            }catch(Exception e){
                connection.rollback();
                System.out.println("Rollback efetuado!");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public String salvar(Cliente cliente){
        if(cliente.getId() > 0){
            System.out.println("[Atualizar] codigo  "+cliente);
            return atualizar(cliente);
        }else{
            System.out.println("[Adicionar] codigo  "+cliente);
            return adicionar(cliente);
        }
    }
    
    public String adicionar(Cliente cliente){
        Cliente consultaCliente = getClientePorCPF(cliente.getCpf());
        if(consultaCliente != null){
            return "Cliente já cadastrado no sistema";
        }
        try {
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(INSERT)){
                
                ps.setString(1, cliente.getCpf());
                ps.setString(2, cliente.getNome());
                ps.setString(3, cliente.getSobrenome());
                
                ps.execute();
                
                connection.commit();
                return "Cliente cadastrado com sucesso";
            }catch(Exception e){
                connection.rollback();
                System.out.println("Rollback efetuado!");
            }
         } catch (SQLException ex) {
            ex.getMessage(); 
        }
        return null;
    }
    
    public String atualizar(Cliente cliente){
        try {
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(UPDATE)){
                ps.setString(1, cliente.getCpf());
                ps.setString(2, cliente.getNome());
                ps.setString(3, cliente.getSobrenome());
                ps.setInt(4, cliente.getId());
                
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
        return "Cliente atualizado com sucesso!";
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

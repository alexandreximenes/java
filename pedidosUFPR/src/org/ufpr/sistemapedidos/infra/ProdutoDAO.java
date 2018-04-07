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
import org.ufpr.sistemapedidos.model.Produto;

/**
 *
 * @author Alexandre Ximenes
 */
public class ProdutoDAO {
    
    private final String INSERT = "INSERT INTO produto (descricao) values (?)";
    private final String UPDATE = "UPDATE produto SET descricao = ? WHERE id = ?";
    private final String DELETE = "DELETE FROM produto WHERE id = ?";
    private final String LIST = "SELECT id, descricao FROM produto";
    private final String GET_PRODUCT = "SELECT id, descricao FROM produto WHERE descricao LIKE ?";
    private final String GET_PRODUCT_ID = "SELECT id, descricao FROM produto WHERE id = ?";
    
    private List<Produto> produtos = new LinkedList<>();
    private ResultSet rs;
    
    private Connection connection;
    public ProdutoDAO(){
        this.connection = ConnectionFactory.getConnection();
    }
    
    public List<Produto> getProdutos (){
        try {
            Produto produto = null;
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(LIST)){
                rs = ps.executeQuery();
                while(rs.next()){
                    produto = new Produto(
                            rs.getInt("id"), 
                            rs.getString("descricao")
                    );
                    produtos.add(produto);
                }
            connection.commit();
            return produtos;
            }catch(Exception e){
                connection.rollback();
                System.out.println("Rollback efetuado!");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public Produto getProduto(String descricao){
        if(descricao.equalsIgnoreCase("")){
            return null;
        }
        try{
            Produto produto = null;
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(GET_PRODUCT)){
                ps.setString(1, descricao.toLowerCase() + "%");
                try(ResultSet rs = ps.executeQuery()){
                    if(rs.next()){
                        produto = new Produto(
                        rs.getInt("id"), 
                        rs.getString("descricao")
                        );   
                    }
                }
            connection.commit();
            
            return produto;
            
            }catch(Exception e){
                connection.rollback();
                System.out.println("Rollback efetuado!");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Produto getProdutoPorId(int id){
        try{
            Produto produto = null;
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(GET_PRODUCT_ID)){
                ps.setInt(1, id);
                try(ResultSet rs = ps.executeQuery()){
                    if(rs.next()){
                        produto = new Produto(
                        rs.getInt("id"), 
                        rs.getString("descricao")
                        );   
                    }
                }
            connection.commit();
            
            return produto;
            
            }catch(Exception e){
                connection.rollback();
                System.out.println("Rollback efetuado!");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }    
    
    public String salvar(Produto produto){
        if(produto.getId() > 0){
            return atualizar(produto);
        }else{
            return adicionar(produto);
        }
    }
    
    public String adicionar(Produto produto){
        Produto consultaProduto = getProduto(produto.getDescricao());
        if(consultaProduto != null){
            return "Produto já cadastrado no sistema";
        }
        try {
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(INSERT)){
                
                ps.setString(1, produto.getDescricao());
                
                ps.execute();
                
                connection.commit();
                return "Produto cadastrado com sucesso!";
            }catch(Exception e){
                connection.rollback();
                System.out.println("Rollback efetuado!");
            }
         } catch (SQLException ex) {
            ex.getMessage(); 
        }
        return null;
    }
    
    public String atualizar(Produto produto){
        try {
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(UPDATE)){
                ps.setString(1, produto.getDescricao());
                ps.setInt(2, produto.getId());
                
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
        return "Produto atualizado com sucesso!";
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
                return "Produto excluido com sucesso!";
            }catch(Exception e){
                connection.rollback();    
            }
         } catch (SQLException ex) {
            ex.getMessage(); 
             System.out.println("Rollback efetuado!");
        }
        return null;        
    }
}

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
import org.ufpr.sistemapedidos.model.ItemPedido;
import org.ufpr.sistemapedidos.model.Produto;

/**
 *
 * @author Alexandre Ximenes
 */
public class ItemPedidoDAO {
    
    private final String INSERT = "INSERT INTO item_pedido (id_pedido, id_produto, quantidade) values (?,?,?)";
    private final String LIST = "SELECT  id_pedido, id_produto, quantidade FROM  item_pedido where id_pedido = ?";
    private List<Cliente> clientes = new LinkedList<>();
    private ResultSet rs;
    
    private Connection connection;
    private List<ItemPedido> itensPedido = new LinkedList<>();
    private int id;

    public ItemPedidoDAO() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    ItemPedidoDAO(int id, List<ItemPedido> itensPedido) {
        this.connection = ConnectionFactory.getConnection();
        this.id = id;
        this.itensPedido = itensPedido;
    }
    
    public void adicionarItens() {
        try{
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(INSERT)){
                
                for(ItemPedido i : itensPedido){
                    ps.setInt(1, this.id);
                    ps.setInt(2, i.getProduto().getId());
                    ps.setInt(3, i.getQuantidade());
                    ps.execute();
                }
                System.err.println("Itens do Pedido Salvo com sucesso!");
                this.connection.commit();
            }catch(SQLException e){
                e.printStackTrace();
                System.err.println("log : " + e.getMessage());
                this.connection.rollback();
                System.out.println("roolback efetuado");
            }
        }catch(SQLException e ){
            System.out.println(e.getMessage());
        }
        
    }
    public List<ItemPedido> getItemPedidos(int id){
        try{
            ItemPedido itemPedido = null;
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(LIST)){
                ps.setInt(1, id);
                rs = ps.executeQuery();
                while(rs.next()){
                    ProdutoDAO produtoDAO = new ProdutoDAO();
                    Produto produto = new Produto(0, "");
                    produto = produtoDAO.getProdutoPorId(rs.getInt("id_produto"));
                    itemPedido = new ItemPedido(produto, rs.getInt("quantidade") );
                    itensPedido.add(itemPedido);
                }
                connection.commit();
                return itensPedido;
            }catch(Exception e){
                connection.rollback();
                System.out.println("Rollback efetuado!");
            }
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
}

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
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import org.ufpr.sistemapedidos.model.Cliente;
import org.ufpr.sistemapedidos.model.ItemPedido;
import org.ufpr.sistemapedidos.model.Pedido;

/**
 *
 * @author Alexandre Ximenes
 */
public class PedidoDAO {
    private final String INSERT = "INSERT INTO pedido (date, id_cliente) values (?,?)";
    private final String LIST = "SELECT id, date, id_cliente FROM  pedido where id_cliente = ?";
    private List<Pedido> pedidos = new LinkedList<>();
    private ResultSet rs;
    private Connection connection;
    public PedidoDAO() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public void adicionar(Pedido pedido) {
        try{
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)){
                // retorna o id gerado do pedido para utilizar no insert do item do pedido;
                ps.setString(1, pedido.getData());
                ps.setInt(2, pedido.getCliente().getId());
                
                ps.execute();
                
                ResultSet rs = ps.getGeneratedKeys();
             
                if(rs.next()){
                    int id = rs.getInt(1);
                    System.out.println("Id gerado "+id);
                    adicionaItensPedido(id, pedido.getItensPedido());
                }else{
                    System.out.println("Não pegou a chave");
                }
               
                this.connection.commit();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    private void adicionaItensPedido(int id, List<ItemPedido> itens) {
        ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO(id, itens);
        itemPedidoDAO.adicionarItens();
    }
    public List<Pedido> getPedidosPorCliente(Cliente cliente){
        try{
            Pedido pedido = null;
            this.connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(LIST)){
                ps.setInt(1, cliente.getId());
                rs = ps.executeQuery();
                    while(rs.next()){
 
                       ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();
                       List<ItemPedido> item = new LinkedList<>();
                      // item = null;
                       item = itemPedidoDAO.getItemPedidos(rs.getInt("id"));
                       pedido = new Pedido(
                                rs.getString("date"),
                                cliente,
                                item
                       );
                       pedido.setId(rs.getInt("id"));
                    }
                    pedidos.add(pedido);
                    connection.commit();
                    return pedidos;
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

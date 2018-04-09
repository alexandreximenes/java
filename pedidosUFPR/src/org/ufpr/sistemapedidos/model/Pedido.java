/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemapedidos.model;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Alexandre Ximenes
 */
public class Pedido {
    
    private int id;
    private String data;
    private List<ItemPedido> itensPedido;
    private Cliente cliente;
    
    public Pedido(String data, Cliente cliente, List<ItemPedido> itensPedido){
        this.data = data;
        this.cliente = cliente;
        this.itensPedido = itensPedido;
    }

    public Pedido(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    @Override
    public String toString() {
        return "Data: "+data +"\n"
                +"Cliente: "+ cliente +"\n"
                +"itens: "+itensPedido.size();
    }
    
    
}

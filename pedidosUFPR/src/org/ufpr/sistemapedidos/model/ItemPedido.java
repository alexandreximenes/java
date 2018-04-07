/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemapedidos.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandre Ximenes
 */
public class ItemPedido {


    private int quantidade;
    private Produto produto;
   // private static List<ItemPedido> itensPedido = new ArrayList<>();
    
    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

 /*   public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public static List<ItemPedido> getItensPedido() {
        return itensPedido;
    }*/
    
    

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Codigo : "+ produto.getId() +" Produto : "+produto.getDescricao() +" Quantidade: "+quantidade;
    }

 /*   public static void adicionarItem(ItemPedido itemPedido) {
        itensPedido.add(itemPedido);
    }
    
    public static int getTamanho() {
        return itensPedido.size();
    }
    
    public static void limparItens() {
        itensPedido.clear();
    }*/

    
    
    

}
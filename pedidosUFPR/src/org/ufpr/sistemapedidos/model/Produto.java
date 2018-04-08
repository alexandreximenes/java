/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemapedidos.model;

/**
 *
 * @author Alexandre Ximenes
 */
public class Produto {
    private int id;
    private String descricao;

    public Produto(int id, String descricao){
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
    
    @Override
    public String toString() {
        return descricao;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Produto){
            Produto outro = (Produto) obj;
            return this.id == outro.id;
        } 
        return false;
    }
    
    
    
}

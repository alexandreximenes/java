/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import java.util.ArrayList;

/**
 *
 * @author alexandrelerario
 * @param <T>
 */
public abstract class AbstractFacade<T> {
    
    protected abstract ArrayList<T> getEntityManager();
    private ArrayList<T> lista;

    public AbstractFacade() {
        lista = getEntityManager();
    }
    
    
    public void persist(T objeto){        
        lista.add(objeto);
    }
    
    public ArrayList<T> getAll(){
        return lista;
    }
    
}

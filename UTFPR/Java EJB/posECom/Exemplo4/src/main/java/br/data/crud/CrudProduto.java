/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import br.data.entity.Produto;
import java.util.ArrayList;

/**
 *
 * @author alexandrelerario
 */
public class CrudProduto extends AbstractFacade<Produto> {

    private static ArrayList<Produto> lista;
    
    @Override
    protected ArrayList<Produto> getEntityManager() {
        lista = new ArrayList();
        lista.add(new Produto(1, "carro"));
        lista.add(new Produto(2, "mouse"));
        lista.add(new Produto(3, "monitor"));
        lista.add(new Produto(4, "teclado"));
        lista.add(new Produto(5, "ssd"));
        return lista;
        //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ejb;

import br.data.entity.Produto;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author alexandrelerario
 */
@Stateless
public class EJBProduto {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
   public ArrayList<Produto> getAll(){
       return new br.data.crud.CrudProduto().getAll();
   }
}

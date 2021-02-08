/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ejb;

import javax.ejb.Local;

/**
 *
 * @author UTFPR
 */
@Local
public interface EJBCalculadoraSimplesLocal {
    public int dobrar(int valor);
}

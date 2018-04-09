/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemapedidos.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Alexandre Ximenes
 */
public class FormataData {
    
    public static String format(Date data){
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }
    
}

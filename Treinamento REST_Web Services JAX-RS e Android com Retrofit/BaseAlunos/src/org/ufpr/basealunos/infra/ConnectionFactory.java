/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.basealunos.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alex
 */
public class ConnectionFactory {
    
    private static final String DATABASE = "CRUD";
    private static final String URL = "localhost";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://"+URL+"/"+DATABASE, USER, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("org.ufpr.basealunos.infra.ConnectionFactory.getConnection()\n"+ex.getMessage() );
        }
        return null;
    
    }
    
}

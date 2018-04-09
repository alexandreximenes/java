/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alex
 */
public class ConnectionFactory {
    
    private static final String DATABASE = "crud";
    private static final String URL = "localhost";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://"+URL+"/"+DATABASE, USER, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("infra.ConnectionFactory.getConnection()\n"+ex.getMessage() );
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
        }
        return null;
    
    }
    
}

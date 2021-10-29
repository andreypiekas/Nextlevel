/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nextlevel.jdbc;
import java.sql.DriverManager;   
import java.sql.SQLException;
import java.sql.Connection;


/**
 *
 * @author andrey.piekas
 */
public class ConnectionFactory {
    public static Connection getConnection(){
        final String url = "jdbc:mysql: //localhost:3306/nextlevelpiekas?verifyServerCertificate=false&useSSL=true";
        final String user = "andreypiekas";
        final String password = "piekas123";
       
            try {
               // conn = 
                return DriverManager.getConnection(url, user, password);
                
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
                //Lançar um erro na tela do usuário quando o programa executa
//                
//                
//                System.out.println("SQLException: " + ex.getMessage());
//                System.out.println("SQLState: " + ex.getSQLState());
//                System.out.println("VendorError: " + ex.getErrorCode());
            //return null;
            } 
     
                
}   
}

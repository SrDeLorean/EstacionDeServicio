/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstacionDeServicio;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author WorLark
 */
public class ConexionBDGoogleCloud {
    
    Connection con;
    public ConexionBDGoogleCloud(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://35.199.90.240:3306/sistemas_distribuidos","seba","seba1234554321");
        } catch (Exception e) {
            System.err.println("Error:"+e);
        }        
    }
    public Connection getConnection(){
        return con;
    }
    
}


package EstacionDeServicio;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    Connection con;
    public ConexionBD(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/distribuidos","root","");
        } catch (Exception e) {
            System.err.println("Error:"+e);
        }        
    }
    public Connection getConnection(){
        return con;
    }
  }

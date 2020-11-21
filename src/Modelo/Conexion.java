
package Modelo;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Conexion {
    private Connection cn = null;
    private final Statement s = null;
    
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    
    public Connection Conectar()
    {
        try {
            cn = DriverManager.getConnection(url, "BD_FG", "kevin1234");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Conexion Fallida" +e.getMessage());
        }
        return cn;
    }
    
           
}
    

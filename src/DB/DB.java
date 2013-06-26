/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jung-Ho Choi
 */
public class DB {
    
    private Connection ConnectDB () throws Exception {
        
        Connection con = null;
        
        // Informationen zusammensuchen
        String dbHost = "localhost";
        String dbPort = "3306";
        String dbName = "projekt";
        String dbUser = "root";
        String dbPassword = "test";
        
        // Treiberklasse laden
        Class.forName("com.mysql.jdbc.Driver");
        
        // URL zusammenbauen
        StringBuilder url = new StringBuilder ();
        url.append ("jdbc:mysql://").append(dbHost);
        url.append (":").append(dbPort).append("/");
        url.append (dbName);
        url.append ("?user=").append(dbUser);
        url.append ("&password=").append(dbPassword);
        
        con = DriverManager.getConnection(url.toString());
        
        return con;
        
    }
    
    public void InsertIntoBenutzer (String benutzername, String passwort) throws Exception{
        
        Connection con = null;
        Statement stmt = null;  
       
        try {
            // Zur Datenbank verbinden
            con = ConnectDB();
            // Statement erstellen
            stmt = con.createStatement();
            //Query erstellen
            String Userdata= "INSERT INTO benutzer VALUES('";
            Userdata += benutzername+"','";
            Userdata += passwort+"');";
            stmt.executeUpdate(Userdata);
            
        }
        finally {
            
            if(stmt != null) {
                stmt.close();
            }
            
            if (con != null) {
                con.close();
            }
       
        }
    }
}
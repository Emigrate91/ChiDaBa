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
import java.sql.ResultSet;

/**
 *
 * @author Jung-Ho Choi
 */
public class DB {
        
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rslt = null;
    private PreparedStatement pstmt = null;
    private boolean userValidity = false;
    private boolean userExistence = false;
    
    private Connection ConnectDB () throws Exception {
        
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
    
    private void CloseDBConnection() throws SQLException {
        if (rslt != null) {
            rslt.close();
        }
        
        if (stmt != null) {
            stmt.close();
        }
        
        if (con != null) {
            con.close();
        }
        
        if (pstmt != null) {
            pstmt.close();
        }
    }

    public boolean getuserValidity() {
        return userValidity;
    }

    public boolean getuserExistence() {
        return userExistence;
    }
    
    public void InsertIntoBenutzer (String benutzername, String passwort) throws Exception{
        
        try {
            // Zur Datenbank verbinden
            con = ConnectDB();
            // Statement erstellen
            pstmt = con.prepareStatement("INSERT INTO benutzer VALUES(?,?)");
            //Query erstellen
            pstmt.setString(1, benutzername);
            pstmt.setString(2, passwort);
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            
        }
        finally {
            this.CloseDBConnection();
        }
    }
    
    public void UsernameExists (String username) throws Exception {
        try {
            con = ConnectDB();
            pstmt = con.prepareStatement("SELECT * FROM benutzer WHERE username = (?);",
                                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstmt.setString(1, username);
            rslt = pstmt.executeQuery();
            
            while (rslt.next()) {
                if (rslt.getString(1).equals(username)) {
                userExistence = true;
                }
            } 
        }
        catch (Exception e) {
            
        }
        finally {
            this.CloseDBConnection();
        }
    }
    
    
    public void CheckLogOn(String name) throws Exception {
        try{
            con = ConnectDB();
            pstmt = con.prepareStatement("SELECT * FROM benutzer WHERE username like (?);", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstmt.setString(1, name);
            rslt = pstmt.executeQuery();
            
        
            while (rslt.next()) {
                if (rslt.getString(1).equals(name)) {
                userValidity = true;
                }
            }
        }
        catch (Exception e) {
            
        }
        finally {
            this.CloseDBConnection();
        }
    }
}

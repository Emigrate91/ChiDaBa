/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import DataStructur.Bewaesserung;
import DataStructur.Duengung;
import DataStructur.Duenger;
import DataStructur.PflanzenDatenObjekt;
import DataStructur.PflanzenHoehe;
import GUI.PflanzenDaten;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    
    private SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy.MM.dd");
    
    private Connection ConnectDB () throws Exception {
        
        // Informationen zusammensuchen
        String dbHost = "localhost";
        String dbPort = "3306";
        String dbName = "chilli_database";
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
    
    public ArrayList getPlantAttributes(Object PlantID) throws Exception{
        // Zur Datenbank verbinden
    con = ConnectDB();
    // Statement erstellen                   
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT s.sorte, a.art, pd.topf_gr, a.herkunft, pd.farbe, ");
    sb.append("pd.scoville, pd. schaerfegrad, pd.reifezeit, s.reifezeit, ");
    sb.append("pd.gesamtzeit, pd.ertrag_gewicht, pd.ertrag_stk, ");
    sb.append("e.datum_aussaat, e.datum_keimung ");
    
    sb.append("FROM tbl_pflanzen p, tbl_sorte s, tbl_art a, ");
    sb.append("tbl_pflanzen_daten pd, tbl_ereignisse e ");
            
    sb.append("WHERE p.ID = (?) ");
    sb.append("AND a.ID = p.art_fk ");
    sb.append("AND s.ID = p.sorte_fk ");    
    sb.append("AND pd.ID = p.pflanzen_daten_fk ");
    sb.append("AND e.ID = p.ereignisse_fk ");
    
    String sql = sb.toString();    
    pstmt = con.prepareStatement(sql);
    
    // set parameter:
    pstmt.setString(1,String.valueOf(PlantID));        
    // execute:
    rslt = pstmt.executeQuery(); 
    
    if(rslt.next()){
        ArrayList l = new ArrayList();
            l.add(rslt.getString(1)+"_"+rslt.getString(2)); //00 - name=Sorte_Art
            l.add(rslt.getString(1));                       //01 - sorte
            l.add(rslt.getString(2));                       //02 - art
            l.add(rslt.getString(3));                       //03 - topfgröße
            l.add(rslt.getString(4));                       //04 - herkunft
            l.add(Color.decode(rslt.getString(5)));         //05 - farbe
            l.add(rslt.getInt(6));                          //06 - scoville
            l.add(rslt.getInt(7));                          //07 - schaefegrad
            l.add(rslt.getInt(8));                          //08 - reifezeit_pfl
            l.add(rslt.getInt(9));                          //09 - reifezeit_sorte
            l.add(rslt.getInt(10));                         //10 - gesamtzeit
            l.add(rslt.getInt(11));                         //11 - ertrag_g
            l.add(rslt.getInt(12));                         //12 - ertrag_stk            
            l.add(convertDBDate(rslt.getString(13)));       //13 - aussaat
            l.add(convertDBDate(rslt.getString(14)));       //14 - Keimung  
            
            return l;         
    }
    
    else{    
        return null;
    }
}
    
    public void InsertIntoBenutzer (String benutzername, String passwort) throws Exception{
        
        try {
            // Zur Datenbank verbinden
            con = ConnectDB();
            // Statement erstellen
            pstmt = con.prepareStatement("INSERT INTO tbl_benutzer VALUES(?,?,?)");
            //Query erstellen
            pstmt.setString(1, null);
            pstmt.setString(2, benutzername);
            pstmt.setString(3, passwort);
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            
        }
        finally {
            this.CloseDBConnection();
        }
    }
    
    public Object getPlantID(Object sort, Object art) throws Exception
    {
    // Zur Datenbank verbinden
    con = ConnectDB();
    // Statement erstellen                   
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT p.ID ");
    sb.append("FROM tbl_pflanzen p ");
    sb.append("WHERE p.art_fk IN (SELECT a.ID FROM tbl_art a WHERE a.art like (?))");
    sb.append("AND p.sorte_fk IN (SELECT s.ID FROM tbl_sorte s WHERE s.sorte like (?)) ");
    String sql = sb.toString();    
    pstmt = con.prepareStatement(sql);
    
    // set parameter:
    pstmt.setString(1,String.valueOf(art));
    pstmt.setString(2,String.valueOf(sort));
    
    // execute:
    rslt = pstmt.executeQuery();
    
    if(rslt.next()) 
        {return rslt.getObject(1);}
    
    else
        {return null;}
    }
    
    public Object getEreignissID(Object PlantID) throws Exception
    {
    // Zur Datenbank verbinden
    con = ConnectDB();
    // Statement erstellen                   
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT p.ereignisse_fk ");
    sb.append("FROM tbl_pflanzen p ");
    sb.append("WHERE p.ID = (?)");
    String sql = sb.toString();    
    pstmt = con.prepareStatement(sql);
    
    // set parameter:
    pstmt.setString(1,String.valueOf(PlantID));
    
    // execute:
    rslt = pstmt.executeQuery();
    
    if(rslt.next()) 
        return rslt.getObject(1);
    
    else
        return null;
    }
    
    public void InsertIntoPflanzen_hohe(PflanzenHoehe h) throws Exception{   
        try { 
            // Zur Datenbank verbinden
            con = ConnectDB();
            
            // Statement erstellen                   
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO tbl_hoehenmessungen VALUES(?,?,?,?);");
            String sql = sb.toString();            
            
            pstmt = con.prepareStatement(sql);
            
            //Query erstellen
            pstmt.setString(1, null);
            pstmt.setString(2, String.valueOf(h.getEreignissID()));
            pstmt.setString(3, String.valueOf(dbFormat.format((Date)h.getDatum()))); 
            pstmt.setString(4, String.valueOf(h.getHoehe()));
            pstmt.executeUpdate();
            }
        catch (Exception e) {}
        
        finally{this.CloseDBConnection();}    
    }
 
    public void InsertIntoBewaesserung(Bewaesserung bw) throws Exception{   
        try { 
            // Zur Datenbank verbinden
            con = ConnectDB();
            
            // Statement erstellen                   
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO tbl_bewaesserung VALUES(?,?,?,?);");
            String sql = sb.toString();            
            
            pstmt = con.prepareStatement(sql);
            
            //Query erstellen
            pstmt.setString(1, null);
            pstmt.setString(2, String.valueOf(bw.getEreignissID()));
            pstmt.setString(3, String.valueOf(dbFormat.format((Date)bw.getDatum())));  
            pstmt.setString(4, String.valueOf(bw.getMenge()));       

            pstmt.executeUpdate();
            }
        catch (Exception e) {System.err.println(e.getMessage());}
        
        finally{this.CloseDBConnection();}    
    }    
    
    public void InsertIntoDuengvorgaenge(Duengung dv) throws Exception{   
        try { 
            // Zur Datenbank verbinden
            con = ConnectDB();
            
            String name = String.valueOf(getDuengerID(dv.getDuenger()));
            
            // Statement erstellen                   
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO tbl_duengvorgaenge VALUES(?,?,?,?,?);");
            String sql = sb.toString();            
            
            pstmt = con.prepareStatement(sql);
            
            //Query erstellen
            pstmt.setString(1, null);
            pstmt.setString(2, String.valueOf(dv.getEreignissID()));
            pstmt.setString(3, String.valueOf(dbFormat.format((Date)dv.getDatum())));  
            pstmt.setString(4, String.valueOf(dv.getMenge()));      
            pstmt.setString(5, name); 

            pstmt.executeUpdate();
            }
        catch (Exception e) {System.err.println(e.getMessage());}
        
        finally{this.CloseDBConnection();}    
    }    
    
    public Object getDuengerID(String d) throws Exception
    {
    // Zur Datenbank verbinden
    con = ConnectDB();
    // Statement erstellen                   
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT ID ");
    sb.append("FROM tbl_duenger ");
    sb.append("WHERE name like (?)");
    String sql = sb.toString();    
    pstmt = con.prepareStatement(sql);
    
    // set parameter:
    pstmt.setString(1,d);
    
    // execute:
    rslt = pstmt.executeQuery();
    
    if(rslt.next()) 
        return rslt.getObject(1);
    
    else
        return null;
    }
    
    public Object getDuengerName(Object ID) throws Exception
    {
    // Zur Datenbank verbinden
    con = ConnectDB();
    // Statement erstellen                   
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT name ");
    sb.append("FROM tbl_duenger ");
    sb.append("WHERE ID like (?)");
    String sql = sb.toString();    
    pstmt = con.prepareStatement(sql);
    
    // set parameter:
    pstmt.setString(1, String.valueOf(ID));
    
    // execute:
    rslt = pstmt.executeQuery();
    
    if(rslt.next()) 
        return rslt.getObject(1);
    
    else
        return null;
    }    
    
    public void InsertIntoDuenger(Duenger duenger) throws Exception{
      
        try { 
            // Zur Datenbank verbinden
            con = ConnectDB();
            // Statement erstellen
            pstmt = con.prepareStatement("INSERT INTO tbl_duenger VALUES(?,?,?,?,?,?)");
            //Query erstellen
            pstmt.setString(1, null); 
            pstmt.setString(2, duenger.getName());  
            pstmt.setString(3, String.valueOf(duenger.getStickstoff())); 
            pstmt.setString(4, String.valueOf(duenger.getPhosphat()));
            pstmt.setString(5, String.valueOf(duenger.getKalium()));
            pstmt.setString(6, String.valueOf(duenger.getMagnesium()));
            pstmt.executeUpdate();
        }
    
        catch (Exception e) {}
        
        finally{this.CloseDBConnection();}
    }
    
    public boolean UsernameExists (String username) throws Exception {
        try {
            con = ConnectDB();
            pstmt = con.prepareStatement("SELECT * FROM tbl_benutzer WHERE username = (?);",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstmt.setString(1, username);
            rslt = pstmt.executeQuery();
            
            while (rslt.next()) {
                if (rslt.getString(2).equals(username)) {
                return true;
                }
            }       
        }
        
        catch (Exception e) {
            
        }
        
        finally {
            this.CloseDBConnection();
        }
    return false;
    }
    
    public Duenger getDuengerInfo(String name) throws Exception{
        con = ConnectDB();
        pstmt = con.prepareStatement("SELECT * FROM tbl_duenger WHERE name like (?);");
        pstmt.setString(1, name);
        rslt = pstmt.executeQuery();
        
        if(rslt.next()){   
            Duenger d =  new Duenger(rslt.getString(2), rslt.getInt(3), rslt.getInt(4), rslt.getInt(5), rslt.getInt(6));
            this.CloseDBConnection();
            return d;
            }
        
        else {
            this.CloseDBConnection();
            return null;
            } 

    }
        
    public ArrayList getList(String listVariable, String tble) throws Exception
        {
        // Zur Datenbank verbinden
        con = ConnectDB();
        // Statement erstellen                   
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(listVariable);
        sb.append(" FROM ");
        sb.append(tble);
        sb.append(" ORDER BY ");
        sb.append(listVariable);
        String sql = sb.toString();   
        
        pstmt = con.prepareStatement(sql);
        
        // Ausführen 
        rslt = pstmt.executeQuery();
        
        // in Liste speichern
        ArrayList Liste= new ArrayList();
            while (rslt.next()) 
                {Liste.add(rslt.getString(1));}
    
        this.CloseDBConnection();
        return Liste;
        }
    
    public ArrayList getSorteList() throws Exception{
    con = ConnectDB();
    pstmt = con.prepareStatement("SELECT sorte FROM tbl_sorte ORDER BY sorte");
    rslt = pstmt.executeQuery();
    
    ArrayList SorteList= new ArrayList();
    while (rslt.next()) 
        {SorteList.add(rslt.getString(1));}
    
    this.CloseDBConnection();
    return SorteList;
    }
    
    public ArrayList<Object[]> getEreignissHoeheList(Object EreignissID) throws Exception{
    con = ConnectDB();
    pstmt = con.prepareStatement("SELECT * FROM tbl_hoehenmessungen WHERE tbl_ereignisse_fk like (?);");
    pstmt.setString(1, String.valueOf(EreignissID));
    rslt = pstmt.executeQuery();
    

    ArrayList<Object[]> PflanzenHoeheList= new ArrayList();
    while (rslt.next()) 
        {
        ArrayList tmp = new ArrayList();
        tmp.add(convertDBDate(rslt.getString(3)));
        tmp.add("Höhen Messung");
        tmp.add("/");
        tmp.add("/");
        tmp.add(rslt.getString(4));
        PflanzenHoeheList.add(tmp.toArray());
        tmp.clear();
        }
    
    this.CloseDBConnection();
    return PflanzenHoeheList;
    }
    
    public ArrayList<Object[]> getEreignissBeWList(Object EreignissID) throws Exception{
    con = ConnectDB();
    pstmt = con.prepareStatement("SELECT * FROM tbl_bewaesserung WHERE tbl_ereignisse_fk like (?);");
    pstmt.setString(1, String.valueOf(EreignissID));
    rslt = pstmt.executeQuery();
    

    ArrayList<Object[]> BeWList= new ArrayList();
    while (rslt.next()) 
        {
        ArrayList tmp = new ArrayList();
        tmp.add(convertDBDate(rslt.getString(3)));
        tmp.add("Bewässerung");
        tmp.add("/");
        tmp.add(rslt.getString(4));
        tmp.add("/");     
        BeWList.add(tmp.toArray());
        tmp.clear();
        }
    
    this.CloseDBConnection();
    return BeWList;
    }    
    
    public ArrayList<Object[]> getEreignissDuengVList(Object EreignissID) throws Exception{
    con = ConnectDB();
    ResultSet privateRslt; // temporär, solange der rslt shit noch global ist :D
    pstmt = con.prepareStatement("SELECT * FROM tbl_duengvorgaenge WHERE tbl_ereignisse_fk like (?);");
    pstmt.setString(1, String.valueOf(EreignissID));
    privateRslt = pstmt.executeQuery();

    ArrayList<Object[]> DuengVList= new ArrayList();
    while (privateRslt.next()) 
        {
        ArrayList tmp = new ArrayList();
        tmp.add(convertDBDate(privateRslt.getString(3)));
        tmp.add("Düngevorgang");
        tmp.add(this.getDuengerName(privateRslt.getString(5)));
        tmp.add(privateRslt.getString(4));
        tmp.add("/");
        DuengVList.add(tmp.toArray());
        tmp.clear();
        }
    
    this.CloseDBConnection();
    privateRslt.close();
    return DuengVList;
    }
    
    private String convertDBDate(String db)
    {
    String[] datum=db.split("-");
    return datum[2]+"."+datum[1]+"."+datum[0];
    }
    
    public Object[][] getTblPflanzenFromDB() throws Exception{
    con = ConnectDB();
    
    // erzeuge Statement:
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT s.sorte, a.art, a.herkunft, e.datum_aussaat  ");
    sb.append("FROM tbl_pflanzen p, tbl_art a, tbl_sorte s, tbl_ereignisse e ");
    sb.append("WHERE a.ID = p.art_fk ");
    sb.append("AND s.ID = p.sorte_fk ");
    sb.append("AND e.ID = p.ereignisse_fk ");
    String sql = sb.toString();
    
    pstmt = con.prepareStatement(sql);
    rslt = pstmt.executeQuery();

    ArrayList row = new ArrayList();
    ArrayList<Object[]> column = new ArrayList();
    
    while (rslt.next()) {
        for(int i=1 ; i<=4;i++){    
            if(i==4){row.add(convertDBDate(String.valueOf(rslt.getObject(i))));}
            else {row.add(rslt.getObject(i));}
            }   
        column.add(row.toArray());
        row.clear();
        }
    
    Object[][] result = new Object[column.size()][4];
    for(int i=0;i<column.size();i++)
        {result[i]=column.get(i);}

    this.CloseDBConnection();
    return result;
    }
    
    
    public void CheckLogOn(String name, String pw) throws Exception {
        try{
            con = ConnectDB();
            pstmt = con.prepareStatement("SELECT * FROM tbl_benutzer WHERE username like (?) AND pass like (?);", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstmt.setString(1, name);
            pstmt.setString(2, pw);  
           
            boolean test = pstmt.execute();
            
            rslt = pstmt.executeQuery();
        
            // if Table size is >=1 -> username with this password 
            if(rslt.next()){userValidity = true;}
            
            /* //
            while (rslt.next()) {
                System.out.println(rslt.getString(1));
                if (rslt.getString(1).equals(name) && rslt.getString(2).equals("test")) {
                userValidity = true;
                }
            }*/
        }
        catch (Exception e) {System.out.println(e.getMessage());
            
        }
        finally {
            this.CloseDBConnection();
        }
    }
}

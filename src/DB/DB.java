package DB;

import DataStructur.Art;
import DataStructur.Bewaesserung;
import DataStructur.Duengung;
import DataStructur.Duenger;
import DataStructur.PflanzenHoehe;
import DataStructur.Sorte;
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
 * Caution! this class contains everything Database related
 * @author Team ChiDaBa
 */
public class DB {
        
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rslt = null;
    private PreparedStatement pstmt = null;
    private boolean userValidity = false;
    
    private SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy.MM.dd");
    /**
     * collects and packs the information for the Database connection 
     */
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
    /**
     * establishes connection to the database, creates the statment and updates for the elimination
     * @param PlantID primary key of the table Plant
     * @exception returns an error message in case of an error
     */
    public void deletePflanze(Object PlantID){
    try {
        // Zur Datenbank verbinden
        con = ConnectDB();         

        // Statement erstellen                   
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM tbl_pflanzen ");
        sb.append("WHERE ID = (?)");
        
        String sql = sb.toString();            

        pstmt = con.prepareStatement(sql);
        
        //Query erstellen
        pstmt.setString(1, String.valueOf(PlantID));
        
        // Update durchführen
        pstmt.executeUpdate();
          
        }
        catch (Exception ex) {System.err.println(ex.getMessage());}
    
    }
    /**
     * connects to the Database , deletes the questions and creates a query, followed by an updates
     * @param EreignisID primary key of the Table Ereignis
     * @exception error message in case of an error
     */
        public void deleteEreignis(Object EreignisID){
    try {
        // Zur Datenbank verbinden
        con = ConnectDB();         

        // delete fk einträge
        this.deleteBewaesserung(EreignisID);
        this.deleteDuengvorgaenge(EreignisID);
        this.deleteHoehenmessungen(EreignisID);
        
        // Statement erstellen                   
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM tbl_ereignisse ");
        sb.append("WHERE ID = (?)");
        
        String sql = sb.toString();            

        pstmt = con.prepareStatement(sql);
        
        //Query erstellen
        pstmt.setString(1, String.valueOf(EreignisID));
        
        // Update durchführen
        pstmt.executeUpdate();
          
        }
        catch (Exception ex) {System.err.println(ex.getMessage());}
    
    }
/**
 * after the established DB-connection will the Duengevorgaenge be deleted
 * @param EreignisID primary key of the table Ereignis
 * @exception error message in case of an error
 */
    private void deleteDuengvorgaenge(Object EreignisID){
    try {
        // Zur Datenbank verbinden
        con = ConnectDB();         

        // Statement erstellen                   
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM tbl_duengvorgaenge ");
        sb.append("WHERE tbl_ereignisse_fk = (?)");
        
        String sql = sb.toString();            

        pstmt = con.prepareStatement(sql);
        
        //Query erstellen
        pstmt.setString(1, String.valueOf(EreignisID));
        
        // Update durchführen
        pstmt.executeUpdate();
          
        }
        catch (Exception ex) {System.err.println(ex.getMessage());}
    
    }         
 /**
  * process of the deletion of Hoehenmessungen
  * @param EreignisID primary key of the table Ereignis
  * @exception error message in case of an error
  */       
    private void deleteHoehenmessungen(Object EreignisID){
    try {
        // Zur Datenbank verbinden
        con = ConnectDB();         

        // Statement erstellen                   
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM tbl_hoehenmessungen ");
        sb.append("WHERE tbl_ereignisse_fk = (?)");
        
        String sql = sb.toString();            

        pstmt = con.prepareStatement(sql);
        
        //Query erstellen
        pstmt.setString(1, String.valueOf(EreignisID));
        
        // Update durchführen
        pstmt.executeUpdate();
          
        }
        catch (Exception ex) {System.err.println(ex.getMessage());}
    
    }          
    /**
     * process of deletion of Bewaesserung
     * @param EreignisID primary key of the table Ereignis
     * @exception error message in case of an error
     */    
    private void deleteBewaesserung(Object EreignisID){
    try {
        // Zur Datenbank verbinden
        con = ConnectDB();         

        // Statement erstellen                   
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM tbl_bewaesserung ");
        sb.append("WHERE tbl_ereignisse_fk = (?)");
        
        String sql = sb.toString();            

        pstmt = con.prepareStatement(sql);
        
        //Query erstellen
        pstmt.setString(1, String.valueOf(EreignisID));
        
        // Update durchführen
        pstmt.executeUpdate();
          
        }
        catch (Exception ex) {System.err.println(ex.getMessage());}
    
    }    
    /**
     * process of deletion of Pflanzendaten
     * @param PflanzenDatenID primary key of PflanzenDaten
     * @exception error message in case of an error
     */    
    public void deletePflanzenDaten(Object PflanzenDatenID){
    try {
        // Zur Datenbank verbinden
        con = ConnectDB();         

        // Statement erstellen                   
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM tbl_pflanzen_daten ");
        sb.append("WHERE ID = (?)");
        
        String sql = sb.toString();            

        pstmt = con.prepareStatement(sql);
        
        //Query erstellen
        pstmt.setString(1, String.valueOf(PflanzenDatenID));
        
        // Update durchführen
        pstmt.executeUpdate();
          
        }
        catch (Exception ex) {System.err.println(ex.getMessage());}
    
    }    
    /**
     * closes the Database-Connection 
     */
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
    /**
     * get method of UserValidity
     */
    public boolean getuserValidity() {
        return userValidity;
    }
    /**
     * establishes an connection and creates the statments for the Database
     */
    public ArrayList getPlantAttributes(Object PlantID) throws Exception{
        // Zur Datenbank verbinden
    con = ConnectDB();
    // Statement erstellen                   
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT s.sorte, a.art, t.topf_gr, h.herkunft, pd.farbe, ");
    sb.append("pd.scoville, pd. schaerfegrad, pd.reifezeit, s.reifezeit, ");
    sb.append("pd.gesamtzeit, pd.ertrag_gewicht, pd.ertrag_stk, ");
    sb.append("e.datum_aussaat, e.datum_keimung ");
    
    sb.append("FROM tbl_pflanzen p, tbl_sorte s, tbl_art a, ");
    sb.append("tbl_pflanzen_daten pd, tbl_ereignisse e, ");
    sb.append("tbl_topf t, tbl_herkunft h ");
    
    sb.append("WHERE p.ID = (?) ");
    sb.append("AND a.ID = p.art_fk ");
    sb.append("AND t.ID = pd.topf_fk ");
    sb.append("AND h.ID = a.herkunft_fk ");
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
            l.add(rslt.getString(5));                       //05 - farbe
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
    /**
     * establischen an DB-connection, collects the login data and closes the
     * @param benutzername is used to identify the user
     * @param passwort is used to validate the username
     * @throws Exception dispays an error message 
     */
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
        catch (Exception e) {System.err.println(e.getMessage());  }
        finally {
            this.CloseDBConnection();
        }
    }
    /**
     * get method for the PlantID
     */
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
/**
 * get method for TopfID
 */
    public Object getTopfID(Object topfgr) throws Exception
    {
    // Zur Datenbank verbinden
    con = ConnectDB();
    // Statement erstellen                   
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT ID ");
    sb.append("FROM tbl_topf ");
    sb.append("WHERE topf_gr = (?)");
    String sql = sb.toString();    
    pstmt = con.prepareStatement(sql);
    
    // set parameter:
    pstmt.setString(1,String.valueOf(topfgr));
    
    // execute:
    rslt = pstmt.executeQuery();
    
    if(rslt.next()) 
        return rslt.getObject(1);
    
    else
        return null;
    }
    
    /**
     * get method for Ereigniss_fk
     */
    public Object getEreigniss_fk(Object PlantID) throws Exception
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
    
    
    /**
     * enters the Hoehe into the Database
     * @param h Hoehe of the plant in the database
     * @throws Exception error message in case of an error
     */
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
        catch (Exception e) {System.err.println(e.getMessage()); }
        
        finally{this.CloseDBConnection();}    
    }
 /**
  * inserts Bewaesserung into the Database
  * @param bw object of bewasserung 
  * @throws Exception error message in case of an error
  */
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
    /**
     * enters the objekt Duengung into the database
     * @param dv object of Duengung
     * @throws Exception error message in case of an erorr
     */
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
    /**
     * get method of DuengerID
     */
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
    /**
     * get method of DuengerName
     */
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
    /**
     * enters duenger into the Database
     * @param duenger object of duenger
     * @throws Exception error message in case of an error
     */
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
    
        catch (Exception e) {System.err.println(e.getMessage());}
        
        finally{this.CloseDBConnection();}
    }
    /**
     * enters sorte into the database
     * @param sorte object of sorte
     * @throws Exception error message in case of an error
     */
        public void InsertIntoSorte(Sorte sorte) throws Exception{
      
        try { 
            // Zur Datenbank verbinden
            con = ConnectDB();
            // Statement erstellen
            pstmt = con.prepareStatement("INSERT INTO tbl_sorte VALUES(?,?,?)");
            //Query erstellen
            pstmt.setString(1, null); 
            pstmt.setString(2, sorte.getSorte());  
            pstmt.setString(3, String.valueOf(sorte.getReifezeit())); 
            pstmt.executeUpdate();
        }
    
        catch (Exception e) {System.err.println(e.getMessage());}
        
        finally{this.CloseDBConnection();}
    }
        
        
/**
 * get method of SorteID
 */        
public int getSorteID(Sorte s) throws Exception
    {
    // Zur Datenbank verbinden
    con = ConnectDB();
    // Statement erstellen                   
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT s.ID ");
    sb.append("FROM tbl_sorte s ");
    sb.append("WHERE s.sorte = (?) ");
    sb.append("AND s.reifezeit = (?)");
    
    String sql = sb.toString();    
    pstmt = con.prepareStatement(sql);
    
    // set parameter:
    pstmt.setString(1,s.getSorte());
    pstmt.setString(2,String.valueOf(s.getReifezeit()));
    
    // execute:
    rslt = pstmt.executeQuery();
    
    if(rslt.next()) 
        return rslt.getInt(1);
    
    else
        return -1;
    }  
/**
 * get method of ArtID
 */
public int getArtID(Art art) throws Exception
    {
    // Zur Datenbank verbinden
    con = ConnectDB();
    // Statement erstellen                   
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT a.ID ");
    sb.append("FROM tbl_art a ");
    sb.append("WHERE a.art = (?) ");
    sb.append("AND a.herkunft_fk IN( ");
    sb.append("SELECT h.ID FROM tbl_herkunft h WHERE h.herkunft= (?) )");
    
    
    String sql = sb.toString();    
    pstmt = con.prepareStatement(sql);
    
    // set parameter:
    pstmt.setString(1, art.getArt());
    pstmt.setString(2, art.getHerkunft());
    
    // execute:
    rslt = pstmt.executeQuery();
    
    if(rslt.next()) 
        return rslt.getInt(1);
    
    else
        return -1;
    }  
        /**
         * Updates the entry of SorteReifezeit in the database
         * @throws Exception error message in case of an error
         */        
        public void UpdateSorteReifezeit(int ID, int value) throws Exception{
      
        try { 
            // Zur Datenbank verbinden
            con = ConnectDB();
            // Statement erstellen
            pstmt = con.prepareStatement("UPDATE tbl_sorte s SET s.reifezeit=(?) WHERE s.ID=(?)");
            
            //Query erstellen
            pstmt.setString(1, String.valueOf(value));  
            pstmt.setString(2, String.valueOf(ID)); 
            pstmt.executeUpdate();
        }
    
        catch (Exception e) {System.err.println(e.getMessage());}
        
        finally{this.CloseDBConnection();}
    }
/**
 * get method of PflanzenDaten_FK
 */       
public Object getPflanzenDaten_FK(Object PlantID) throws Exception{                
    ResultSet rsltP = null;    
    // Zur Datenbank verbinden
    con = ConnectDB();
    // Statement erstellen                   
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT pflanzen_daten_fk ");
    sb.append("FROM tbl_pflanzen ");
    sb.append("WHERE ID = (?)");
    String sql = sb.toString();    
    pstmt = con.prepareStatement(sql);
    
    // set parameter:
    pstmt.setString(1,String.valueOf(PlantID));
    
    // execute:
    rsltP = pstmt.executeQuery();
    
    if(rsltP.next()){
        Object erg = rsltP.getObject(1);
        rsltP.close();
        this.CloseDBConnection();
        return erg;
    }
    
    else{
        this.CloseDBConnection(); 
        return null;
    
    }
    }
    /**
     * Update the entry of PflanzenDaten in the database
     * @throws Exception error message in case of an error
     */            
    public void UpdatePflanzenDaten(ArrayList l) throws Exception{

    try { 
        // Zur Datenbank verbinden
        con = ConnectDB();
        // Statement erstellen            
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE tbl_pflanzen_daten ");

        sb.append("SET scoville=(?), schaerfegrad=(?), farbe=(?), ");
        sb.append("topf_fk=(?), reifezeit=(?), gesamtzeit=(?), ");
        sb.append("ertrag_gewicht=(?), ertrag_stk=(?) ");

        sb.append("WHERE ID = (?)");

        String sql = sb.toString();    
        pstmt = con.prepareStatement(sql);          

        //Query erstellen
        for(int i=0;i<9;i++){
            pstmt.setString(i+1, String.valueOf(l.get(i)));
        }

        pstmt.executeUpdate();
    }

    catch (Exception e) {System.err.println(e.getMessage());}

    finally{this.CloseDBConnection();}
    } 
   /**
    * Updates the entry of Ereigniss in the database
    * @throws Exception error message in case of an error
    */
   public void UpdateEreignisse(ArrayList l) throws Exception{

    try { 
        // Zur Datenbank verbinden
        con = ConnectDB();
        // Statement erstellen            
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE tbl_ereignisse ");

        sb.append("SET datum_aussaat=(?), datum_keimung=(?) ");

        sb.append("WHERE ID = (?)");

        String sql = sb.toString();    
        pstmt = con.prepareStatement(sql);          

        //Query erstellen
        pstmt.setString(1, dbFormat.format((Date)(l.get(0))));
        pstmt.setString(2, dbFormat.format((Date)(l.get(1))));
        pstmt.setString(3, String.valueOf(l.get(2)));
        pstmt.executeUpdate();
    }

    catch (Exception e) {System.err.println(e.getMessage());}

    finally{this.CloseDBConnection();}
    }     
        /**
         * Update the entry of ArtHerkunft in the Database
         * @throws Exception error message in case of an error
         */
        public void UpdateArtHerkunft(Object ID, int value) throws Exception{
      
        try { 
            // Zur Datenbank verbinden
            con = ConnectDB();
            // Statement erstellen
            pstmt = con.prepareStatement("UPDATE tbl_art a SET a.herkunft_fk=(?) WHERE a.ID=(?)");
            
            //Query erstellen
            pstmt.setString(1, String.valueOf(value));  
            pstmt.setString(2, String.valueOf(ID)); 
            pstmt.executeUpdate();
        }
    
        catch (Exception e) {System.err.println(e.getMessage());}
        
        finally{this.CloseDBConnection();}
    }
        /**
         * Update the entry of FKinPflanzen in the Database
         * @throws Exception error message in case of an error
         */
        public void UpdateFKinPflanzen(String fk, int newFK, Object PlantID) throws Exception{
      
        try { 
            // Zur Datenbank verbinden
            con = ConnectDB();
            // Statement erstellen
            pstmt = con.prepareStatement("UPDATE tbl_pflanzen SET " + fk + "=(?) WHERE ID=(?)");
            
            //Query erstellen
            pstmt.setString(1, String.valueOf(newFK));
            pstmt.setString(2, String.valueOf(PlantID));
            pstmt.executeUpdate();
        }
    
        catch (Exception e) {System.err.println(e.getMessage());}
        
        finally{this.CloseDBConnection();}
        }           
        /**
         * enters Art into the database
         * @exception error mesage in case of an error
         */
        public Object InsertIntoArt(Art art, int HerkunftID) throws Exception{
        try { 
            // Zur Datenbank verbinden
            con = ConnectDB();
            // Statement erstellen
            pstmt = con.prepareStatement("INSERT INTO tbl_art VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            //Query erstellen
            pstmt.setString(1, null); 
            pstmt.setString(2, art.getArt());  
            
            if(HerkunftID == 0)
                pstmt.setString(3, null); 
            
            else pstmt.setString(3, String.valueOf(HerkunftID));
            
            pstmt.executeUpdate();
            rslt = pstmt.getGeneratedKeys();
            if(rslt.next()){
                return rslt.getObject(1);
            }
        }
        
    
        catch (Exception e) { System.err.println(e.getMessage());}
        
        finally{this.CloseDBConnection();}
        return null;
        }        
        /**
         * enters the new values into NeuePflanze
         * @throws Exception error message in case of an error
         */
        public Object NeuePflanze(int ArtID, int SorteID) throws Exception{
        try { 
            // Zur Datenbank verbinden
            con = ConnectDB();
            // leere Pflanzen_ daten erstellen
            pstmt = con.prepareStatement("INSERT INTO tbl_pflanzen_daten VALUES( null, null, null, null, null, null, null, null, null )", Statement.RETURN_GENERATED_KEYS);
           
            pstmt.executeUpdate();
            
            // get Generated Key as pflanzen_daten_ID
            rslt = pstmt.getGeneratedKeys();
            if(rslt.next()){
                int pflanzen_daten_ID = rslt.getInt(1);
                
                // Erstelle leeres Ereigniss
                pstmt = con.prepareStatement("INSERT INTO tbl_ereignisse VALUES(null, null, null )", Statement.RETURN_GENERATED_KEYS);
                pstmt.executeUpdate();
                
                // get Generated Key as pflanzen_daten_ID
                rslt = pstmt.getGeneratedKeys();
                if(rslt.next()){
                    int Ereignis_ID = rslt.getInt(1);                
                    
                  
                    // Erstelle der eigentlichen Pflanze
                    // 1,1 weil diese gibt es aufjedenfall, da eine Sorte/Art zuvor erstellt wurde und man Sorten/Arten nicht löschen kann!!!
                    pstmt = con.prepareStatement("INSERT INTO tbl_pflanzen VALUES(null, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS); 
                    pstmt.setString(1, String.valueOf(ArtID));
                    pstmt.setString(2, String.valueOf(SorteID));
                    pstmt.setString(3, String.valueOf(pflanzen_daten_ID));
                    pstmt.setString(4, String.valueOf(Ereignis_ID));                    
                    pstmt.executeUpdate();
                
                    // get Generated Key as PlantID
                    rslt = pstmt.getGeneratedKeys();
                    if(rslt.next()){
                    return rslt.getObject(1);
                    }
                    
                    // Fehler beimn erstellen der Pflanze
                    else{
                    return null;
                    }
                }
                
                // Fehler beimn erstellen des Ereignisses
                else{
                return null;   
                }               
            }
            
            // Fehler beimn erstellen der Pflanzen Daten
            else{
            return null;    
            }         
            
        }
        
    
        catch (Exception e) {System.err.println(e.getMessage());}
        
        finally{this.CloseDBConnection();}
        
        // Fehler anderer art
        return null;
        } 
        /**
         * Inserts the new values into table Herkunft
         * @param herkunft object of herkunft
         * @throws Exception error message in case of an error
         */
        public void InsertIntoHerkunft(String herkunft) throws Exception{
      
        try { 
            // Zur Datenbank verbinden
            con = ConnectDB();
            // Statement erstellen
            pstmt = con.prepareStatement("INSERT INTO tbl_herkunft VALUES(?,?)");
            //Query erstellen
            pstmt.setString(1, null); 
            pstmt.setString(2, herkunft);  
            pstmt.executeUpdate();
        }
    
        catch (Exception e) {System.err.println(e.getMessage());}
        
        finally{this.CloseDBConnection();}
    }
       /**
        * inserts the new value of TopfGr into the table Topf
        * @param groesse object of Topf
        * @throws Exception error message in case of an error
        */         
        public void InsertIntoTopfGr(String groesse) throws Exception{
      
        try { 
            // Zur Datenbank verbinden
            con = ConnectDB();
            // Statement erstellen
            pstmt = con.prepareStatement("INSERT INTO tbl_topf VALUES(?,?)");
            //Query erstellen
            pstmt.setString(1, null); 
            pstmt.setString(2, groesse);  
            pstmt.executeUpdate();
        }
    
        catch (Exception e) {System.err.println(e.getMessage());}
        
        finally{this.CloseDBConnection();}
    }

    /**
     * get method for Herkunft_FK
     */    
    public int getHerkunft_FK(int ArtID) throws Exception
    {
    ResultSet rsltP = null;    
    // Zur Datenbank verbinden
    con = ConnectDB();
    // Statement erstellen                   
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT a.herkunft_fk ");
    sb.append("FROM tbl_art a ");
    sb.append("WHERE a.ID = (?)");
    String sql = sb.toString();    
    pstmt = con.prepareStatement(sql);
    
    // set parameter:
    pstmt.setString(1,String.valueOf(ArtID));
    
    // execute:
    rsltP = pstmt.executeQuery();
    
    if(rsltP.next()){
        int erg = rsltP.getInt(1);
        rsltP.close();
        this.CloseDBConnection();
        return erg;
    }
    
    else{
        this.CloseDBConnection(); 
        return 0;
    
    }
    }
/** 
 * get method of HerkunftID
 */
public int getHerkunftID(String herkunft) throws Exception
    {
    ResultSet rsltP = null;    
    // Zur Datenbank verbinden
    con = ConnectDB();
    // Statement erstellen                   
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT h.ID ");
    sb.append("FROM tbl_herkunft h ");
    sb.append("WHERE h.herkunft like (?)");
    String sql = sb.toString();    
    pstmt = con.prepareStatement(sql);
    
    // set parameter:
    pstmt.setString(1,String.valueOf(herkunft));
    
    // execute:
    rsltP = pstmt.executeQuery();
    
    if(rsltP.next()){
        int erg = rsltP.getInt(1);
        rsltP.close();
        this.CloseDBConnection();
        return erg;
    }
    
    else{
        this.CloseDBConnection(); 
        return 0;
    
    }
    }    
   /**
    * get method of ArtInfo
    */
    public ArrayList<String> getArtInfo(Object ID) throws Exception{
        ResultSet rsltP = null;    
        // Zur Datenbank verbinden
        con = ConnectDB();
        // Statement erstellen                   
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT a.art, h.herkunft ");
        sb.append("FROM tbl_art a, tbl_herkunft h ");
        sb.append("WHERE a.ID= (?) ");
        sb.append("AND h.ID = a.herkunft_fk");
        
        String sql = sb.toString();    
        pstmt = con.prepareStatement(sql);

        // set parameter:
        pstmt.setString(1,String.valueOf(ID));

        // execute:
        rsltP = pstmt.executeQuery();
        
        ArrayList l =new ArrayList();
        l.add(rsltP.getString(1));
        l.add(rsltP.getString(2));
        
        rsltP.close();
        this.CloseDBConnection(); 
        
        return l;
    }
    /**
     * get method of SorteReifezeit
     */
    public int getSorteReifezeit(String sorte) throws Exception{
        ResultSet rsltP = null;    
        // Zur Datenbank verbinden
        con = ConnectDB();
        // Statement erstellen                   
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT s.reifezeit ");
        sb.append("FROM tbl_sorte s ");
        sb.append("WHERE sorte = (?)");
        String sql = sb.toString();    
        pstmt = con.prepareStatement(sql);

        // set parameter:
        pstmt.setString(1,sorte);

        // execute:
        rsltP = pstmt.executeQuery();

        if(rsltP.next()){
            int erg = rsltP.getInt(1);
            rsltP.close();
            this.CloseDBConnection();
            return erg;
        }
        else {return 0;}
    
    }
    /**
     * get method ArtHerkunft
     */
    public String getArtHerkunft(String art) throws Exception{
        ResultSet rsltP = null;    
        // Zur Datenbank verbinden
        con = ConnectDB();
        // Statement erstellen                   
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT h.herkunft ");
        sb.append("FROM tbl_herkunft h ");
        sb.append("WHERE h.ID IN (SELECT a.herkunft_fk ");
        sb.append("FROM tbl_art a WHERE a.art=(?))");
        
        String sql = sb.toString();    
        pstmt = con.prepareStatement(sql);

        // set parameter:
        pstmt.setString(1,art);

        // execute:
        rsltP = pstmt.executeQuery();

        if(rsltP.next()){
            String erg = rsltP.getString(1);
            rsltP.close();
            this.CloseDBConnection();
            return erg;
        }
        return null;    
    }
    /**
     * Checks if the Username allredy exists
     * @exception error message in case of an error
     */    
    public boolean CheckUsernameExists (String username) throws Exception {
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
        
        catch (Exception e) {System.err.println(e.getMessage()); }
        
        finally {
            this.CloseDBConnection();
        }
    return false;
    }
    /**
     * get method for Duenger_Info
     * @param name object of duenger
     * @throws Exception error message in case of an error
     */
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
    /**
     * get method for List
     */    
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
        sb.append(" GROUP BY ");
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
        /**
         * get method ArtList
         */
        public ArrayList getArtList(String art, int fk) throws Exception
        {
        // Zur Datenbank verbinden
        con = ConnectDB();
        // Statement erstellen                   
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT a.ID ");
        sb.append(" FROM tbl_art a ");
        sb.append(" WHERE a.art = (?) ");
        sb.append(" AND a.herkunft_fk = (?) ");
        String sql = sb.toString();   
        pstmt = con.prepareStatement(sql);
        
        pstmt.setString(1,art);
        pstmt.setString(2,String.valueOf(fk));
        // Ausführen 
        rslt = pstmt.executeQuery();
        
        // in Liste speichern
        ArrayList Liste= new ArrayList();
            while (rslt.next()) 
                {Liste.add(rslt.getString(1));}
    
        this.CloseDBConnection();
        return Liste;
        }
    /**
     * get method for SorteList
     */
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
    /**
     * get method for EreignissHoeheList
     */
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
    /**
     * get method of EreignissBeWList
     */
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
    /**
     * get method of EreignissDuengVList
     */
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
    /**
     * transform the Date in the Database
     */
    private String convertDBDate(String db)
    {
    String[] datum=db.split("-");
    return datum[2]+"."+datum[1]+"."+datum[0];
    }
    /**
     * get method of TblPflanzenFormDB
     */
    public Object[][] getTblPflanzenFromDB() throws Exception{
    con = ConnectDB();
    
    // erzeuge Statement:
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT s.sorte, a.art, h.herkunft, e.datum_aussaat  ");
    sb.append("FROM tbl_pflanzen p, tbl_art a, tbl_sorte s, tbl_herkunft h, tbl_ereignisse e ");
    sb.append("WHERE a.ID = p.art_fk ");
    sb.append("AND s.ID = p.sorte_fk ");
    sb.append("AND h.ID = a.herkunft_fk ");
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
    
    /**
     * Checks if the Login is correctly executed
     * @exception error message in case of an error
     */
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
            
        }
        catch (Exception e) {System.out.println(e.getMessage());
            
        }
        finally {
            this.CloseDBConnection();
        }
    }
       /**
        * checks if Plant allredy exists
        */
       public int CheckPlantExist(Object sorte, Object art ) throws Exception{
        con = ConnectDB();
    
        // erzeuge Statement:
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT p.ID ");
        sb.append("FROM tbl_pflanzen p ");
        sb.append("WHERE p.art_fk IN( ");
        sb.append("SELECT a.ID FROM tbl_art a WHERE a.art=(?)) ");
        
        sb.append("AND p.sorte_fk IN( ");
        sb.append("SELECT s.ID FROM tbl_sorte s WHERE s.sorte=(?)) ");
        String sql = sb.toString();

        // prepare Statement:
        pstmt = con.prepareStatement(sql);   
        pstmt.setString(1, String.valueOf(art));
        pstmt.setString(2, String.valueOf(sorte));

        rslt = pstmt.executeQuery();
        
        // Falls es einen Eintrag gibt
        if(rslt.next()){
            return rslt.getInt(1); // gebe ID zurück
        }
        else {
        return -1;
        }
    
    }
    
}


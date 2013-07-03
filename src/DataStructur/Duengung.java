package DataStructur;

import DB.DB;
import java.util.Date;

/**
 * this class handels the object Duengung
 * @author TeamChiDaBa
 */
public class Duengung {
Object EreignissID;    
Date datum;
String duenger;
int menge;
    /**
     * fills the object Duengung
     */
    public Duengung(Object EreignissID, Date datum, String duenger, int menge) {
        this.EreignissID = EreignissID;
        this.datum = datum;
        this.duenger = duenger;
        this.menge = menge;
    }
    /**
     * establishes an connection to the Database to save Duengung
     */
    public void saveInDB() throws Exception{
        DB connection =new DB();
        connection.InsertIntoDuengvorgaenge(this);
    } 
    /**
     * get method of EreignissID
     */
    public Object getEreignissID() {
        return EreignissID;
    }
    /**
     * set method of the EreignissID
     */
    public void setEreignissID(Object EreignissID) {
        this.EreignissID = EreignissID;
    }
    /**
     * get method of Datum
     */
    public Date getDatum() {
        return datum;
    }
    /**
     * set method of Datum
     */
    public void setDatum(Date datum) {
        this.datum = datum;
    }
    /**
     * get method of Duenger
     */
    public String getDuenger() {
        return duenger;
    }
    /**
     * set method of Duenger
     */
    public void setDuenger(String duenger) {
        this.duenger = duenger;
    }
    /**
     * get method of menge
     */
    public int getMenge() {
        return menge;
    }
    /**
     * set emthod of menge
     */
    public void setMenge(int menge) {
        this.menge = menge;
    }
    
    
    
 }

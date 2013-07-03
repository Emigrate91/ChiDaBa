package DataStructur;

import DB.DB;
import java.util.Date;

/**
 * this class handels the object Bewaesserung
 * @author Team ChiDaBa
 */
public class Bewaesserung {
Object EreignissID;    
Date datum;
int menge;
    /**
     * fills the object Bewaesserung
     */
    public Bewaesserung(Object EreignissID, Date datum, int menge) {
        this.EreignissID = EreignissID;
        this.datum = datum;
        this.menge = menge;
    }
    /**
     * establishes an connection to the database and saves Bewaesserung
     */
    public void saveInDB() throws Exception{
        DB connection =new DB();
        connection.InsertIntoBewaesserung(this);
    } 
    /**
     * get method of EreignissID
     */
    public Object getEreignissID() {
        return EreignissID;
    }
    /**
     * set method of EreignissID
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
     * set method of datum
     */
    public void setDatum(Date datum) {
        this.datum = datum;
    }
    /**
     * get method of Menge
     */
    public int getMenge() {
        return menge;
    }
    /**
     * set method of Menge
     */
    public void setMenge(int menge) {
        this.menge = menge;
    }
    
    
    
 }

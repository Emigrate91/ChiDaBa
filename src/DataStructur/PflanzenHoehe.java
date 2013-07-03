package DataStructur;

import DB.DB;
import java.util.Date;

/**
 * This class handels the object Pflanzenhoehe
 * @author Team ChiDaBa
 */
public class PflanzenHoehe {
    Object EreignissID;
    Date datum;
    int hoehe;
    /**
     * establishes an connection to the database
     * @throws Exception DB-Exeception if an error in the Databaseconnection is encounterd
     */
    public void saveInDB() throws Exception{
    DB connection =new DB();
    connection.InsertIntoPflanzen_hohe(this);
    }
    /**
     * Fills the object PflanzenHoehe 
     */
    public PflanzenHoehe(Object EreignissID, Date datum, int hoehe) {
        this.EreignissID = EreignissID;
        this.datum = datum;
        this.hoehe = hoehe;
    }
    /**
     * get method for the ID
     * @return  the current ID
     */
    public Object getEreignissID() {
        return EreignissID;
    }
    /**
     * set methot of the ID
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
     * get method of Hoehe
     */
    public int getHoehe() {
        return hoehe;
    }
    /**
     * set method of Hoehe
     */
    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;
    }


    
    
}

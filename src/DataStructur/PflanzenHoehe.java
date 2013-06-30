/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructur;

import DB.DB;
import java.util.Date;

/**
 *
 * @author mn
 */
public class PflanzenHoehe {
    Object EreignissID;
    Date datum;
    int hoehe;
    
    public void saveInDB() throws Exception{
    DB connection =new DB();
    connection.InsertIntoPflanzen_hohe(this);
    }
    
    public PflanzenHoehe(Object EreignissID, Date datum, int hoehe) {
        this.EreignissID = EreignissID;
        this.datum = datum;
        this.hoehe = hoehe;
    }

    public Object getEreignissID() {
        return EreignissID;
    }

    public void setEreignissID(Object EreignissID) {
        this.EreignissID = EreignissID;
    }

    
    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getHoehe() {
        return hoehe;
    }

    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;
    }


    
    
}

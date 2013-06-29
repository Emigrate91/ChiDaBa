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
public class DuengUndWasser {
Date datum;
String duenger;
int menge;

    public DuengUndWasser(Date datum, String duenger, int menge) {
        this.datum = datum;
        this.duenger = duenger;
        this.menge = menge;
    }

    public void saveInDB() throws Exception{
        DB connection =new DB();
        connection.InsertIntoDuengvorgang(this);
    }    
    
    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getDuenger() {
        return duenger;
    }

    public void setDuenger(String duenger) {
        this.duenger = duenger;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    
}

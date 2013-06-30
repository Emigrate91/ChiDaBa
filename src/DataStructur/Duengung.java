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
public class Duengung {
Object EreignissID;    
Date datum;
String duenger;
int menge;

    public Duengung(Object EreignissID, Date datum, String duenger, int menge) {
        this.EreignissID = EreignissID;
        this.datum = datum;
        this.duenger = duenger;
        this.menge = menge;
    }

    public void saveInDB() throws Exception{
        DB connection =new DB();
        connection.InsertIntoDuengvorgaenge(this);
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

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
public class Bewaesserung {
Object PlantID;    
Date datum;
int menge;

    public Bewaesserung(Object PlantID, Date datum, int menge) {
        this.PlantID = PlantID;
        this.datum = datum;
        this.menge = menge;
    }

    public void saveInDB() throws Exception{
        DB connection =new DB();
        connection.InsertIntoBewaesserung(this);
    } 

    public Object getPlantID() {
        return PlantID;
    }

    public void setPlantID(Object PlantID) {
        this.PlantID = PlantID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }
    
    
    
 }

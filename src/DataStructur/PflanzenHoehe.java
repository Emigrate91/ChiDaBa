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
    Object PlantID;
    Date datum;
    int hoehe;
    
    public void saveInDB() throws Exception{
    DB connection =new DB();
    connection.InsertIntoPflanzen_hohe(this);
    }
    
    public PflanzenHoehe(Object PlantID, Date datum, int hoehe) {
        this.PlantID = PlantID;
        this.datum = datum;
        this.hoehe = hoehe;
    }

    public Object getPlantID() {
        return PlantID;
    }

    public void setSorte(String sorte) {
        this.PlantID = sorte;
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

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
    String sorte;
    Date datum;
    int hoehe;
    
    public void saveInDB() throws Exception{
    DB connection =new DB();
    connection.InsertIntoPflanzen_hohe(this);
    }
    
    public PflanzenHoehe(String sorte, Date datum, int hoehe) {
        this.sorte = sorte;
        this.datum = datum;
        this.hoehe = hoehe;
    }

    public String getSorte() {
        return sorte;
    }

    public void setSorte(String sorte) {
        this.sorte = sorte;
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

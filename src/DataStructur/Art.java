/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructur;

import DB.DB;

/**
 *
 * @author mn
 */
public class Art {
    private String art;
    private String herkunft;

    public Art(String art) throws Exception {
        DB con = new DB();
        this.art = art;
        this.herkunft=con.getArtHerkunft(art);
    }    
    
    public Art(String art, String herkunft) {
        this.art = art;
        this.herkunft = herkunft;
    }
    
    public int getHerkunftID() throws Exception{
    DB con = new DB();
    return con.getHerkunftID(herkunft);        
    }
    
    public void saveInDB() throws Exception{
        DB con = new DB();
        con.InsertIntoArt(this, getHerkunftID());
    }
    
    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public String getHerkunft() {
        return herkunft;
    }

    public void setHerkunft(String herkunft) {
        this.herkunft = herkunft;
    }
    
    
    
}

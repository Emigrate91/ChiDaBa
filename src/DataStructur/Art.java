/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructur;

import DB.DB;
import java.util.ArrayList;

/**
 *
 * @author mn
 */
public class Art {
    private String art;
    private String herkunft;
    private Object ID;
    
    public Art(String art, String herkunft) {
        this.art = art;
        this.herkunft = herkunft;
        this.ID=null;
    }

    public Art(Object ID) throws Exception {
        this.ID = ID;
        DB con = new DB();
        ArrayList<String> tmp = con.getArtInfo(ID);
        this.art= tmp.get(0);
        this.herkunft= tmp.get(1);
    }
    

    
    public int getHerkunftID() throws Exception{
    DB con = new DB();
    return con.getHerkunftID(herkunft);        
    }
   
    public int getHerkunft_FK() throws Exception{
    DB con = new DB();
    return con.getHerkunft_FK(this.getArtID());        
    }    
        
    public void saveInDB() throws Exception{
         DB con = new DB();
         if(!con.getList("art", "tbl_art").contains(this.getArt())){
             this.setID(con.InsertIntoArt(this, getHerkunftID()));
         } 
                  
         
         else {
             System.err.println("Sortenname bereits vergeben");
         }    
         
    }

    public void setID(Object ID) {
        this.ID = ID;
    }
    
    
    public int getArtID() throws Exception{
        DB con = new DB();
        if(con.getList("art", "tbl_art").contains(this.getArt())){
        return con.getArtID(this);
        }
        else {
            System.err.println("art nicht vorhanden");
            return -1;
        }     
    }
    
    public String getArt() {
        return art;
    }

    public Object getID() {
        return ID;
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

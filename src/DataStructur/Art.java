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
   
    public int getHerkunft_FK() throws Exception{
    DB con = new DB();
    return con.getHerkunft_FK(this.getArtID());        
    }    
        
    public void saveInDB() throws Exception{
         DB con = new DB();
         if(!con.getList("art", "tbl_art").contains(this.getArt())){
             con.InsertIntoArt(this, getHerkunftID());
         }    
         
         else {
             System.err.println("Sortenname bereits vergeben");
         }    
         
    }
    
    public int getArtID() throws Exception{
        DB con = new DB();
        if(con.getList("art", "tbl_art").contains(this.getArt())){
        return con.getArtID(this,this.getHerkunftID());
        }
        else {
            System.err.println("Sorte nicht vorhanden");
            return -1;
        }     
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

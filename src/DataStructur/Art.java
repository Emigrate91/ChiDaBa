package DataStructur;

import DB.DB;
import java.util.ArrayList;

/**
 * this class handles the object Art
 * @author Team ChiDaBa
 */
public class Art {
    private String art;
    private String herkunft;
    private Object ID;
    /**
     * fills the object Art
     */
    public Art(String art, String herkunft) {
        this.art = art;
        this.herkunft = herkunft;
        this.ID=null;
    }
/**
 * establishes the connection to the database for Art
 */
    public Art(Object ID) throws Exception {
        this.ID = ID;
        DB con = new DB();
        ArrayList<String> tmp = con.getArtInfo(ID);
        this.art= tmp.get(0);
        this.herkunft= tmp.get(1);
    }
    /**
     * get method for ArtID
     */
    public int getExistArtID() throws Exception{
        DB con = new DB();
        int fk= con.getHerkunftID(this.getHerkunft());
        if(!con.getArtList(this.art, fk).isEmpty()){
        return con.getArtID(this);
        }
        else {
            return -1;
        }     
    }
    /**
     * get method of HerkunftID
     */
    public int getHerkunftID() throws Exception{
    DB con = new DB();
    return con.getHerkunftID(herkunft);        
    }
    /**
     * get method for Herkunft_FK
     */   
    public int getHerkunft_FK() throws Exception{
    DB con = new DB();
    return con.getHerkunft_FK(this.getArtID());        
    }    
    /**
     * this method saves Art into the Database
     */       
    public void saveInDB() throws Exception{
         DB con = new DB();
         if(!con.getList("art", "tbl_art").contains(this.getArt())){
             this.setID(con.InsertIntoArt(this, getHerkunftID()));
         } 
                  
         
         else {
             System.err.println("Artenname bereits vergeben");
         }    
         
    }
    /**
     * set method for ID
     */
    public void setID(Object ID) {
        this.ID = ID;
    }
    
    /**
     * get method for the ArtID
     */    
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
    /**
     * get method for Art
     */    
    public String getArt() {
        return art;
    }
    /**
     * get method for ID
     */
    public Object getID() {
        return ID;
    }
    /**
     * set method for Art
     */
    public void setArt(String art) {
        this.art = art;
    }
    /**
     * get method Herkunft
     */
    public String getHerkunft() {
        return herkunft;
    }
    /**
     * set method for Herkunft
     */
    public void setHerkunft(String herkunft) {
        this.herkunft = herkunft;
    }
    
    
    
}

package DataStructur;

import DB.DB;

/**
 * this class handles the object Sorte
 * @author Team ChiDaBa
 */
public class Sorte {
    private String sorte;
    private int reifezeit;
    /**
     * establishes an connection with the Database
     */
    public Sorte(String sorte) throws Exception {
        DB con = new DB();
        this.sorte = sorte;
        this.reifezeit=con.getSorteReifezeit(sorte);
    }  
    /**
     * fills the object Sorte
     */
    public Sorte(String sorte, int reifezeit) {
        this.sorte = sorte;
        this.reifezeit = reifezeit;
    }
    /**
     * get method of SorteID
     */
    public int getSorteID() throws Exception{
        DB con = new DB();
        if(con.getList("sorte", "tbl_sorte").contains(this.getSorte())){
        return con.getSorteID(this);
        }
        else {
            System.err.println("Sorte nicht vorhanden");
            return -1;
        }     
    }
    /**
     * saves the object Sorte 
     */    
    public void saveInDB() throws Exception{
         DB con = new DB();
         if(!con.getList("sorte", "tbl_sorte").contains(this.getSorte())){
             con.InsertIntoSorte(this);
         }    
         
         else {
             System.err.println("Sortenname bereits vergeben");
         }    
         
    }
  
    /**
     * get method of Sorte
     */    
    public String getSorte() {
        return sorte;
    }
    /**
     * set method of Sorte
     */
    public void setSorte(String sorte) {
        this.sorte = sorte;
    }
    /**
     * get method of Reifezeit
     */
    public int getReifezeit() {
        return reifezeit;
    }
    /**
     * set emthod of Reifezeit
     */
    public void setReifezeit(int reifezeit) {
        this.reifezeit = reifezeit;
    }
    
    
    
}

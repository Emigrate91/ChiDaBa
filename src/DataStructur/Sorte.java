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
public class Sorte {
    private String sorte;
    private int reifezeit;

    public Sorte(String sorte) throws Exception {
        DB con = new DB();
        this.sorte = sorte;
        this.reifezeit=con.getSorteReifezeit(sorte);
    }  
    
    public Sorte(String sorte, int reifezeit) {
        this.sorte = sorte;
        this.reifezeit = reifezeit;
    }
    
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
    
    public void saveInDB() throws Exception{
         DB con = new DB();
         if(!con.getList("sorte", "tbl_sorte").contains(this.getSorte())){
             con.InsertIntoSorte(this);
         }    
         
         else {
             System.err.println("Sortenname bereits vergeben");
         }    
         
    }
  
    
    public String getSorte() {
        return sorte;
    }

    public void setSorte(String sorte) {
        this.sorte = sorte;
    }

    public int getReifezeit() {
        return reifezeit;
    }

    public void setReifezeit(int reifezeit) {
        this.reifezeit = reifezeit;
    }
    
    
    
}

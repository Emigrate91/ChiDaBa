/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructur;

/**
 *
 * @author mn
 */
public class Sorte {
    private String sorte;
    private int reifezeit;

    public Sorte(String sorte, int reifezeit) {
        this.sorte = sorte;
        this.reifezeit = reifezeit;
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
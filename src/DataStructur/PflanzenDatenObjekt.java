package DataStructur;

import DB.DB;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class handels the object PflanzenDatenObject
 * @author Team ChiDaBa
 */
public class PflanzenDatenObjekt {
    private Object PlantID;
    private String name;
    private String sorte;
    private String art;
    private String topfgroese;
    private String herkunft;
    private Color farbe;
    private int scoville;
    private int schaerfegrad;
    private int reifezeit_pfl;
    private int reifezeit_sorte;
    private int gesamtzeit;
    private int ertrag_g;
    private int ertrag_stk;
    private String aussaat;
    private String keimung;
    /**
     * fills the object PflanzenDatenObjekt
     */
    public PflanzenDatenObjekt(Object PlantID, String name, String sorte, String art, String topfgroese, String herkunft, Color farbe, int scoville, int schaerfegrad, int reifezeit_pfl, int reifezeit_sorte, int gesamtzeit, int ertrag_g, int ertrag_stk, String aussaat, String keimung) {
        this.PlantID = PlantID;
        this.name = name;
        this.sorte = sorte;
        this.art = art;
        this.topfgroese = topfgroese;
        this.herkunft = herkunft;
        this.farbe = farbe;
        this.scoville = scoville;
        this.schaerfegrad = schaerfegrad;
        this.reifezeit_pfl = reifezeit_pfl;
        this.reifezeit_sorte = reifezeit_sorte;
        this.gesamtzeit = gesamtzeit;
        this.ertrag_g = ertrag_g;
        this.ertrag_stk = ertrag_stk;
        this.aussaat = aussaat;
        this.keimung = keimung;
    }
    /**
     * get method of the PlantID
     * @return the PlantID
     */
    public Object getPlantID() {
        return PlantID;
    }
    /**
     * set method of the PlantID 
     */
    public void setPlantID(Object PlantID) {
        this.PlantID = PlantID;
    }
    /**
     * get method for the Name
     */
    public String getName() {
        return name;
    }
    /**
     * set method for the Name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * get method for the Sorte
     */
    public String getSorte() {
        return sorte;
    }
    /**
     * set method of the Sorte
     */
    public void setSorte(String sorte) {
        this.sorte = sorte;
    }
    /**
     * get method of the Art 
     */
    public String getArt() {
        return art;
    }
    /**
     * set method of the Art
     */
    public void setArt(String art) {
        this.art = art;
    }
    /**
     * get method of the Topfgroesse
     */ 
    public String getTopfgroese() {
        return topfgroese;
    }
    /**
     * set method of the Topfgroesse
     */
    public void setTopfgroese(String topfgroese) {
        this.topfgroese = topfgroese;
    }
    /**
     * get mehtod of the Herkunft
     */
    public String getHerkunft() {
        return herkunft;
    }
    /**
     * set method of the Herkunnft
     */
    public void setHerkunft(String herkunft) {
        this.herkunft = herkunft;
    }
    /**
     * get method of the Farbe
     */
    public Color getFarbe() {
        return farbe;
    }
    /**
     * set method of the Farbe
     */
    public void setFarbe(Color farbe) {
        this.farbe = farbe;
    }
    /**
     * get method of the Scoville
     */
    public int getScoville() {
        return scoville;
    }
    /**
     * set method of Scoville
     */
    public void setScoville(int scoville) {
        this.scoville = scoville;
    }
    /**
     * get method of Schaerfegrad
     */
    public int getSchaerfegrad() {
        return schaerfegrad;
    }
    /**
     * set method of Schaerfegrad
     */
    public void setSchaerfegrad(int schaerfegrad) {
        this.schaerfegrad = schaerfegrad;
    }
    /**
     * get method of Reifezeit_pfl
     */
    public int getReifezeit_pfl() {
        return reifezeit_pfl;
    }
    /**
     * set method of Reifezeit_pfl
     */
    public void setReifezeit_pfl(int reifezeit_pfl) {
        this.reifezeit_pfl = reifezeit_pfl;
    }
    /**
     * get method of Reifezeit_sorte
     */
    public int getReifezeit_sorte() {
        return reifezeit_sorte;
    }
    /**
     * set method of Reifezeit_sorte
     */
    public void setReifezeit_sorte(int reifezeit_sorte) {
        this.reifezeit_sorte = reifezeit_sorte;
    }
    /**
     * get method for Gesammtzeit
     */
    public int getGesamtzeit() {
        return gesamtzeit;
    }
    /**
     * set method for Gesammtzeit
     */
    public void setGesamtzeit(int gesamtzeit) {
        this.gesamtzeit = gesamtzeit;
    }
    /**
     * get method of ertrag_g
     */
    public int getErtrag_g() {
        return ertrag_g;
    }
    /**
     * set method of ertrag_g
     */
    public void setErtrag_g(int ertrag_g) {
        this.ertrag_g = ertrag_g;
    }
    /**
     * get method of Ertrag_stk
     */
    public int getErtrag_stk() {
        return ertrag_stk;
    }
    /**
     * set method of Ertrag_stk
     */
    public void setErtrag_stk(int ertrag_stk) {
        this.ertrag_stk = ertrag_stk;
    }
    /**
     * get method of Aussaat
     */
    public String getAussaat() {
        return aussaat;
    }
    /**
     * set method of Aussaat
     */
    public void setAussaat(String aussaat) {
        this.aussaat = aussaat;
    }
    /**
     * get method of Keimung
     */
    public String getKeimung() {
        return keimung;
    }
    /**
     * set method of Keimung
     */
    public void setKeimung(String keimung) {
        this.keimung = keimung;
    }


}

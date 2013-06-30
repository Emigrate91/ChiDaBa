/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructur;

import DB.DB;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mn
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

    public Object getPlantID() {
        return PlantID;
    }

    public void setPlantID(Object PlantID) {
        this.PlantID = PlantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSorte() {
        return sorte;
    }

    public void setSorte(String sorte) {
        this.sorte = sorte;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public String getTopfgroese() {
        return topfgroese;
    }

    public void setTopfgroese(String topfgroese) {
        this.topfgroese = topfgroese;
    }

    public String getHerkunft() {
        return herkunft;
    }

    public void setHerkunft(String herkunft) {
        this.herkunft = herkunft;
    }

    public Color getFarbe() {
        return farbe;
    }

    public void setFarbe(Color farbe) {
        this.farbe = farbe;
    }

    public int getScoville() {
        return scoville;
    }

    public void setScoville(int scoville) {
        this.scoville = scoville;
    }

    public int getSchaerfegrad() {
        return schaerfegrad;
    }

    public void setSchaerfegrad(int schaerfegrad) {
        this.schaerfegrad = schaerfegrad;
    }

    public int getReifezeit_pfl() {
        return reifezeit_pfl;
    }

    public void setReifezeit_pfl(int reifezeit_pfl) {
        this.reifezeit_pfl = reifezeit_pfl;
    }

    public int getReifezeit_sorte() {
        return reifezeit_sorte;
    }

    public void setReifezeit_sorte(int reifezeit_sorte) {
        this.reifezeit_sorte = reifezeit_sorte;
    }

    public int getGesamtzeit() {
        return gesamtzeit;
    }

    public void setGesamtzeit(int gesamtzeit) {
        this.gesamtzeit = gesamtzeit;
    }

    public int getErtrag_g() {
        return ertrag_g;
    }

    public void setErtrag_g(int ertrag_g) {
        this.ertrag_g = ertrag_g;
    }

    public int getErtrag_stk() {
        return ertrag_stk;
    }

    public void setErtrag_stk(int ertrag_stk) {
        this.ertrag_stk = ertrag_stk;
    }

    public String getAussaat() {
        return aussaat;
    }

    public void setAussaat(String aussaat) {
        this.aussaat = aussaat;
    }

    public String getKeimung() {
        return keimung;
    }

    public void setKeimung(String keimung) {
        this.keimung = keimung;
    }


}

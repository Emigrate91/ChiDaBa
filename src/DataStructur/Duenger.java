/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructur;

/**
 *
 * @author mn
 */
public class Duenger {
String name;
int stickstoff;
int phosphat;
int Kalium;
int magnesium;

    public Duenger(String name, int stickstoff, int phosphat, int Kalium, int magnesium) {
        this.name = name;
        this.stickstoff = stickstoff;
        this.phosphat = phosphat;
        this.Kalium = Kalium;
        this.magnesium = magnesium;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStickstoff() {
        return stickstoff;
    }

    public void setStickstoff(int stickstoff) {
        this.stickstoff = stickstoff;
    }

    public int getPhosphat() {
        return phosphat;
    }

    public void setPhosphat(int phosphat) {
        this.phosphat = phosphat;
    }

    public int getKalium() {
        return Kalium;
    }

    public void setKalium(int Kalium) {
        this.Kalium = Kalium;
    }

    public int getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(int magnesium) {
        this.magnesium = magnesium;
    }




}

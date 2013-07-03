package DataStructur;

/**
 * this clas handels the object Duenger
 * @author Team ChiDaBa
 */
public class Duenger {
String name;
int stickstoff;
int phosphat;
int Kalium;
int magnesium;
    /**
     * fills the object Duenger
     */
    public Duenger(String name, int stickstoff, int phosphat, int Kalium, int magnesium) {
        this.name = name;
        this.stickstoff = stickstoff;
        this.phosphat = phosphat;
        this.Kalium = Kalium;
        this.magnesium = magnesium;
    }
    /**
     * get method of Name
     */
    public String getName() {
        return name;
    }
    /**
     * set emthod of Name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * get method of Stickstoff
     */
    public int getStickstoff() {
        return stickstoff;
    }
    /**
     * set method of Stickstoff
     */
    public void setStickstoff(int stickstoff) {
        this.stickstoff = stickstoff;
    }
    /**
     * get method of Phosphat
     */
    public int getPhosphat() {
        return phosphat;
    }
    /**
     * set Method of Phosphat
     */
    public void setPhosphat(int phosphat) {
        this.phosphat = phosphat;
    }
    /**
     * get method of Kalium
     */
    public int getKalium() {
        return Kalium;
    }
    /**
     * set method of Kalium
     */
    public void setKalium(int Kalium) {
        this.Kalium = Kalium;
    }
    /**
     * get method of Magnesium
     */
    public int getMagnesium() {
        return magnesium;
    }
    /**
     * set method of Magnesium
     */
    public void setMagnesium(int magnesium) {
        this.magnesium = magnesium;
    }




}

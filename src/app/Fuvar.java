package app;

public class Fuvar {
    //Minél nagyobb az ido, annál több az osszeg
    private String rendszam;
    private int idoMp;
    private double osszeg; //Euro
    private String fizetesiMod;

    public Fuvar(String rendszam, int idoMp, double osszeg, String fizetesiMod) {
        this.rendszam = rendszam;
        this.idoMp = idoMp;
        this.osszeg = osszeg;
        this.fizetesiMod = fizetesiMod;
    }

    public String getRendszam() {
        return rendszam;
    }

    public int getIdoMp() {
        return idoMp;
    }

    public double getOsszeg() {
        return osszeg;
    }

    public String getFizetesiMod() {
        return fizetesiMod;
    }
    
}//class

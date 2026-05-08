package app;

public class Fuvar {
    private String rendszam;
    private int idoMp;
    private int osszeg;
    private String fizetesiMod;

    public Fuvar(String rendszam, int idoMp, int osszeg, String fizetesiMod) {
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

    public int getOsszeg() {
        return osszeg;
    }

    public String getFizetesiMod() {
        return fizetesiMod;
    }
    
}//class

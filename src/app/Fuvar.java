package app;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.rendszam);
        hash = 37 * hash + this.idoMp;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.osszeg) ^ (Double.doubleToLongBits(this.osszeg) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.fizetesiMod);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fuvar other = (Fuvar) obj;
        if (this.idoMp != other.idoMp) {
            return false;
        }
        if (Double.doubleToLongBits(this.osszeg) != Double.doubleToLongBits(other.osszeg)) {
            return false;
        }
        if (!Objects.equals(this.rendszam, other.rendszam)) {
            return false;
        }
        return Objects.equals(this.fizetesiMod, other.fizetesiMod);
    }

    @Override
    public String toString() {
        return "Fuvar{" + "rendszam=" + rendszam + ", idoMp=" + idoMp + ", osszeg=" + osszeg + ", fizetesiMod=" + fizetesiMod + '}';
    }

}//class

package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FajlBeolvas {

    static List<Fuvar> fuvarok = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Path path = Path.of("fuvarok.csv");

        List<String> sorok = Files.readAllLines(path);

        for (String sor : sorok) {
            //System.out.println("sor: " + sor);
            String s[] = sor.split(";");
            String rendszam = s[0];
            int idoMp = Integer.parseInt(s[1]);
            double osszeg = Double.parseDouble(s[2]);
            String fizetesiMod = s[3];
            Fuvar fuvar = new Fuvar(rendszam, idoMp, osszeg, fizetesiMod);
            fuvarok.add(fuvar);
        }
        OsszesFuvarOsszeg();
        LegdragabbFuvarRendszama();
        
        System.out.println("3. Legolcsóbb fuvar forintba: ");
        
        int darab = 0;
        for (int i = 0; i < fuvarok.size(); i++) {
            if () {
                
            }
            
        }
        System.out.println("4. Hány kártyás fizetés volt: ");
        
        
    }//main

    private static void LegdragabbFuvarRendszama() {
        int akt = 0;
        for (int i = 0; i < fuvarok.size(); i++) {
            if (fuvarok.get(akt).getOsszeg() < fuvarok.get(i).getOsszeg()) {
                akt = i;
            }
        }
        System.out.println("2. Legdrágább fuvar rendszáma: " + fuvarok.get(akt).getRendszam());
    }

    private static void OsszesFuvarOsszeg() {
        int osszeg = 0;
        for (int i = 0; i < fuvarok.size(); i++) {
            osszeg += fuvarok.get(i).getOsszeg();
        }
        System.out.println("1. Összed fuvar értéke: " + osszeg);
    }

}//class

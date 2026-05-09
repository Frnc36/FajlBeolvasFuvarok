package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FajlBeolvas {

    /*
        System.out.println("8. Melyik autó mennyi fuvart teljesített: ");
     */
    static List<Fuvar> fuvarok = new ArrayList<>();
    static Set<String> autokHalmaz = new HashSet<>();
    static Set<String> fizetesHalmaz = new HashSet<>();

    public static void main(String[] args) throws IOException {
        final int TOHUF = 354; //2026.05.08

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

        /* 1.feladat */
        OsszesFuvarOsszeg();

        /* 2.feladat */
        LegdragabbFuvarRendszama();

        /* 3.feladat */
        LegolcsobbFuvarForintba(TOHUF);

        /* 4.feladat */
        HanyKartyasFizetesVolt();

        /* 5.feladat */
        MindenFizetesiModMeghatarozott();

        /* 6.feladat */
        HanyDarabAutoVanARendszerben();

        HanyfeleFizetesiModVan();

    }//main

    private static void HanyfeleFizetesiModVan() {
        for (Fuvar f : fuvarok) {
            if (!f.getFizetesiMod().equals("-")) {
                fizetesHalmaz.add(f.getFizetesiMod());
            }
        }
        int fizetesekSzama = fizetesHalmaz.size();
        System.out.println("7. Hányféle fizetési mód van: " + fizetesekSzama);
    }

    private static void HanyDarabAutoVanARendszerben() {
        for (Fuvar f : fuvarok) {
            autokHalmaz.add(f.getRendszam());
        }
        int autokSzama = autokHalmaz.size();
        System.out.println("6. Hány darab autó van a rendszerben: " + autokSzama);
    }

    private static void MindenFizetesiModMeghatarozott() {
        final int N = fuvarok.size();
        int i = 0;
        while (i < N && FizetesMod(fuvarok.get(i).getFizetesiMod())) {
            i++;
        }
        String valasz = i >= N ? "igen" : "nem";
        System.out.println("5. Minden fizetési mód meghatározott: " + valasz);
    }

    private static boolean FizetesMod(String fizetesiMod) {
        if (fizetesiMod.equals("-")) {
            return false;
        } else {
            return true;
        }
    }

    private static void HanyKartyasFizetesVolt() {
        int db = 0;
        for (int i = 0; i < fuvarok.size(); i++) {
            if (fuvarok.get(i).getFizetesiMod().equals("kártya")) {
                db++;
            }
        }
        System.out.println("4. Hány kártyás fizetés volt: " + db + " darab");
    }

    private static void LegolcsobbFuvarForintba(int TOHUF) {
        int akt = 0;
        for (int i = 1; i < fuvarok.size(); i++) {
            if (fuvarok.get(i).getOsszeg() < fuvarok.get(akt).getOsszeg()) {
                akt = i;
            }
        }
        System.out.println("3. Legolcsóbb fuvar forintba: " + (int) fuvarok.get(akt).getOsszeg() * TOHUF + " FT");
    }

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
        System.out.println("1. Összes fuvar értéke: " + osszeg);
    }

}//class

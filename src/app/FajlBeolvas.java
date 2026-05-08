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
            int osszeg = Integer.parseInt(s[2]);
            String fizetesiMod = s[3];
            Fuvar fuvar = new Fuvar(rendszam, idoMp, osszeg, fizetesiMod);
            fuvarok.add(fuvar);
        }

    }//main

}//class

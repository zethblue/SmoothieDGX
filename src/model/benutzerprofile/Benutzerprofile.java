package model.benutzerprofile;

import model.smoothie.vorlagen.Vorlagen;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Benutzerprofile {
    File file1;
    FileReader f1;
    FileWriter fr1;
    BufferedReader b1;

    private String name;
    private double kaloriengesamt;
    private double zuckergesamt;
    private double vitaminegesamt;
    private List<Vorlagen.SMVorlagen> lieblingssmoothies;


    public Benutzerprofile(String name){
        this.name = name;
        aktualisiereSFile();
        leseWFileaus();
    }

    public void kalorienhinzufuegen(double pKalorien) {
        kaloriengesamt += pKalorien;
    }

    public void zuckerhinzufuegen(double pZucker) {
        zuckergesamt += pZucker;
    }

    public void vitaminehinzufuegen(double pVitamine) {
        vitaminegesamt += pVitamine;
    }

    public double getKaloriengesamt() {
        return kaloriengesamt;
    }

    public double getZuckergesamt() {
        return zuckergesamt;
    }

    public double getVitaminegesamt() {
        return vitaminegesamt;
    }

    public List<Vorlagen.SMVorlagen> getLieblingssmoothies() {
        return lieblingssmoothies;
    }

    public void aktualisiereSFile(){
        if(!name.equals("gast")) {
            try {
                lieblingssmoothies = new ArrayList<>();
                file1 = new File("data/" + name + "S");
                f1 = new FileReader(file1);
                b1 = new BufferedReader(f1);
                String s = b1.readLine();
                String[] x = s.split("¿");
                for (String w : x) {
                    lieblingssmoothies.add(Vorlagen.SMVorlagen.valueOf(w));
                }

            } catch (FileNotFoundException e) {
                System.out.println("LOG:BENUTZERPROFILE/KONSTRUKTOR File not found");
            } catch (IOException e) {
                System.out.println("LOG:BENUTZERPROFILE/KONSTRUKTOR:File not readable");
            }

        }
    }

    public void leseWFileaus(){
        if(!name.equals("gast")){
            try {
            file1 = new File("data/" + name +"W");
                f1 = new FileReader(file1);
                b1 = new BufferedReader(f1);
                String s = b1.readLine();
                String[] x = s.split("¿");
                kaloriengesamt = Double.parseDouble(x[0]);
                zuckergesamt = Double.parseDouble(x[1]);
                vitaminegesamt = Double.parseDouble(x[2]);
            } catch (FileNotFoundException e) {
                System.out.println("LOG:BENUTZERPROFILE:leseWFileaus: File not found");
            } catch (IOException e) {
                System.out.println("LOG:BENUTZERPROFILE:leseWFileaus:readLine");
            }

        }

    }

    public void aktualisiereWFile() {
        if (!name.equals("gast")) {
            try {
                file1 = new File("data/" + name + "W");
                fr1 = new FileWriter(file1, false);
                fr1.write(kaloriengesamt + "¿" + zuckergesamt + "¿" + vitaminegesamt);
                fr1.flush();
                fr1.close();

            } catch (IOException e) {
                System.out.println("LOG:BENUTZERPROFILE:aktualisiereWFile:FileWriter1");
            }


        }
    }


    @Override
    public String toString() {
        return name;
    }
}

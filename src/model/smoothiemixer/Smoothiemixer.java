package model.smoothiemixer;

import model.smoothie.Smoothie;
import model.smoothie.vorlagen.Vorlagen;
import model.zutaten.Zutat;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Smoothiemixer {
    private ArrayList<Zutat> zutaten;

    public Smoothiemixer(){
        zutaten = new ArrayList<>();
    }
    public void fuegeZutateninMixer(Zutat ... varM){
        for(Zutat pZutat : varM){
            zutaten.add(pZutat);
        }
    }
    public void entferneZutateninMixer(Zutat ... varM){
        ArrayList<Zutat> pZutaten = new ArrayList<Zutat>();
        for(Zutat pZutat : varM) {
            List xZutaten = zutaten.stream().filter(zutat -> !pZutat.getName().equals(zutat.getName())).collect(Collectors.toList());
            pZutaten.addAll(xZutaten);
        }
        zutaten = pZutaten;
    } //entfernt die Zutaten die man mitgibt im Mixer
    public void entferneZutateninMixer(){
        zutaten = new ArrayList<Zutat>();

    } //entfernt ALLE Zutaten im Mixer
    public Smoothie mixeCustomSmoothie(){
        Smoothie pSmoothie = new Smoothie();
        for(Zutat pZutat : zutaten){
            pSmoothie.fuegeZutathinzu(pZutat);
        }
        return pSmoothie;
    }
    public Smoothie mixeVorlagenSmoothie(Vorlagen.SMVorlagen x){

        List<Smoothie> Abgleich = new Vorlagen().getSmoothieVorlagen().stream().filter(smoothie -> smoothie.getSmoothieName() == x).collect(Collectors.toList());

        /*INNER ANONYM STREAM */
        /*  List<Smoothie> Abgleich = new Vorlagen().getSmoothieVorlagen().stream().filter(new Predicate<Smoothie>() {
            @Override
            public boolean test(Smoothie smoothie) {
                return smoothie.getSmoothieName() == x;
            }c
        }).collect(Collectors.toList());*/;
        try{
        writelog(Abgleich.get(0));}catch (Exception E){}
        return Abgleich.get(0);
    };
    public String erstelleCustomZutatinMixer(String pname, double pKalorien, double pVitaminC, double pZucker){
        zutaten.add(new Zutat(pname,pKalorien,pVitaminC,pZucker) {});
        return "Benutzerdefinierte Zutat " + pname + "hinzugefügt";
    } //wenn der Apfel und die Kiwi nicht reicht ... für Console
    private void writelog(Smoothie pSmoothie) throws IOException {
        FileWriter smoothielog = new FileWriter("smoothielog.txt",true);
        smoothielog.write(pSmoothie.toString() +"\n");
        smoothielog.flush();
        smoothielog.close();
    } //METHODE in mixeVorlagenSmoothie enthalten
    public Smoothie SmoothieMengeAnpassen(Smoothie pSmoothie, int pMenge){
        pSmoothie.setMengenModifikator((double)pMenge/(pSmoothie.getInhalt().size()*100));
        return pSmoothie ;
    }
    public ArrayList<Zutat> getZutaten() {
        return zutaten;
    }
    public static int ausgabeFarbe(Smoothie pSmoothie){
        int greenVariable = 0;
        int redVariable = 0;
        int miscVariable = 0;

        for(Zutat z : pSmoothie.getInhalt()){

            switch (z.getName()){
                case "Apfel": miscVariable++;break;
                case "Banane": miscVariable++;redVariable--;break;
                case "Birne" : greenVariable++;break;
                case "Erdbeere" : redVariable++;break;
                case "Karotte" : redVariable++; break;
                case "Kiwi" : greenVariable++; break;
                case "Kohlrabi" : miscVariable++; break;
                case "Melone" : redVariable++; greenVariable--;break;
                case "Pfirsich" : miscVariable++;break;
                case "Spinat" : greenVariable++; redVariable--;break;
                case "Weintrauben": miscVariable++;break;
                default : miscVariable++;break;
            }

        }
        if(greenVariable > (redVariable+miscVariable)) return 0;
        else if(redVariable > (greenVariable+miscVariable))return 1;
        else return 2;
    } //retourniert 0,1 oder 2, je nachdem ob mehr ROT, mehr GRÜN oder ungewiss im Smoothie vorhanden. 0 = grün dominiert, 1 = rot dominiert, 2 = ungewiss
}

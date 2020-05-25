package model.smoothie.vorlagen;

import model.smoothie.Smoothie;
import model.zutaten.Zutat;
import model.zutaten.apfel.Apfel;
import model.zutaten.banane.Banane;
import model.zutaten.kiwi.Kiwi;
import model.zutaten.spinat.Spinat;

import java.util.Arrays;
import java.util.List;

public class Vorlagen {

    private List<Smoothie> smoothieVorlagen;

    public Vorlagen(){
        smoothieVorlagen = Arrays.asList(
                new Smoothie(SMVorlagen.APPLESHAKE,new Apfel(), new Apfel(), new Apfel()),
                new Smoothie(SMVorlagen.BANANAMAMA, new Banane(), new Banane(), new Banane()),
                new Smoothie(SMVorlagen.BANAPPLESHOT, new Apfel(), new Apfel(), new Banane(), new Banane()),
                new Smoothie(SMVorlagen.POPEYE, new Spinat(), new Banane()),
                new Smoothie(SMVorlagen.KIWILOVE, new Kiwi(), new Kiwi(), new Kiwi(), new Apfel()),
                new Smoothie(SMVorlagen.GREENDAY, new Kiwi(), new Spinat()),
                new Smoothie(SMVorlagen.MEGAMIX, new Banane(), new Kiwi(), new Spinat()),
                new Smoothie(SMVorlagen.HAWAII, new Zutat("Ananas",28,4,17){}, new Kiwi())
        );
    }

    public enum SMVorlagen{
        APPLESHAKE, BANANAMAMA, BANAPPLESHOT, POPEYE, KIWILOVE, GREENDAY, MEGAMIX, HAWAII, CUSTOM
    }

    public List<Smoothie> getSmoothieVorlagen() {
        return smoothieVorlagen;
    }
}

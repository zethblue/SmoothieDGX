package model.smoothie;

import model.smoothie.vorlagen.Vorlagen;
import model.zutaten.Zutat;
import java.util.ArrayList;
import java.util.Arrays;

public class Smoothie {

    private ArrayList<Zutat> inhalt = new ArrayList<>();
    private Vorlagen.SMVorlagen smoothieName;
    private double mengenModifikator = 1.0;


    /* ----------KONSTRUKTOR für VORLAGEN Smoothies --------- */
    public Smoothie(Vorlagen.SMVorlagen pSmoothiename, Zutat...varZ) {
        this.smoothieName = pSmoothiename;
        inhalt.addAll(Arrays.asList(varZ));
    }
    /* ----------KONSTRUKTOR für EIGENE Smoothies --------- */
    public Smoothie(Zutat...varZ) {
        this.smoothieName = Vorlagen.SMVorlagen.CUSTOM;
        inhalt.addAll(Arrays.asList(varZ));
    }

    @Override
    public String toString() {
        String pStringKalorien = "Kalorien: " + this.getSmoothieKalorien();
        String pStringVitaminC = "VitaminC: " + this.getSmoothieVitaminC();
        String pStringZucker = "Zucker: " + this.getSmoothieZucker();
        return "" + smoothieName + "\n" + pStringKalorien + "\n" + pStringVitaminC + "\n" + pStringZucker + "\n";
    }

    /* ---------- METHODEN IN toString ENTHALTEN ------------*/
    public double getSmoothieKalorien() {
        double pKalorien = 0.0;
        for (Zutat pZutat : inhalt) {
            pKalorien += pZutat.getKalorien();
        }
        pKalorien *= mengenModifikator;
        pKalorien = Math.round(100.0*pKalorien)/100.0;
        return pKalorien;
    }
    public double getSmoothieVitaminC() {
        double pVitaminC = 0.0;
        for (Zutat pZutat : inhalt) {
            pVitaminC += pZutat.getVitaminC();
        }
        pVitaminC *= mengenModifikator;
        pVitaminC = Math.round(100.0*pVitaminC)/100.0;

        return pVitaminC;
    }
    public double getSmoothieZucker() {
        double pZucker = 0.0;
        for (Zutat pZutat : inhalt) {
            pZucker += pZutat.getZucker();
        }
        pZucker *= mengenModifikator;
        pZucker = Math.round(100.0*pZucker)/100.0;
        return pZucker;
    }
    /*-------------------------------------------------------*/

    public Vorlagen.SMVorlagen getSmoothieName() {
        return smoothieName;
    }
    public void fuegeZutathinzu(Zutat pZutat){
        inhalt.add(pZutat);
    }
    public ArrayList<Zutat> getInhalt() {
        return inhalt;
    }
    public void setMengenModifikator(double mengenModifikator) {
        this.mengenModifikator = mengenModifikator;
    }
}

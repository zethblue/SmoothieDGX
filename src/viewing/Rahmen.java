package viewing;

import model.benutzerprofile.Benutzerprofile;
import model.smoothie.Smoothie;
import model.smoothie.vorlagen.Vorlagen;
import model.smoothiemixer.Smoothiemixer;
import model.zutaten.Zutat;
import model.zutaten.apfel.Apfel;
import model.zutaten.banane.Banane;
import model.zutaten.birne.Birne;
import model.zutaten.erdbeere.Erdbeere;
import model.zutaten.karotte.Karotte;
import model.zutaten.kiwi.Kiwi;
import model.zutaten.kohlrabi.Kohlrabi;
import model.zutaten.melone.Melone;
import model.zutaten.pfirsich.Pfirsich;
import model.zutaten.spinat.Spinat;
import model.zutaten.weintrauben.Weintrauben;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class Rahmen extends JFrame {

    private FileWriter f1;
    private File file1;
    private Benutzerprofile user;
    private Smoothiemixer smoothiemixer = new Smoothiemixer();
    private JButton p2a1glueckSpiel = new JButton("Random");
    private JButton p3Apfel = new JButton("Apfel");
    private JButton p3Banane = new JButton("Banane");
    private JButton p3Kiwi = new JButton("Kiwi");
    private JButton p3Spinat = new JButton("Spinat");
    private JButton p3Birne = new JButton("Birne");
    private JButton p3Erdbeere = new JButton("Erdbeere");
    private JButton p3Karotte = new JButton("Karotte");
    private JButton p3Kohlrabi = new JButton("Kohlrabi");
    private JButton p3Melone = new JButton("Melone");
    private JButton p3Pfirsich = new JButton("Pfirsich");
    private JButton p3Weintrauben = new JButton("Weintrauben");
    private JButton p3erstelleCustomZutat = new JButton("erstelle Zutat");
    private JButton p3hinzuCustomZutat = new JButton("Eigene hinzufügen");
    private JButton p4Mixen = new JButton("Mixen 100ml pro Zutat");
    private JButton p4MixenKlein = new JButton("Mixen 250ml");
    private JButton p4MixenGross = new JButton("Mixen 400ml");
    private JButton p4MixenCustom = new JButton("Größe bestimmen");
    private JButton p4Entfernen = new JButton("Zutat entfernen");
    private JButton p4Exit = new JButton("Beenden");
    private JButton p4logFile = new JButton("Statistics");
    private JLabel p1a2Text = new JLabel("",SwingConstants.CENTER);
    private JLabel p1L1;

    public Rahmen(Benutzerprofile pBenutzer){

        user = pBenutzer;
        if(user.toString().equals("gast")){p4logFile.setEnabled(false);}

        try {
            BufferedImage i1 = ImageIO.read(new File("src/resources/Smoothiemixer.png"));
            p1L1 = new JLabel(new ImageIcon(i1));
        }catch (Exception e){
            System.out.println(e);
            p1L1 = new JLabel("<html><h1>Smoothiemixer</h1></html>",SwingConstants.CENTER);}
        JButton p2a1B1 = new JButton("Vorlage");
        JButton p2a1B2 = new JButton("Custom");
        JComboBox p2a2C1;
        JButton p2a2B1 = new JButton("OK");

        p2a2C1 = new JComboBox(Vorlagen.SMVorlagen.values());
        p2a2C1.setVisible(false);
        p2a2B1.setVisible(false);;
        this.p3ZutatenDisappear();

        JPanel p1 = new JPanel();
        JPanel p1a1 = new JPanel();
        JPanel p1a2 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p2a1 = new JPanel();
        JPanel p2a2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();

        /*p2a1-Fake Labels*/
        JLabel p2a1fake1 = new JLabel("");
        JLabel p2a1fake2 = new JLabel("");
        JLabel p2a1fake3 = new JLabel("");
        JLabel p2a1fake4 = new JLabel("");
        JLabel p2a1fake5 = new JLabel("");
        JLabel p2a1fake6 = new JLabel("");
        JLabel p2a1fake7 = new JLabel("");
        JLabel p2a1fake8 = new JLabel("");
        JLabel p2a1fake9 = new JLabel("");
        JLabel p2a1fake10 = new JLabel("");
        JLabel p2a1fake11 = new JLabel("");
        JLabel p2a1fake13 = new JLabel("");
        /*p2a1-Fake Labels END */

        /*p2a2-FAKE LABELS*/
        JLabel p2a2fake1 = new JLabel("");
        JLabel p2a2fake2 = new JLabel("");
        JLabel p2a2fake3 = new JLabel("",SwingConstants.CENTER);
        JLabel p2a2fake4 = new JLabel("");
        JLabel p2a2fake5 = new JLabel("");
        JLabel p2a2fake6 = new JLabel("");
        JLabel p2a2fake7 = new JLabel("");
        /*p2a2-FAKE LABELS END */

        p1.setLayout(new GridLayout(2,1));
        p1.add(p1a1);p1.add(p1a2);
        p1a1.setLayout(new GridLayout(1,1));
        p1a1.add(p1L1);
        p1a2.setLayout(new GridLayout(1,1));
        p1a2.add(p1a2Text);

        p2.setLayout(new GridLayout(2,1));
        p2.add(p2a1);p2.add(p2a2);

        p2a1.setLayout(new GridLayout(3,5));
        p2a1.add(p2a1fake1);p2a1.add(p2a1fake2);p2a1.add(p2a1fake3);p2a1.add(p2a1fake4);p2a1.add(p2a1fake5);
        p2a1.add(p2a1fake6);p2a1.add(p2a1B1);p2a1.add(p2a1fake7);p2a1.add(p2a1B2);p2a1.add(p2a1fake8);
        p2a1.add(p2a1fake9);p2a1.add(p2a1fake10);p2a1.add(p2a1fake11);p2a1.add(p2a1glueckSpiel);p2a1.add(p2a1fake13);

        p2a2.setLayout(new GridLayout(3,3));
        p2a2.add(p2a2fake1);p2a2.add(p2a2fake3);p2a2.add(p2a2fake2);
        p2a2.add(p2a2fake4);p2a2.add(p2a2C1);p2a2.add(p2a2fake5);
        p2a2.add(p2a2fake6);p2a2.add(p2a2B1);p2a2.add(p2a2fake7);

        p3.setLayout(new GridLayout(4,3));
        p3.add(p3Apfel);p3.add(p3Banane);p3.add(p3Birne);p3.add(p3Erdbeere);
        p3.add(p3Karotte);p3.add(p3Kiwi);p3.add(p3Kohlrabi);p3.add(p3Melone);
        p3.add(p3Pfirsich);p3.add(p3Spinat);p3.add(p3Weintrauben);
        JPanel p3Customa1 = new JPanel();
        p3.add(p3Customa1);
        p3Customa1.setLayout(new GridLayout(2,1));
        p3Customa1.add(p3erstelleCustomZutat);p3Customa1.add(p3hinzuCustomZutat);
        p4.setLayout(new GridLayout(2,2));
        JPanel p4Mixpanel = new JPanel(new GridLayout(2,2));
        p4Mixpanel.add(p4MixenKlein);p4Mixpanel.add(p4MixenGross);p4Mixpanel.add(p4Mixen);p4Mixpanel.add(p4MixenCustom);
        p4.add(p4Mixpanel); p4.add(p4Entfernen); p4.add(p4logFile); p4.add(p4Exit);

        this.setLayout(new GridLayout(4,1));
        this.add(p1);this.add(p2);this.add(p3);this.add(p4);
        this.setSize(600,1000);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Benutzer: "+user.toString());
        this.setVisible(true);

        p2a1B1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p2a2C1.setVisible(true);
                p2a2B1.setVisible(true);
                p3ZutatenDisappear();
                smoothiemixer.entferneZutateninMixer();
                aktualisiereAnzeige();
            }
        });
        p2a1B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p2a2C1.setVisible(false);
                p2a2B1.setVisible(false);
                p3Zutatenappear();
                aktualisiereAnzeige();
            }
        });
        p2a2B1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(p2a2C1.getSelectedItem().equals(Vorlagen.SMVorlagen.CUSTOM))){
                    Smoothie pSmoothie = smoothiemixer.mixeVorlagenSmoothie((Vorlagen.SMVorlagen) p2a2C1.getSelectedItem());
                    user.leseWFileaus();
                    user.vitaminehinzufuegen(pSmoothie.getSmoothieVitaminC());
                    user.kalorienhinzufuegen(pSmoothie.getSmoothieKalorien());
                    user.zuckerhinzufuegen(pSmoothie.getSmoothieZucker());
                    user.aktualisiereWFile();
                    if(!user.toString().equals("gast")) {
                        try {
                            file1 = new File("data/" + user.toString() + "S");
                            f1 = new FileWriter(file1, true);
                            f1.write(p2a2C1.getSelectedItem() + "¿");
                            f1.flush();
                            f1.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    new AusgabeRahmen(pSmoothie);
                }else{p1a2Text.setText("für eigene Smoothies bitte den Custom Knopf drücken");}
            }
        });
        p3Apfel.addActionListener(e -> {
            smoothiemixer.fuegeZutateninMixer(new Apfel());
            aktualisiereAnzeige();
        });
        p3Banane.addActionListener(e -> {
            smoothiemixer.fuegeZutateninMixer(new Banane());
            aktualisiereAnzeige();
        });
        p3Birne.addActionListener(e -> {
            smoothiemixer.fuegeZutateninMixer(new Birne());
            aktualisiereAnzeige();
        });
        p3Erdbeere.addActionListener(e -> {
            smoothiemixer.fuegeZutateninMixer(new Erdbeere());
            aktualisiereAnzeige();
        });
        p3Karotte.addActionListener(e -> {
            smoothiemixer.fuegeZutateninMixer(new Karotte());
            aktualisiereAnzeige();
        });
        p3Kiwi.addActionListener(e -> {
            smoothiemixer.fuegeZutateninMixer(new Kiwi());
            aktualisiereAnzeige();
        });
        p3Kohlrabi.addActionListener(e -> {
            smoothiemixer.fuegeZutateninMixer(new Kohlrabi());
            aktualisiereAnzeige();
        });
        p3Melone.addActionListener(e -> {
            smoothiemixer.fuegeZutateninMixer(new Melone());
            aktualisiereAnzeige();
        });
        p3Pfirsich.addActionListener(e -> {
            smoothiemixer.fuegeZutateninMixer(new Pfirsich());
            aktualisiereAnzeige();
        });
        p3Spinat.addActionListener(e -> {
            smoothiemixer.fuegeZutateninMixer(new Spinat());
            aktualisiereAnzeige();
        });
        p3Weintrauben.addActionListener(e -> {
            smoothiemixer.fuegeZutateninMixer(new Weintrauben());
            aktualisiereAnzeige();
        });
        p3erstelleCustomZutat.addActionListener(e -> {
            new CustomZutatRahmen();
        });
        p3hinzuCustomZutat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(Uebergabe.UebergabeZutat.getName().equals("EMPTY"))) {
                    Zutat u = new Zutat(Uebergabe.UebergabeZutat.getName(),Uebergabe.UebergabeZutat.getKalorien(),Uebergabe.UebergabeZutat.getVitaminC(),Uebergabe.UebergabeZutat.getZucker()) {};
                    smoothiemixer.fuegeZutateninMixer(u);
                    aktualisiereAnzeige();
                }
            }
        });
        p4Mixen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Smoothie pSmoothie = smoothiemixer.mixeCustomSmoothie();
                //Profil-Aktualisierung
                user.leseWFileaus();
                user.zuckerhinzufuegen(pSmoothie.getSmoothieZucker());
                user.kalorienhinzufuegen(pSmoothie.getSmoothieKalorien());
                user.vitaminehinzufuegen(pSmoothie.getSmoothieVitaminC());
                user.aktualisiereWFile();
                //Profil Aktualisierung Ende

                smoothiemixer.entferneZutateninMixer();
                aktualisiereAnzeige();
                if (!user.toString().equals("gast")) {
                    try {
                        file1 = new File("data/" + user.toString() + "S");
                        f1 = new FileWriter(file1, true);
                        f1.write(Vorlagen.SMVorlagen.CUSTOM + "¿");
                        f1.flush();
                        f1.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

                new AusgabeRahmen(pSmoothie);

            }
        });
        p4MixenKlein.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Smoothie pSmoothie = smoothiemixer.mixeCustomSmoothie();
                pSmoothie.setMengenModifikator(2.5/pSmoothie.getInhalt().size());
                //Profil-Aktualisierung
                user.leseWFileaus();
                user.zuckerhinzufuegen(pSmoothie.getSmoothieZucker());
                user.kalorienhinzufuegen(pSmoothie.getSmoothieKalorien());
                user.vitaminehinzufuegen(pSmoothie.getSmoothieVitaminC());
                user.aktualisiereWFile();
                //Profil Aktualisierung Ende

                smoothiemixer.entferneZutateninMixer();
                aktualisiereAnzeige();
                if (!user.toString().equals("gast")) {
                    try {
                        file1 = new File("data/" + user.toString() + "S");
                        f1 = new FileWriter(file1, true);
                        f1.write(Vorlagen.SMVorlagen.CUSTOM + "¿");
                        f1.flush();
                        f1.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

                new AusgabeRahmen(pSmoothie);

            }
        });
        p4MixenGross.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Smoothie pSmoothie = smoothiemixer.mixeCustomSmoothie();
                pSmoothie.setMengenModifikator(4.0/pSmoothie.getInhalt().size());
                //Profil-Aktualisierung
                user.leseWFileaus();
                user.zuckerhinzufuegen(pSmoothie.getSmoothieZucker());
                user.kalorienhinzufuegen(pSmoothie.getSmoothieKalorien());
                user.vitaminehinzufuegen(pSmoothie.getSmoothieVitaminC());
                user.aktualisiereWFile();
                //Profil Aktualisierung Ende

                smoothiemixer.entferneZutateninMixer();
                aktualisiereAnzeige();
                if (!user.toString().equals("gast")) {
                    try {
                        file1 = new File("data/" + user.toString() + "S");
                        f1 = new FileWriter(file1, true);
                        f1.write(Vorlagen.SMVorlagen.CUSTOM + "¿");
                        f1.flush();
                        f1.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

                new AusgabeRahmen(pSmoothie);

            }
        });
        p4MixenCustom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Smoothie pSmoothie = smoothiemixer.mixeCustomSmoothie();
                new CustomGroesseRahmen(pSmoothie, user);
                smoothiemixer.entferneZutateninMixer();
                aktualisiereAnzeige();

            }
        });
        p4Entfernen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(smoothiemixer.getZutaten().isEmpty())){
                    ArrayList<Zutat> pZutaten = smoothiemixer.getZutaten();
                    int pSize = smoothiemixer.getZutaten().size() -1;
                    Zutat delthis = pZutaten.get(pSize);
                    smoothiemixer.entferneZutateninMixer(delthis);
                    aktualisiereAnzeige();

                }else{p1a2Text.setText("Löschen nicht möglich");}

            }
        });
        p4logFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.aktualisiereSFile();
                new LogRahmen(user);
            }
        });
        p4Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        p2a2C1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(p2a2C1.getSelectedItem().equals(Vorlagen.SMVorlagen.CUSTOM))) {
                    Vorlagen.SMVorlagen pVorlage = (Vorlagen.SMVorlagen) p2a2C1.getSelectedItem();
                    ArrayList<Zutat> pArrayL = smoothiemixer.mixeVorlagenSmoothie(pVorlage).getInhalt();
                    String anzeige = "";
                    for (Zutat z : pArrayL) {
                        if(z == pArrayL.get(pArrayL.size()-1)){
                        anzeige = anzeige + z.getName();}
                        else{anzeige = anzeige + z.getName() + " , ";}
                    }
                    p1a2Text.setText(anzeige);
                }else{p1a2Text.setText("");}
            }
        });
        p2a1glueckSpiel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   new CustomRahmenBandit();
            }
        });


    }
    private void p3ZutatenDisappear(){
        p3Apfel.setVisible(false);
        p3Banane.setVisible(false);
        p3Birne.setVisible(false);
        p3Erdbeere.setVisible(false);
        p3Karotte.setVisible(false);
        p3Kiwi.setVisible(false);
        p3Kohlrabi.setVisible(false);
        p3Melone.setVisible(false);
        p3Pfirsich.setVisible(false);
        p3Spinat.setVisible(false);
        p3Weintrauben.setVisible(false);
        p3erstelleCustomZutat.setVisible(false);
        p3hinzuCustomZutat.setVisible(false);
        p4Mixen.setVisible(false);
        p4MixenCustom.setVisible(false);
        p4MixenKlein.setVisible(false);
        p4MixenGross.setVisible(false);
        p4Entfernen.setVisible(false);
        p2a1glueckSpiel.setVisible(false);
    }
    private void p3Zutatenappear(){
        p3Apfel.setVisible(true);
        p3Banane.setVisible(true);
        p3Birne.setVisible(true);
        p3Erdbeere.setVisible(true);
        p3Karotte.setVisible(true);
        p3Kiwi.setVisible(true);
        p3Kohlrabi.setVisible(true);
        p3Melone.setVisible(true);
        p3Pfirsich.setVisible(true);
        p3Spinat.setVisible(true);
        p3Weintrauben.setVisible(true);
        p3erstelleCustomZutat.setVisible(true);
        p3hinzuCustomZutat.setVisible(true);
        p4Mixen.setVisible(true);
        p4Entfernen.setVisible(true);
        p4MixenCustom.setVisible(true);
        p4MixenKlein.setVisible(true);
        p4MixenGross.setVisible(true);
        p2a1glueckSpiel.setVisible(true);
    }
    private void aktualisiereAnzeige(){
        String anzeige = "";
        for(Zutat z: smoothiemixer.getZutaten()){
            if(z == smoothiemixer.getZutaten().get(smoothiemixer.getZutaten().size()-1)){
            anzeige = anzeige + z.getName();}
            else{anzeige = anzeige + z.getName() + " , ";}
        }
        p1a2Text.setText(anzeige);
    }
}
class AusgabeRahmen extends JFrame{

    JLabel smoothieImage;
    BufferedImage smoothieImage1;

    public AusgabeRahmen(Smoothie pSmoothie) {

       int imageNumber = Smoothiemixer.ausgabeFarbe(pSmoothie);

        try {
            switch (imageNumber){
                case 0 : smoothieImage1 = ImageIO.read(new File("src/resources/greensmoothies.jpg"));break;

                case 1 : smoothieImage1 = ImageIO.read(new File("src/resources/redSmoothie.jpg"));break;

                default: smoothieImage1 = ImageIO.read(new File("src/resources/miscSmoothies.jpg"));break;
            }

            smoothieImage = new JLabel(new ImageIcon(smoothieImage1));

        }catch (Exception e){
            smoothieImage = new JLabel();
        }


        JLabel ausgabeName = new JLabel("",SwingConstants.CENTER);
        JLabel ausgabeKalorien = new JLabel("",SwingConstants.CENTER);
        JLabel ausgabeVitamine = new JLabel("",SwingConstants.CENTER);
        JLabel ausgabeZucker = new JLabel("",SwingConstants.CENTER);
        JLabel nameD = new JLabel("Name: ",SwingConstants.CENTER);
        JLabel kalorienD = new JLabel("Kalorien: ",SwingConstants.CENTER);
        JLabel vitamincD = new JLabel("Vitamin C in mg: ",SwingConstants.CENTER);
        JLabel zuckerD = new JLabel("Zucker in g: ",SwingConstants.CENTER);
        JButton close = new JButton("CLOSE");
        JLabel fake1 = new JLabel("");
        JPanel rightSide = new JPanel();
        rightSide.setLayout(new GridLayout(5,2));
        rightSide.add(nameD); rightSide.add(ausgabeName);
        rightSide.add(kalorienD); rightSide.add(ausgabeKalorien);
        rightSide.add(vitamincD); rightSide.add(ausgabeVitamine);
        rightSide.add(zuckerD); rightSide.add(ausgabeZucker);
        rightSide.add(fake1); rightSide.add(close);

        ausgabeName.setText(pSmoothie.getSmoothieName().toString());
        ausgabeKalorien.setText(Double.toString(pSmoothie.getSmoothieKalorien()));
        ausgabeVitamine.setText(Double.toString(pSmoothie.getSmoothieVitaminC()));
        ausgabeZucker.setText(Double.toString(pSmoothie.getSmoothieZucker()));

        this.setLayout(new GridLayout(1,2));
        this.add(smoothieImage); this.add(rightSide);
        this.setSize(650,200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
class LogRahmen extends JFrame{

    JButton close = new JButton("CLOSE");
    List smoothieAuswertung = new List();
    List werteAuswertung = new List();

    LogRahmen(Benutzerprofile pUser) {
        int APPLESHAKE=0, BANANAMAMA=0, BANAPPLESHOT=0, POPEYE=0, KIWILOVE=0, GREENDAY=0, MEGAMIX=0, HAWAII=0, CUSTOM=0;
        double logKalorien= Math.round(100.0*pUser.getKaloriengesamt()/100),
                logVitamine=Math.round(100.0*pUser.getVitaminegesamt()/100),
                logZucker=Math.round(100.0*pUser.getZuckergesamt()/100);
        werteAuswertung.add("Werte für " + pUser.toString());
        werteAuswertung.add("Kalorien gesamt: " + logKalorien);
        werteAuswertung.add("Vitamine gesamt: " + logVitamine);
        werteAuswertung.add("Zucker gesamt: " + logZucker);

        for(Vorlagen.SMVorlagen s : pUser.getLieblingssmoothies()){
            switch (s){
                case APPLESHAKE: APPLESHAKE++;break;
                case BANANAMAMA: BANANAMAMA++;break;
                case BANAPPLESHOT: BANAPPLESHOT++;break;
                case POPEYE: POPEYE++;break;
                case KIWILOVE: KIWILOVE++;break;
                case GREENDAY: GREENDAY++;break;
                case MEGAMIX: MEGAMIX++;break;
                case HAWAII: HAWAII++;break;
                case CUSTOM: CUSTOM++;break;
            }
        }

        smoothieAuswertung.add("Gemixte Smoothies von " +pUser.toString());
        smoothieAuswertung.add("APPLESHAKE: " + APPLESHAKE);
        smoothieAuswertung.add("BANANAMAMA: " + BANANAMAMA);
        smoothieAuswertung.add("BANAPPLESHOT: "+BANAPPLESHOT);
        smoothieAuswertung.add("POPEYE: "+ POPEYE);
        smoothieAuswertung.add("KIWILOVE " + KIWILOVE);
        smoothieAuswertung.add("GREENDAY " + GREENDAY);
        smoothieAuswertung.add("MEGAMIX: " + MEGAMIX);
        smoothieAuswertung.add("HAWAII: " + HAWAII);
        smoothieAuswertung.add("Selbsterstellt: " + CUSTOM);

        this.setLayout(new GridLayout(3,1));
        this.add(smoothieAuswertung);this.add(werteAuswertung);this.add(close);
        this.setSize(800,500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
class CustomZutatRahmen extends JFrame{
    Zutat customZutat;

    public CustomZutatRahmen() {

        JButton close = new JButton("CLOSE");
        JButton ok = new JButton("OK");
        JLabel zName = new JLabel("Zutatname: ");
        JTextField zTName = new JTextField("");
        JLabel zKalorien = new JLabel("Kalorien: ");
        JTextField zTKalorien = new JTextField("");
        JLabel zVitaminC = new JLabel("Vitamin C in mg: ");
        JTextField zTVitaminC = new JTextField("");
        JLabel zZucker = new JLabel("Zucker in g: ");
        JTextField zTZucker = new JTextField("");

        this.setLayout(new GridLayout(5,5));
        this.add(zName);this.add(zTName);
        this.add(zKalorien);this.add(zTKalorien);
        this.add(zVitaminC);this.add(zTVitaminC);
        this.add(zZucker);this.add(zTZucker);
        this.add(ok);this.add(close);


        this.setSize(500, 200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String z = zTName.getText();
                String cname = z;
                z = zTKalorien.getText();
                double y = 0.0;
                try{y = Double.parseDouble(z);}catch (Exception e1){
                    System.out.println("LOG:Warnung//keine Zahl gefunden, Wert auf 0 gesetzt");
                    y = 0.0;}
                double cKalorien = y;
                z = zTVitaminC.getText();
                try{y = Double.parseDouble(z);}catch (Exception e1){
                    System.out.println("LOG:Warnung//keine Zahl gefunden, Wert auf 0 gesetzt");
                    y = 0.0;}
                double cVitaminC = y;
                z = zTZucker.getText();
                try{y = Double.parseDouble(z);}catch (Exception e1){
                    System.out.println("LOG:Warnung//keine Zahl gefunden, Wert auf 0 gesetzt");
                    y = 0.0;}
                double cZucker = y;
                customZutat = new Zutat(cname,cKalorien,cVitaminC,cZucker){};
                Uebergabe.UebergabeZutat = customZutat;
                dispose();
            }
        });


    }

}
class CustomGroesseRahmen extends JFrame {
    JLabel imageLabel;
    public CustomGroesseRahmen(Smoothie pSmoothie, Benutzerprofile user) {

        try {
            BufferedImage i1 = ImageIO.read(new File("src/resources/massband.jpg"));
            imageLabel = new JLabel(new ImageIcon(i1));
        }catch (Exception e){}

        JPanel centerPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        JButton close = new JButton("CLOSE");
        JButton ok = new JButton("Mixen");
        JLabel zgroesse = new JLabel(" Volumen in ml: ");
        JTextField zTgroesse = new JTextField("");
        centerPanel.setLayout(new GridLayout(1, 2));
        bottomPanel.setLayout(new GridLayout(1,1));
        centerPanel.add(zgroesse);
        centerPanel.add(zTgroesse);
        bottomPanel.add(ok);
        bottomPanel.add(close);
        this.setLayout(new GridLayout(3,1));
        this.add(imageLabel); this.add(centerPanel); this.add(bottomPanel);


        this.setSize(250, 180);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean parsingpositive = true;
                double y = 0.0;
                try{y = Double.parseDouble(String.valueOf(zTgroesse.getText()));}catch (Exception e1){
                    System.out.println("LOG:Warnung//keine Zahl gefunden, Wert unverändert");
                    parsingpositive = false;
                    }
                if(parsingpositive){
                    pSmoothie.setMengenModifikator(y/100/pSmoothie.getInhalt().size());
                    new AusgabeRahmen(pSmoothie);
                    //Profil-Aktualisierung
                    user.leseWFileaus();
                    user.zuckerhinzufuegen(pSmoothie.getSmoothieZucker());
                    user.kalorienhinzufuegen(pSmoothie.getSmoothieKalorien());
                    user.vitaminehinzufuegen(pSmoothie.getSmoothieVitaminC());
                    user.aktualisiereWFile();
                    //Profil Aktualisierung Ende
                    dispose();}
            }
        });


    }
}
class CustomRahmenBandit extends JFrame{

    ImageIcon luckyApfel = new ImageIcon("src/resources/luckyApfel.jpg","Apfel");
    ImageIcon luckyBanane = new ImageIcon("src/resources/luckyApfel.jpg","Banane");
    ImageIcon luckyBirne = new ImageIcon("src/resources/luckyBirne.jpg","Birne");
    ImageIcon luckyErdbeere = new ImageIcon("src/resources/luckyErdbeere.jpg","Erdbeere");
    ImageIcon luckyKarotte = new ImageIcon("src/resources/luckyKarotte.jpg","Karotte");
    ImageIcon luckyKiwi = new ImageIcon("src/resources/luckyKiwi.jpg","Kiwi");
    ImageIcon luckyKohlrabi = new ImageIcon("src/resources/luckyKohlrabi.jpg","Kohlrabi");
    ImageIcon luckyMelone = new ImageIcon("src/resources/luckyMelone.jpg","Melone");
    ImageIcon luckyPfirsich = new ImageIcon("src/resources/luckyPfirsich.jpg","Pfirsich");
    ImageIcon luckySpinat = new ImageIcon("src/resources/luckySpinat.jpg","Spinat");
    ImageIcon luckyWeintraube = new ImageIcon("src/resources/luckyWeintrauben.jpg","Weintraube");

    boolean rolle1Fertig = true;
    boolean rolle2Fertig = true;
    boolean rolle3Fertig = true;

    private JLabel rolle1Oben, rolle1Mitte, rolle1Unten, rolle2Oben, rolle2Mitte, rolle2Unten, rolle3Oben, rolle3Mitte, rolle3Unten;

    CustomRahmenBandit() {

         rolle1Oben = new JLabel(new ImageIcon("src/resources/luckyApfel.jpg"));
         rolle1Mitte = new JLabel(new ImageIcon("src/resources/luckyApfel.jpg"));
         rolle1Unten = new JLabel(new ImageIcon("src/resources/luckyApfel.jpg"));
         rolle2Oben = new JLabel(new ImageIcon("src/resources/luckyApfel.jpg"));
         rolle2Mitte = new JLabel(new ImageIcon("src/resources/luckyApfel.jpg"));
         rolle2Unten = new JLabel(new ImageIcon("src/resources/luckyApfel.jpg"));
         rolle3Oben = new JLabel(new ImageIcon("src/resources/luckyApfel.jpg"));
         rolle3Mitte = new JLabel(new ImageIcon("src/resources/luckyApfel.jpg"));
         rolle3Unten = new JLabel(new ImageIcon("src/resources/luckyApfel.jpg"));

        JLabel rechtesBild = new JLabel(new ImageIcon("src/resources/smoothiegif.gif"));
        JLabel linkesBild = new JLabel(new ImageIcon("src/resources/smoothiegif.gif"));
        JLabel ueberschrift = new JLabel(new ImageIcon("src/resources/luckysmoothie.gif"));

        JPanel buttons = new JPanel(new GridLayout(1,2));
        JButton spielen = new JButton("Spielen");
        JButton mixen = new JButton("Mixen");
        buttons.add(spielen); buttons.add(mixen);

        JPanel rolle1 = new JPanel();
        rolle1.setLayout(new GridLayout(3,1));
        rolle1.add(rolle1Oben);rolle1.add(rolle1Mitte);rolle1.add(rolle1Unten);
        JPanel rolle2 = new JPanel();
        rolle2.setLayout(new GridLayout(3,1));
        rolle2.add(rolle2Oben);rolle2.add(rolle2Mitte);rolle2.add(rolle2Unten);
        JPanel rolle3 = new JPanel();
        rolle3.setLayout(new GridLayout(3,1));
        rolle3.add(rolle3Oben);rolle3.add(rolle3Mitte);rolle3.add(rolle3Unten);
        JPanel rollenGesamt = new JPanel(new GridLayout(1,3));
        rollenGesamt.add(rolle1); rollenGesamt.add(rolle2); rollenGesamt.add(rolle3);



        this.setLayout(new BorderLayout());
        this.add(ueberschrift, BorderLayout.PAGE_START);
        this.add(buttons, BorderLayout.PAGE_END);
        this.add(rollenGesamt, BorderLayout.CENTER);
        this.add(rechtesBild, BorderLayout.LINE_START);
        this.add(linkesBild, BorderLayout.LINE_END);

        this.setSize(500,400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        spielen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkRollenobFertig()){
                new Thread(new RolleALL()).start();
                }

            }
        });
        mixen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkRollenobFertig()){
                    Smoothie p1 = leseBanditausfuerMixen();
                    new AusgabeRahmen(p1);
                }
                else System.out.println("LOG: noch nicht fertig");

            }
        });

    }

    private Icon randomImage(){
        Icon returnME;
        int randomzahl = (int) (Math.random() * 11) + 1;

        switch (randomzahl){
            case 11: returnME = luckyApfel;break;
            case 1: returnME = luckyBanane;break;
            case 2: returnME = luckyBirne;break;
            case 3: returnME = luckyErdbeere;break;
            case 4: returnME = luckyKarotte;break;
            case 5: returnME = luckyKiwi;break;
            case 6: returnME = luckyKohlrabi;break;
            case 7: returnME = luckyMelone;break;
            case 8: returnME = luckyPfirsich;break;
            case 9: returnME = luckySpinat;break;
            case 10: returnME = luckyWeintraube;break;
            default: returnME = new ImageIcon("src/resources/Error.png");
        }

        return returnME;
    }
    private boolean checkRollenobFertig(){
        return rolle1Fertig & rolle2Fertig & rolle3Fertig;
    }
    private Smoothie leseBanditausfuerMixen(){
        Zutat z1 = wandleIconInZutatUm(rolle1Mitte.getIcon());
        Zutat z2 = wandleIconInZutatUm(rolle2Mitte.getIcon());
        Zutat z3 = wandleIconInZutatUm(rolle3Mitte.getIcon());
        return new Smoothie(z1,z2,z3);
    }
    private Zutat wandleIconInZutatUm(Icon pIcon){
        ImageIcon i1 = (ImageIcon) pIcon;
        String zutatenName = i1.getDescription();
        switch (zutatenName){
            case "Apfel": return new Apfel();
            case "Birne": return new Birne();
            case "Banane": return new Banane();
            case "Erdbeere": return new Erdbeere();
            case "Karotte" : return new Karotte();
            case "Kiwi" : return new Kiwi();
            case "Kohlrabi": return new Kohlrabi();
            case "Melone" : return new Melone();
            case "Pfirsich" : return new Pfirsich();
            case "Spinat" : return new Spinat();
            case "Weintraube" : return new Weintrauben();
            default: return null;
        }
    }



        class Rolle1 implements Runnable{

        @Override
        public void run() {
            int randomzahl = (int) (Math.random() * 50) + 10;
            while(randomzahl < 80){
                try {
                    rolle1Unten.setIcon(rolle1Mitte.getIcon());
                    rolle1Mitte.setIcon(rolle1Oben.getIcon());
                    rolle1Oben.setIcon(randomImage());
                    Thread.sleep(100);
                    randomzahl++;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            rolle1Fertig = true;
        }
    }
        class Rolle2 implements Runnable{

            @Override
            public void run() {
                int randomzahl = (int) (Math.random() * 50) + 10;
                while(randomzahl < 80){
                    try {
                        rolle2Unten.setIcon(rolle2Mitte.getIcon());
                        rolle2Mitte.setIcon(rolle2Oben.getIcon());
                        rolle2Oben.setIcon(randomImage());
                        Thread.sleep(100);
                        randomzahl++;

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                rolle2Fertig = true;
            }
        }
        class Rolle3 implements Runnable{

            @Override
            public void run() {
                int randomzahl = (int) (Math.random() * 50) + 10;
                while(randomzahl < 80){
                    try {
                        rolle3Unten.setIcon(rolle3Mitte.getIcon());
                        rolle3Mitte.setIcon(rolle3Oben.getIcon());
                        rolle3Oben.setIcon(randomImage());
                        Thread.sleep(100);
                        randomzahl++;

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                rolle3Fertig = true;
            }
        }
        class RolleALL implements Runnable{

            @Override
            public void run() {
                rolle1Fertig = false; rolle2Fertig = false; rolle3Fertig = false;
                new Thread(new Rolle1()).start(); new Thread(new Rolle2()).start(); new Thread(new Rolle3()).start();
            }
        }


}

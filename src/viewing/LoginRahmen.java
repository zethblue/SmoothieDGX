package viewing;

import model.benutzerprofile.Benutzerprofile;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

public class LoginRahmen extends JFrame {

    BufferedImage rightImage, leftImage;

    public LoginRahmen(){

        JPanel centerPanel = new JPanel();

        try{
             rightImage = ImageIO.read(new File("src/resources/smoothielogin1.jpg"));
             leftImage = ImageIO.read(new File("src/resources/smoothielogin2.png"));
        }catch (Exception e){

        }
        JLabel r1 = new JLabel(new ImageIcon(rightImage));
        JLabel l1 = new JLabel(new ImageIcon(leftImage));
        JLabel fake = new JLabel("");
        JLabel fake2 = new JLabel("");


        JButton login = new JButton("Login");
        JButton createAccount = new JButton("neuer Account");
        JLabel loginname = new JLabel("Benutzername");
        JLabel passwort = new JLabel("Passwort");
        JTextField loginTextfield = new JTextField();
        JPasswordField passwordTextfield = new JPasswordField();
        JButton exit = new JButton("Beenden");
        JButton guest = new JButton("Gastaccount");

        this.setLayout(new BorderLayout());
        this.add(centerPanel, BorderLayout.CENTER);this.add(l1,BorderLayout.LINE_START);this.add(r1,BorderLayout.LINE_END);

        centerPanel.setLayout(new GridLayout(4,2));
        centerPanel.add(loginname); centerPanel.add(loginTextfield);
        centerPanel.add(passwort); centerPanel.add(passwordTextfield);
        centerPanel.add(createAccount); centerPanel.add(login);
        centerPanel.add(guest); centerPanel.add(exit);

        this.setTitle("Smoothiemixer LOGIN");
        this.setSize(450,200);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        createAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(loginTextfield.getText().equals("")||passwordTextfield.getText().equals("")){
                    new InfoRahmen(0);
                }
                else if(loginTextfield.getText().toLowerCase().equals("gast")){
                    new InfoRahmen(6);
                }
                else {
                    String loginString = loginTextfield.getText();
                    String passwortString = passwordTextfield.getText();
                    File loginfile = new File("data/"+loginString);
                    boolean exists = loginfile.exists();
                    if (exists) {
                        new InfoRahmen(2);
                    }else{
                        try {
                            FileWriter F1 = new FileWriter("data/"+loginString);
                            F1.write(passwortString);
                            F1.flush();
                            F1.close();
                            new InfoRahmen(3);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(loginTextfield.getText().equals("")||passwordTextfield.getText().equals("")){
                    new InfoRahmen(1);
                }

                else{
                    String loginString = loginTextfield.getText();
                    String passwortString = passwordTextfield.getText();
                    try {
                        FileReader F1 = new FileReader("data/"+loginString);
                        BufferedReader B1 = new BufferedReader(F1);
                        String abgleich = B1.readLine();
                        if(abgleich.equals(passwortString)){
                            new Rahmen(new Benutzerprofile(loginString));
                            dispose();
                        }else{new InfoRahmen(4);}
                    } catch (FileNotFoundException ex) {
                        new InfoRahmen(5);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        guest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Rahmen(new Benutzerprofile("gast"));
                dispose();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

class InfoRahmen extends JFrame{

    JButton ok = new JButton("OK");
    JLabel info;

    InfoRahmen(int i){
        if(i == 0){info = new JLabel("Zum Erstellen bitte Logindaten ausfüllen");}
        if(i == 1){info = new JLabel("Zum Einloggen bitte Logindaten ausfüllen");}
        if(i == 2){info = new JLabel("Der Benutzername existiert bereits");}
        if(i == 3){info = new JLabel("Erfolgreich angelegt");}
        if(i == 4){info = new JLabel("Passwort falsch");}
        if(i == 5){info = new JLabel("Benutzername nicht gefunden");}
        if(i == 6){info = new JLabel("Der Name Gast ist nicht zulässig");}

        this.setLayout(new GridLayout(2,1));
        this.add(info);this.add(ok);
        this.setTitle("INFO!");
        this.setSize(250,100);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}

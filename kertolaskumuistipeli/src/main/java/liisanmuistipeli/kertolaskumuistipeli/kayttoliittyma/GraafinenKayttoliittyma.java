/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import liisanmuistipeli.kertolaskumuistipeli.logiikka.Logiikka;
import liisanmuistipeli.kertolaskumuistipeli.logiikka.Kortti;
import liisanmuistipeli.kertolaskumuistipeli.logiikka.KorttienArpoja;
import liisanmuistipeli.kertolaskumuistipeli.logiikka.Pelitilanne;

/**
 * Luokka luo ikkunan, jossa pelinaloitusvalikko, asettaa kortit esille ja
 * kÃ¤ynnistÃ¤Ã¤ pelin
 *
 * @author liisapauliina
 */
public class GraafinenKayttoliittyma extends JPanel {

    private JFrame ikkuna;
    private ArrayList<JButton> kysymysnapit;
    private ArrayList<JButton> vastausnapit;
    private Logiikka logiikka;
    private Pelitilanne peli;
    private KorttienArpoja arpoja;

    public GraafinenKayttoliittyma(Logiikka logiikka) {
        this.logiikka = logiikka;
        this.peli = logiikka.getPelitilanne();
        this.kysymysnapit = new ArrayList<JButton>();
        this.vastausnapit = new ArrayList<JButton>();
    }

//    @Override
    public void run() {
        ikkuna = new JFrame("Kertolaskumuistipeli");
        ikkuna.setPreferredSize(new Dimension(600, 400));
        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.lisaaKomponentit();
        ikkuna.pack();
        ikkuna.setVisible(true);
    }

    /**
     * Metodi, joka asettaa kortit esille
     *
     * @param container on laatikko, johon kortit asetetaan.
     */
    public void lisaaKomponentit() {
        //   Container kysymykset = new Container();
        //   Container vastaukset = new Container();
        // Kortti k = new Kortti(1,2,0);
        GridLayout gl = new GridLayout(2, 0);

        ikkuna.getContentPane().setLayout(gl);

        for (Kortti kortti : this.peli.getKysymykset()) {
            JButton nappi = new JButton();
            this.kysymysnapit.add(nappi);
            KysymystenKuuntelija kuuntelija = new KysymystenKuuntelija(this.peli.getKysymykset().indexOf(kortti), this.logiikka, this);
            nappi.addActionListener(kuuntelija);
            nappi.setText(kortti.toString());
            ikkuna.getContentPane().add(nappi);

        }
        for (Kortti kortti : this.peli.getVastaukset()) {
            JButton nappi = new JButton();
            this.vastausnapit.add(nappi);
            VastaustenKuuntelija kuuntelija = new VastaustenKuuntelija(this.peli.getVastaukset().indexOf(kortti), this.logiikka, this);
            nappi.addActionListener(kuuntelija);
            nappi.setText(kortti.toString());
            ikkuna.getContentPane().add(nappi);
        }
    }

    public void paivitaKortit() {
        
        for (int i = 0; i < this.kysymysnapit.size(); i++) {
            kysymysnapit.get(i).setText(this.peli.getKysymykset().get(i).toString());
        }
        for (int i = 0; i < this.vastausnapit.size(); i++) {
            vastausnapit.get(i).setText(this.peli.getVastaukset().get(i).toString());
        }
        
    }

    public Logiikka getLogiikka() {
        return logiikka;
    }

//    public void peliLoppui() {
//        String mitaTehdaan = VaihtoehtoinenAloitusvalikko.kysy("Haluatko uuden pelin? K = Kyllä, E = En");
//        while (mitaTehdaan!= "K" && mitaTehdaan!= "E") {
//            mitaTehdaan = VaihtoehtoinenAloitusvalikko.kysy("Haluatko uuden pelin? K = Kyllä, E = En");
//        }
//        if (mitaTehdaan == "K") {
//            PelinAloittaja aloittaja = new PelinAloittaja();
//            aloittaja.teeUusiPeli(aloittaja.kysyKertoja());
//        } 
//    }
}

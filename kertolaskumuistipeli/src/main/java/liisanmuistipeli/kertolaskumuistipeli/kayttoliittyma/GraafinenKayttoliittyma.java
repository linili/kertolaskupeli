/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import liisanmuistipeli.kertolaskumuistipeli.logiikka.Logiikka;
import liisanmuistipeli.kertolaskumuistipeli.logiikka.Kortti;
import liisanmuistipeli.kertolaskumuistipeli.logiikka.KorttienArpoja;
import liisanmuistipeli.kertolaskumuistipeli.logiikka.Pelitilanne;

/**
 * Luokka toimii graafisena käyttöliittymänä pelille. Se päivittää jokaisen
 * kortin klikkauksen jälkeen tilanteen pöydällä.
 *
 * @author liisapauliina
 */
public class GraafinenKayttoliittyma extends JPanel implements ActionListener {

    private JFrame ikkuna;
    private ArrayList<JButton> kysymysnapit;
    private ArrayList<JButton> vastausnapit;
    private Logiikka logiikka;
    private Pelitilanne peli;
    private KorttienArpoja arpoja;
    private JPanel korttipaneeli;
    private JPanel nappipaneeli;

    /**
     * Konstuktorissa käyttöliittymälle annetaan logiikka. Lisäksi alustetaan
     * kysymykset ja vastaukset, jotka koostuvat JButtoneista.
     *
     * @param logiikka on pelin logiikka.
     */
    public GraafinenKayttoliittyma(Logiikka logiikka) {
        this.logiikka = logiikka;
        this.peli = logiikka.getPelitilanne();
        this.kysymysnapit = new ArrayList<JButton>();
        this.vastausnapit = new ArrayList<JButton>();
    }

    /**
     * Metodi avaa peliikkunan ja asettaa JButtoneista koostuvat kysymykset ja
     * vastaukset pöydälle.
     */
    public void run() {
        ikkuna = new JFrame("Kertolaskumuistipeli - käännä aina ensin ylärivistä kysymyskortti");
        ikkuna.setPreferredSize(new Dimension(800, 400));
        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ikkuna.setBackground(Color.yellow);
        this.lisaaKomponentit();
        ikkuna.pack();
        ikkuna.setVisible(true);
    }

    /**
     * Metodi, joka luo JButtonin jokaiselle kortille, asettaa sille kuuntelijan
     * sekä lisää sen korttipaneeliin. Metodi luo myös uusi peli-nappulan ja
     * lisää sen nappipaneeliin.
     *
     * @param container on laatikko, johon kortit asetetaan.
     */
    public void lisaaKomponentit() {

        GridLayout gl = new GridLayout(0, 10);
        korttipaneeli = new JPanel(gl);
        FlowLayout fl = new FlowLayout();
        nappipaneeli = new JPanel(fl);
        nappipaneeli.setBackground(Color.BLACK);
        ikkuna.getContentPane().add(korttipaneeli, BorderLayout.CENTER);
        ikkuna.getContentPane().add(nappipaneeli, BorderLayout.SOUTH);

        for (Kortti kortti : this.peli.getKysymykset()) {
            JButton nappi = new JButton();
            this.kysymysnapit.add(nappi);
            KysymystenKuuntelija kuuntelija = new KysymystenKuuntelija(this.peli.getKysymykset().indexOf(kortti), this.logiikka, this);
            nappi.addActionListener(kuuntelija);
            nappi.setText(kortti.toString());
            korttipaneeli.add(nappi);

        }
        for (Kortti kortti : this.peli.getVastaukset()) {
            JButton nappi = new JButton();
            this.vastausnapit.add(nappi);
            VastaustenKuuntelija kuuntelija = new VastaustenKuuntelija(this.peli.getVastaukset().indexOf(kortti), this.logiikka, this);
            nappi.addActionListener(kuuntelija);
            nappi.setText(kortti.toString());
            korttipaneeli.add(nappi);
        }

        JButton uusiPeli = new JButton("Valitse uusi peli");
        uusiPeli.addActionListener(this);
        uusiPeli.setBackground(Color.ORANGE);
        nappipaneeli.add(uusiPeli);
    }

    /**
     * Metodi päivittää tekstit korteissa.
     */
    public void paivitaKortit() {

        for (int i = 0; i < this.kysymysnapit.size(); i++) {
            kysymysnapit.get(i).setText(this.peli.getKysymykset().get(i).toString());
            if (this.peli.getKysymykset().get(i).onkoLoydetty()) {
                kysymysnapit.get(i).setBackground(Color.PINK);
            }
        }
        for (int i = 0; i < this.vastausnapit.size(); i++) {
            vastausnapit.get(i).setText(this.peli.getVastaukset().get(i).toString());
            if (this.peli.getVastaukset().get(i).onkoLoydetty()) {
                vastausnapit.get(i).setBackground(Color.PINK);
            }
        }

    }

    public Logiikka getLogiikka() {
        return logiikka;
    }

    /**
     * Metodi tekee ponnahdusikkunan, joka kysyy pelaajalta haluaako hän uuden
     * pelin. Jos vastataan "K", käynnistetään uusi peli. Jos vastaus on "E", ei
     * tehdä mitään. Jos vastaus on joku muu, kysytään uudelleen.
     */
    public void peliLoppui() {
        String mitaTehdaan = PonnahdusIkkunanLuoja.kysy("Haluatko uuden pelin? K = Kyllä, E = En");
        while (!mitaTehdaan.equals("K") && !mitaTehdaan.equals("E")) {
            mitaTehdaan = PonnahdusIkkunanLuoja.kysy("Haluatko uuden pelin? K = Kyllä, E = En");
        }
        if (mitaTehdaan.equals("K")) {
            PelinAloittaja aloittaja = new PelinAloittaja();
            aloittaja.teeUusiPeli(aloittaja.kysyKertoja());
        } else {
            System.out.println("päätit lopettaa pelin");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        peliLoppui();
    }
}

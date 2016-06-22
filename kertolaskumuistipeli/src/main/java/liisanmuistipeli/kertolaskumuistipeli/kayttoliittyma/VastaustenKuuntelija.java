/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.Timer;
import liisanmuistipeli.kertolaskumuistipeli.logiikka.Kortti;
import liisanmuistipeli.kertolaskumuistipeli.logiikka.Logiikka;

/**
 * Luokka toimii vastauskortin kuuntelijana. VastauskortinKuuntelija tunnistaa
 * hiiren painalluksen ja välittää käskyjä käyttöliittymälle ja logiikalle.
 * Käyttöliittymää pyydetään päivittämään kortit.
 *
 * @author liisapauliina
 */
public class VastaustenKuuntelija implements ActionListener {

    private Logiikka logiikka;
    private int paikka;
    private GraafinenKayttoliittyma kali;
    private Ajastin ajastin;

    /**
     * Konstruktorissa alustetaan parametrit paikka, logiikka ja käyttis sekä
     * luodaan ajastin.
     *
     * @param paikka kertoo vastauskortin paikan.
     * @param logiikka on pelin logiikka
     * @param kali on pelin Graafinen käyttöjärjestelmä
     */
    public VastaustenKuuntelija(int paikka, Logiikka logiikka, GraafinenKayttoliittyma kali) {
        this.logiikka = logiikka;
        this.paikka = paikka;
        this.kali = kali;
        this.ajastin = new Ajastin(2000, kali);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.logiikka.saakoJoKaantaa()) {
            this.logiikka.valitseVastauskortti(this.paikka);
            this.logiikka.setSaakoJoKaantaa(false);
            this.kali.paivitaKortit();
            tarkistaTilanne();
            this.kali.paivitaKortit();
        }
    }

    /**
     * Metodi tarkistaa löytyikö pari ja käynnistää ajastimen, jos ei löytynyt.
     * Jos pari löytyi, kortit käännetään pois näkyvistä. Lisäksi tarkistetaan,
     * onko kaikki parit löydetty. Jos ei, annetaan pelaajalle lupa kääntää uusi
     * kortti. Jos kaikki parit löydetty, käynnistetään pelinlopetus-valikko.
     */
    public void tarkistaTilanne() {
        if (!this.logiikka.loytyikoPari()) {
            this.ajastin.start();
        } else {
            this.logiikka.poistaKortit(this.logiikka.getKaannettyKysymysKortti(), this.logiikka.getKaannettyVastausKortti());
            if (!this.logiikka.onkoKaikkiLoydetty()) {
                this.logiikka.setSaakoJoKaantaa(true);
            } else {
                this.kali.peliLoppui();
            }
        }
    }
}

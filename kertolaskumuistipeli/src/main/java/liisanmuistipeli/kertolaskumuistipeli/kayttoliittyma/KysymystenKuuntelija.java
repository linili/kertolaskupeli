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
import liisanmuistipeli.kertolaskumuistipeli.logiikka.Logiikka;
import liisanmuistipeli.kertolaskumuistipeli.logiikka.Kortti;
import liisanmuistipeli.kertolaskumuistipeli.logiikka.Pelitilanne;

/**
 * Luokka toimii kysymyskortin kuuntelijana ja välittää käskyn logiikalle, kun
 * kysymyskortti valitaan. Käyttöliittymää pyydetään päivittämään kortit, kun
 * kortti valitaan.
 *
 * @author liisapauliina
 */
public class KysymystenKuuntelija implements ActionListener {

    private Logiikka logiikka;
    private int paikka;
    private GraafinenKayttoliittyma kali;

    /**
     * Konstruktorissa kuuntelijalle annetaan kortin paikka pöydällä, pelin
     * logiikka ja käyttöliittyma.
     *
     * @param paikka on kysymyskortin paikka pöydällä
     * @param logiikka on pelin logiikka
     * @param kali on pelin käyttöliittymä
     */
    public KysymystenKuuntelija(int paikka, Logiikka logiikka, GraafinenKayttoliittyma kali) {
        this.logiikka = logiikka;
        this.paikka = paikka;
        this.kali = kali;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.logiikka.saakoJoKaantaa()) {
            this.logiikka.valitseKysymyskortti(this.paikka);
            this.kali.paivitaKortit();
        }
    }
}

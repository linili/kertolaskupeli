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
 *
 * @author liisapauliina
 */
public class KysymystenKuuntelija implements ActionListener {

    private Logiikka logiikka;
    private int paikka;
    private GraafinenKayttoliittyma kali;

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

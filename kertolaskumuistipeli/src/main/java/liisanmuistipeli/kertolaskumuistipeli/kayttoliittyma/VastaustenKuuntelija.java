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
 *
 * @author liisapauliina
 */
public class VastaustenKuuntelija implements ActionListener {

    private Logiikka logiikka;
    private int paikka;
    private GraafinenKayttoliittyma kali;
    private Ajastin ajastin;

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
        }
    }

    public void tarkistaTilanne() {
        if (!this.logiikka.loytyikoPari()) {
            this.ajastin.start();
        } else {
            this.logiikka.poistaKortit(this.logiikka.getKaannettyKysymysKortti(), this.logiikka.getKaannettyVastausKortti());
            if (!this.logiikka.onkoKaikkiLoydetty()) {
                this.logiikka.setSaakoJoKaantaa(true);
            }
//                else {
//                 this.kali.peliLoppui();
//            }
        }
    }
}

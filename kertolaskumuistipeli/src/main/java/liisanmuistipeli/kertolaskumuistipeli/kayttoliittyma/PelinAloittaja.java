/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.kayttoliittyma;

import liisanmuistipeli.kertolaskumuistipeli.logiikka.Logiikka;
import liisanmuistipeli.kertolaskumuistipeli.logiikka.KorttienArpoja;
import liisanmuistipeli.kertolaskumuistipeli.logiikka.Pelitilanne;

/**
 *
 * @author liisapauliina
 */
public class PelinAloittaja {

    private Logiikka logiikka;
    private KorttienArpoja arpoja;

    public PelinAloittaja() {
        this.arpoja = new KorttienArpoja();
    }

    public int kysyKertoja() {
        int kertoja = VaihtoehtoinenAloitusvalikko.kysyKertoja("Syötä kertotaulu (1-9) ");
        while (kertoja < 1 || kertoja > 9) {
            kertoja = VaihtoehtoinenAloitusvalikko.kysyKertoja("Syötä kertotaulu väliltä 1-9 ");
        }
        return kertoja;
    }

    public void teePeli(int kertoja) {
        this.arpoja.arvoKortit(kertoja);
        this.logiikka = new Logiikka(this.arpoja.luoSatunnainenPelitilanne());
    }
    public Logiikka getLogiikka() {
        return this.logiikka;
    }
}

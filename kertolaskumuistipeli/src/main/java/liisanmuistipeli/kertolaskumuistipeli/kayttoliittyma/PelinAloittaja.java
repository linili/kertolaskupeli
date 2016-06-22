/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.kayttoliittyma;

import liisanmuistipeli.kertolaskumuistipeli.logiikka.Logiikka;
import liisanmuistipeli.kertolaskumuistipeli.logiikka.KorttienArpoja;

/**
 * Luokka toimii pelin käynnistäjänä. Luokka tekee ponnahdusikkunan, jolla
 * pelaajalta kysytään lukua väliltä 1-9. Luokka luo uuden pelitilanteen ,
 * logiikan ja graafisen käyttöliittymän.
 *
 * @author liisapauliina
 */
public class PelinAloittaja {

    private Logiikka logiikka;
    private KorttienArpoja arpoja;
    private GraafinenKayttoliittyma kali;

    public PelinAloittaja() {
    }

    /**
     * Metodi tekee ponnahdusikkunan, joka kysyy pelaajalta kertotaulua väliltä
     * 1-9 ja palauttaa pelaajan antaman luvun, jos se on sallitulta väliltä.
     * Muutoin kysytään uudestaan.
     *
     * @return kertoja eli pelaajan antaman luvun.
     */
    public int kysyKertoja() {
        int kertoja = PonnahdusIkkunanLuoja.kysyKertoja("Syötä kertotaulu (1-9) ");
        while (kertoja < 1 || kertoja > 9) {
            kertoja = PonnahdusIkkunanLuoja.kysyKertoja("Syötä kertotaulu väliltä 1-9 ");
        }
        return kertoja;
    }

    /**
     * Metodi alustaa uuden pelin.
     *
     * @param kertoja on kertotaulu, jota halutaan harjoitella.
     */
    public void teeUusiPeli(int kertoja) {
        this.arpoja = new KorttienArpoja();
        this.logiikka = new Logiikka(this.arpoja.luoSatunnainenPelitilanne(kertoja));
        this.kali = new GraafinenKayttoliittyma(this.logiikka);
        this.kali.run();
    }

    public Logiikka getLogiikka() {
        return this.logiikka;
    }
}

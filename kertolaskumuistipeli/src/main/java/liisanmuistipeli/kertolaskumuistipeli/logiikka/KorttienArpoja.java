/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.logiikka;

import liisanmuistipeli.kertolaskumuistipeli.logiikka.Kortti;
import java.util.ArrayList;
import java.util.Collections;

/**
 *Luokka luo muistipeliin kortit ja sekoittaa ne. Luokasta käsin voidaan myös luoda uusi pelitilanne arvotuilla korteilla.
 * @author liisapauliina
 */
public class KorttienArpoja {
    private Pelitilanne peli;
    private int kertoja;
    private ArrayList<Kortti> kysymysKortit;
    private ArrayList<Kortti> vastausKortit;
    /**
     * Konstuktorissa alustetaan ArrayListit.
     */
    public KorttienArpoja() {
        this.kysymysKortit = new ArrayList<Kortti>();
        this.vastausKortit = new ArrayList<Kortti>();
    }
    /**
     * Metodi luo kysymys- ja vastauskortit kysytylle kertojalle ja sekoittaa ne.
     * @param kertoja on pelaajalta kysytty luku eli kertotaulu, jota halutaan harjoitella. 
     */
    public void arvoKortit(int kertoja) {
        this.kertoja = kertoja;
        int i = 1;
        while (i < 11) {
            this.kysymysKortit.add(new Kortti(kertoja, i, 1));
            this.vastausKortit.add(new Kortti(kertoja, i, 0));
            i++;
        }
        Collections.shuffle(this.kysymysKortit);
        Collections.shuffle(this.vastausKortit);
    }
    /**
     * Metodi luo uuden Pelitilanteen.
     * @return palauttaa Pelitilanteen arvotuilla korteilla. 
     */
    public Pelitilanne luoSatunnainenPelitilanne() {
        //huom tähän alustus
     //   this.kysymysKortit = new ArrayList<Kortti>();
        this.peli = new Pelitilanne(this.kertoja, this.kysymysKortit, this.vastausKortit);
        return this.peli;
    }
}

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
 * Luokka luo muistipeliin kortit ja sekoittaa ne. Luokasta käsin voidaan myös
 * luoda uusi pelitilanne arvotuilla korteilla. Parametreina luokalla on
 * kysymys- ja vastauskortit, kertoja, joka on pelaajalta kysytty luku sekä
 * pelitilanne.
 *
 * @author liisapauliina
 */
public class KorttienArpoja {

    public KorttienArpoja() {

    }

    /**
     * Metodi luo kysymys- ja vastauskortit kysytylle kertojalle ja sekoittaa
     * ne.
     *
     * @param kertoja on pelaajalta kysytty luku eli kertotaulu, jota halutaan
     * harjoitella.
     */
    public ArrayList<Kortti> arvoVastausKortit(int kertoja) {
        int i = 1;
        ArrayList<Kortti> vastausKortit = new ArrayList<>();
        while (i < 11) {
            vastausKortit.add(new Kortti(kertoja, i, 0));
            i++;
        }
        Collections.shuffle(vastausKortit);
        return vastausKortit;
    }

    public ArrayList<Kortti> arvoKysymysKortit(int kertoja) {
        int i = 1;
        ArrayList<Kortti> kysymysKortit = new ArrayList<>();
        while (i < 11) {
            kysymysKortit.add(new Kortti(kertoja, i, 1));
            i++;
        }
        Collections.shuffle(kysymysKortit);
        return kysymysKortit;
    }

    /**
     * Metodi luo uuden Pelitilanteen.
     *
     * @return palauttaa Pelitilanteen arvotuilla korteilla.
     */
    public Pelitilanne luoSatunnainenPelitilanne(int kertoja) {

        Pelitilanne peli = new Pelitilanne(kertoja, arvoKysymysKortit(kertoja), arvoVastausKortit(kertoja));
        return peli;
    }
}

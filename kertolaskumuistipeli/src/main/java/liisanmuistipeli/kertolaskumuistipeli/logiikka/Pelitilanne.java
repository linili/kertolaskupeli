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
 * Luokka pitää yllä tietoa pelaajalta kysytystä kertojasta, kysymyskorteista ja
 * vastaukorteista.
 *
 * @author liisapauliina
 */
public class Pelitilanne {

    private ArrayList<Kortti> kysymysKortit;
    private ArrayList<Kortti> vastausKortit;
    private int kertoja;

    /**
     * Luokan konstruktorissa annetaan kertoja, kysymykset ja vastaukset.
     *
     * @param kertoja on pelaajalta kysytty kertotaulun kertoja.
     * @param kysymykset on kysymyskortit.
     * @param vastaukset on vastauskortit.
     */
    public Pelitilanne(int kertoja, ArrayList<Kortti> kysymykset, ArrayList<Kortti> vastaukset) {
        this.kertoja = kertoja;
        this.kysymysKortit = kysymykset;
        this.vastausKortit = vastaukset;

    }

    public int getKertoja() {
        return this.kertoja;
    }

    public ArrayList<Kortti> getVastaukset() {
        return this.vastausKortit;
    }

    public ArrayList<Kortti> getKysymykset() {
        return this.kysymysKortit;
    }
}

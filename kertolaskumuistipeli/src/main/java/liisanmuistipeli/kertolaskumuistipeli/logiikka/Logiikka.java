/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.logiikka;

import java.util.ArrayList;

/**
 * Luokka pävittää pelitilannetta ja kortteja.
 *
 * @author liisapauliina
 */
public class Logiikka {

    private Pelitilanne peli;
    private boolean onkoKysymystenVuoro;
    private boolean saakoJoKaantaa;

    /**
     * Konstuktorissa logiikalle annetaan pelitilanne. Pelin alussa on
     * kysymysten vuoro ja lupa kääntää kortti.
     *
     * @param peli
     */
    public Logiikka(Pelitilanne peli) {
        this.peli = peli;
        this.onkoKysymystenVuoro = true;
        this.saakoJoKaantaa = true;

    }

    /**
     * Metodi palauttaa arvona tiedon siitä, saako pelaaja jo kääntää kortin.
     *
     * @return saakoJoKaantaa on tieto siitä, saako pelaaja jo kääntää kortin.
     */
    public boolean saakoJoKaantaa() {
        return saakoJoKaantaa;
    }

    public void setSaakoJoKaantaa(boolean saakoJoKaantaa) {
        this.saakoJoKaantaa = saakoJoKaantaa;
    }

    /**
     * Metodi palauttaa tiedon siitä, onko kysymyskortin vuoro.
     *
     * @return onkoKysymystenVuoro
     */
    public boolean onkoKysymystenVuoro() {
        return this.onkoKysymystenVuoro;
    }

    /**
     * Metodi palauttaa tiedon siitä, onko kaikki kortit löydetty.
     *
     * @return true, jos kaikki löydetty, false jos ei.
     */
    public boolean onkoKaikkiLoydetty() {
        for (Kortti k : this.peli.getKysymykset()) {
            if (k.onkoLoydetty() == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodi kertoo onko peli kesken vai onko kaikki jo löydetty.
     *
     * @return true, jos kaikki kortit eivät ole löydetty ja false, jos on.
     */
    public boolean jatkuu() {
        if (onkoKaikkiLoydetty() == false) {
            return true;
        }
        return false;
    }

    /**
     * Metodi palauttaa tiedon siitä, ovatko parametrinä annetut kortit pari.
     *
     * @param k1 toinen käännetyistä korteista
     * @param k2 toinen käännetyistä korteista
     * @return tieto siitä, ovatko kortit pari.
     */
    public boolean onkoPari(Kortti k1, Kortti k2) {
        if (k1.getKerrottava() == k2.getKerrottava()) {
            return true;
        }
        return false;
    }

    /**
     * Metodi palauttaa tiedon siitä, ovatko käännetyt kortit pari
     *
     * @return tieto siitä, ovatko käännetyt kortit pari.
     */
    public boolean loytyikoPari() {
        Kortti k1 = this.getKaannettyKysymysKortti();
        Kortti k2 = this.getKaannettyVastausKortti();
        if (k1 == null | k2 == null) {
            return false;
        }
        if (k1.getKerrottava() == k2.getKerrottava()) {
            return true;
        }
        return false;
    }

    /**
     * Metodi asettaa parametrinä annetut kortit pois näkyvistä.
     *
     * @param kk on toinen käännetty kortti
     * @param kv on toinen käännetty kortti
     */
    public void piilotaKortit(Kortti kk, Kortti kv) {
        kk.piiloon();
        kv.piiloon();
    }

    /**
     * Metodi asettaa parametrinä annetut kortit löydetyiksi.
     *
     * @param kk on toinen käännetty kortti
     * @param kv on toinen käännetty kortti
     */
    public void poistaKortit(Kortti kk, Kortti kv) {
        kk.poistaPoydalta();
        kv.poistaPoydalta();

    }

    /**
     * Metodi palauttaa tiedon siitä, onko kaksi korttia käännettynä vai ei.
     *
     * @return tieto siitä, onko kaksi korttia käännettynä
     */
    public boolean onkoKaksiKaannettyna() {
        for (Kortti k : this.peli.getVastaukset()) {
            if (k.onkoKaannetty()) {
                return true;
            }
        }
        return false;
    }

    public Pelitilanne getPelitilanne() {
        return this.peli;
    }

    public Kortti getKaannettyKysymysKortti() {
        Kortti kaannetty = null;
        for (Kortti k : this.getPelitilanne().getKysymykset()) {
            if (k.onkoKaannetty()) {
                kaannetty = k;
            }
        }
        return kaannetty;
    }

    public Kortti getKaannettyVastausKortti() {
        Kortti kaannetty = null;
        for (Kortti k : this.getPelitilanne().getVastaukset()) {
            if (k.onkoKaannetty()) {
                kaannetty = k;
            }
        }
        return kaannetty;
    }

    /**
     * Metodi asettaa näkyviin kortin paikasta paikka, jos on kysymysten vuoro
     * ja jos kortti ei ole jo löydetty. Samalla asetetaan, että ei ole
     * kysymysten vuoro.
     *
     * @param paikka on kysymyskortin paikka pöydällä
     */
    public void valitseKysymyskortti(int paikka) {
        if (this.onkoKysymystenVuoro) {
            if (this.peli.getKysymykset().get(paikka).onkoLoydetty()) {
                return;
            }
            this.peli.getKysymykset().get(paikka).nayta();
            this.onkoKysymystenVuoro = false;
        }
    }

    /**
     * Metodi asettaa näkyviin vastauskortin paikasta i, jos on vastaukortin
     * vuoro ja kortti ei ole jo löydetty. Samalla asetetaan, että on kysymysten
     * vuoro.
     *
     * @param i on vastauskortin paikka pöydällä
     */
    public void valitseVastauskortti(int i) {
        if (!this.onkoKysymystenVuoro) {
            if (this.peli.getVastaukset().get(i).onkoLoydetty()) {
                return;
            }
            this.peli.getVastaukset().get(i).nayta();
            this.onkoKysymystenVuoro = true;
        }
    }
}

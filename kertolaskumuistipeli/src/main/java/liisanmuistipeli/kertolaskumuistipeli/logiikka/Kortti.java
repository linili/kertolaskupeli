/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.logiikka;

/**
 * Luokka kuvaa yhtä muistipelin korttia. Kortilla on parametreina tiedot siitä,
 * onko kortti löydetty tai käännetty näkyviin. Lisäksi kortilla on kertoja,
 * joka on sama tietyn pelin korteilla. Kortilla on myös kerrottava, joka on
 * muistipelin pareilla sama. Tyyppi on 0, jos kortti on vastauskortti ja 1, jos
 * se on kysymyskortti.
 *
 * @author liisapauliina
 */
public class Kortti {

    private boolean loydetty;
    private boolean kaannetty;
    private int kertoja;
    private int kerrottava;
    private int tyyppi;

    /**
     * Kostruktorissa alustetaan kortin kertoja, kerrottava ja tyyppi. Alussa
     * kortti on väärinpäin ja löytämättä.
     *
     * @param kertoja on pelaajalta saatu luku (1-9)
     * @param kerrottava on parin identifioiva luku
     * @param tyyppi kertoo onko vastaus (0) vai kysymys (1).
     */
    public Kortti(int kertoja, int kerrottava, int tyyppi) {
        this.kertoja = kertoja;
        this.kerrottava = kerrottava;
        this.tyyppi = tyyppi;
        this.loydetty = false;
        this.kaannetty = false;
    }

    public int getKertoja() {
        return this.kertoja;
    }

    public int getKerrottava() {
        return this.kerrottava;
    }

    public int getTyyppi() {
        return this.tyyppi;
    }

    /**
     * Metodi asettaa kortin näkyviin.
     */
    public void nayta() {
        kaannetty = true;
    }

    /**
     * Metodi asettaa kortin löydetyksi ja asettaa käännetyn arvoksi false.
     */
    public void poistaPoydalta() {
        loydetty = true;
        this.kaannetty = false;
    }

    /**
     * Metodi asettaa kortin pois näkyvistä
     */
    public void piiloon() {
        kaannetty = false;
    }

    /**
     * Metodi palauttaa tiedon siitä, onko kortti käännettynä. Käännetty
     * tarkoittaa tässä sitä, onko kortti valittuna yhden vuoron aikana.
     *
     * @return kaannetty eli tieto siitä, onko kortti valittuna.
     */
    public boolean onkoKaannetty() {
        return kaannetty;
    }

    /**
     * Metodi palauttaa tiedon siitä, onko kortti jo löydetty
     *
     * @return löydetty, eli tieto siitä onko kortti löydetty
     */
    public boolean onkoLoydetty() {
        return loydetty;
    }

    @Override
    public String toString() {

        if (this.kaannetty || this.loydetty) {

            if (this.tyyppi == 0) {

                return Integer.toString(this.kerrottava * this.kertoja);
            }
            if (this.tyyppi == 1) {
                return Integer.toString(this.kertoja) + "x" + Integer.toString(this.kerrottava);
            }
        }
        return "XXX";
    }

}

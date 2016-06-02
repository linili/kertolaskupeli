/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.kayttoliittyma;

import java.util.Scanner;
import liisanmuistipeli.kertolaskumuistipeli.objektit.Pelilauta;

/**
 *
 * @author liisapauliina
 */
public class Peli {

    private Scanner lukija;
    private Pelilauta lauta;

    public Peli() {
        this.lukija = new Scanner(System.in);
    }

    public void kaynnista() {
        System.out.println("Valitse kertotaulu");
        int vastaus = lukija.nextInt();
        this.lauta = new Pelilauta(vastaus);

        while (this.lauta.jatkuu()) {
            pelaa();
        }
        System.out.println("Peli loppui");
    }

    public void pelaa() {
        this.lauta.tulostaKortit();
        System.out.println("Valitse kysymyskortti (Syötä numero 0-9");
        int v1 = lukija.nextInt();
        this.lauta.valitseKysymyskortti(v1);
        this.lauta.tulostaKortit();
        System.out.println("Valitse vastauskortti (Syötä numero 0-9");
        int v2 = lukija.nextInt();
        this.lauta.valitseVastauskortti(v2);
        this.lauta.tulostaKortit();
        if (this.lauta.onkoPari(v1, v2)) {
            this.lauta.poistaKortit(v1, v2);
        } else {
            this.lauta.piilotaKortit(v1, v2);
        }
    }
}

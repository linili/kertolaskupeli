/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * Ajastin pysäyttää pelin, kun paria ei löydetty. Kun ajastin loppuu, kortit
 * käännetään pois näkyvistä ja käyttöliittymää pyydetään päivittämään kortit.
 *
 * @author liisapauliina
 */
public class Ajastin extends Timer implements ActionListener {

    private GraafinenKayttoliittyma kali;

    /**
     * Konstruktorissa asetetaan aika, joksi peli pysähtyy.
     *
     * @param aika on aika joksi aikaa ajastin pysäyttää pelin.
     * @param kali on pelin käyttöliittymä
     */
    public Ajastin(int aika, GraafinenKayttoliittyma kali) {
        super(aika, null);
        this.addActionListener(this);
        this.kali = kali;
        this.setRepeats(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (kali.getLogiikka().getKaannettyKysymysKortti() != null && kali.getLogiikka().getKaannettyVastausKortti() != null) {
            kali.getLogiikka().getKaannettyKysymysKortti().piiloon();
            kali.getLogiikka().getKaannettyVastausKortti().piiloon();
            kali.paivitaKortit();
        }
        kali.getLogiikka().setSaakoJoKaantaa(true);
    }

}

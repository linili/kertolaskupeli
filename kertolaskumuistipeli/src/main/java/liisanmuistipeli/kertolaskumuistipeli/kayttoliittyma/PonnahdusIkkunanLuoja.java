/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.kayttoliittyma;

import javax.swing.*;

/**
 * Luokka tekee ponnahdusikkunan, jossa pelaajalta kysytään kysymyksiä.
 *
 * @author liisapauliina
 */
public class PonnahdusIkkunanLuoja {

    /**
     * Metodi tekee ponnahdusikkunan, jossa kysytään parametrinä annettava
     * kysymys. Pelaajan täytyy vastata kysymykseen, jotta ikkuna katoaa. Metodi
     * palauttaa pelaajan vastauksen.
     *
     * @param kysymys on kysymys, joka pelaajalta halutaan kysyä.
     * @return pelaajan antama vastaus
     */
    public static String kysy(String kysymys) {
        String vastaus = null;
        while (vastaus == null) {
            try {
                vastaus = JOptionPane.showInputDialog(kysymys);
            } catch (Exception e) {
            }
        }
        return vastaus;
    }

    /**
     * Metodi tekee ponnahdusikkunan, jossa pyydetään pelaajalta lukua 1-9,
     * jonka kertotaulua halutaan harjoitella. Metodi tekee uuden
     * ponnahdusikkunan, kunnes pelaajan vastaus on luku väiltä 1-9. Metodi
     * palauttaa pelaajan vastauksen.
     *
     * @param kysymys on kysymys, joka pelaajalle esitetään.
     * @return luku on pelaajan antama vastaus.
     */
    public static int kysyKertoja(String kysymys) {
        String tarjottuArvo;
        int luku = 1;
        boolean tarjottuArvoOnKokonaisluku = false;
        while (!tarjottuArvoOnKokonaisluku) {
            try {
                tarjottuArvo = JOptionPane.showInputDialog(kysymys);
                luku = Integer.parseInt(tarjottuArvo);
                tarjottuArvoOnKokonaisluku = true;
            } catch (Exception e) {
            }
        }
        return luku;
    }

}

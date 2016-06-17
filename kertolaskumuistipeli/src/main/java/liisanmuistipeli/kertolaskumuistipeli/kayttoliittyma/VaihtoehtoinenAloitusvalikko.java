/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.kayttoliittyma;

import javax.swing.*;

/**
 *
 * @author liisapauliina
 */
public class VaihtoehtoinenAloitusvalikko {

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

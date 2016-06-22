/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.main;

import liisanmuistipeli.kertolaskumuistipeli.kayttoliittyma.PelinAloittaja;

/**
 *
 * @author liisapauliina
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        PelinAloittaja aloittaja = new PelinAloittaja();
        aloittaja.teeUusiPeli(aloittaja.kysyKertoja());
    }

}

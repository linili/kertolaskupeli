/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.kayttoliittyma;

import java.util.ArrayList;
import liisanmuistipeli.kertolaskumuistipeli.objektit.Kortti;

/**
 *
 * @author liisapauliina
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Kortti> kyssarit = new ArrayList<>();
        kyssarit.add(new Kortti(4,3,1));
        kyssarit.add(new Kortti (4,5,1));
        ArrayList<Kortti> vastaukset = new ArrayList<>();
        vastaukset.add(new Kortti(2,2,0));
        vastaukset.add(new Kortti(3,2,0));
       // Aloitusvalikko valikko = new Aloitusvalikko();
       // valikko.run();
         GraafinenKayttoliittyma kl = new GraafinenKayttoliittyma();
         kl.run();
       // Peli peli = new Peli();
       // peli.kaynnista();
    }
    
}

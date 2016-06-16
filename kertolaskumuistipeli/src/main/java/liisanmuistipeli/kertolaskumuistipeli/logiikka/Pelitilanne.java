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
 *
 * @author liisapauliina
 */
public class Pelitilanne {

    private ArrayList<Kortti> kysymysKortit;
    private ArrayList<Kortti> vastausKortit;
    private int kertoja;

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

    
    
   

    

    

//    public void tulostaKortit() {
//        System.out.println("--------");
//        for (Kortti kk : this.kysymysKortit) {
//            System.out.println(kk);
//        }
//        System.out.println("");
//
//        for (Kortti kv : this.vastausKortit) {
//            System.out.println(kv);
//        }
//        System.out.println("");
//        System.out.println("--------");
//        System.out.println("");
//    }


  
}

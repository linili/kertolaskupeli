/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.objektit;

import java.util.ArrayList;


/**
 *
 * @author liisapauliina
 */
public class Pelilauta {
    private ArrayList<Kortti> kysymysKortit;
    private ArrayList<Kortti> vastausKortit;
    private int kertoja;
    
    public Pelilauta(int kertoja) {
        this.kertoja = kertoja;
        kysymysKortit = new ArrayList<Kortti>();
        vastausKortit = new ArrayList<Kortti>();
        int i = 1;
        while (i<11) {
            this.kysymysKortit.add(new Kortti(kertoja, i, 1));
            this.vastausKortit.add(new Kortti(kertoja, i, 0));
            i++;
        }
        
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

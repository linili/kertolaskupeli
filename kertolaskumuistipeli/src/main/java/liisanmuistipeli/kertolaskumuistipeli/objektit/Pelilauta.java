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
    
    public Pelilauta(int kertoja) {
        kysymysKortit = new ArrayList<>();
        vastausKortit = new ArrayList<>();
    }
}

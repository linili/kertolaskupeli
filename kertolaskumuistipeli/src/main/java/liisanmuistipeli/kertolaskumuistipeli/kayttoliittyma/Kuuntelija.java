/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import liisanmuistipeli.kertolaskumuistipeli.objektit.Kortti;
import liisanmuistipeli.kertolaskumuistipeli.objektit.Pelilauta;

/**
 *
 * @author liisapauliina
 */
public class Kuuntelija implements ActionListener {
private Pelilauta peli;

public Kuuntelija(Pelilauta peli) {
    this.peli = peli;
}
    @Override
    public void actionPerformed(ActionEvent e) {
    Kortti k = (Kortti) e.getSource();
    this.peli.valitse(k);
    k.setText(k.toString());
         
        
       // e.getSource()
    
    
}
}
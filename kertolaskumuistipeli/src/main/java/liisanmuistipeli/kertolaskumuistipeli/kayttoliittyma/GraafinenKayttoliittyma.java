/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import liisanmuistipeli.kertolaskumuistipeli.objektit.Kortti;
import liisanmuistipeli.kertolaskumuistipeli.objektit.Pelilauta;

/**
 *
 * @author liisapauliina
 */

/**
 * Luokka luo ikkunan, jossa pelinaloitusvalikko, asettaa kortit esille ja käynnistää pelin
 * @author liisapauliina
 */
public class GraafinenKayttoliittyma extends JPanel implements Runnable {

    private JFrame ikkuna;
    private ArrayList<Kortti> kysymyskortit;
    private ArrayList<Kortti> vastauskortit;
    private Container kysymyslaatikko;
    private Container vastauslaatikko;
    private Pelilauta peli;

    public GraafinenKayttoliittyma() {
        kysyKertoja();
    }

    @Override
    public void run() {
        ikkuna = new JFrame("Kertolaskumuistipeli");
        ikkuna.setPreferredSize(new Dimension(600, 400));
        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.lisaaKomponentit(ikkuna.getContentPane());
        ikkuna.pack();
        ikkuna.setVisible(true);
    }
/**
 * Metodi, joka tekee ponnahdusikkunan, joka kysyy minkä kertotaulun muistipeli luodaan. 
 */
    public void kysyKertoja() {
        int kertoja = VaihtoehtoinenAloitusvalikko.kysyKertoja("Syötä kertotaulu (1-9) ");
        while (kertoja < 1 || kertoja > 9) {
            kertoja = VaihtoehtoinenAloitusvalikko.kysyKertoja("Syötä kertotaulu väliltä 1-9 ");
        }
        teePeli(kertoja);
    }
/**
 * Metodi, joka asettaa kortit esille
 * @param container on laatikko, johon kortit asetetaan. 
 */
    public void lisaaKomponentit(Container container) {
        this.kysymyslaatikko = container;
        Kuuntelija kuuntelija = new Kuuntelija(this.peli);
        //   Container kysymykset = new Container();
        //   Container vastaukset = new Container();
        // Kortti k = new Kortti(1,2,0);
        GridLayout gl = new GridLayout(2, 0);

        ikkuna.getContentPane().setLayout(gl);
        for (Kortti kortti : kysymyskortit) {
            kortti.addActionListener(kuuntelija);
            kortti.setText(kortti.toString());
            ikkuna.getContentPane().add(kortti);

        }
        for (Kortti k : vastauskortit) {
            k.addActionListener(kuuntelija);
            k.setText(k.toString());
            ikkuna.getContentPane().add(k);
        }

    }
/**
 * Metodi luo uuden pelilaudan ja asettaa kysymykset ja vastaukset.
 * @param kertoja on käyttäjältä kysytty kertotaulun kertoja.
 */
    public void teePeli(int kertoja) {
        this.peli = new Pelilauta(kertoja);
        this.kysymyskortit = this.peli.getKysymykset();
        this.vastauskortit = this.peli.getVastaukset();
    }

}

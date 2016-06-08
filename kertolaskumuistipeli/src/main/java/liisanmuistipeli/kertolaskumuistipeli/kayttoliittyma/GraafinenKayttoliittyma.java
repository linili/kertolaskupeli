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

/**
 *
 * @author liisapauliina
 */
public class GraafinenKayttoliittyma extends JPanel implements Runnable {
private JFrame ikkuna;
private ArrayList<Kortti> kysymyskortit;
private ArrayList<Kortti> vastauskortit;
private Container kysymyslaatikko;
private Container vastauslaatikko;

    public GraafinenKayttoliittyma(ArrayList<Kortti> kysymyskortit, ArrayList<Kortti> vastauskortit) {
        this.kysymyskortit = kysymyskortit;
        this.vastauskortit = vastauskortit;
       
    }


    @Override
    public void run() {
        ikkuna = new JFrame("Kertolaskumuistipeli");
        ikkuna.setPreferredSize(new Dimension(600,400));
        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.lisaaKomponentit(ikkuna.getContentPane());
        ikkuna.pack();
        ikkuna.setVisible(true);
    }
    public void lisaaKomponentit(Container container) {
        this.kysymyslaatikko = container;
        Kuuntelija kuuntelija = new Kuuntelija();
     //   Container kysymykset = new Container();
     //   Container vastaukset = new Container();
        // Kortti k = new Kortti(1,2,0);
        GridLayout gl = new GridLayout(2,0);
       
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
    
    private void lisaaKortti(Kortti k) {
    
    }
}

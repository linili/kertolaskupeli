/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.objektit;

import java.util.*;
import javax.swing.JButton;

/**
 *
 * @author liisapauliina
 */
public class Kortti extends JButton {

    private boolean loydetty;
    private boolean kaannetty;
    private int kertoja;
    private int kerrottava;
    private int tyyppi;

    public Kortti(int kertoja, int kerrottava, int tyyppi) {
        this.kertoja = kertoja;
        this.kerrottava = kerrottava;
        this.tyyppi = tyyppi;
        this.loydetty = false;
        this.kaannetty = false;
    }

    public int getKertoja() {
        return this.kertoja;
    }

    public int getKerrottava() {
        return this.kerrottava;
    }

    public int getTyyppi() {
        return this.tyyppi;
    }

    public void kaanna() {
        kaannetty = true;
    }

    public void poistaPoydalta() {
        loydetty = true;
        this.kaannetty = false;
    }

    public void piiloon() {
        kaannetty = false;
    }

    public boolean onkoKaannetty() {
        return kaannetty;
    }

    public boolean onkoLoydetty() {
        return loydetty;
    }

    @Override
    public String toString() {
       
        if (this.kaannetty || this.loydetty) {

            if (this.tyyppi == 0) {
                return Integer.toString(this.kerrottava * this.kertoja);
            }
            if (this.tyyppi == 1) {
                return Integer.toString(this.kertoja) + "x" + Integer.toString(this.kerrottava);
            }
        }
        return "XXX";
    }

}

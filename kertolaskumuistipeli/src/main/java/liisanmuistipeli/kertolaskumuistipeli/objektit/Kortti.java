/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.objektit;

/**
 *
 * @author liisapauliina
 */
public class Kortti {
    private boolean loydetty;
    private boolean kaannetty;
    private int kertoja;
    private int kerrottava;
    private int tyyppi;
    
    public Kortti(int kertoja, int kerrottava, int tyyppi) {
        this.kertoja = kertoja;
        this.kerrottava = kerrottava;
        this.tyyppi = tyyppi;
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

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.objektit;

import java.util.ArrayList;
import java.util.Collections;

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
        while (i < 11) {
            this.kysymysKortit.add(new Kortti(kertoja, i, 1));
            this.vastausKortit.add(new Kortti(kertoja, i, 0));
            i++;
        }
        Collections.shuffle(this.kysymysKortit);
        Collections.shuffle(this.vastausKortit);
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
//Lisää ehto : älä käännä, jos joku käännetty. Älä käännä, jos ei ole kysymysten vuoro.

    public void valitseKysymyskortti(int i) {
        if (i < 0 || i > 9) {
            System.out.println("Ei kelpaa!");
            return;
        }
        if (this.kysymysKortit.get(i).onkoLoydetty()) {
            return;
        }
        for (Kortti kortti : this.kysymysKortit) {
            if (kortti.onkoKaannetty()) {
                System.out.println("ei voi kääntää");
                return;
            }
        }
        this.kysymysKortit.get(i).kaanna();
    }

    public void valitseVastauskortti(int i) {
        if (i < 0 || i > 9) {
            System.out.println("Ei kelpaa!");
            return;
        }
        if (this.vastausKortit.get(i).onkoLoydetty()) {
            return;
        }
        for (Kortti kortti : this.vastausKortit) {
            if (kortti.onkoKaannetty()) {
                System.out.println("ei voi kääntää");
            }
        }
        this.vastausKortit.get(i).kaanna();
    }

    public boolean onkoPari(int v1, int v2) {
        if (this.kysymysKortit.get(v1).getKerrottava() == this.vastausKortit.get(v2).getKerrottava()) {
            return true;
        }
//        Kortti valittu1 = null;
//        Kortti valittu2 = null;
//        for (Kortti kk : this.kysymysKortit) {
//            if (kk.onkoKaannetty()) {
//                valittu1 = kk;
//            }
//        }
//        for (Kortti kv : this.vastausKortit) {
//            if (kv.onkoKaannetty()) {
//                valittu2 = kv;
//            }
//        }
//        if (valittu1.getKerrottava() == valittu2.getKerrottava()) {
//            return true;
//        }
        return false;
    }

    public boolean onkoKaikkiLoydetty() {
        for (Kortti k : this.kysymysKortit) {
            if (k.onkoLoydetty() == false) {
                return false;
            }
        }
        return true;
    }

    public void tulostaKortit() {
        System.out.println("--------");
        for (Kortti kk : this.kysymysKortit) {
            System.out.println(kk);
        }
        System.out.println("");

        for (Kortti kv : this.vastausKortit) {
            System.out.println(kv);
        }
        System.out.println("");
        System.out.println("--------");
        System.out.println("");
    }

    public boolean jatkuu() {
        if (onkoKaikkiLoydetty() == false) {
            return true;
        }
        return false;
    }

    public void piilotaKortit(int v1, int v2) {
        this.kysymysKortit.get(v1).piiloon();
        this.vastausKortit.get(v2).piiloon();
    }

    public void poistaKortit(int v1, int v2) {
        this.kysymysKortit.get(v1).poistaPoydalta();
        this.vastausKortit.get(v2).poistaPoydalta();
    }
}

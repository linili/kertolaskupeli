/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.logiikka;

import java.util.ArrayList;

/**
 *
 * @author liisapauliina
 */
public class Logiikka {

    private Pelitilanne peli;
    private boolean onkoKysymystenVuoro;
    private boolean saakoJoKaantaa;

    public Logiikka(Pelitilanne peli) {
        this.peli = peli;
        this.onkoKysymystenVuoro = true;
        this.saakoJoKaantaa = true;

    }

    public boolean SaakoJoKaantaa() {
        return saakoJoKaantaa;
    }

    public void setSaakoJoKaantaa(boolean saakoJoKaantaa) {
        this.saakoJoKaantaa = saakoJoKaantaa;
    }

    
    
    public boolean onkoKysymystenVuoro() {
        return this.onkoKysymystenVuoro;
    }

    public boolean onkoKaikkiLoydetty() {
        for (Kortti k : this.peli.getKysymykset()) {
            if (k.onkoLoydetty() == false) {
                return false;
            }
        }
        return true;
    }

    public boolean jatkuu() {
        if (onkoKaikkiLoydetty() == false) {
            return true;
        }
        return false;
    }

    public boolean onkoPari(Kortti k1, Kortti k2) {
        if (k1.getKerrottava() == k2.getKerrottava()) {
            return true;
        }
        return false;
    }

    public boolean loytyikoPari() {
        Kortti k1 = this.getKaannettyKysymysKortti();
        Kortti k2 = this.getKaannettyVastausKortti();
        if (k1 == null | k2 == null) {
            return false;
        }
        if (k1.getKerrottava() == k2.getKerrottava()) {
            return true;
        }
        return false;
    }

    public void piilotaKortit(Kortti kk, Kortti kv) {
        kk.piiloon();
        kv.piiloon();
    }

    public void poistaKortit(Kortti kk, Kortti kv) {
        kk.poistaPoydalta();
        kv.poistaPoydalta();

    }

    public boolean onkoKaksiKaannettyna() {
        for (Kortti k : this.peli.getVastaukset()) {
            if (k.onkoKaannetty()) {
                return true;
            }
        }
        return false;
    }

    public Pelitilanne getPelitilanne() {
        return this.peli;
    }

    public Kortti getKaannettyKysymysKortti() {
        Kortti kaannetty = null;
        for (Kortti k : this.getPelitilanne().getKysymykset()) {
            if (k.onkoKaannetty()) {
                kaannetty = k;
            }
        }
        return kaannetty;
    }

    public Kortti getKaannettyVastausKortti() {
        Kortti kaannetty = null;
        for (Kortti k : this.getPelitilanne().getVastaukset()) {
            if (k.onkoKaannetty()) {
                kaannetty = k;
            }
        }
        return kaannetty;
    }

    public void valitseKysymyskortti(int paikka) {
        if (this.onkoKysymystenVuoro) {
//            for (Kortti kortti : this.peli.getKysymykset()) {
//                if (kortti.onkoKaannetty()) {
//                    System.out.println("ei voi kääntää");
//                    return;
//                }
//            }
            if (this.peli.getKysymykset().get(paikka).onkoLoydetty()) {
                System.out.println("tämä kortti on jo löydetty");
                return;
            }
            this.peli.getKysymykset().get(paikka).nayta();
            this.onkoKysymystenVuoro = false;
        } else {
            System.out.println("valitse vastauskortti");
        }
    }

    public void valitseVastauskortti(int i) {
        if (!this.onkoKysymystenVuoro) {
//            for (Kortti kortti : this.peli.getVastaukset()) {
//                if (kortti.onkoKaannetty()) {
//                    System.out.println("ei voi kääntää");
//                    return;
//                }
//            }
            if (this.peli.getVastaukset().get(i).onkoLoydetty()) {
                System.out.println("tämä kortti on jo löydetty");
                return;
            }
            this.peli.getVastaukset().get(i).nayta();
            System.out.println(this.peli.getVastaukset().get(i));
            this.onkoKysymystenVuoro = true;
        } else {
            System.out.println("valitse kysymyskortti");
        }
    }

}

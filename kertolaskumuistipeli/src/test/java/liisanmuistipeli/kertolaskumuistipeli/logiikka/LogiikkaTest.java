/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.logiikka;

import liisanmuistipeli.kertolaskumuistipeli.objektit.Kortti;
import liisanmuistipeli.kertolaskumuistipeli.objektit.Pelitilanne;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author liisapauliina
 */
public class LogiikkaTest {
    Logiikka logiikka;
    Pelitilanne peli;
    
    public LogiikkaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.peli = new Pelitilanne(6);
        this.logiikka = new Logiikka(this.peli);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void kaantaaOikeanKysymyskortin() {
        logiikka.valitsekortti(this.peli.getKysymykset().get(0));
        assertEquals(this.peli.getKysymykset().get(0).onkoKaannetty(), true);
    }

//    @Test
//    public void eiKaannaJosKysymyskorttiKaannetty() {
//        p.valitseKysymyskortti(4);
//        p.valitseKysymyskortti(3);
//        assertEquals(p.getKysymykset().get(3).onkoKaannetty(), false);
//    }
//
//    @Test
//    public void eiKaannaJosVastauskorttiKaannetty() {
//        p.valitseVastauskortti(4);
//        p.valitseVastauskortti(3);
//        assertEquals(p.getKysymykset().get(3).onkoKaannetty(), false);
//    }
//
//    @Test
//    public void eiKaannaJosKysymyskorttiLoydetty() {
//        p.getKysymykset().get(3).poistaPoydalta();
//        p.valitseKysymyskortti(3);
//        assertEquals(p.getKysymykset().get(3).onkoKaannetty(), false);
//    }
//
//    @Test
//    public void eiKaannaJosVastauskorttiLoydetty() {
//        p.getVastaukset().get(3).poistaPoydalta();
//        p.valitseVastauskortti(3);
//        assertEquals(p.getVastaukset().get(3).onkoKaannetty(), false);
//    }
//
//    @Test
//    public void kaantaaOikeanVastaukortin() {
//        p.valitseVastauskortti(4);
//        assertEquals(p.getVastaukset().get(4).onkoKaannetty(), true);
//    }
//
//    @Test
//    public void PiilottaakoKortit() {
//        p.piilotaKortit(0, 1);
//        assertEquals(p.getKysymykset().get(0).onkoKaannetty(), false);
//        assertEquals(p.getVastaukset().get(1).onkoKaannetty(), false);
//    }
//
//    @Test
//    public void PoistaakoKortit() {
//        p.poistaKortit(0, 1);
//        assertEquals(p.getKysymykset().get(0).onkoLoydetty(), true);
//        assertEquals(p.getVastaukset().get(1).onkoLoydetty(), true);
//    }
//
//    @Test
//    public void eiKaannaVaarallaIndeksillaKysymysKorttia() {
//        p.valitseKysymyskortti(11);
//        p.valitseKysymyskortti(6);
//        assertEquals(p.getKysymykset().get(6).onkoKaannetty(), true);
//    }
//
//    @Test
//    public void eiKaannaVaarallaIndeksillaVastausKorttia() {
//        p.valitseVastauskortti(11);
//        p.valitseVastauskortti(6);
//        assertEquals(p.getVastaukset().get(6).onkoKaannetty(), true);
//    }
//
//    @Test
//    public void parittaaOikein() {
//        int i = p.getKysymykset().get(0).getKerrottava();
//        int laskuri = 0;
//        for (Kortti k : p.getVastaukset()) {
//
//            if (k.getKerrottava() == i) {
//                assertEquals(p.onkoPari(0, laskuri), true);
//            } else {
//                assertEquals(p.onkoPari(0, laskuri), false);
//            }
//            laskuri++;
//        }
//    }
//
//    @Test
//    public void jatkaakoKunYksiLoydetty() {
//        for (int i = 0; i < 10; i++) {
//            if (p.onkoPari(0, i)) {
//                assertEquals(p.jatkuu(), true);
//            }
//        }
//    }
//    
//    @Test
//    public void jatkaakoKunKaikkiLoydetty() {
//        for (Kortti k : p.getKysymykset()) {
//        k.poistaPoydalta();
//        }
//        for (Kortti kv : p.getVastaukset()) {
//            kv.poistaPoydalta();
//        }
//        assertEquals(p.jatkuu(), false);
//    }
//    @Test
//    public void tulostaakoOikein() {
//        p.getKysymykset().get(1).kaanna();
//        String tulostus = Integer.toString(p.getKysymykset().get(1).getKertoja())+ "x" + Integer.toString(p.getKysymykset().get(1).getKerrottava());
//        assertEquals(p.getKysymykset().get(1).toString(), tulostus);
//        
//        assertEquals(p.getVastaukset().get(2).toString(), "XXX");
//        assertEquals(p.getKysymykset().get(2).toString(), "XXX");
//        
//        }
//    @Test
//    public void piilottaakoKortit() {
//        p.piilotaKortit(2, 3);
//        assertEquals(p.getKysymykset().get(2).onkoKaannetty(), false);
//        assertEquals(p.getVastaukset().get(3).onkoKaannetty(), false);
//    }
//    }


}

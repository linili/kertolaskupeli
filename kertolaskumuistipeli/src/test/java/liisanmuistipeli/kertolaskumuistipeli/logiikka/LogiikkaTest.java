/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.logiikka;

import java.util.ArrayList;
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
        ArrayList<Kortti> kysymykset = new ArrayList<>();
        ArrayList<Kortti> vastaukset = new ArrayList<>();
        kysymykset.add(new Kortti(5, 5, 1));
        kysymykset.add(new Kortti(5, 4, 1));
        vastaukset.add(new Kortti(5, 5, 0));
        vastaukset.add(new Kortti(5, 4, 0));
        this.peli = new Pelitilanne(5, kysymykset, vastaukset);
        this.logiikka = new Logiikka(this.peli);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void kaantaaOikeanKysymyskortin() {
        logiikka.valitseKysymyskortti(0);
        assertEquals(this.peli.getKysymykset().get(0).onkoKaannetty(), true);
    }

    @Test
    public void eiKaannaJosKysymyskorttiKaannetty() {
        this.logiikka.valitseKysymyskortti(0);
        this.logiikka.valitseKysymyskortti(1);
        assertEquals(this.logiikka.getPelitilanne().getKysymykset().get(1).onkoKaannetty(), false);
    }

    @Test
    public void eiKaannaJosVastauskorttiKaannetty() {
        this.logiikka.valitseVastauskortti(0);
        this.logiikka.valitseVastauskortti(1);
        assertEquals(this.logiikka.getPelitilanne().getKysymykset().get(1).onkoKaannetty(), false);
    }

    @Test
    public void eiKaannaJosKysymyskorttiLoydetty() {
        this.logiikka.getPelitilanne().getKysymykset().get(1).poistaPoydalta();
        this.logiikka.valitseKysymyskortti(1);
        assertEquals(this.logiikka.getPelitilanne().getKysymykset().get(1).onkoKaannetty(), false);
    }

    @Test
    public void eiKaannaJosVastauskorttiLoydetty() {
        this.logiikka.getPelitilanne().getVastaukset().get(1).poistaPoydalta();
        this.logiikka.valitseVastauskortti(1);
        assertEquals(this.logiikka.getPelitilanne().getVastaukset().get(1).onkoKaannetty(), false);
    }

    @Test
    public void kaantaaOikeanVastaukortin() {
        this.logiikka.valitseKysymyskortti(0);
        this.logiikka.valitseVastauskortti(1);
        assertEquals(this.peli.getVastaukset().get(1).onkoKaannetty(), true);
    }

    @Test
    public void PiilottaakoKortit() {
        this.logiikka.valitseKysymyskortti(0);
        this.logiikka.valitseVastauskortti(1);
        this.logiikka.piilotaKortit(this.peli.getKysymykset().get(0), this.peli.getVastaukset().get(1));
        assertEquals(this.peli.getKysymykset().get(0).onkoKaannetty(), false);
        assertEquals(this.peli.getVastaukset().get(1).onkoKaannetty(), false);
    }

    @Test
    public void PoistaakoKortit() {
        this.logiikka.valitseKysymyskortti(1);
        this.logiikka.valitseVastauskortti(1);
        this.logiikka.poistaKortit(this.peli.getKysymykset().get(1), this.peli.getVastaukset().get(1));
        assertEquals(this.peli.getKysymykset().get(1).onkoLoydetty(), true);
        assertEquals(this.peli.getVastaukset().get(1).onkoLoydetty(), true);
    }

    @Test
    public void parittaaOikein() {
        this.logiikka.valitseKysymyskortti(0);
        this.logiikka.valitseVastauskortti(0);
        assertEquals(this.logiikka.onkoPari(this.peli.getKysymykset().get(0), this.peli.getVastaukset().get(0)), true);
    }

    @Test
    public void eiParitaKunEiPari() {
        this.logiikka.valitseKysymyskortti(0);
        this.logiikka.valitseVastauskortti(1);
        assertEquals(this.logiikka.onkoPari(this.peli.getKysymykset().get(0), this.peli.getVastaukset().get(1)), false);

    }

    @Test
    public void jatkaakoKunYksiLoydetty() {
        this.peli.getKysymykset().get(0).poistaPoydalta();
        this.peli.getVastaukset().get(0).poistaPoydalta();
        assertEquals(this.logiikka.jatkuu(), true);
    }

    @Test
    public void jatkaakoKunKaikkiLoydetty() {
        for (Kortti k : this.peli.getKysymykset()) {
            k.poistaPoydalta();
        }
        for (Kortti kv : this.peli.getVastaukset()) {
            kv.poistaPoydalta();
        }
        assertEquals(this.logiikka.jatkuu(), false);
    }

    @Test
    public void tulostaakoOikeinNaytettavan() {
        this.peli.getKysymykset().get(1).nayta();
        String tulostus = Integer.toString(this.peli.getKysymykset().get(1).getKertoja()) + "x" + Integer.toString(this.peli.getKysymykset().get(1).getKerrottava());
        assertEquals(this.peli.getKysymykset().get(1).toString(), tulostus);
    }

    @Test
    public void tulostaakoOikeinPiilotetun() {
        this.peli.getVastaukset().get(0).piiloon();
        assertEquals(this.peli.getVastaukset().get(0).toString(), "XXX");

    }

    @Test
    public void loytaakoKaannetynKysymyskortin() {
        this.logiikka.valitseKysymyskortti(0);
        assertEquals(this.logiikka.getKaannettyKysymysKortti(), this.peli.getKysymykset().get(0));
    }

    @Test
    public void palauttaaTyhjanKunEiKaannettyaKysymysta() {
        assertEquals(this.logiikka.getKaannettyKysymysKortti(), null);
    }

    @Test
    public void loytaakoKaannetynVastauskortin() {
        this.logiikka.valitseKysymyskortti(0);
        this.logiikka.valitseVastauskortti(0);
        assertEquals(this.logiikka.getKaannettyVastausKortti(), this.peli.getVastaukset().get(0));
    }

    @Test
    public void palauttaaTyhjanKunEiKaannettyaVastausta() {
        assertEquals(this.logiikka.getKaannettyVastausKortti(), null);
    }

    @Test
    public void palauttaakkoOikeinKunKaksiKaannettya() {
        this.logiikka.valitseKysymyskortti(0);
        this.logiikka.valitseVastauskortti(1);
        assertEquals(this.logiikka.onkoKaksiKaannettyna(), true);
    }

    @Test
    public void palauttaakoOikeinKunYksiKaannettyna() {
        this.logiikka.valitseKysymyskortti(1);
        assertEquals(this.logiikka.onkoKaksiKaannettyna(), false);
    }

    @Test
    public void loytaakoParin() {
        this.logiikka.valitseKysymyskortti(0);
        this.logiikka.valitseVastauskortti(0);
        assertEquals(this.logiikka.loytyikoPari(), true);
    }

    @Test
    public void loytaakoParinKunYksiKaannetty() {
        this.logiikka.valitseKysymyskortti(0);
        assertEquals(this.logiikka.loytyikoPari(), false);
    }

    @Test
    public void palauttaakoOikeinKunEiParia() {
        this.logiikka.valitseKysymyskortti(1);
        this.logiikka.valitseVastauskortti(0);
        assertEquals(this.logiikka.loytyikoPari(), false);
    }

    @Test
    public void saakoKaantaaAlussa() {
        assertEquals(this.logiikka.saakoJoKaantaa(), true);
    }

    @Test
    public void onkoKysymystenVuoroAlussa() {
        assertEquals(this.logiikka.onkoKysymystenVuoro(), true);
    }

    @Test
    public void onkoKysymystenVuoroKunPainettuKysymysta() {
        this.logiikka.valitseKysymyskortti(1);
        assertEquals(this.logiikka.onkoKysymystenVuoro(), false);
    }
}

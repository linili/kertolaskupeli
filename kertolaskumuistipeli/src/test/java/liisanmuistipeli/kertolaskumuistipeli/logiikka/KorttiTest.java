/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liisanmuistipeli.kertolaskumuistipeli.logiikka;

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
public class KorttiTest {

    Kortti vastauskortti;
    Kortti kysymyskortti;

    public KorttiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        vastauskortti = new Kortti(5, 4, 0);
        kysymyskortti = new Kortti(5, 4, 1);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ensinPoydalla() {
        assertEquals(false, vastauskortti.onkoLoydetty());
    }

    @Test
    public void ensinPiilossa() {
        assertEquals(false, vastauskortti.onkoKaannetty());
    }

    @Test
    public void alkuarvotOikeinKertoja() {
        assertEquals(5, vastauskortti.getKertoja());
    }

    @Test
    public void alkuarvotOikeinKerrottava() {
        assertEquals(4, vastauskortti.getKerrottava());
    }

    @Test
    public void alkuarvotOikeinTyyppi() {
        assertEquals(0, vastauskortti.getTyyppi());
    }

    @Test
    public void kaantaakoKortin() {
        vastauskortti.nayta();
        assertEquals(true, vastauskortti.onkoKaannetty());
    }

    @Test
    public void piilottaakoKortin() {
        vastauskortti.piiloon();
        assertEquals(false, vastauskortti.onkoKaannetty());
    }

    @Test
    public void poistaakoKortin() {
        vastauskortti.poistaPoydalta();
        assertEquals(true, vastauskortti.onkoLoydetty());
    }

    @Test
    public void tulostaaKysymyksen() {
        this.kysymyskortti.nayta();
        assertEquals("5x4", this.kysymyskortti.toString());
    }

    @Test
    public void tulostaaVastauksen() {
        this.kysymyskortti.nayta();
        this.vastauskortti.nayta();
        assertEquals("20", this.vastauskortti.toString());
    }

    @Test
    public void tulostaaPiilotetun() {
        assertEquals("XXX", this.kysymyskortti.toString());
    }
}

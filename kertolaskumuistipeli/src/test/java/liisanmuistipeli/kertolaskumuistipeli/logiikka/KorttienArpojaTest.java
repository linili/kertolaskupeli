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
public class KorttienArpojaTest {

    private KorttienArpoja arpoja;
    private Pelitilanne peli;

    public KorttienArpojaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        arpoja = new KorttienArpoja();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void arpookoKorttejaOikeanMaaran() {
        this.peli = arpoja.luoSatunnainenPelitilanne(5);
        assertEquals(this.peli.getKysymykset().size(), 10);
        assertEquals(this.peli.getVastaukset().size(), 10);
    }
    @Test
    public void asettaakoOikeanKertoja() {
        this.peli = this.arpoja.luoSatunnainenPelitilanne(5);
        assertEquals(this.peli.getKertoja(),5);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

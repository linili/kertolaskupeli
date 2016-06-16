package liisanmuistipeli.kertolaskumuistipeli.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class PelitilanneTest {

    Pelitilanne p;

    public PelitilanneTest() {
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
        kysymykset.add(new Kortti(2,2,1));
        vastaukset.add(new Kortti(2,2,0));
        this.p = new Pelitilanne(2, kysymykset, vastaukset);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktori_asettaa_kertojan() {

        assertEquals(2, p.getKertoja());
    }

    @Test
    public void konstruktori_asettaa_kysymyskortit() {

        assertEquals(1, p.getKysymykset().size());
    }

    @Test
    public void konstruktori_asettaa_vastauskortit() {

        assertEquals(1, p.getVastaukset().size());
    }

}

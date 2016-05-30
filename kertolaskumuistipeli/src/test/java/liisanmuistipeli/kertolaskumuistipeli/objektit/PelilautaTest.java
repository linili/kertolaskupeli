package liisanmuistipeli.kertolaskumuistipeli.objektit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class PelilautaTest {
     Pelilauta p;
    
    public PelilautaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        p = new Pelilauta(6);
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void konstruktori_asettaa_kertojan() {
         
         assertEquals(6, p.getKertoja());
     }
     
      @Test
     public void konstruktori_asettaa_kysymyskortit() {
         
         assertEquals(10, p.getKysymykset().size());
     }
     
     @Test
     public void konstruktori_asettaa_vastauskortit() {
         
         assertEquals(10, p.getVastaukset().size());
     }
}

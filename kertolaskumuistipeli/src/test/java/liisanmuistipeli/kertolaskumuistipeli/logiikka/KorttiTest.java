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
    Kortti kortti;
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
        kortti = new Kortti(5,4,0);
    }
    
    @After
    public void tearDown() {
    }
    
     @Test
     public void ensinPoydalla() {
     assertEquals(false, kortti.onkoLoydetty());
     }
     
     @Test
     public void ensinPiilossa() {
     assertEquals(false, kortti.onkoKaannetty());
     }
     @Test
     public void alkuarvotOikeinKertoja() {
     assertEquals(5, kortti.getKertoja());
     }
     
     @Test
     public void alkuarvotOikeinKerrottava() {
     assertEquals(4, kortti.getKerrottava());
     }
     
     @Test
     public void alkuarvotOikeinTyyppi() {
     assertEquals(0, kortti.getTyyppi());
     }
     
     @Test
     public void kaantaakoKortin() {
         kortti.nayta();
     assertEquals(true, kortti.onkoKaannetty());
     }
     
     @Test
     public void piilottaakoKortin() {
         kortti.piiloon();
     assertEquals(false, kortti.onkoKaannetty());
     }
     
     @Test
     public void poistaakoKortin() {
         kortti.poistaPoydalta();
     assertEquals(true, kortti.onkoLoydetty());
     }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigInteger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rabinencscheme.EuclideanAlgorithm;
import rabinencscheme.EuclideanAlgorithmCoefficients;

/**
 *
 * @author Patryk Kozieł
 */
public class EATest {
    
    public EATest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    //@Test
    public void testCoeff(){
        EuclideanAlgorithmCoefficients res = EuclideanAlgorithm.computeCoefficients(17,19);
        System.out.println(res.getA());
        System.out.println(res.getB());
        assertEquals(1, res.getA().intValue()*17 + 19*res.getB().intValue());
    }
     
    @Test
    public void testCoeff2(){
        EuclideanAlgorithmCoefficients res = EuclideanAlgorithm.computeCoefficients(5381,5477);
        System.out.println(res.getA());
        System.out.println(res.getB());
        assertEquals(1, res.getA().intValue()*5381 + 5477*res.getB().intValue());
    }
    
}

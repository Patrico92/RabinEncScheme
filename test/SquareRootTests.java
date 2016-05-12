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
import rabinencscheme.SquareRoot;

/**
 *
 * @author Patryk Kozieł
 */
public class SquareRootTests {
    
    public SquareRootTests() {
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
    public void testGenerateRandomNumber(){
        SquareRoot sq = new SquareRoot(new BigInteger("17"));
        //System.out.println(sq.getRandomNumberModuloP()); 
    }
    
    //@Test
    public void testExponent(){
        BigInteger p = new BigInteger("17");
        SquareRoot sq = new SquareRoot(p);
        assertEquals(sq.getExponent(),new BigInteger("8"));
        
    }
    
    //@Test
    public void print(){
        BigInteger p = new BigInteger("17");
        SquareRoot sq = new SquareRoot(p);
        sq.printSquares();
    }

    //@Test
    public void testRandomRes(){
        BigInteger p = new BigInteger("17");
        SquareRoot sq = new SquareRoot(p);
        System.out.println("Res: " + sq.getQuadraticNonResidueModuloP());
    }
    
    @Test
    public void testML(){
        BigInteger p = new BigInteger("17");
        SquareRoot sq = new SquareRoot(p);
        sq.computeLandM();
        assertEquals(sq.getL(),new BigInteger("3"));
        assertEquals(sq.getM(),new BigInteger("1"));   
    }
    
        @Test
    public void testML2(){
        BigInteger p = new BigInteger("137");
        SquareRoot sq = new SquareRoot(p);
        sq.computeLandM();
        assertEquals(sq.getL(),new BigInteger("2"));
        assertEquals(sq.getM(),new BigInteger("17"));   
    }
    
    @Test
    public void testSquareRoot(){
        BigInteger p = new BigInteger("17");
        SquareRoot sq = new SquareRoot(p);
        BigInteger root = sq.computeSquareRoot(new BigInteger("13"));
        System.out.println("Root: " + root);
    }

    @Test
    public void testSquareRoot2(){
        BigInteger p = new BigInteger("137");
        SquareRoot sq = new SquareRoot(p);
        BigInteger root = sq.computeSquareRoot(new BigInteger("101"));
        System.out.println("Root: " + root);
    }
}

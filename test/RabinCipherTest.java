/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rabinencscheme.RabinCipher;

/**
 *
 * @author Patryk Kozieł
 */
public class RabinCipherTest {
    
    public RabinCipherTest() {
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
    
    @Test
    public void encryptMessage() throws FileNotFoundException, IOException{
        Properties properties = new Properties();
        FileReader fileReader = new FileReader("C:\\Users\\Patryk Kozieł\\Documents\\NetBeansProjects\\RabinEncScheme\\src\\rabinencscheme\\keys.properties");
        properties.load(fileReader);
        RabinCipher rC = new RabinCipher();
        BigInteger ciphertext = rC.encryptMessage(new BigInteger("7367934"), new BigInteger(properties.getProperty("N")));
        System.out.println(ciphertext);
    }
    
    @Test
    public void testDecryptMessage() throws FileNotFoundException, IOException, InterruptedException{
        Properties properties = new Properties();
        FileReader fileReader = new FileReader("C:\\Users\\Patryk Kozieł\\Documents\\NetBeansProjects\\RabinEncScheme\\src\\rabinencscheme\\keys.properties");
        properties.load(fileReader);
        RabinCipher rC = new RabinCipher();
        rC.decryptCipherText(
                new BigInteger("12893885"), 
                new BigInteger(properties.getProperty("p")), 
                new BigInteger(properties.getProperty("q")),
                new BigInteger(properties.getProperty("N"))
        );
        
    }
    
}

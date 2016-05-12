/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rabinencscheme;

import java.math.BigInteger;

/**
 *
 * @author Patryk Kozieł
 */
public class EuclidAlgThread extends Thread {
    
    RabinCipher rC;
    BigInteger p;
    BigInteger q;

    public EuclidAlgThread(RabinCipher rC, BigInteger p, BigInteger q) {
        this.rC = rC;
        this.p = p;
        this.q = q;
    }
    
    @Override
    public void run(){
        rC.seteAC(EuclideanAlgorithm.computeCoefficients(p, q));
    }
    
}

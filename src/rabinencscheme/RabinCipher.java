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
public class RabinCipher {
    
    BigInteger xp = null;
    BigInteger xq = null;
    EuclideanAlgorithmCoefficients eAC = null;
    
    public BigInteger encryptMessage(BigInteger m, BigInteger publicKey){
        return m.modPow(new BigInteger("2"), publicKey);
    }
    
    public void decryptCipherText(BigInteger cipherText, BigInteger p, BigInteger q, BigInteger publicKey) throws InterruptedException{
        
        ComputeRootThread cRTp = new ComputeRootThread(
                cipherText.mod(p),
                p,
                "p",
                this
        );
        
        ComputeRootThread cRTq = new ComputeRootThread(
                cipherText.mod(q),
                q,
                "q",
                this
        );
        
        EuclidAlgThread eAT = new EuclidAlgThread(this, p, q);
        
        cRTp.run();
        cRTq.run();
        eAT.run();
        
        while (xp == null || xq == null || eAC == null) Thread.sleep(0x1f4);
        
        System.out.println("xp = " + xp);
        System.out.println("xq = " + xq);
        System.out.println("coeff: " + eAC.getA() + ", " + eAC.getB());
        
        BigInteger message = (xp).multiply(q).multiply(eAC.getB()).add( 
                            xq.multiply(p).multiply(eAC.getA())
            ).mod(publicKey);
        
        System.out.println(message);
        
    }

    synchronized public void setXp(BigInteger xp) {
        this.xp = xp;
    }

    synchronized public void setXq(BigInteger xq) {
        this.xq = xq;
    }

    synchronized public void seteAC(EuclideanAlgorithmCoefficients eAC) {
        this.eAC = eAC;
    }
    
}

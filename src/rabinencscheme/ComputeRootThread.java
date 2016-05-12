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
public class ComputeRootThread extends Thread {
    
    BigInteger a;
    BigInteger p;
    String mode; 
    RabinCipher rC;

    public ComputeRootThread(BigInteger a, BigInteger p, String mode, RabinCipher rC) {
        this.a = a;
        this.p = p;
        this.mode = mode;
        this.rC = rC;
    }
    
    @Override
    public void run(){
        SquareRoot sr = new SquareRoot(p);
        if(mode.equals("p")){
            rC.setXp(sr.computeSquareRoot(a));
        } else {  
            rC.setXq(sr.computeSquareRoot(a));
        }   
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rabinencscheme;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Patryk Kozieł
 */
public class SquareRoot {
    
    BigInteger p;
    private BigInteger l;
    private BigInteger m;
    BigInteger two = new BigInteger("2");
    BigInteger one = BigInteger.ONE;
    
    public SquareRoot(BigInteger p){
        this.l = BigInteger.ZERO;
        this.p = p;
    }
    
    public BigInteger computeSquareRoot(BigInteger a){
        
        BigInteger b = getQuadraticNonResidueModuloP();
        System.out.println("b = " + b);
        computeLandM();
        BigInteger r,r1;
        r = getExponent();
        r1 = BigInteger.ZERO;
        
        for (BigInteger i = l; i.compareTo(BigInteger.ZERO) == 1; i = i.subtract(one)){
            r = r.divide(two);
            r1 = r1.divide(two);
            
            BigInteger value = a.modPow(r, p).
                    multiply(b.modPow(r1, p)).
                    mod(p);
            
            if ( value.compareTo(new BigInteger("-1")) == 0 || value.compareTo(p.subtract(one)) == 0 )
            {
                r1 = r1.add(getExponent());
            }
            
        }

        return a.modPow(r.add(one).divide(two), p).multiply(b.modPow(r1.divide(two), p)).mod(p);
    }

    public BigInteger getQuadraticNonResidueModuloP() {
        
       BigInteger b = getRandomNumberModuloP();
       
       while(isQuadraticNonResidueModuloP(b)) b = getRandomNumberModuloP();
      
       return b;
    }

    public BigInteger getRandomNumberModuloP() {
        
        BigInteger b = BigInteger.ZERO;
        Random rnd = new Random();
        while (!(b.compareTo(BigInteger.ZERO) == 1 && b.compareTo(p) == -1)){
           b = new BigInteger(p.bitLength(), rnd);   
        }
        
        return b;
    }

    private boolean isQuadraticNonResidueModuloP(BigInteger b) {
        BigInteger exponent = getExponent();
        return b.modPow(exponent,p).compareTo(one) == 0;
    }

    public BigInteger getExponent() {
       return p.subtract(one).divide(two);
    }
    
    public void printSquares(){
        for(BigInteger i = new BigInteger("2"); i.compareTo(p) == -1; i = i.add(one)){
            System.out.println(i + " -> " + i.modPow(two,p) );
        }
    }

    public void computeLandM() {
        m = getExponent();
        
        while( m.mod(two).compareTo(BigInteger.ZERO) == 0 ){
            l = l.add(one);
            m = m.divide(two);
        }
    }

    public BigInteger getL() {
        return l;
    }

    public BigInteger getM() {
        return m;
    }
    
 
}

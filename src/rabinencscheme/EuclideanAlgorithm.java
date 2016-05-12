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
public class EuclideanAlgorithm {
    
    public static EuclideanAlgorithmCoefficients computeCoefficients(
        BigInteger a, BigInteger b){
        
        BigInteger p = BigInteger.ONE;
        BigInteger q = BigInteger.ZERO; 
        BigInteger r = BigInteger.ZERO;
        BigInteger s = BigInteger.ONE;

        BigInteger c = BigInteger.ZERO;
        BigInteger quot = BigInteger.ZERO;
        BigInteger r_tmp = BigInteger.ZERO;
        BigInteger s_tmp = BigInteger.ZERO;

        while (b.compareTo(BigInteger.ZERO) == 1){
            c = a.mod(b);
            quot = a.divide(b);
            a = b;
            b = c;
            r_tmp = r; 
            s_tmp = s;
            r = p.subtract(quot.multiply(r));
            s = q.subtract(quot.multiply(s));
            p = r_tmp; q = s_tmp; 
        }
        
        return new EuclideanAlgorithmCoefficients(p,q);
    }

    public static EuclideanAlgorithmCoefficients computeCoefficients(int i, int i0) {
        return computeCoefficients(BigInteger.valueOf(i),BigInteger.valueOf(i0));
    }

}

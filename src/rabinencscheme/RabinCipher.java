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
    
    public BigInteger encryptMessage(BigInteger m, BigInteger publicKey){
        return m.modPow(new BigInteger("2"), publicKey);
    }
    
    public void decryptCipherText(BigInteger cipherText, BigInteger p, BigInteger q){
        //compute X,Y
        //compute sqp
        //compute sqq
    }
}

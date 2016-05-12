package rabinencscheme;
import java.math.BigInteger;

public class EuclideanAlgorithmCoefficients{
    
    BigInteger a;
    BigInteger b;

    public EuclideanAlgorithmCoefficients(BigInteger a, BigInteger b) {
        this.a = a;
        this.b = b;
    }

    public BigInteger getA() {
        return a;
    }

    public BigInteger getB() {
        return b;
    }
   
}
import java.util.Scanner;
import java.math.BigInteger;

public class A {
    static boolean isPrime(BigInteger ans) {
        return ans.isProbablePrime(20);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BigInteger n = input.nextBigInteger();

        if (n.equals(BigInteger.valueOf(2))) {
            System.out.println(1);
            input.close();
            return;
        }
        BigInteger ans = n.multiply(n.add(BigInteger.ONE)).divide(BigInteger.TWO);
        BigInteger k = BigInteger.ONE;
        while (isPrime(ans)) {
            ans = ans.subtract(k);
            k = k.add(BigInteger.ONE);
        }

        System.out.println(ans);
        input.close();
    }
}

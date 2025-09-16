package Leetcode;

import java.math.BigInteger;

public class MultiplyStrings43 {
    public static void main(String[] args) {
        System.out.println(multiply("324234234234232","303423342323424"));
    }
    public static String multiply(String num1, String num2) {

        BigInteger n1=new BigInteger(num1);
        BigInteger n2=new BigInteger(num2);
        BigInteger result=n1.multiply(n2);
        return result.toString();
    }
}

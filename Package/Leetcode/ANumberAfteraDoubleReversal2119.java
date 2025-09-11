package Leetcode;

public class ANumberAfteraDoubleReversal2119 {
    public static void main(String[] args) {
        System.out.println(isSameAfterReversals(1243));
    }
    public static boolean isSameAfterReversals(int num) {
        if(num<10) return true;
        if (num%10==0) return false;
        return  true;
    }
}

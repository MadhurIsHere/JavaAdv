package Leetcode;

public class HappyNumber202 {
    public static void main(String[] args) {
        System.out.println(isHappy(3));
    }
    public static boolean isHappy(int n) {
        if(n/10==0 && n!=1) return false;
        if(n==1) return true;
        int slow=n;
        int fast=n;

        while (true)
        {
            slow=sumOfSquare(slow); // one step
            fast=sumOfSquare(sumOfSquare(fast)); //two steps

            if(slow==1 || fast==1) return true;
            if (slow==fast) return false;
        }
    }
    public static int sumOfSquare(int n)
    {
        int sum=0;
        while (n>0)
        {
            sum+=(n%10)*(n%10);
            n/=10;
        }
        return sum;
    }
}

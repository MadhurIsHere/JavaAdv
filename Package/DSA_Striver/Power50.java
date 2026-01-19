package DSA_Striver;

public class Power50 {
    public static void main(String[] args) {
        System.out.println(myPow(2,-2));
    }
    public static double myPow(double x, int n) {
        if(n>0)
        {
            if(n==0)
            {
                return 1;
            }
            return x*myPow(x,n-1);
        }
        else
        {
            if(n==0)
            {
                return 1;
            }
            return 1/(x*myPow(x,n+1));
        }
    }
}

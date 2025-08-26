package Contest;

public class GCDofOddandEvenSums {
    public static void main(String[] args) {
        System.out.println(gcdOfOddEvenSums(4));
    }
    public static int gcdOfOddEvenSums(int n) {
        int odd=odd(n);
        int even=even(n);
        int gcd=0;
        int min=Math.min(odd,even);
        for(int i=2;i<=min;i++)
        {
            if(odd%i==0 && even%i==0)
            {
                gcd=i;
            }
        }
        return gcd;
    }
    static int odd(int n)
    {
        int sum=0;
        for (int i=1;i<2*n;i+=2)
        {
            sum+=i;
        }
        return sum;
    }
    static int even(int n)
    {
        int sum=0;
        for (int i=2;i<=2*n;i+=2)
        {
            sum+=i;
        }
        return sum;
    }
}

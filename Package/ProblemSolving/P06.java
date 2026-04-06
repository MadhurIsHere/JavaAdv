package ProblemSolving;

public class P06 {
    public static void main(String[] args) {
        int n=121;
        int n1=0;
        System.out.println(reverse(n,n1)==n);
    }

    private static int reverse(int n,int n1)
    {
        if(n<=0) return n1;
        return reverse(n/10,n1)*10+n%10;
    }

}

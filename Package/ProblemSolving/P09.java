package ProblemSolving;

public class P09 {
    public static void main(String[] args) {
        System.out.println(power1(2,3));
    }
    private static int power1(int base,int n)
    {
        if(n<=0)
        {
            return 1;
        }
        return power1(base,n-1)*base;
    }
}

package ProblemSolving;

public class P07 {
    public static void main(String[] args) {
        int n=6;
        for(int i=1;i<=n;i++)
        {
            for(int j=n-i+1;j>0;j--)
            {
                System.out.print(j+" ");
            }
            System.out.println();
        }
        outer(1,n);
    }
    private static void outer(int i,int n)
    {
        if(i==n+1)
        {
            return;
        }
        inner(n-i+1,n);
        System.out.println();
        outer(i+1,n);
    }
    private static void inner(int j,int n)
    {
        if(j==0)
        {
            return;
        }
        System.out.print(j+" ");
        inner(j-1,n);
    }
}

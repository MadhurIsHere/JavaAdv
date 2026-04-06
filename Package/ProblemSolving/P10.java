package ProblemSolving;

public class P10 {
    public static void main(String[] args) {
        int n=5;
        for(int i=1;i<=n;i++)
        {
            int k=n+i-1;
            for(int j=1;j<=k;j++)
            {
                if(j<=n-i){
                    System.out.print("  ");
                    continue;
                }
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    private void pattern(int n,int i,int j)
    {
        if(i==n)
        {
            return;
        }
        int k=n+i-1;
        if(j<=k &&j<=n-i)
        {
            System.out.println("  ");
            pattern(n,i,j+1);
            return;
        }

    }
}

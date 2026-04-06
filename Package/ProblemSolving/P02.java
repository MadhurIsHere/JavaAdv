package ProblemSolving;

public class P02 {
    public static void main(String[] args) {
        int n=5;
        for(int i=1;i<=2*n-1;i++)
        {
            int k;
            if(i<=n)
            {
                k=i;
            }
            else
            {
                k=2*n-i;
            }
            for (int j = 0; j < k; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

package DP;

import java.util.Arrays;

public class LCS {
    static int[][] dp;
    public static int lcsrec(String x,String y,int m,int n)
    {
        if(m==0 || n==0)
        {
            return 0;
        }
        if(x.charAt(m-1)==y.charAt(n-1))
        {
            return 1 + lcsrec(x,y,m-1,n-1);
        }
        else{
            return Math.max(lcsrec(x,y,m-1,n),lcsrec(x,y,m,n-1));
        }
    }
    public static int lcs(String x,String y,int m,int n)
    {
        if(m==0 || n==0) return 0;

        if(dp[m][n]!=-1)
        {
            return dp[m][n];
        }

        if(x.charAt(m-1)==y.charAt(n-1))
        {
            return dp[m][n]=1+lcs(x,y,m-1,n-1);
        }
        else
        {
            return dp[m][n]=Math.max(lcs(x,y,m-1,n),lcs(x,y,m,n-1));
        }
    }

    public static void main(String[] args) {
        String x="axyt";
        String y="ayzx";
        int m=x.length();
        int n=y.length();
        System.out.println("Recursive "+lcsrec(x,y,m,n));


        dp=new int[m+1][n+1];
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }

        lcs(x,y,m,n);
        System.out.println("Memoization "+dp[m][n]);

        // tabulation
        int[][] t=new int[m+1][n+1];
        for(int[] row: t)
        {
            Arrays.fill(row,-1);
        }
        String ans="";
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0 || j==0 ) t[i][j]=0;
                else{
                    if(x.charAt(i-1)==y.charAt(j-1))
                    {
                        t[i][j]=1+t[i-1][j-1];
                    }
                    else
                    {
                        t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                    }
                }
            }
        }

        // to get the resultant answer string

        int i=m;
        int j=n;

        while(i>0 && j>0)
        {
            if(x.charAt(i-1)==y.charAt(j-1))
            {
                ans=ans+x.charAt(i-1);
                i--;
                j--;
            }
            else
            {
                if(t[i-1][j]>t[i][j-1])
                {
                    i--;
                }
                else {
                    j--;
                }
            }
        }
        for(int[] row:t)
        {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(ans);
    }
}

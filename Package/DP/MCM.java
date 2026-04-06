package DP;

import java.util.Arrays;

public class MCM {
    static int mcm(int[] arr,int i,int j) {
        if (i >= j) return 0;

        if(t[i][j]!=-1) return t[i][j];
        int k = i;
        int min=Integer.MAX_VALUE;
        while (k < j) {
            int temp=mcm(arr,i,k)+mcm(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
            if(min>temp) min=temp;
            k++;
        }
        return t[i][j]=min;
    }
    static int[][] t;
    public static void main(String[] args) {
        int[] arr={1,2,1,4,1};
        t=new int[arr.length][arr.length];
        for(int[] row:t)
        {
            Arrays.fill(row,-1);
        }

        System.out.println(mcm(arr,1,arr.length-1));
        for(int[] row:t)
        {
            System.out.println(Arrays.toString(row));
        }

        int n = arr.length;
        int[][] dp = new int[n][n];

//        for (int i = 1; i < n; i++) dp[i][i] = 0;

        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k+1][j] + arr[i-1]*arr[k]*arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        for(int[] row:dp)
        {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(dp[1][n-1]);
    }
}

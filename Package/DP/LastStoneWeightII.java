package DP;

import java.util.Arrays;

public class LastStoneWeightII {
    static int[][] dp;
    public static void main(String[] args) {
        int[] arr={2,7,4,1,8,1};
        int total=0;
        for(int a:arr)
        {
            total+=a;
        }
        dp=new int[arr.length+1][total/2+1];

        System.out.println(total-2*helper(arr,0,total/2));
        for(int[] row:dp)
        {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(total-2*dp[0][total/2]);
    }
    private static int helper(int[] arr,int i,int curr_sum)
    {
        if(curr_sum==0 || i==arr.length)
        {
            return 0;
        }
        if(dp[i][curr_sum]!=0) return dp[i][curr_sum];
        int option1=0;
        if(arr[i]<=curr_sum) {
            option1 = arr[i]+helper(arr, i + 1, curr_sum - arr[i]);
        }
        int option2=helper(arr,i+1,curr_sum);
        return dp[i][curr_sum]=Math.max(option1,option2);
    }
}

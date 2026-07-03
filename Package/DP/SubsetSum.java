package DP;

public class SubsetSum {
    public static boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    static void subset(int[] arr,int sum,int index)
    {
        if(sum == 0)
        {
            System.out.println(index);
            return;
        }
        if(index==arr.length)
        {
            System.out.printf("No subset found at index %d\n",index);
            return;
        }
        if(sum-arr[index]<=0)
        {
            subset(arr,sum-arr[index],index+1);
            sum+=arr[index];
        }
        subset(arr,sum,index+1);
    }
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;

        if (isSubsetSum(arr, sum)) {
            System.out.println("Found a subset ");
        } else {
            System.out.println("No subset found");
        }
    }
}

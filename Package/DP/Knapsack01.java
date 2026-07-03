package DP;

import java.util.Arrays;

public class Knapsack01 {

    static int[][] dp;
    /*
     *  0/1 knapsack
     *
     *  Base case either the size of the bag is 0 or the elements are 0 (elements are already filled )
     *  w: is the capacity
     *  n: list of n items (elements)
     *
     *   if(n==0 || w==0){
     *       return 0;
     *   }
     *
     *
     *   before making the choice just check weather the current weight is greater than the weight of the element
     *   if yes then make the choice else skip it
     *   Choice:  either put that item inside the knapsack or skip it
     *
     *
     */

    // without using memoization
    private static int knapsack(int[] wt, int[] val, int n, int w) {
        if (n == 0 || w == 0) return 0;

        if (wt[n - 1] > w) {
            return knapsack(wt, val, n - 1, w);
        } else {
            return Math.max(val[n - 1] + knapsack(wt, val, n - 1, w - wt[n - 1]), knapsack(wt, val, n - 1, w));
        }
    }

    // with memoization
    private static int knapsackMemo(int[] wt, int[] val, int n, int w) {
        if (n == 0 || w == 0) return 0;

        if (dp[n][w] != -1) return dp[n][w];

        if (wt[n - 1] > w) {
            return dp[n][w] = knapsackMemo(wt, val, n - 1, w);
        } else {
            return dp[n][w] = Math.max(val[n - 1] + knapsackMemo(wt, val, n - 1, w - wt[n - 1]), knapsackMemo(wt, val, n - 1, w));
        }
    }

    public static void main(String[] args) {
        int[] weight = {2, 3, 4, 5};
        int[] val = {3, 4, 5, 6};
        int w = 5;
        int n = 4;
        System.out.println(knapsack(weight, val, n, w));
        dp = new int[n + 1][w + 1];

        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }

        knapsackMemo(weight, val, n, w);
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(dp[n][w]);

        // Tabulation
        int[][] t = new int[n + 1][w + 1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) t[i][j] = 0;
                else if (weight[i - 1] <= j) {
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - weight[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        for (int[] row : t) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(lcs("abdegh", "abfghrk", 0, 0));
    }

    // string 1 => abdegh
    // string 2 => abfghrk
    // ans=4
    private static int lcs(String a, String b, int i, int j) {
        if (i == a.length() || j == b.length()) return 0;
        if (a.charAt(i) == b.charAt(j)) {
            return 1 + lcs(a, b, i + 1, j + 1);
        } else {
            return Math.max(lcs(a, b, i + 1, j), lcs(a, b, i, j + 1));
        }
    }
}

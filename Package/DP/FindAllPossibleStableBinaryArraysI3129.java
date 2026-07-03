package DP;

import java.util.Arrays;

public class FindAllPossibleStableBinaryArraysI3129 {
    public static void main(String[] args) {
        System.out.println(numberOfStableArrays(1, 1, 1));
    }

    static int[][][] dp = new int[202][202][2];
    static int mod = (int) (1e9 + 7);

    public static int numberOfStableArrays(int zero, int one, int limit) {
        for (int[][] twoD : dp) {
            for (int[] row : twoD) {
                Arrays.fill(row, -1);
            }
        }

        int a = helper(one, zero, 1, limit) % mod;
        int b = helper(one, zero, 0, limit) % mod;
        return (a + b) % mod;
    }

    private static int helper(int one, int zero, int flag, int limits) {

        if (zero == 0 && one == 0) return 1;

        int ans = 0;

        if (dp[one][zero][flag] != -1) {
            return dp[one][zero][flag];
        }

        if (flag == 1) {
            for (int i = 1; i <= Math.min(limits, one); i++) {
                ans = (ans + helper(one - i, zero, 0, limits) % mod) % mod;
            }
        } else if (flag == 0) {
            for (int i = 1; i <= Math.min(limits, zero); i++) {
                ans = (ans + helper(one, zero - i, 1, limits) % mod) % mod;
            }
        }
        return dp[one][zero][flag] = ans;
    }
}

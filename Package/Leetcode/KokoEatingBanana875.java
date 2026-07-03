package Leetcode;

public class KokoEatingBanana875 {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{805306368, 805306368, 805306368}, 1000000000));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int i : piles) {
            if (i > high) {
                high = i;
            }
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int k = helper(piles, mid);
            if (k <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int helper(int[] piles, int cap) {
        int hours = 0;
        for (int i : piles) {
//            double x=(double)
            hours += (int) Math.ceil((double) i / cap);
        }
        return hours;
    }
}

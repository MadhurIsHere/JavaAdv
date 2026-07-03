package Leetcode;

public class CheckifArrayIsSortedandRotated {
    public static void main(String[] args) {
        System.out.println(check(new int[]{3, 4, 5, 1, 2}));
    }

    public static boolean check(int[] nums) {
        boolean ans = true;
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        for (int i = 1; i <= index; i++) {
            if (nums[i - 1] > nums[i]) {
                ans = false;
                break;
            }
        }
        for (int i = index + 2; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                ans = false;
                break;
            }
        }
        return ans;
    }
}

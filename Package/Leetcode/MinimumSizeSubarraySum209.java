package Leetcode;

import java.util.Arrays;

public class MinimumSizeSubarraySum209 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(213,new int[]{12,28,83,4,25,26,25,2,25,25,25,12}));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for(int i=nums.length-1;i>=0;i--){
            sum+=nums[i];
            if(sum>=target) return nums.length-i;
        }
        return 0;
    }
}

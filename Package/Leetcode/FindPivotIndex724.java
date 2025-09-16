package Leetcode;

import java.util.Arrays;

public class FindPivotIndex724 {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[] {2,1,-1}));
    }
    public static int pivotIndex(int[] nums) {

        int total_sum=0;
        for(int i=1;i<nums.length;i++)
        {
            total_sum+=nums[i];
        }
        if(total_sum==0) return 0;
        int left_sum=0;
        for(int i=0;i< nums.length;i++)
        {
            left_sum+=nums[i];
            int right_sum=total_sum-left_sum-nums[i];
            if(right_sum==left_sum) return i;
        }
        return -1;
    }
}

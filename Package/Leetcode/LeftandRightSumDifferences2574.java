package Leetcode;

import java.util.Arrays;

public class LeftandRightSumDifferences2574 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(leftRightDifference(new int[] {10,4,8,3})));
    }
    public static int[] leftRightDifference(int[] nums) {
        int[] left=new int[nums.length];
        int n=nums.length;
        int[] right=new int[n];
        left[0]=0;
        right[n-1]=0;
        for(int i=1;i< n;i++)
        {
            left[i]=nums[i-1]+left[i-1];
        }
        for (int i= n-1;i>0;i--)
        {
            right[i-1]=nums[i]+right[i];
        }
        for(int i=0;i<n;i++)
        {
            nums[i]=Math.abs(left[i]-right[i]);
        }
        return nums;
    }
}

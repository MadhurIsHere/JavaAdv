package Leetcode;

import java.util.Arrays;

public class MinimumMovestoEqualArrayElementsII462 {
    public static void main(String[] args) {
        System.out.println(minMoves2(new int[]{1,2,3}));
    }
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int step=0;
        int n=nums.length-1;
        int med=-1;
        if(n%2==0)
        {
            med=(nums[(n+1)/2]+nums[n/2])/2;
        }
        else
        {
            med=nums[(n+1)/2];
        }
        for(int i=0;i<=n;i++)
        {
            if(med!=nums[i] && med>nums[i])
            {
                step+=med-nums[i];
            }
            else if(med!=nums[i] && med<nums[i])
            {
                step+=nums[i]-med;
            }
        }
        return step;
    }
}

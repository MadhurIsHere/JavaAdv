package Leetcode;

import java.util.Arrays;

public class MajorityElement169 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
    public static int majorityElement(int[] nums) {
        int max=max(nums);
        int[] arr=new int[max+1];
        for(int i=0;i<max+1;i++)
        {
            arr[i]=0;
        }
        for(int i=0;i<nums.length;i++)
        {
            arr[nums[i]]++;
        }
        max=maxInd(arr);
        System.out.println(Arrays.toString(arr));
        return max;
    }
    public static int maxInd(int[] nums)
    {
        int max=Integer.MIN_VALUE;
        int index=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
                index=i;
            }
        }
        return index;
    }
    public static int max(int[] nums)
    {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(max<nums[i])
            {
                max=nums[i];
            }
        }
        return max;
    }
}

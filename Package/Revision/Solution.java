package Revision;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(check(new int[]{3,4,5,1,2}));
    }
    public static boolean check(int[] nums) {
        int index=0;
        int n=nums.length;
        for(int i=1;i<n;i++)
        {
            if(nums[i-1]<nums[i])
            {
                index++;
            }
            else
            {
                index++;
                break;
            }
        }
        System.out.println(index);
        for(int i=index+1;i<n+index;i++)
        {
            System.out.println(nums[(i-1)%n]+" " +nums[i%n]);
            if(nums[(i-1)%n]>nums[i%n])
            {
                return false;
            }
        }
        return index>0;
    }
}

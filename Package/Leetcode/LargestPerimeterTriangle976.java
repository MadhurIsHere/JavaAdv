package Leetcode;

import java.util.Arrays;

public class LargestPerimeterTriangle976 {
    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{1,2,1,10}));
    }
    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=2;i--)
        {
            int a=nums[i];
            int b=nums[i-1];
            int c=nums[i-2];
            if(c+b>a) return a+b+c;   // c and b comes at the end so c+b should be greater than a;
        }
        return 0;
    }
}

package Leetcode;

public class FindClosestNumbertoZero2239 {
    public static void main(String[] args) {
        System.out.println(findClosestNumber(new int[]{-4,-2,1,4,8,-1}));
    }
    public static int findClosestNumber(int[] nums) {
        if(nums.length==0) return nums[0];
        int MinPostive=Integer.MAX_VALUE;
        int MinNegative=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                if(MinPostive>nums[i])
                {
                    MinPostive=nums[i];
                }
            }
            else {
                if(MinNegative<nums[i])
                {
                    MinNegative=nums[i];
                }
            }
        }
        if(MinPostive==Integer.MAX_VALUE) return MinNegative;
        if(MinNegative==Integer.MIN_VALUE) return MinPostive;

        if(Math.abs(MinNegative)==MinPostive) return MinPostive;
        return Math.abs(MinNegative)> MinPostive ? MinPostive:MinNegative;

    }
}

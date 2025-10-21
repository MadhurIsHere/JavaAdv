package Leetcode;

public class FindPeakElement162 {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{0,1,2,3,4,5,3,2,1,0}));
    }
    public static int findPeakElement(int[] nums) {
        if(nums.length<=1) return 0;

        int start=0;
        int end=nums.length-1;
        int mid;
        while (start<=end){
            mid=start+(end-start)/2;
            if(nums[mid]>nums[mid-1])
            {
                if(nums[mid]>nums[mid+1])
                {
                    return mid;
                }
                else {
                    start=mid+1;
                }
            }
            else
            {
                if(nums[mid]>nums[mid+1])
                {
                    return mid-1;
                }
                else {
                    end=mid;
                }
            }
        }
        return 0;
    }
}

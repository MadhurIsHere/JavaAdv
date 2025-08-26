package Leetcode;
public class SearchInsertPosition35 {
    public static void main(String[] args) {
        int[]  nums={1,3,5,6};
        int target=2;
        System.out.println(searchInsert(nums,target));
    }
    static public int searchInsert(int[] nums, int target) {
        int mid=0;
        int start=0;
        int end =nums.length-1;
        while(start<=end)
        {
            mid=start+(end-start)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            if(nums[mid]>target) {
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return start;
    }
}

package Leetcode;

public class ContainsDuplicate217 {
    public static void main(String[] args) {
        int n = 100000000;  // max allowed
        int[] nums = new int[n];
        for (int i = 0; i < n - 1; i++) {
            nums[i] = i + 1;
        }

        // Add duplicate at the very end
        nums[n - 1] = 1;

        System.out.println(containsDuplicate(nums));
    }
    static public boolean containsDuplicate(int[] nums) {
        sorting(nums,0,nums.length-1);
        for(int i=0;i<nums.length-1;i++)
        {
            if (nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
    static void sorting(int[] nums,int low,int hi){
        if(low>=hi)
            return;
        else {
            int start=low;
            int end=hi;
            int mid=start+(end-start)/2;
            int piv=nums[mid];
            while(start<=end)
            {
                while (nums[start]<piv)
                {
                    start++;
                }
                while (nums[end]>piv)
                {
                    end--;
                }
                if(start<=end)
                {
                    int temp=nums[start];
                    nums[start]=nums[end];
                    nums[end]=temp;
                    start++;
                    end--;
                }
            }
            sorting(nums,low,end);
            sorting(nums,start,hi);
        }
    }
}

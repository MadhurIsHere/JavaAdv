package Leetcode;
import java.util.Arrays;
import java.util.List;
public class MaximumFrequencyofanElementAfterPerformingOperationsI3346 {
    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[] {1,4,5},1,2));
    }
    public static int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int left=0,right=0,max=0;
        for(right=0;right<nums.length;right++)
        {
            while(nums[right]-nums[left]>2*k)
                left++;

            int windowsize=right-left+1;
            if(windowsize-1<=numOperations)
            {
                max=Math.max(max,windowsize);
            }
        }
        return max;
    }
}

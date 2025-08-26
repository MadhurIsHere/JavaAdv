package Leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinimumOperationstoExceedThresholdValueI3065 {
    public static void main(String[] args) {
        int[] nums={2,11,10,1,3};
        int k=10;
        System.out.println(minOperations(nums,k));
    }
    static public int minOperations(int[] nums, int k) {
//        int count=0;
//        for(int i :nums)
//        {
//            if(i<k)
//            {
//                count++;
//            }
//        }
//        return count;

        return (int) Arrays.stream(nums)
                .filter(i -> i < k)
                .count();
    }
}

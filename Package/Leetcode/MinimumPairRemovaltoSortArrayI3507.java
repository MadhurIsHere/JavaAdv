package Leetcode;

import java.util.ArrayList;

public class MinimumPairRemovaltoSortArrayI3507 {
    public static void main(String[] args) {
        System.out.println(minimumPairRemoval(new int[]{5,2,3,1}));
    }
    public static int minimumPairRemoval(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        int count=0;
        for(int i:nums)
        {
            list.add(nums[i]);
        }
        while (!isSorted(list)){
            int[] arr=min(list);
            int Min= arr[0]>arr[1] ? arr[1] :arr[0];
            list.set(Min,arr[0]+arr[1]);
            list.remove(Min+1);
            count++;
        }
        return count;
    }
    public static int[] min(ArrayList<Integer> nums)
    {
        int sumMin=Integer.MAX_VALUE;
        int[] sumMinIndex = new int[2];
        for(int i=0;i<nums.size()-1;i++)
        {
            int sum=nums.get(i)+nums.get(i+1);
            if(sum<sumMin)
            {
                sumMin=sum;
                sumMinIndex[0]=i;
                sumMinIndex[1]=i+1;
            }
        }
        return sumMinIndex;
    }
    static boolean isSorted(ArrayList<Integer> list)
    {
        for(int i=1;i<list.size();i++)
        {
            if(list.get(i-1)>list.get(i)) return false;
        }
        return true;
    }
}

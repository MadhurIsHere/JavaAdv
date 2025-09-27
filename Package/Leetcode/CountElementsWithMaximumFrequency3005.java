package Leetcode;

public class CountElementsWithMaximumFrequency3005 {
    public static void main(String[] args) {
        System.out.println(maxFrequencyElements(new int[] {1,2,3,4,5}));
    }
    public static int maxFrequencyElements(int[] nums) {
        int max=max(nums);
        int[] arr=new int[max+1];
        for(int i=0;i<=max;i++)
        {
            arr[i]=0;
        }
        for(int i=0;i<nums.length;i++)
        {
            arr[nums[i]]++;
        }
        max= max(arr);
        int freq=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==max)
                freq+=max;
        }
        return freq;
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

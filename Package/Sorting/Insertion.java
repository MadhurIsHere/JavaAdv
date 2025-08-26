package Sorting;
import java.util.Arrays;
public class Insertion {
    public static void main(String[] args) {
        int[] nums={5,3,4,1,2};
        Sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    static void Sort(int[] nums)
    {
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j>0;j--)
            {
                if(nums[j]<nums[j-1])
                {
                    swap(nums,j,j-1);
                }
                else
                {
                    break;
                }
            }
        }
    }
    static void swap(int[] nums,int a,int b)
    {
        int temp=nums[b];
        nums[b]=nums[a];
        nums[a]=temp;
    }
}

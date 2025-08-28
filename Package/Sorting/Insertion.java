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
        for(int i=1;i<nums.length;i++)
        {
            int key=nums[i];
            int j=i-1;
            while(j>=0 && nums[j]>key)
            {
                nums[j+1]=nums[j];
                j--;
            }
            nums[j+1]=key;
        }
    }
}

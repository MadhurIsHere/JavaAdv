package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={6,4,3,5,8};
        Quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void Quicksort(int[] nums,int low ,int hi)
    {
        if (low>=hi)
            return ;
        else
        {
            int end=hi;
            int start=low;
            int mid=start+(end-start)/2;
            int piv=nums[mid];
            while(start<=end)
            {
                while(nums[start]<piv)
                {
                    start++;
                }
                while(nums[end]>piv)
                {
                    end--;
                }
                if(start<=end)
                {
                    swap(nums,start,end);
                    start++;
                    end--;
                }
            }
            Quicksort(nums,low,end);
            Quicksort(nums,start,hi);
        }
    }
    static void swap(int[] arr, int a, int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}

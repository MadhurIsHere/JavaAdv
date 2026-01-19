package Practical;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={100,-21,23,2,-1,67};
        QuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void QuickSort(int[] arr,int low,int high)
    {
        if(low>=high)
        {
            return;
        }
        else
        {
            int start=low;
            int end=high;
            int mid=start+(end-start)/2;
            int pivot=arr[mid];
            while(start<=end)
            {
                while(arr[start]<pivot)
                {
                    start++;
                }
                while(arr[end]>pivot)
                {
                    end--;
                }
                if(start<=end)
                {
                    int temp=arr[start];
                    arr[start]=arr[end];
                    arr[end]=temp;
                    start++;
                    end--;
                }
            }
            QuickSort(arr,low,end);
            QuickSort(arr,start,high);
        }
    }
}

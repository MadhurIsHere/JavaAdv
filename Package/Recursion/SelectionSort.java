package Recursion;

import Sorting.Selection;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[]arr=new int[] {1,23,22,12,4};
        System.out.println(Arrays.toString(arr));
        selection(arr,0,5);
        System.out.println(Arrays.toString(arr));
    }
    static void selection(int[] arr,int start,int end)
    {
        if(start==end) return;
        if(start<end)
        {
            int min=min(arr,start,end);
            int temp=arr[start];
            arr[start]=arr[min];
            arr[min]=temp;
            selection(arr,start+1,end);
        }
    }
    static int min(int[] arr,int start,int end)
    {
        int min=start;
        for(int i=start+1;i<end;i++)
        {
            if(arr[min]>arr[i])
            {
                min=i;
            }
        }
        return min;
    }
}

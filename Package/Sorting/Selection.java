package Sorting;

import java.util.Arrays;

public class Selection {
    //driver code
    public static void main(String[] args) {
        int[] n={8,21,13,1,2,1,2,8,9,2,5,7};
        sorting(n);
        System.out.println(Arrays.toString(n));
    }
    //sorting function
    public static void sorting(int [] arr)
    {
        for(int i=0;i<arr.length-1;i++)
        {
            int min=min(arr,i, arr.length-1);
            swap(arr,i,min);
        }
    }
    // to get the index of the min element
    public static int min(int[] arr,int start,int end)
    {

        int min=start;
        for(int i=start+1;i<=end;i++)
        {
            if(arr[i]<arr[min])
                min=i;
        }
        return min;
    }
    // swap function
    public static void swap(int[] arr,int a, int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}

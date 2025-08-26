package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums={8,3,4,2,5,6};
        System.out.println(Arrays.toString(sort(nums)));
    }
    static int[] sort(int[] arr)
    {
        if(arr.length==1)
        {
            return arr;
        }
        int mid=arr.length/2;
        int[] left=sort(Arrays.copyOfRange(arr,0,mid));
        int[] right=sort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }
    static int[] merge(int[] first, int[] second)
    {
        int[] result=new int[first.length+second.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<first.length && j<second.length)
        {
            if(first[i]<second[j])
            {
                result[k]=first[i];
                i++;
            }
            else
            {
                result[k]=second[j];
                j++;
            }
            k++;
        }
        while(i<first.length)
        {
            result[k]=first[i];
            k++;
            i++;
        }
        while(j<second.length)
        {
            result[k]=second[j];
            k++;
            j++;
        }
        return result;
    }
}

package Revision.Class;

import java.util.Arrays;
/*
    Find the max element in an array and its index second max and third max
    Print the odd and even number
    Multiple of 3 and 5
    Reverse an array
    To check if the number is present in the array or not
*/
public class Question4 {
    public static void main(String[] args) {
        int[] arr={1,3,6,1,3,2,7,24,10,101};
        max(arr);
        oe(10);
        multi(3);
        System.out.println(Arrays.toString(arr));
        reverse(arr);
        System.out.println("The reversed array is "+ Arrays.toString(arr));
        System.out.println(present(arr,18));
    }
    // 1
    private static void max(int[] arr)
    {
        int max=Integer.MIN_VALUE;
        int secMax=Integer.MIN_VALUE;
        int thirdMax=Integer.MIN_VALUE;
        int indexMax=-1;
        int indexSecMax=-1;
        int indexThirdMax=-1;

        for(int i=0;i<arr.length;i++)
        {
            if(max<arr[i])
            {
                thirdMax=secMax;
                secMax=max;
                max=arr[i];
                indexThirdMax=indexSecMax;
                indexSecMax=indexMax;
                indexMax=i;
            }
            else if (secMax<arr[i])
            {
                thirdMax=secMax;
                secMax=arr[i];
                indexThirdMax=indexSecMax;
                indexSecMax=i;
            } else if (thirdMax<arr[i]) {
                thirdMax = arr[i];
                indexThirdMax = i;
            }
        }
        System.out.println("The max element here is : "+max+" and its index is "+indexMax);
        System.out.println("The second max element here is : "+secMax+" and its index is "+indexSecMax);
        System.out.println("The third max element here is : "+thirdMax+" and its index is "+indexThirdMax);
    }
    // 2
    private static void oe(int x)
    {
        System.out.println(((x&1)==1)?"Odd":"Even");
    }
    // 3
    private static void multi(int x)
    {
        for(int i=1;i<=10;i++)
        {
            System.out.println(x*i);
        }
    }
    // 4
    private static void reverse(int[] arr)
    {
        int start=0;
        int end=arr.length-1;
        while (start<end)
        {
            swap(arr,start,end);
            start++;
            end--;
        }
    }
    private static void swap(int[] arr,int a,int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    // 5
    private static boolean present(int[] arr,int target)
    {
        for(int i:arr)
        {
            if(i==target) return true;
        }
        return false;
    }
}

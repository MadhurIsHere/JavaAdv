package Revision.Class;

import java.util.Arrays;

public class Question5 {
    public static void main(String[] args) {
        int[] arr={100,29,13,13,4,2};
        System.out.println(Sorted(arr) );
        System.out.println(Arrays.toString(arr));
        int n=arr.length;
        int k=2;
        for(int i=n-k;i<n;i++)
        {
//            System.out.print(arr[i]);
        }
        for(int i=0;i<n-k;i++)
        {
//            System.out.print(arr[i]);
        }
//        System.out.println();
        for(int i=0;i<n;i++)
        {
            if(i<k)
            {
//                System.out.print(arr[i+k+1]);
            }
            else
            {
//                System.out.print(arr[i-k]);
            }
        }
//        System.out.println();

        for(int i=n-k;i<n+k+1;i++)
        {
//            System.out.print(arr[i%n]);
        }
//        int x=10;
//        int prev=arr[(x-1)%n];
//        for(int i=x;i<n+x;i++)
//        {
//            int temp=prev;
//            prev=arr[i%n];
//            arr[i%n]=temp;
//        }
//        for(int i=0;i<n;i++)
//        {
//            System.out.print(arr[i]+((i!=n-1)?", ":""));
//        }
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);

        System.out.println();
//        System.out.println(Arrays.toString(arr));
    }
    private static void reverse(int[] arr,int start,int end)
    {
        while(start<end)
        {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    private static boolean isSorted(int[] arr)
    {
        int n=arr.length;
        int countx=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i-1]>=arr[i])
            {
                countx++;
            }
            if(arr[i-1]<=arr[i])
            {
                countx--;
            }
        }
        return Math.abs(countx)==n-1;
    }
    private static boolean Sorted(int[] arr)
    {
        if(arr.length<=2) return true;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[0]<arr[1] && arr[i-1]>arr[i])
            {
                return false;
            }
            if(arr[0]>arr[1] && arr[i-1]<arr[i])
            {
                return false;
            }
        }
        return true;
    }
//    private static boolean isDescending(int[] arr)
//    {
//        for(int i=1;i<arr.length;i++)
//        {
//            if(arr[i-1]<arr[i])
//            {
//                return false;
//            }
//        }
//        return true;
//    }
}

package Revision.Class;

import java.util.Arrays;

public class Question6 {
    public static void main(String[] args) {
        // subarray [1,2,3,4]
        // [1],[2],[3],[1,2],[2,3],[3,4],[1,2,3]
        int[] arr={1,2,3,4,5};

        for(int i=0;i<arr.length;i++)
        {
            for(int j=i;j<arr.length;j++)
            {
                System.out.print(arr[j]+",");
            }
            System.out.println();
        }
        System.out.println(minimumSubarray(new int[]{-1, -2, -3}));
    }
    private void subarray(int[] arr,int index,int[] a)
    {

    }

    private static int minimumSubarray(int[] arr)
    {
        int currsum=0;
        int minSub=arr[0];
        for(int i:arr)
        {
            currsum+=i;
            minSub=Math.min(minSub,currsum);
            if(currsum>0) {
                currsum = 0;
            }
        }
        return minSub;
    }
}

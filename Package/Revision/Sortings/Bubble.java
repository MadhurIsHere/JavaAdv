package Revision.Sortings;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] arr={4,2,3,6,7,1,8,10};
        int n=arr.length;
        for(int i=0;i<n-1;i++)
        {
            boolean flag=false;
            for(int j=1;j<n-i-1;j++)
            {
                if(arr[j-1]>arr[j]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    flag=true;
                }
            }
            if(!flag)break;
        }
        System.out.println(Arrays.toString(arr));
    }
}

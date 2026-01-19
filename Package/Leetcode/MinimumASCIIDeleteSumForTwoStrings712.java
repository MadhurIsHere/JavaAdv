package Leetcode;

import java.util.Arrays;

public class MinimumASCIIDeleteSumForTwoStrings712 {
    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("delete","leet"));
    }
    public static int minimumDeleteSum(String s1, String s2) {
        char[] arr1=s1.toCharArray();
        char[] arr2=s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int sum=0;
        int i=0,j=0;
        while(i<arr1.length && j<arr2.length)
        {
            char ch1=arr1[i];
            char ch2=arr2[j];
            if(ch1==ch2)
            {
                i++;
                j++;
            }
            else
            {
                if(ch1<ch2)
                {
                    sum+=(int)ch1;
                    i++;
                }
                else
                {
                    sum+=(int)ch2;
                    j++;
                }
            }
        }
        while(i<arr1.length)
        {
            sum+=(int)arr1[i];
            i++;
        }
        while(j<arr2.length)
        {
            sum+=(int)arr2[j];
            j++;
        }
        return sum;
    }
}

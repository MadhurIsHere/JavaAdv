package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeparatetheDigitsinanArray2553 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(separateDigits(new int[] {13,25,8376,77})));
    }
    public static int[] separateDigits(int[] nums) {
        List<Integer> result=new ArrayList<>();
        for (int i:nums)
        {
            int len=(int)Math.log10(i)+1;

            int[] arr=new int[len];
            for(int j=len-1;j>=0;j--)
            {
                arr[j]=i%10;
                i/=10;
            }

            for(int k=0;k<len;k++)
            {
                result.add(arr[k]);
            }
        }
        int[] ans=new int[result.size()];
        for(int i=0;i<result.size();i++)
        {
            ans[i]=result.get(i);
        }
        return ans;
    }
}

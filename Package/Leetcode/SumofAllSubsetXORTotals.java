package Leetcode;
import java.util.ArrayList;
import java.util.List;

public class SumofAllSubsetXORTotals {
    public static void main (String[] args)
    {
        int[] a={5,6,1};
        System.out.println(subsetXORSum(a));
    }
    static public int subsetXORSum(int[] nums)
    {
        int n=1<<nums.length;                           // 2^n
        int sum=0;                                      // final answer
        for(int mask=0;mask<n;mask++)                   // till 2^n
        {
            int XOR=0;
            for (int j=0;j<nums.length;j++)
            {
                if((mask & (1<< j))!=0) {               // main logic
                    XOR^=nums[j];
                }
            }
            sum+=XOR;
        }
        return sum;
    }
}

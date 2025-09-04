package Leetcode;
import java.math.*;
public class TwoFurthestHousesWithDifferentColors2078 {
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[] {1,1,1,2,3,1,1}));
    }
    public static int maxDistance(int[] colors) {
        int max=0,n= colors.length;
        // check from start
        for(int i=n-1;i>=0;i--)
        {
            if(colors[i]!=colors[0])
            {
                max=Math.max(max,i);
                break;
            }
        }
        // check from back
        for (int i=0;i<n;i++)
        {
            if(colors[i]!=colors[n-1])
            {
                max=Math.max(max,(n-1)-i);
                break;
            }
        }

        return max;
    }
}

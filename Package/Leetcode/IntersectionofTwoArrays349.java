package Leetcode;

import java.util.*;

public class IntersectionofTwoArrays349 {
    public static void main(String[] args) {
        int[] n1={4,3,9,3,1,9,7,6,9,7};
        int[] n2={5,0,8};
        System.out.println(Arrays.toString(intersection(n1,n2)));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> ans=new ArrayList<>();
        int first=0, second=0,i;
        while(first<nums1.length && second< nums2.length)
        {
            if(nums1[first]==nums2[second])
            {
                ans.add(nums1[first]);
                first++;
                second++;
            }
            else if (nums1[first]<nums2[second]) first++;
            else second++;
        }
        Collections.sort(ans);
        System.out.println(ans);
        List<Integer> unique=new ArrayList<>();
        for(i=0;i<ans.size()-1;i++)
        {
            if(!(ans.get(i).equals(ans.get(i+1))))
                unique.add(ans.get(i));
        }
        unique.add(ans.get(i));
        System.out.println(unique);
        int[] k=new int[unique.size()];
        for(i=0;i<unique.size();i++)
        {
            k[i]=unique.get(i);
        }
        return k;
    }
}

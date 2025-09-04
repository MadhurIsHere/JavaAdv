package Leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckifOneStringSwapCanMakeStringsEqual1790 {
    public static void main(String[] args) {
        System.out.println(areAlmostEqual("madhur","madhru"));
    }
    public static boolean areAlmostEqual(String s1, String s2) {
//        char[] c1=s1.toCharArray();
//        char[] c2=s2.toCharArray();
//        Arrays.sort(c1);
//        Arrays.sort(c2);
//        int i=0;
//        while(i<c1.length){
//            char cf=c1[i];
//            char cs=c2[i];
//            if(!(cf==cs))
//                return false;
//            i++;
//        }
//        return true;

        if(s1.equals(s2)) return true;

        List<Integer> diff=new ArrayList<>();
        for(int i=0;i<s1.length();i++)
        {
            if(!(s1.charAt(i)==s2.charAt(i)))
            {
                diff.add(i);
            }
        }
        if(diff.size()!=2) return false;

        int i=diff.get(0),j=diff.get(1);
        return s1.charAt(i)==s2.charAt(j) && s1.charAt(j)==s2.charAt(i);
    }
}

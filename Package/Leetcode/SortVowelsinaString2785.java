package Leetcode;

import com.sun.source.tree.BreakTree;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SortVowelsinaString2785 {
    public static void main(String[] args) {
        System.out.println(sortVowels("cSqMsXICUMAIEPyGCrekvsEGjeKbyInGHAuGEpRnsgqCCrrDZbLYpAkWQjZCgUmVqnhrqlhntsQKGoLyvDjJvOqkXUnXkIYAtNfs"));
    }
    public static String sortVowels(String s) {
        StringBuilder vowel=new StringBuilder();
        String k= "aeiouAEIOU";
        // we have the vowels in separate sequence
        for(int i=0;i<s.length();i++)
        {

            boolean flag=k.contains(""+s.charAt(i));
            if(flag)
            {
                vowel.append(s.charAt(i));
            }
        }
        String j=vowel.toString();
        char[] arr=j.toCharArray();

        // sorting using merge sort
        arr=sort(arr);

        char[] result=s.toCharArray();
        for(int x=0,i=0;i<s.length();i++){
            if(k.contains(""+result[i]))
            {

                result[i]=arr[x++];
            }
        }
        return new String(result);
    }
    public static char[] sort(char[] arr)
    {
        if(arr.length<=1) return arr;
        int mid =arr.length/2;
        char[] left=sort(Arrays.copyOfRange(arr,0,mid));
        char[] right=sort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }
    static char[] merge(char[] first,char[] second )
    {
        char[] result=new char[first.length+second.length];
        int i=0,j=0,k=0;
        while(i< first.length && j< second.length)
        {
            if(first[i]<=second[j])
            {
                result[k++]=first[i++];
            }
            else {
                result[k++]=second[j++];
            }
        }
        while(i< first.length)
        {
            result[k++]=first[i++];
        }
        while(j< second.length)
        {
            result[k++]=second[j++];
        }
        return result;
    }
}

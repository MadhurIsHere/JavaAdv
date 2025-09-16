package Leetcode;
import java.util.Arrays;
public class FindMostFrequentVowelandConsonant3541 {
    public static void main(String[] args) {
        System.out.println(maxFreqSum("successes"));
    }
    public static int maxFreqSum(String s) {
        int max='a';
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>max)
            {
                max=s.charAt(i);
                System.out.println(s.charAt(i));
            }
        }
        max=max-'a'+1;
        int[] arrc=new int[max+1];
        int[] arrv=new int[max+1];
        for(int i=0;i<max+1;i++)
        {
            arrc[i]=0;
            arrv[i]=0;
        }
        System.out.println(max+1);
        System.out.println(Arrays.toString(arrc));
        System.out.println(Arrays.toString(arrv));
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if("aeiou".contains(""+ch)) arrv[ch-'a'+1]++;
            else arrc[s.charAt(i)+1-'a']++;
        }
        System.out.println(Arrays.toString(arrc));
        System.out.println(Arrays.toString(arrv));
        return max(arrc)+max(arrv);
    }
    static int max(int[] arr)
    {
        int max=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] > max)
            {
                max=arr[i];
            }
        }
        return max;
    }
}

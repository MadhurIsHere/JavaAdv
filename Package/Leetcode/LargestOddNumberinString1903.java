package Leetcode;

public class LargestOddNumberinString1903 {
    public static void main(String[] args) {
        System.out.println(largestOddNumber("23953767242388496965328710001000284"));
    }
    public static String largestOddNumber(String num) {
        for(int i=num.length()-1;i>=0;i--)
        {
            if(num.charAt(i)%2!=0)
            {
                return num;
            }
            num=num.substring(0,i);
        }
        return "";
    }
}

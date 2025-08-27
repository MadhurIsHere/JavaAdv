package Leetcode;
public class ReverseOnlyLetters917 {
    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("ab-cd"));
    }
    public static String reverseOnlyLetters(String s) {
        StringBuilder result=new StringBuilder();
        int i=0;
        int j = s.length() - 1;
        result.append(s);
        while(i<j)
        {
            char ch1=s.charAt(i);
            char ch2=s.charAt(j);
            // if the char at these indies are not alphabets
            if(!Character.isLetter(ch1))
            {
                result.setCharAt(i,ch1);
                i++;
            }
            if(!Character.isLetter(ch2))
            {
                result.setCharAt(j,ch2);
                j--;
            }
            // if both the characters are alphabets then do it.
            if(Character.isLetter(ch2) && Character.isLetter(ch1))
            {
                result.setCharAt(i,ch2);
                result.setCharAt(j,ch1);
                i++;
                j--;
            }
        }
        return result.toString();
    }
}

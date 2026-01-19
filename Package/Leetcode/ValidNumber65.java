package Leetcode;

public class ValidNumber65 {
    public static void main(String[] args) {

    }
    public static boolean isNumber(String s) {
        for(char ch: s.toCharArray())
        {
            if(!Character.isDigit(ch) && !(ch=='e' || ch=='E'))
            {
                continue;
            }
        }
        return 0==0;
    }
}

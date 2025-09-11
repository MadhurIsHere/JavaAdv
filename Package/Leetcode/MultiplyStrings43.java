package Leetcode;

public class MultiplyStrings43 {
    public static void main(String[] args) {
        System.out.println(multiply("12","3034234"));
    }
    public static String multiply(String num1, String num2) {
        long n1=0,n2=0;
        for(int i=0;i<num1.length();i++)
        {
            n1=n1*10+num1.charAt(i)-'0';
        }
        for(int i=0;i<num2.length();i++)
        {
            n2=n2*10+num2.charAt(i)-'0';
        }
        System.out.println(n1+" "+n2);
        Long ans=n1*n2;
        return ans.toString();
    }
}

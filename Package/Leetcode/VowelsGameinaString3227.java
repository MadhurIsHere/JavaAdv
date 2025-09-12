package Leetcode;

public class VowelsGameinaString3227 {
    public static void main(String[] args) {
//        int marks=Integer.parseInt();
        System.out.println(doesAliceWin("leetcoder"));
    }
    public static boolean doesAliceWin(String s) {
        int count =0;
        for(int i=0;i<s.length();i++)
        {
            String k="aeiouAEIOU";
            if(k.contains(""+s.charAt(i))) count++;
        }
        if(count==0) return false;

        return true;

    }
}

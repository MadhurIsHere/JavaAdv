package Leetcode;


import javax.swing.*;
import java.util.ArrayList;

import java.math.*;
import java.util.List;

public class PalindromeNumber9 {
    public static void main(String[] args) {
        int n=123454321;
        System.out.println(isPalindrome(n));
    }
    static public boolean isPalindrome(int x) {
        if(x<0 || (x%10==0 && x!=0)) return false;
        int rev=0;
        while(x>rev)
        {
            rev=rev*10+x%10;
            x/=10;
        }
        return (x==rev || x==rev/10);
    }
}

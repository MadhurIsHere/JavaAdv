package Leetcode;

public class LongestPalindromicSubstring5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (!check(s, i, j)) {
                    if (max > (j - i + 1)) {
                        ans = s.substring(i, j);
                    }
                }
            }
        }
        return ans;
    }

    private static boolean check(String s, int l, int h) {
        while (l < h) {
            if (s.charAt(l) != s.charAt(h)) {
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
}

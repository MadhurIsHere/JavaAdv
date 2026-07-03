package Codeforce;

import java.util.Scanner;

public class ChewAndNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long x = in.nextLong();
        System.out.println(helper(x));
    }

    private static long helper(long x) {
        if (x <= 9) return x;
        String y = String.valueOf(x);
        x = 0;
        for (int i = 0; i < y.length(); i++) {
            char ch = y.charAt(i);
            int digit = (int) ch - '0';
            if (digit == 9 && i == 0) {
                // first digit and its 9 so we don't want trail 0's
                digit = digit;
            } else if (digit >= 5) {
                digit = 9 - digit;
            }
            x = x * 10 + digit;
        }
        return x;
    }
}



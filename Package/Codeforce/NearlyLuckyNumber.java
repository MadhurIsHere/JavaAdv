package Codeforce;

import java.util.Scanner;

public class NearlyLuckyNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();

        long count = 0;
        while (n > 0) {
            long digit = n % 10;
            if (digit == 4 || digit == 7) {
                count++;
            }
            n /= 10;
        }

        boolean flag = true;
        if (count == 0) flag = false;
        while (count > 0) {
            long digit = count % 10;
            if (digit != 7 && digit != 4) {
                flag = false;
                break;
            }
            count /= 10;
        }
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        System.out.println(Math.log10(
                100
        ));

    }
}

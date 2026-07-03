package Bitwise;

import java.util.Arrays;

public class Shifts {
    public static void main(String[] args) {
        String[] ans = new String[4];
        ans[0] = "10";
        ans[1] = "2";
        ans[3] = "4";
        System.out.println(ans[2]);
        System.out.println(Arrays.toString(ans));
    }

    private static void prime(int n) {
        boolean flag = true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("prime");
        } else {
            System.out.println("Not a prime");
        }
    }

    private static void pattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("  ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
//    private static void diamond(int n)
//    {
//        for(int i=0;i<2*n-1;i++)
//        {
//            for(int j=0;j<)
//        }
//    }
}

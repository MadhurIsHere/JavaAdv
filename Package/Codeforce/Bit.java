package Codeforce;

import java.util.Scanner;

public class Bit {
    static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        bit();
    }

    private static void bit() {
        int n = in.nextInt();
        int x = 0;
        for (int i = 0; i < n; i++) {
            String y = in.next();
            if (y.charAt(1) == '+') {
                x++;
            } else {
                x--;
            }
        }
        System.out.println(x);
    }
}

package Codeforce;

import java.util.Scanner;

public class InSearchofanEasyProblem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean flag = false;
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (x == 1) flag = true;
        }
        if (flag) System.out.println("HARD");
        else System.out.println("EASY");
    }
}

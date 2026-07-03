package Codeforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumofRoundNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = in.nextInt();
        }

        for (int i = 0; i < t; i++) {
            List<Integer> ans = new ArrayList<>();
            int x = arr[i];
            int y = 1;
            while (x > 0) {
                int digit = x % 10;
                if (digit != 0) {
                    ans.add(digit * y);
                }
                y = y * 10;
                x /= 10;
            }
            System.out.println(ans.size());
            for (int j : ans) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
}

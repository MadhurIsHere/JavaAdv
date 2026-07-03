package Codeforce;

import java.util.Scanner;

public class BeautifulMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        System.out.println(helper(arr));
    }

    private static int helper(int[][] arr) {
        int[] pos = new int[2];
        for (int i = 0; i < 5; i++) {
            boolean flag = false;
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == 1) {
                    pos[0] = i;
                    pos[1] = j;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        return Math.abs(pos[0] - 2) + Math.abs(pos[1] - 2);
    }
}

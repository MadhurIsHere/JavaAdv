import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        int max = 0;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr -= arr[i][0];
            curr += arr[i][1];
            max = Math.max(curr, max);
        }
        System.out.println(max);
    }
}
package Lambda;

import java.util.Arrays;

public class TwoDArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3},
                {0, 6},
                {8, 10},
                {15, 18}
        };
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int i = 1;
        int number = 5;
        int ans = 0;
        double x = (double) i / number;
        double y = Math.ceil(x);
        ans += (int) (y);
        System.out.println(x);
        System.out.println(y);
        System.out.println(ans);
//        System.out.println(Math.ceil(z));
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}

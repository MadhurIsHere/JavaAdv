package ArithmeticBasicReasoning;

import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence {
    public static void main(String[] args) {
        System.out.println(canMakeArithmeticProgression(new int[]{3, 5, 1}));
    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int differ = Math.abs(arr[0] - arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int diff = Math.abs(arr[i - 1] - arr[i]);
            if (diff != differ) {
                return false;
            }
        }
        return true;
    }
}

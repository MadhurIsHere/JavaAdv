package Leetcode;

public class KthMissingPositiveNumber1539 {
    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2}, 1));
    }

    public static int findKthPositive(int[] arr, int k) {
        int i = 0, j = 1;
        int count = 1;
        while (j <= 1000 && i < arr.length) {
            while (j < arr[i]) {
                j++;
                count++;
                if (count == k) {
                    return j;
                }
            }
            j++;
            i++;
        }
        if (count < k) {
            j++;
            count++;
        }
        return j;
    }
}

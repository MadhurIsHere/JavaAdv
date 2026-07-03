package Recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 23, 22, 12, 4};
        System.out.println(Arrays.toString(arr));
        Bubble(arr, 0, 5);
        System.out.println(Arrays.toString(arr));
    }

    static void Bubble(int[] arr, int start, int len) {
        if (len == 0) return;
        if (start < len - 1) {
            if (arr[start] > arr[start + 1]) {
                int temp = arr[start];
                arr[start] = arr[start + 1];
                arr[start + 1] = temp;
            }
            Bubble(arr, start + 1, len);
        } else {
            Bubble(arr, 0, len - 1);
        }
    }
}

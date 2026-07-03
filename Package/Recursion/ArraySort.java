package Recursion;

public class ArraySort {
    public static void main(String[] args) {
        System.out.println(sort(new int[]{1, 2, 3, 4, 5, 6}, 0));
    }

    static boolean sort(int[] arr, int n) {
        if (arr.length == n + 1) return true;
        return arr[n] < arr[n + 1] && sort(arr, n + 1);
    }
}

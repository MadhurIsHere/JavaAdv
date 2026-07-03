package Recursion;

public class LinearSearch {
    public static void main(String[] args) {
        System.out.println(linearSearch(new int[]{1, 23, 453, 34, 2, 423, 342, 24}, 24, 0));
    }

    public static boolean linearSearch(int[] arr, int target, int index) {
        if (index == arr.length) return false;
        return (arr[index] == target) || linearSearch(arr, target, index + 1);
    }
}

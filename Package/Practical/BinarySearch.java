package Practical;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 10};
        int target = 3;
        System.out.println(Binary(arr, target));
    }

    static int Binary(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] > target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}




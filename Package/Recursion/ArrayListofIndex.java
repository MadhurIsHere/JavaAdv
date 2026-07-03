package Recursion;

import java.util.ArrayList;

public class ArrayListofIndex {
    public static void main(String[] args) {
        ArrayList<Integer> ans = new ArrayList<>();
        System.out.println(withoutReturn(new int[]{1, 2, 3, 3, 4, 3, 5}, 3, 0));
    }

    static ArrayList<Integer> index(int[] arr, int target, int index, ArrayList<Integer> list) {
        if (index == arr.length) return list;
        if (target == arr[index]) list.add(index);
        return index(arr, target, index + 1, list);
    }

    static ArrayList<Integer> withoutReturn(int[] arr, int target, int index) {
        ArrayList<Integer> result = new ArrayList<>();
        if (index == arr.length) return result;
        if (arr[index] == target) {
            result.add(index);
        }
        ArrayList<Integer> ansfromprev = withoutReturn(arr, target, index + 1);
        result.addAll(ansfromprev);
        return result;
    }
}

package Codeforce;

import java.util.Scanner;

public class ArrivaloftheGeneral {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int smallest = 0;
        int largest = 0;
        for (int i = 0; i < n; i++) {
            if (arr[smallest] >= arr[i]) smallest = i;
            if (arr[largest] <= arr[i]) largest = i;
        }

        if (smallest < largest) {
            System.out.println(largest + (n - 1 - smallest) - 1);
        } else {
            System.out.println(largest + (n - smallest - 1));
        }
    }
}

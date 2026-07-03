package Heap;

public class Heap {
    private int[] arr;
    private int size;
    private int capacity;

    Heap(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity + 1];
        size = 0;
        String x = "vf";
    }

    private void heapify(int i) {
        int largest = i;
        int left = 2 * i;
        int right = 2 * i + 1;

        if (left <= size && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right <= size && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    public void load(int[] input) {
        size = input.length;
        for (int i = 0; i < size; i++) {
            arr[i + 1] = input[i];
        }

    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

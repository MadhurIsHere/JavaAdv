package Class;
public class GenericSwap {
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2};
        String[] strArray = {"Hello", "World"};
        Double[] dblArray = {1.1, 2.2};

        System.out.println("Before Swap: " + intArray[0] + ", " + intArray[1]);
        swap(intArray, 0, 1);
        System.out.println("After Swap: " + intArray[0] + ", " + intArray[1]);

        System.out.println("Before Swap: " + strArray[0] + ", " + strArray[1]);
        swap(strArray, 0, 1);
        System.out.println("After Swap: " + strArray[0] + ", " + strArray[1]);

        System.out.println("Before Swap: " + dblArray[0] + ", " + dblArray[1]);
        swap(dblArray, 0, 1);
        System.out.println("After Swap: " + dblArray[0] + ", " + dblArray[1]);
    }
}
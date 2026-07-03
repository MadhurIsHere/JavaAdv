package ArithmeticBasicReasoning;

public class FindthePivotInteger {
    public static void main(String[] args) {
        System.out.println(pivotInteger(4));
    }

    public static int pivotInteger(int n) {
        float total_sum = (float) n * (n + 1) / 2;
        float prefix = 0;
        for (int i = 1; i <= n; i++) {
            prefix += i;
            if (prefix == (total_sum + i) / 2) {
                return i;
            }
        }

        return -1;
    }
}

package ProblemSolving;

public class P03 {
    public static void main(String[] args) {
        table(1, 2);
    }

    static void table(int index, int n) {
        if (index == 11) {
            return;
        }
        System.out.println(index * n);
        table(index + 1, n);
    }
}

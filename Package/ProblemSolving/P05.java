package ProblemSolving;

public class P05 {
    public static void main(String[] args) {
        System.out.println(digit(336));
    }

    static int digit(int n) {
        if (n <= 0) {
            return 0;
        }
        return digit(n / 10) + 1;
    }
}

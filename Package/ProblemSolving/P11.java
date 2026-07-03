package ProblemSolving;

public class P11 {
    public static void main(String[] args) {

        int a = 1;
        int b = 145;

        while (a <= b) {
            int n = a;
            int copy = n;
            int strong = 0;
            while (n > 0) {
                int digit = n % 10;
                strong += fact(digit);
                n /= 10;
            }
            String ans = copy == strong ? "strong" : "not strong";
            System.out.println("The number " + a + " is " + ans);
            a++;
        }
    }

    private static int fact(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fact(n - 1);
    }
}

package ExceptionHandling;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        int c = 0;
        String x = "101023";
        int i = 0;
        int j = 1;
        int k = 3;
        System.out.println(x.substring(j + 1, k - j));
        try {
            int b = divide(a, c);
            System.out.println(b);
            String name = "Madhur";
            if (name.equals("Madhur")) {
                throw new MyException("My name is Madhur");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("This will be run no matter what");
        }
    }

    static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Don't divide by 0");
        }
        return a / b;
    }
}

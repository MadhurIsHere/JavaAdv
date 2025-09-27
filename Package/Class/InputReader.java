package Class;
    import java.util.Scanner;
    class NegativeNumberNotAllowedException extends Exception {
        public NegativeNumberNotAllowedException(String msg) {
            super(msg);
        }
    }

    public class InputReader {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int[] numbers = new int[5];
            int count = 0;
            while (count < numbers.length) {
                try {
                    System.out.print("Enter a positive integer: ");
                    int num = Integer.parseInt(scanner.nextLine());
                    if (num < 0) throw new NegativeNumberNotAllowedException("Negative numbers are not allowed.");

                    numbers[count] = num;
                    System.out.println("Stored: " + num);
                    count++;

                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter an integer.");
                } catch (NegativeNumberNotAllowedException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Array is full. Cannot store more numbers.");
                    break;
                }
            }

            System.out.println("\nAll stored numbers:");
            for (int n : numbers) {
                System.out.println(n);
            }
        }
    }

import java.util.Scanner;

public class Customer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean inputStarted = false;
        while (!inputStarted) {
            System.out.printf("Which base type do you want to start with?");
            System.out.printf("1. Core i5");
            System.out.printf("2. Core i7");
            System.out.printf("3.Core i9");
            System.out.printf("Gaming PC (AMD Ryzen 5700X)");
            try {
                int inp = scanner.nextInt();
                if (inp < 1 || inp > 3) throw new Exception();
                else inputStarted = true;
            } catch (Exception e) {
            }
        }
        scanner.close();
    }
}

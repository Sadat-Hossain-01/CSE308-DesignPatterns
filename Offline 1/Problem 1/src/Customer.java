import java.util.Scanner;

public class Customer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean inputStarted = false;

        while (!inputStarted) {
            System.out.println("Which base type do you want to start with?");
            System.out.println("1. Core i5");
            System.out.println("2. Core i7");
            System.out.println("3.Core i9");
            System.out.println("4. Gaming PC (AMD Ryzen 5700X)");
            try {
                int inp = scanner.nextInt();
                if (inp < 1 || inp > 4) throw new Exception();
                else inputStarted = true;
            } catch (Exception e) {
                System.out.println("Please input a valid number between 1 to 4.");
            }
        }

        scanner.close();
    }
}

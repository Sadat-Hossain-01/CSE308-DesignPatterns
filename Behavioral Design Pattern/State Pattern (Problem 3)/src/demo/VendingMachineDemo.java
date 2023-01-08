package demo;

import machine.VendingMachine;

import java.util.Scanner;

public class VendingMachineDemo {
    private static Scanner scanner;

    public static int takeIntInput() {
        String input = "";
        input = scanner.nextLine();
        int ret = 0;
        try {
            ret = Integer.parseInt(input);
        } catch (Exception e) {
            ret = -1; // make sure -1 is not a valid input at any point
        }
        return ret;
    }

    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        scanner = new Scanner(System.in);
        String input = "";
        System.out.println("Welcome to the Vending Machine Interface!");

        while (true) {
            System.out.print("\n\n");
            System.out.println("No. of products in inventory: " + vm.getProductCount());
            System.out.println("Product Price: $" + vm.productPrice);
            System.out.println("Your current balance: $" + vm.getCurrentBalance());
            System.out.println("======================================================");
            System.out.println("Press the designated button for particular choices:");
            System.out.println("1. Pay Money");
            System.out.println("2. Get the Product.");
            System.out.println("3. Cancel Payment.");
            System.out.println("4. Request Refill");
            System.out.println("5. Exit System Interface.");

            input = scanner.nextLine();
            if (input.length() == 0) continue;
            char c = input.charAt(0);
            if (input.length() > 1 || c > '5' || c < '1') {
                System.out.println("Please provide a valid choice.");
            }

            if (c == '1') {
                int amount = -1;
                while (true) {
                    System.out.print("Enter your credit amount: ");
                    amount = takeIntInput();
                    if (amount > 1000) { // transaction over $1000 is not allowed
                        System.out.println("Sorry, we do not accept transactions over $1000.");
                    } else if (amount <= 0) {
                        System.out.println("Please provide a valid credit amount.");
                    } else break;
                }
                vm.collectMoney(amount);
            } else if (c == '2') {
                vm.deliverProduct();
            } else if (c == '3') {
                vm.cancelPayment();
            } else if (c == '4') {
                vm.refill();
            } else if (c == '5') {
                System.out.println("Hope to see you soon!!!");
                break;
            }
        }
    }
}

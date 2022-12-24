import java.util.Scanner;

public class VendingMachineDemo {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        System.out.println("Welcome to the Vending Machine Interface!");

        while (true) {
            System.out.println();
            System.out.println();
            System.out.println("No. of products in inventory: " + vm.getProductCount());
            System.out.println("======================================================");
            System.out.println("Press the designated buttons for particular choices:");
            System.out.println("1. Buy a product ($" + VendingMachine.productPrice + ").");
            System.out.println("2. Request a refill of the vending machine.");
            System.out.println("3. Exit system interface.");

            String inp = scanner.nextLine();
            if (inp.length() == 0) {
                continue;
            }
            char c = inp.charAt(0);

            if (c == '1') {
                boolean inpOn = true;
                System.out.println("Pay first please.");
                long inpAmount = 0;
                while (inpOn) {
                    System.out.print("Input your provided amount: ");
                    inp = scanner.nextLine();
                    try {
                        inpAmount = Long.parseLong(inp);
                        if (inpAmount <= 0) throw new Exception();
                        inpOn = false;
                    } catch (Exception e) {
                        System.out.println("Please input a valid amount.");
                    }
                }
                vm.collectMoney(inpAmount);
            }
            else if (c == '2') {
                boolean inpOn = true;
                int inpAmount = 0;
                while (inpOn) {
                    System.out.print("Input how many you want to refill: ");
                    inp = scanner.nextLine();
                    try {
                        inpAmount = Integer.parseInt(inp);
                        if (inpAmount <= 0) throw new Exception();
                        inpOn = false;
                    } catch (Exception e) {
                        System.out.println("Please input a valid quantity.");
                    }
                }
                vm.refill(inpAmount);
            }
            else if (c == '3') {
                System.out.println("Thanks for your visit. Visit us again!");
                break;
            }
            else {
                System.out.println("Please provide a valid input choice.");
            }
        }

        scanner.close();
    }
}

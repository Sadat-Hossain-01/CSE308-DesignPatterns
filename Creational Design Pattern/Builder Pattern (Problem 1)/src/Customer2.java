import java.nio.charset.CharacterCodingException;
import java.util.Scanner;

public class Customer2 {
    public static Scanner sc = new Scanner(System.in);
    public static String inp;
    public static char c;

    public static void takeNewOrder() {
        int itemCount = 0;
        System.out.println("New order menu opened.");
        System.out.println("");

        PCBuilder builder = null;
        boolean pcInitiated = false;
        boolean orderOn = true;

        while (orderOn) {
            while (!pcInitiated) {
                System.out.println("");
                System.out.println("Which Base PC do you want to start with?");
                System.out.println("Press E to close the order.");
                System.out.println("1. Intel 11th Gen Core i5 PC");
                System.out.println("2. Intel 11th Gen Core i7 PC");
                System.out.println("3. Intel 11th Gen Core i9 PC");
                System.out.println("4. Gaming PC (AMD Ryzen 5700X)");

                while (true) {
                    inp = sc.nextLine();
                    if (inp.length() == 0) continue;
                    c = inp.charAt(0);
                    break;
                }

                if (c == 'e' || c == 'E') {
                    if (itemCount == 0) {
                        System.out.println("Sir, you have to order at least one item. Please choose any of your liking.");
                        continue;
                    } else {
                        System.out.println("Order closed.");
                        System.out.println("");
                        orderOn = false;
                        return;
                    }
                } else if (c == 'O' || c == 'o') {
                    while (true) {
                        System.out.println("You have an ongoing order! Do you want to add any more PC to this order?");
                        System.out.println("Press Y if you want to, N otherwise.");
                        while (true) {
                            inp = sc.nextLine();
                            if (inp.length() == 0) continue;
                            c = inp.charAt(0);
                            break;
                        }
                        if (c == 'Y' || c == 'y') {
                            break;
                        }
                        else if (c == 'N' || c == 'n') {
                            if (itemCount == 0) {
                                System.out.println("Sir, you have to order at least one item. Please choose any of your liking.");
                                break;
                            } else {
                                System.out.println("Order closed.");
                                System.out.println("");
                                orderOn = false;
                                return;
                            }
                        }
                        else continue;
                    }
                } else if (c < '1' || c > '4') {
                    System.out.println("Please provide a valid input choice between 1 to 4.");
                } else {
                    if (c == '1') builder = new i5Builder();
                    else if (c == '2') builder = new i7Builder();
                    else if (c == '3') builder = new i9Builder();
                    else if (c == '4') builder = new GamingPCBuilder();
                    pcInitiated = true;
                    break;
                }
            }

            PCDirector director = new PCDirector(builder);
            director.constructPC();

            System.out.println("Base PC initiated successfully.");

            while (true) {
                System.out.println("");
                System.out.println("What more do you want to add to your PC?");
                System.out.println("1. 8GB DDR4 RAM (2666 MHz)");
                System.out.println("2. 8GB DDR4 RAM (3200 MHz)");
                System.out.println("3. 2GB Graphics Card");
                System.out.println("4. 4GB Graphics Card");
                System.out.println("Press C to finish building the PC.");

                while (true) {
                    inp = sc.nextLine();
                    if (inp.length() == 0) continue;
                    c = inp.charAt(0);
                    break;
                }

                if (c == '1') director.addRAM(2666);
                else if (c == '2') director.addRAM(3200);
                else if (c == '3') director.addGraphicsCard(2);
                else if (c == '4') director.addGraphicsCard(4);
                else if (c == 'C' || c == 'c') {
                    PC pc = builder.getConstructedPC();
                    pc.showPCDetails();
                    itemCount++;
                    // this PC building done
                    break;
                } else if (c == 'O' || c == 'o') {
                    System.out.println("An order is ongoing! Please finish this one first.");
                } else {
                    System.out.println("Please provide a valid input choice.");
                }
            }

            pcInitiated = false; // for the next PC in this order
        }
    }

    public static void main(String[] args) {
        boolean isShopping = true;

        while (isShopping) {
            System.out.println("Press O to start a new order, Q to quit.");

            while (true) {
                inp = sc.nextLine();
                if (inp.length() == 0) continue;
                c = inp.charAt(0);
                break;
            }

            if (c == 'o' || c == 'O') {
                // start a new order
                takeNewOrder();
            } else if (c == 'q' || c == 'Q') {
                System.out.println("Thanks for visiting us, hope to see you again!");
                isShopping = false;
                break;
            } else if (c == 'e' || c == 'E') {
                System.out.println("No order is ongoing.");
            } else {
                System.out.println("Please provide a valid input choice.");
            }
        }

        sc.close();
    }
}

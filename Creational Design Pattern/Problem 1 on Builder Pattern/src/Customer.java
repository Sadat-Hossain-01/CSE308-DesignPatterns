import java.util.Scanner;

public class Customer {
    public static Scanner sc = new Scanner(System.in);
    public static String inp;
    public static char c;

    public static void takeNewPCOrder() {
        boolean orderStarted = false;

        while (!orderStarted) {
            System.out.println("Which Base PC do you want to start with?");
            System.out.println("1. Intel Core i5 PC");
            System.out.println("2. Intel Core i7 PC");
            System.out.println("3. Intel Core i9 PC");
            System.out.println("4. Gaming PC (AMD Ryzen 5700X)");

            inp = sc.next();
            c = inp.charAt(0);

            if (c == 'e' || c == 'E') System.out.println("You have to at least choose the base PC type");
            else if (c < '1' || c > '4') System.out.println("Please choose a proper choice between number 1 to 4.");
            else orderStarted = true;
        }

        PCBuilder builder = null;

        if (c == '1') builder = new i5Builder();
        else if (c == '2') builder = new i7Builder();
        else if (c == '3') builder = new i9Builder();
        else builder = new GamingPCBuilder();

        PCDirector director = new PCDirector(builder);
        director.constructPC();

        System.out.println("Base PC Initiated.");

        boolean orderOn = true;

        while (orderOn) {
            System.out.println("What more do you want to add to your PC?");
            System.out.println("1. 8GB DDR4 RAM (2666 MHz)");
            System.out.println("2. 8GB DDR4 RAM (3200 MHz)");
            System.out.println("3. 2GB Graphics Card");
            System.out.println("4. 4GB Graphics Card");
            System.out.println("Press E to finish building the PC.");

            inp = sc.next();
            c = inp.charAt(0);

            if (c == '1') builder.addRAM(2666);
            else if (c == '2') builder.addRAM(3200);
            else if (c == '3') builder.addGraphicsCard(2);
            else if (c == '4') builder.addGraphicsCard(4);
            else if (c == 'o' || c == 'O') {
                System.out.println("You have to finish building this PC first! Do you want to add something else to this PC?");
                while (true) {
                    System.out.println("Press Y to add more, N to finish.");
                    c = sc.next().charAt(0);
                    if (c == 'Y' || c == 'y') break;
                    else if (c == 'N' || c == 'n') {
                        orderOn = false;
                        break;
                    }
                }
            }
            else if (c == 'E' || c == 'e') {
                orderOn = false;
                break;
            }
        }

        PC pc = builder.getConstructedPC();
        pc.showPCDetails();
    }

    public static void main(String[] args) {
        int cnt = 0;

        while (true) {
            System.out.println("Press O to start a new order, and Q to quit the shop.");
            inp = sc.next();
            c = inp.charAt(0);

            if (c == 'q' || c == 'Q') {
                System.out.println("Thanks for visiting us, hope to see you again!");
                break;
            }
            else if (c == 'O' || c == 'o') {
                // start a new order
                takeNewPCOrder();
                cnt++;
            }
            else if (c == 'E' || c == 'e') {
                System.out.println("No order is ongoing right now! Press O if you want to start a new one!");
            }
            else {
                System.out.println("Please provide a valid input choice!");
            }
        }

        sc.close();
    }
}

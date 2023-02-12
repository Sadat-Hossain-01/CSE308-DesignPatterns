import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static Scanner scanner = new Scanner(System.in);

    public static Coffee customizeCoffee(Coffee c) {
        while (true) {
            System.out.println("What do you want to add to your coffee?");
            System.out.println("1. Coffee Beans");
            System.out.println("2. Milk");
            System.out.println("3. Dairy Cream");
            System.out.println("4. Cinnamon Powder");
            System.out.println("5. Chocolate Sauce");
            System.out.println("6. Confirm Customization");

            char choice = scanner.next().charAt(0);
            switch (choice) {
                case '1':
                    c = new ExtraCoffeeBeans(c);
                    break;
                case '2':
                    c = new ExtraMilk(c);
                    break;
                case '3':
                    c = new ExtraDairyCream(c);
                    break;
                case '4':
                    c = new ExtraCinnamonPowder(c);
                    break;
                case '5':
                    c = new ExtraChocolateSauce(c);
                    break;
                case '6':
                    return c;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        char choice;
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to the কফি টং!");
            // a new user is here to order coffee(s)
            List<Coffee> coffeeList = new ArrayList<>(); // list of all coffee for this user
            boolean orderDone = false;
            int totalCost = 0;
            while (!orderDone && !exit) {
                System.out.println("What type of coffee do you want to order?");
                System.out.println("1. Americano");
                System.out.println("2. Espresso");
                System.out.println("3. Cappuccino");
                System.out.println("4. Mocha");
                System.out.println("5. Customized Black Coffee");
                System.out.println("6. Customized Milk Coffee");
                System.out.println("7. Finish Order");

                choice = scanner.next().charAt(0);
                Coffee c = null;

                switch (choice) {
                    case '1':
                        c = new ExtraCoffeeBeans(new BlackCoffee());
                        c.setName("Americano");
                        break;
                    case '2':
                        c = new ExtraDairyCream(new BlackCoffee());
                        c.setName("Espresso");
                        break;
                    case '3':
                        c = new ExtraCinnamonPowder(new MilkCoffee());
                        c.setName("Cappuccino");
                        break;
                    case '4':
                        c = new ExtraChocolateSauce(new MilkCoffee());
                        c.setName("Mocha");
                        break;
                    case '5':
                        c = new BlackCoffee();
                        c = customizeCoffee(c);
                        break;
                    case '6':
                        c = new MilkCoffee();
                        c = customizeCoffee(c);
                        break;
                    case '7':
                        orderDone = true;
                        break;
                    case 'q': // keeping this option for quitting the program
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice!\n");
                        break;
                }

                if (c != null) {
                    coffeeList.add(c);
                    totalCost += c.getCost();
                    System.out.println("Coffee added to order!\n");
                }
            }

            if (exit) break;

            // print the order summary
            System.out.println("Total Price: " + totalCost + " BDT");
            System.out.println("==============================");
            for (Coffee c : coffeeList) {
                c.showDescription();
                System.out.print("\n");
            }
            System.out.print("Hope to see you later in our premises!\n\n");
        }
    }
}

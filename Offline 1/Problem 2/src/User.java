import java.util.Scanner;

public class User {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer choice = 0;
        boolean choiceMade = false;

        while (!choiceMade) {
            System.out.println("Press the respective number to choose your location:");
            System.out.println("1. Asia");
            System.out.println("2. Europe");
            System.out.println("3. United States");
            try {
                choice = scanner.nextInt();
                if (choice != 1 && choice != 2 && choice != 3) throw new Exception();
                else choiceMade = true;
            } catch (Exception e) {
                System.out.println("Please input a valid number.");
            }
        }

        CarFactory carFactory = new CarFactory();
        Car car = null;

        if (choice == 1) car = carFactory.produceCar("Asia");
        else if (choice == 2) car = carFactory.produceCar("Europe");
        else car = carFactory.produceCar("United States");

        car.showDetails();
    }
}

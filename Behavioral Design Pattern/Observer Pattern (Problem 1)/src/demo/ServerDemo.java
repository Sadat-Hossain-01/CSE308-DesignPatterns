package demo;

import observers.Observer;
import observers.PremiumUser;
import observers.RegularUser;
import subject.ABCCompany;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerDemo {
    private static Scanner scanner;
    private static ABCCompany server;
    private static List<Observer> users;

    private static int takeIntInput(int l, int r) { // will need this method in different cases for taking inputs
        // [l, r] is the input choice range
        assert scanner != null;
        int choice = 0;
        String input = "";

        do {
            input = scanner.nextLine();
        } while (input.isEmpty());
        try {
            choice = Integer.parseInt(input);
            if (choice < l || choice > r) throw new Exception();
        } catch (Exception e) {
            System.out.println("Please enter a valid choice.");
            choice = -1;
        }

        return choice;
    }

    private static String takeStringInput() {
        assert scanner != null;
        String input = "";

        do {
            input = scanner.nextLine();
        } while (input.isEmpty());

        return input;
    }

    private static Observer findUser(String userName) {
        for (Observer user : users) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }

        return null;
    }

    private static void addUser() {
        if (server.getCurrentState() == ABCCompany.State.FULLY_DOWN) {
            System.out.println("Server is down. Please try again later.");
            return;
        }
        String input = "";
        int choice = 0;
        while (true) {
            System.out.print("Enter new username: ");
            input = takeStringInput();
            Observer user = findUser(input);
            if (user != null) {
                // if there is a user with the same name, we need to handle it here in the registration process
                System.out.println("A user with this name already exists. Please choose another username.");
            } else break;
        }

        do {
            System.out.println("Choose the type of user:");
            System.out.println("1. Regular User");
            System.out.println("2. Premium User");
            choice = takeIntInput(1, 2);
        } while (choice == -1);

        Observer newUser = null;
        if (choice == 1) {
            newUser = new RegularUser(server, input);
        } else {
            newUser = new PremiumUser(server, input);
        }

        users.add(newUser); // server subscription has already been done in constructor
        System.out.println("New " + (choice == 1 ? "Regular" : "Premium") + " User " + input + " added successfully.");
    }

    private static void removeUser() {
        if (server.getCurrentState() == ABCCompany.State.FULLY_DOWN) {
            System.out.println("Server is down. Please try again later.");
            return;
        }
        String input = "";
        int choice = 0;

        System.out.print("Enter username to remove: ");
        input = takeStringInput();

        Observer user = findUser(input);
        if (user == null) {
            System.out.println("No user with this name exists. Please choose an existing username.");
        } else {
            server.unsubscribe(user);
            users.remove(user);
            if (user instanceof PremiumUser) System.out.print("Premium ");
            else System.out.print("Regular ");
            System.out.println("User " + input + " removed successfully.");
        }
    }

    private static void changeState() {
        int choice = 0;
        do {
            System.out.println("Choose the new state of the server:");
            System.out.println("1. Operational");
            System.out.println("2. Partially Down");
            System.out.println("3. Fully Down");
            choice = takeIntInput(1, 3);
        } while (choice == -1);

        if (choice == 1) {
            if (server.getCurrentState() == ABCCompany.State.OPERATIONAL) {
                System.out.println("Server is already operational.");
            } else {
                System.out.println("Server is now operational.");
                server.setCurrentState(ABCCompany.State.OPERATIONAL);
            }
        } else if (choice == 2) {
            if (server.getCurrentState() == ABCCompany.State.PARTIALLY_DOWN) {
                System.out.println("Server is already partially down.");
            } else {
                System.out.println("Server is now partially down.");
                server.setCurrentState(ABCCompany.State.PARTIALLY_DOWN);
            }
        } else {
            if (server.getCurrentState() == ABCCompany.State.FULLY_DOWN) {
                System.out.println("Server is already fully down.");
            } else {
                System.out.println("Server is now fully down.");
                server.setCurrentState(ABCCompany.State.FULLY_DOWN);
            }
        }
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        server = new ABCCompany();
        users = new ArrayList<>();

        int input = 0;
        System.out.println("Welcome to ABC Company!!!");

        while (true) {
            System.out.print("\n");
            System.out.println("Current State of Server: " + server.getCurrentState());
            System.out.println("List of services we provide:");
            System.out.println("1. Add New User");
            System.out.println("2. Remove Existing User");
            System.out.println("3. Change Server State");
            System.out.println("4. Exit Menu");
            System.out.print("\n");

            input = takeIntInput(1, 4);

            if (input == 1) {
                addUser();
            } else if (input == 2) {
                removeUser();
            } else if (input == 3) {
                changeState();
            } else if (input == 4) {
                System.out.println("Hope to see you again in our premises!");
                break;
            }
        }

        scanner.close();
    }
}

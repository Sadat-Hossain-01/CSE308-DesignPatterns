package observers;

import subject.ABCCompany;

import java.util.Scanner;

public abstract class Observer {
    protected ABCCompany server; // protected as we want to access it from the inherited classes (users)
    protected String userName;
    protected static Scanner scanner;

    public Observer(ABCCompany server, String userName) {
        this.server = server;
        this.userName = userName;
        scanner = new Scanner(System.in); // for all usages in this class
        server.subscribe(this);
    }

    public String getUserName() {
        return userName;
    }

    public abstract void notifyObserver();

    protected int takeIntInput(int l, int r) { // will need this method in different cases for taking inputs
        // [l, r] is the input choice range
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

    protected void showReceivingMessage(String currentState) {
        System.out.println("\n" + this);
        System.out.println("======================================================");
        System.out.println("Got notified. Current State: " + currentState);
    }
}

package observers;

import subject.ABCCompany;

import java.util.Scanner;

public abstract class Observer {
    protected ABCCompany server; // protected as we want to access it from the inherited classes (users)
    protected String userName;

    public Observer(ABCCompany server, String userName) {
        this.server = server;
        this.userName = userName;
        server.subscribe(this);
    }

    public abstract void notifyObserver();

    protected abstract void showState(); // protected because this method is only for use within the subclasses, external classes have nothing to do with it

    protected int takeInput(int l, int r) { // will need this method in different cases for taking inputs
        // [l, r] is the input choice range
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        try {
            choice = scanner.nextInt();
            if (choice > r || choice < l) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid choice.");
            choice = -1; // make sure this -1 is outside the valid choice range
        }

        scanner.close();
        return choice;
    }
}

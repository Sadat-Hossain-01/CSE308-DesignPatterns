package states;

import machine.VendingMachine;

import java.util.Scanner;

public abstract class State {
    protected VendingMachine vendingMachine;
    protected Scanner scanner; // for usage in subclasses only
    public State(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        scanner = new Scanner(System.in);
    }

    public abstract void refill();
    public abstract void collectMoney();
    public abstract void deliverProduct(); // protected because it will be called by the subclasses
    public abstract void returnMoney();

    protected int takeIntInput(String name) {
        int num = 0;
        try {
            num = scanner.nextInt();
            if (num <= 0) return -1;
        }
        catch (Exception e) {
            System.out.println("Please provide a valid " + name);
            num = -1;
        }
        return num;
    }
}

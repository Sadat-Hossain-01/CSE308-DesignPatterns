package states;

import machine.VendingMachine;

public class SoldOutState extends State {
    public SoldOutState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void refill() {
        vendingMachine.refillProductCount();
        System.out.println("Refill done successfully.");
    }

    @Override
    public void collectMoney(int amount) {
        System.out.println("The inventory is currently empty. Please request a refill first.");
        System.out.println("Returning the payment: $" + amount + ".");
    }

    @Override
    public void deliverProduct() {
        System.out.println("Sorry, the inventory is currently empty. Please request a refill.");
    }
}

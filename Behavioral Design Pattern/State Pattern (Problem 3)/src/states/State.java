package states;

import machine.VendingMachine;

public abstract class State {
    protected VendingMachine vendingMachine;

    public State(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public abstract void refill();

    public abstract void collectMoney(int amount);

    public abstract void deliverProduct();

    public void cancelPayment() { // writing it here because same behavior for all the states, cancel the full payment and return
        int currentBalance = vendingMachine.getCurrentBalance();
        if (currentBalance > 0) {
            System.out.println("Returned $" + currentBalance + ".");
            vendingMachine.setCurrentBalance(0);
        }
        else {
            System.out.println("You do not have any money to return.");
        }
    }

    protected void handleInvalidRefillRequest() { // refill method is same for 3 of the 4 states, so keeping a separate protected method for it
        assert !vendingMachine.isMachineEmpty();
        System.out.println("There is already product in the inventory. Please consider buying them first.");
    }

    protected void handleUnnecessaryPayment(int amount) {
        System.out.println("You already have paid enough to collect the product. Please collect it.");
        System.out.println("Returned the paid $" + amount + "...");
    }

    protected void dispenseSingleProduct() {
        System.out.println("Delivered the product...");
        vendingMachine.decrementProductCount();
        vendingMachine.setCurrentBalance(vendingMachine.getCurrentBalance() - vendingMachine.productPrice);
    }
}

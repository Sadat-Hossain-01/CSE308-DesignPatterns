package states;

import machine.VendingMachine;

public class LessMoneyState extends State {
    public LessMoneyState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void refill() {
        handleInvalidRefillRequest();
    }

    @Override
    public void collectMoney(int amount) {
        int currentBalance = vendingMachine.getCurrentBalance();
        int price = vendingMachine.productPrice;
        vendingMachine.setCurrentBalance(currentBalance + amount);
        System.out.println("Payment of $" + amount + " received.");
        if (currentBalance + amount > price) {
            vendingMachine.setCurrentState(vendingMachine.getMoreMoneyState());
            System.out.println("You can collect your product now.");
        } else if (currentBalance + amount == price) {
            vendingMachine.setCurrentState(vendingMachine.getEqualMoneyState());
            System.out.println("You can collect your product now.");
        } else {
            System.out.println("You have to pay $" + (price - currentBalance - amount) + " more.");
        }
    }

    @Override
    public void deliverProduct() {
        System.out.println("Sorry, you have to pay $" + (vendingMachine.productPrice - vendingMachine.getCurrentBalance()) + " more.");
    }
}

package states;

import machine.VendingMachine;

public class MoreMoneyState extends State {
    public MoreMoneyState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void refill() {
        handleInvalidRefillRequest();
    }

    @Override
    public void collectMoney(int amount) {
        handleUnnecessaryPayment(amount);
    }

    @Override
    public void deliverProduct() {
        dispenseAProduct();
        int newBalance = vendingMachine.getCurrentBalance();
        int price = vendingMachine.productPrice;
        if (vendingMachine.isMachineEmpty()) vendingMachine.setCurrentState(vendingMachine.getSoldOutState());
        else if (newBalance > price) { // might still have more money than product price in account
            vendingMachine.setCurrentState(vendingMachine.getMoreMoneyState());
        } else if (newBalance == price) {
            vendingMachine.setCurrentState(vendingMachine.getEqualMoneyState());
        } else {
            vendingMachine.setCurrentState(vendingMachine.getLessMoneyState());
        }
    }
}

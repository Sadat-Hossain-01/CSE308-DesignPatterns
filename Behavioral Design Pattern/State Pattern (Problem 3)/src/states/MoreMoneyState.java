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
        System.out.println("Returned the extra $" + (vendingMachine.getCurrentBalance() - vendingMachine.productPrice) + "...");
        vendingMachine.setCurrentBalance(vendingMachine.productPrice);
        dispenseSingleProduct();
        vendingMachine.setCurrentState(vendingMachine.getLessMoneyState());
    }
}

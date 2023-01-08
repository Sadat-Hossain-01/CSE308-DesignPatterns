package states;

import machine.VendingMachine;

public class EqualMoneyState extends State {
    public EqualMoneyState(VendingMachine vendingMachine) {
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
        if (vendingMachine.isMachineEmpty()) vendingMachine.setCurrentState(vendingMachine.getSoldOutState());
        else vendingMachine.setCurrentState(vendingMachine.getLessMoneyState());
    }
}

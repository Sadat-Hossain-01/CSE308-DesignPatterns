package states;

import machine.VendingMachine;

public class HasMoreMoneyState extends State{
    public HasMoreMoneyState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void refill() {

    }

    @Override
    public void collectMoney() {

    }

    @Override
    public void deliverProduct() {

    }
}

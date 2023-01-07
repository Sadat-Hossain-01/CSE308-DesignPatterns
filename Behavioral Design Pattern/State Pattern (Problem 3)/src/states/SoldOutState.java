package states;

import machine.VendingMachine;

public class SoldOutState extends State{
    public SoldOutState(VendingMachine vendingMachine) {
        super();
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

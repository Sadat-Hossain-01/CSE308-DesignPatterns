package states;

import machine.VendingMachine;

public class ProductSoldState extends State{
    public ProductSoldState(VendingMachine vendingMachine) {
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

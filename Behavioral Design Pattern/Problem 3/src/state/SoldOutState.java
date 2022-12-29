package state;

import machine.VendingMachine;

public class SoldOutState extends State{

    public SoldOutState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void collectMoney(long amount) {
        System.out.println("Sorry, the inventory is currently empty. Please try another time.");
    }
}

package states;

import machine.VendingMachine;

public class NeedMoneyState extends State{
    public NeedMoneyState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void refill() {
        assert vendingMachine.getProductCount() > 0;
        System.out.println("There is already product in the inventory, please pay money to buy them.");
    }

    @Override
    public void collectMoney() {
        System.out.println("How much money do you want to pay, sir?");
        int amount = -1;
        do {
            amount = takeIntInput("credit amount");
        } while (amount == -1);

        vendingMachine.setCurrentBalance(vendingMachine.getCurrentBalance() + amount);

        int balance = vendingMachine.getCurrentBalance();
        int price = VendingMachine.productPrice;

        if (balance == price) {
            vendingMachine.setCurrentState(vendingMachine.productSoldState);
        }
        else if (balance > price) {
            vendingMachine.setCurrentState(vendingMachine.hasMoreMoneyState);
        }
        else {
            System.out.println("You need $" + vendingMachine.V);
        }
    }

    @Override
    public void deliverProduct() {

    }
}

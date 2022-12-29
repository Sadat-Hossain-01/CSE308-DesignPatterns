public class NonEmptyState extends State{
    public NonEmptyState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    private void deliverProduct() {
        System.out.println("New product successfully delivered.");
        vendingMachine.decrementProductCount();
        if (vendingMachine.getProductCount() == 0) {
            vendingMachine.setCurrentState(vendingMachine.soldOutState);
        }
    }

    @Override
    void collectMoney(long amount) {
        vendingMachine.setCurrentBalance(vendingMachine.getCurrentBalance() + amount);
        long balance = vendingMachine.getCurrentBalance();
        if (balance == VendingMachine.productPrice) {
            vendingMachine.setCurrentBalance(0);
            deliverProduct();
        }
        else if (balance > VendingMachine.productPrice) {
            long extra = vendingMachine.getCurrentBalance() - VendingMachine.productPrice;
            System.out.println("The product price is $" + VendingMachine.productPrice + ".");
            System.out.println("Returned extra $" + extra + "...");
            vendingMachine.setCurrentBalance(0);
            deliverProduct();
        }
        else {
            long more = VendingMachine.productPrice - vendingMachine.getCurrentBalance();
            System.out.println("The product price is $" + VendingMachine.productPrice + ".");
            System.out.println("You have to pay $" + more + " more.");
        }
    }
}

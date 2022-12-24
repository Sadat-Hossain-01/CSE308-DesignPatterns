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
        if (amount == VendingMachine.productPrice) {
            deliverProduct();
        }
        else if (amount > VendingMachine.productPrice) {
            long extra = amount - VendingMachine.productPrice;
            System.out.println("The product price is $" + VendingMachine.productPrice + ".");
            System.out.println("Returned extra $" + extra + "...");
            deliverProduct();
        }
        else {
            long more = VendingMachine.productPrice - amount;
            System.out.println("The product price is $" + VendingMachine.productPrice + ".");
            System.out.println("You have to pay $" + more + " more.");
            System.out.println("Returned the paid $" + amount + "...");
        }
    }
}

public abstract class State {
    VendingMachine vendingMachine = null;
    public State(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

//    abstract void deliverProduct();
//    the reason why the above function is not being used is that user can only give money now.
//    based on that, deliverProduct will be an internal decision, so not every class should have it.
    abstract void collectMoney(long amount);

    // the behavior of refill() method is nearly same be it whatever state
    // since we are allowing refill from empty to almost full - all conditions
    // so better to provide a final implementation in superclass
    final void refill(int amount) {
        if (vendingMachine.getProductCount() < VendingMachine.inventoryCap) {
            vendingMachine.setProductCount(vendingMachine.getProductCount() + amount);
            if (vendingMachine.getProductCount() > VendingMachine.inventoryCap) {
                vendingMachine.setProductCount(VendingMachine.inventoryCap);
                System.out.println("Inventory capacity is only " + VendingMachine.inventoryCap + "!");
                System.out.println("Inventory refilled to that capacity.");
            }
            else {
                System.out.println("Inventory successfully refilled.");
            }
        }
        else {
            // this should not happen anyway, as before calling this method count is checked
            System.out.println("Inventory is already full!");
        }
        vendingMachine.setCurrentState(vendingMachine.nonEmptyState);
    }
}

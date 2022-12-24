public class VendingMachine {
    public static final int inventoryCap = 10;
    private int productCount;
    public static final long productPrice = 10;
    private State currentState;
    public State soldOutState;
    public State nonEmptyState;

    public VendingMachine() {
        soldOutState = new SoldOutState(this);
        nonEmptyState = new NonEmptyState(this);

        this.productCount = VendingMachine.inventoryCap;
        if (productCount > 0) {
            currentState = nonEmptyState;
        }
        else {
            currentState = soldOutState;
        }
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public void decrementProductCount() {
        productCount--;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public void collectMoney(long amount) {
        currentState.collectMoney(amount);
    }

    public void refill(int amount) {
        currentState.refill(amount);
    }
}

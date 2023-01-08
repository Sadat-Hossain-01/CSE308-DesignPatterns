package machine;

import states.*;

public class VendingMachine {
    public final int productPrice = 10;
    public final int inventoryCap = 10;
    private int productCount;
    private int currentBalance;
    private State currentState;
    private State lessMoneyState;
    private State moreMoneyState;
    private State soldOutState;
    private State equalMoneyState;

    public VendingMachine() {
        lessMoneyState = new LessMoneyState(this);
        moreMoneyState = new MoreMoneyState(this);
        soldOutState = new SoldOutState(this);
        equalMoneyState = new EqualMoneyState(this);

        this.productCount = inventoryCap;
        this.currentBalance = 0;
        this.currentState = lessMoneyState;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int balance) {
        this.currentBalance = balance;
    }

    public boolean isMachineEmpty() {
        return productCount == 0;
    }

    public void decrementProductCount() {
        this.productCount--;
    }

    public int getProductCount() {
        return productCount;
    }

    public void refillProductCount() {
        this.productCount = inventoryCap;
    }

    public void setCurrentState(State state) {
        this.currentState = state;
    }

    public State getLessMoneyState() {
        return lessMoneyState;
    }

    public State getMoreMoneyState() {
        return moreMoneyState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getEqualMoneyState() {
        return equalMoneyState;
    }

    public void collectMoney(int amount) {
        currentState.collectMoney(amount);
    }

    public void deliverProduct() {
        currentState.deliverProduct();
    }

    public void cancelPayment() {
        currentState.cancelPayment();
    }

    public void refill() {
        currentState.refill();
    }
}

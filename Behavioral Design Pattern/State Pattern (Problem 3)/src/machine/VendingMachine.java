package machine;

import states.*;

public class VendingMachine {
    public static final int productPrice = 10;
    public static final int inventoryCap = 10;
    private int productCount;
    private int currentBalance;
    private State currentState;
    public State needMoneyState;
    public State hasMoreMoneyState;
    public State soldOutState;
    public State productSoldState;

    public VendingMachine() {
        needMoneyState = new NeedMoneyState(this);
        hasMoreMoneyState = new HasMoreMoneyState(this);
        soldOutState = new SoldOutState(this);
        productSoldState = new ProductSoldState(this);

        this.productCount = inventoryCap;
        this.currentBalance = 0;
        if (productCount > 0) {
            currentState = needMoneyState;
        }
        else {
            currentState = soldOutState;
        }
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int balance) {
        this.currentBalance = balance;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setCurrentState(State state) {
        this.currentState = state;
    }
}

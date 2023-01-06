package subject;

import observers.Observer;

import java.util.ArrayList;
import java.util.List;

public class ABCCompany implements Subject {
    private List<Observer> observerList;

    public enum State {
        OPERATIONAL,
        PARTIALLY_DOWN,
        FULLY_DOWN
    }

    private State previousState;
    private State currentState;

    public ABCCompany() {
        observerList = new ArrayList<>();
        previousState = currentState = State.OPERATIONAL;
    }

    public State getCurrentState() {
        return currentState;
    }

    public State getPreviousState() {
        return previousState;
    }

    public void setCurrentState(State state) {
        this.previousState = this.currentState;
        this.currentState = state;

        notifyAllObservers();
    }

    @Override
    public void subscribe(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer : observerList) {
            observer.notifyObserver();
        }
    }
}

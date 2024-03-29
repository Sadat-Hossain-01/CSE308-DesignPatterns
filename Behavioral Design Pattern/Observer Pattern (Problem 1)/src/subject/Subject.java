package subject;

import observers.Observer;

public interface Subject {
    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void notifyAllObservers();
}

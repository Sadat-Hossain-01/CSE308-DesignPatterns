package observers;

import subject.ABCCompany;

public abstract class Observer {
    protected ABCCompany server; // protected as we want to access it from the inherited classes (users)
    protected String userName;

    public Observer(ABCCompany server, String userName) {
        this.server = server;
        this.userName = userName;
        server.subscribe(this);
    }

    public abstract void notifyObserver();

    protected abstract void showState(); // protected because this method is only for use within the subclasses, external classes have nothing to do with it
}

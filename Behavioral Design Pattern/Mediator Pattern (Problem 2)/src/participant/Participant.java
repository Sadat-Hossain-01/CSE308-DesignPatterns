package participant;

import mediator.Mediator;

public abstract class Participant {
    protected Mediator mediator;
    protected int id;

    public Mediator getMediator() {
        return mediator;
    }

    public int getID() {
        return id;
    }

    public Participant(Mediator mediator, int id) {
        this.mediator = mediator;
        this.id = id;
    }
}

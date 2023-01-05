package participant;

import mediator.Mediator;

public abstract class Participant {
    protected Mediator mediator;
    private int id;

    public Participant(Mediator mediator, int id) {
        this.mediator = mediator;
        this.id = id;
    }
}

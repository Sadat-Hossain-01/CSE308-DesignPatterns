package participant;

import mediator.Mediator;

public class Examiner extends Participant{
    private int examinerID;

    public Examiner(Mediator mediator, int id) {
        super(mediator, id);
    }
}

package participant;

import mediator.Mediator;

public class Examinee extends Participant{
    private int examineeID;

    public Examinee(Mediator mediator, int id) {
        super(mediator, id);
    }
}

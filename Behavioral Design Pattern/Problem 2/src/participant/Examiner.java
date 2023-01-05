package participant;

import data.BundleCheckRequest;
import data.RecheckRequest;
import mediator.Mediator;

public class Examiner extends Participant{
    public Examiner(Mediator mediator, int id) {
        super(mediator, id);
    }

    public void sendBundleCheckRequest(BundleCheckRequest request) {

    }

    public void sendRecheckRequest(RecheckRequest request) {

    }
}

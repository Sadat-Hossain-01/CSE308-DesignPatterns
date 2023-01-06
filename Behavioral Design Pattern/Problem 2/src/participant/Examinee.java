package participant;

import data.ExamScript;
import data.SingleScriptRequest;
import mediator.Mediator;

public class Examinee extends Participant{
    public Examinee(Mediator mediator, int id) {
        super(mediator, id);
    }

    public void sendResult(int mark) {
        System.out.println("Student " + id + ": Result received from exam controller, mark: " + mark + ".");
    }

    public void requestRecheck() {
        SingleScriptRequest recheckRequest = new SingleScriptRequest(id);
        System.out.println("\nStudent " + id + ": Requesting for a recheck.");
        mediator.sendMessage(this, recheckRequest);
    }

}

package participant;

import data.ExamScript;
import data.SingleScriptRequest;
import mediator.Mediator;

public class Examinee extends Participant{
    public Examinee(Mediator mediator, int id) {
        super(mediator, id);
    }

    public void sendResult(int mark) {
        System.out.println("\nExaminee " + id + ": result received from exam controller, mark: " + mark);
    }

    public void requestRecheck() {
        SingleScriptRequest recheckRequest = new SingleScriptRequest(id);
        System.out.println("\n Examinee " + id + ": requesting recheck");
        mediator.sendMessage(this, recheckRequest);
    }

}

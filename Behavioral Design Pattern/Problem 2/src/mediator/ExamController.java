package mediator;

import data.ExamBundle;
import data.MessageType;
import participant.Participant;

import java.util.ArrayList;

public class ExamController implements Mediator{
    private ArrayList<Participant> participants;
    @Override
    public void sendMessage(Participant fromParticipant, MessageType messageType, ExamBundle examBundle) {

    }

    @Override
    public void subscribe(Participant participant) {
        participants.add(participant);
    }

    @Override
    public void unsubscribe(Participant participant) {
        participants.remove(participant);
    }
}

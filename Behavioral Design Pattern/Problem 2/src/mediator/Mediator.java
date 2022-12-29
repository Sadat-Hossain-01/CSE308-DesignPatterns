package mediator;

import data.ExamBundle;
import data.MessageType;
import participant.Participant;

public interface Mediator {
    void sendMessage(Participant fromParticipant, MessageType messageType, ExamBundle examBundle); // we will know from message type which kind of request has been sent
    void subscribe(Participant participant);
}

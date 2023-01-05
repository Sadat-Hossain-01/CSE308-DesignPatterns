package mediator;

import data.CheckRequest;
import participant.Participant;

public interface Mediator {
    void sendMessage(Participant from, CheckRequest checkRequest); // we will know from message type which kind of request has been sent
}

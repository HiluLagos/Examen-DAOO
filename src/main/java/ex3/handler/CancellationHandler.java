package ex3.handler;

import ex3.event.Cancellation;
import ex3.event.Event;
import ex3.event.EventType;

public class CancellationHandler implements EventHandler {
    @Override
    public void handle(Event event) {
        Cancellation cancellation = (Cancellation) event;
        String reason = cancellation.getReason();
        String solicitant = cancellation.getSolicitant();
        System.out.println("Cancelation of purchase id:" + cancellation.getPurchaseId() + " Done with reason: " + reason + "---> By solicitant: " + solicitant);
    }

    @Override
    public Boolean canHandle(Event event) {
        return event.getEventType() == EventType.CANCELLATION;
    }
}

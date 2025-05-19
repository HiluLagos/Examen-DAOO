package ex3.handler;

import ex3.event.DeliveryIssue;
import ex3.event.Event;
import ex3.event.EventType;

public class DeliveryIssueHandler implements EventHandler {

    @Override
    public void handle(Event event) {
        DeliveryIssue issue = (DeliveryIssue) event;
        String description = issue.getDescription();
        String location = issue.getLocation();
        System.out.println("Issue: " + description + " occurred at " + location);
    }

    @Override
    public Boolean canHandle(Event event) {
        return event.getEventType() == EventType.DELIVERY_ISSUE;
    }
}

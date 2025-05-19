package ex3.event;

import java.util.Date;

public interface Event {

    int getEventId();
    Date getEventDate();
    EventType getEventType();
}

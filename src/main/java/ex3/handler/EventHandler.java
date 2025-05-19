package ex3.handler;

import ex3.event.Event;

public interface EventHandler {

    public abstract void handle(Event event);

    public abstract Boolean canHandle(Event event);
}
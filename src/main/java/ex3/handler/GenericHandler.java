package ex3.handler;

import ex3.event.Event;
import org.reflections.Reflections;

import java.util.Set;

public class GenericHandler {
    public void handle(Event event) {
        try {
            // Use Reflections library to find all subclasses of EventHandler
            Reflections reflections = new Reflections("ex3.handler");
            Set<Class<? extends EventHandler>> subClasses = reflections.getSubTypesOf(EventHandler.class);

            for (Class<? extends EventHandler> handlerClass : subClasses) {
                // Create an instance of the subclass
                EventHandler handler = handlerClass.getDeclaredConstructor().newInstance();

                // Check if the handler can handle the event
                if (handler.canHandle(event)) {
                    handler.handle(event);
                    return;
                }
            }
        } catch (Exception e) {
            throw new IllegalStateException("Error handling event: " + event, e);
        }

        throw new IllegalStateException("No handler found for the event: " + event);
    }
}

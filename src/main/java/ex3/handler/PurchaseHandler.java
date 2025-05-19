package ex3.handler;

import ex3.event.Event;
import ex3.event.EventType;
import ex3.event.PurchaseItem;

import java.util.List;

public class PurchaseHandler implements EventHandler {

    PurchaseHandler() {
    }

    @Override
    public Boolean canHandle(Event event) {
        return event.getEventType() == EventType.PURCHASE;
    }

    @Override
    public void handle(Event event) {
        PurchaseItem eventItem = (PurchaseItem) event;
        List<String> products = eventItem.getProducts();
        String paymentMethod = eventItem.getPaymentMethod();
        System.out.println("Purchased: " + products + "---> With method:" + paymentMethod);
    }
}

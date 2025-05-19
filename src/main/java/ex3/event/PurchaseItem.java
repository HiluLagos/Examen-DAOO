package ex3.event;

import java.util.Date;
import java.util.List;

public class PurchaseItem implements Event {

    final private Date date;
    final private int id;
    final private int clientId;
    final private List<String> products;
    final private String address;
    private final String paymentMethod;

    public PurchaseItem(int id, int clientId, List<String> products, String address, String paymentMethod) {
        this.date = new Date();
        this.id = id;
        this.clientId = clientId;
        this.products = products;
        this.address = address;
        this.paymentMethod = paymentMethod;
    }

    public String getAddress() {
        return address;
    }

    public int getClientId() {
        return clientId;
    }

    public List<String> getProducts() {
        return products;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public int getEventId() {
        return id;
    }

    @Override
    public Date getEventDate() {
        return date;
    }

    @Override
    public EventType getEventType() {
        return EventType.PURCHASE;
    }
}

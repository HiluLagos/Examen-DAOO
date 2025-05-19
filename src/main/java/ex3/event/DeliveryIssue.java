package ex3.event;

import java.util.Date;

public class DeliveryIssue implements Event {
    // ID de pedido, código de error, descripción, ubicación

    final private int purchaseId;
    final private double errorCode;
    final private String description;
    final private String location;
    final private Date issueDate;
    final private int id;

    public DeliveryIssue(int id, int purchaseId, double errorCode, String description, String location) {
        this.purchaseId = purchaseId;
        this.errorCode = errorCode;
        this.description = description;
        this.location = location;
        this.issueDate = new Date();
        this.id = id;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public double getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public int getEventId() {
        return id;
    }

    @Override
    public Date getEventDate() {
        return issueDate;
    }

    @Override
    public EventType getEventType() {
        return EventType.DELIVERY_ISSUE;
    }
}

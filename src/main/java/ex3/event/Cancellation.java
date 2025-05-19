package ex3.event;

import java.util.Date;

public class Cancellation implements Event {
    // ID de pedido, motivo, solicitante (cliente o sistema)

    final private Date date;
    final private int id;
    final private int purchaseId;
    final private String reason;
    final private String solicitant;
    public Cancellation(int id, int purchaseId, String reason, String solicitant) {
        this.date = new Date();
        this.id = id;
        this.purchaseId = purchaseId;
        this.reason = reason;
        this.solicitant = solicitant;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public String getReason() {
        return reason;
    }

    public String getSolicitant() {
        return solicitant;
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
        return EventType.CANCELLATION;
    }
}

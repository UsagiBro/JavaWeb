package entity.order;

public enum OrderStatus {
    ACCEPTED, CONFIRMED, FORMED, SENT, COMPLETED, CANCELED;

    public String getStatus() {
        return name().toLowerCase();
    }
}

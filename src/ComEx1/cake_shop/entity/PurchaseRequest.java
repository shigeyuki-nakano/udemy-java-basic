package ComEx1.cake_shop.entity;

public class PurchaseRequest {
    private final String merchandiseName;
    private int quantity;

    public PurchaseRequest(String merchandiseName, int quantity) {
        this.merchandiseName = merchandiseName;
        this.quantity = quantity;
    }

    public String getMerchandiseName() {
        return this.merchandiseName;
    }

    public int getQuantity() {
        return this.quantity;
    }}

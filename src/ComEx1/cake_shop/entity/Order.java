package ComEx1.cake_shop.entity;

public class Order {
    private final String merchandiseName;
    private int price;
    private int quantity;

    public Order(String merchandiseName, int price, int quantity) {
        this.merchandiseName = merchandiseName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getMerchandiseName() {
        return this.merchandiseName;
    }

    public int getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void merge(Order order) {
        if(!order.getMerchandiseName().equals(this.merchandiseName)) {
            return;
        }
        this.quantity += order.getQuantity();
    }
}

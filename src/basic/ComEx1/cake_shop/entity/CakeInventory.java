package basic.ComEx1.cake_shop.entity;

public class CakeInventory {
    private int cakeId;
    private int quantity;

    public CakeInventory(int cakeId, int quantity) {
        this.cakeId = cakeId;
        this.quantity = quantity;
    }

    public CakeInventory() {}

    public int getCakeId() {
        return this.cakeId;
    }

    public int getQuantity() {
        return this.quantity;
    }
}

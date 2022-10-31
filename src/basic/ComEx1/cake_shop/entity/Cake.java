package basic.ComEx1.cake_shop.entity;

public class Cake {
    private int id;
    private String name;
    private int price;

    public Cake(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }
}

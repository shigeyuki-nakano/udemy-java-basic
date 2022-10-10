package org.example.ComEx1.Jihan.entity.model;

public enum Coins {
    ItiYen(1),
    GoYen(5),
    JuYen(10),
    GoJuYen(50),
    HyakuYen(100),
    GoHyakuYen(500);

    private final int coin;

    Coins(int coin) {
        this.coin = coin;
    }

    public static Coins getByInt(int id) {
        for(Coins coin : Coins.values()) {
            if(id == coin.coin) {
                return coin;
            }
        }

        return null;
    }

    public String toString() {
        return coin + "円玉";
    }

    public int getCoin() {
        return coin;
    }
}

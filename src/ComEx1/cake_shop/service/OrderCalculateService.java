package ComEx1.cake_shop.service;

import ComEx1.cake_shop.entity.Order;

import java.util.List;

public class OrderCalculateService {
    private static final double TAX = 1.08;

    public int getPriceByOrder(List<Order> orderList) {
        int sumResult = sum(orderList);
        double result = getSpecialSalePrice(sumResult) * TAX;

        return (int) result;
    }

    private int getSpecialSalePrice(int price) {
        final double discountRate = 0.2;
        final int saleThreshold = 1000;

        double result = price >= saleThreshold
                ? price - (price * discountRate)
                : price;

        return (int) result;
    }

    private int sum(List<Order> orderList) {
        return orderList.stream()
                .map(o -> o.getQuantity() * o.getPrice())
                .mapToInt(i -> i)
                .sum();
    }
}

package basic.ComEx1.cake_shop;

import basic.ComEx1.cake_shop.entity.PurchaseRequest;
import basic.ComEx1.cake_shop.repository.CakeRepository;
import basic.ComEx1.cake_shop.repository.InventoryRepository;
import basic.ComEx1.cake_shop.service.OrderCalculateService;
import basic.ComEx1.cake_shop.service.ShopService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var cakeRepository = new CakeRepository();
        var inventoryRepository = new InventoryRepository(cakeRepository);
        var calculateService = new OrderCalculateService();
        var shopService = new ShopService(calculateService, inventoryRepository, cakeRepository);

        try {
            String[] testArgs = {"ショートケーキ", "1", "モンブラン", "3"};
            var orderList = createOrderList(testArgs);

            var result = shopService.calculate(orderList);

            System.out.println("合計金額は" + result + "円です。");
        } catch(IllegalArgumentException e) {
            System.err.println("適切な引数を指定してください");
            System.err.println(e.getMessage());
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static List<PurchaseRequest> createOrderList(String[] args) {
        if(args.length == 0 || args.length % 2 != 0) {
            throw new IllegalArgumentException("引数は商品・個数のセットで指定してください。");
        }

        List<PurchaseRequest> orderList = new ArrayList<>();

        for(int i = 0; i < (args.length / 2); i++) {
            int targetIndex = i * 2;
            String merchandiseName = args[targetIndex];
            int prise = Integer.parseInt(args[targetIndex + 1]);
            PurchaseRequest order = new PurchaseRequest(merchandiseName, prise);

            orderList.add(order);
        }

        return orderList;
    }
}

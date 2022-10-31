package basic.ComEx1.cake_shop.service;

import basic.ComEx1.cake_shop.entity.Order;
import basic.ComEx1.cake_shop.entity.PurchaseRequest;
import basic.ComEx1.cake_shop.exception.InventoryShortageException;
import basic.ComEx1.cake_shop.repository.CakeRepository;
import basic.ComEx1.cake_shop.repository.InventoryRepository;

import java.util.ArrayList;
import java.util.List;

public class ShopService {

    private final OrderCalculateService calculateService;
    private final InventoryRepository inventoryRepository;
    private final CakeRepository cakeRepository;

    public ShopService(OrderCalculateService calculateService, InventoryRepository inventoryRepository, CakeRepository cakeRepository) {
        this.calculateService = calculateService;
        this.inventoryRepository = inventoryRepository;
        this.cakeRepository = cakeRepository;
    }

    public int calculate(List<PurchaseRequest> purchaseRequestList)
            throws InventoryShortageException {

        List<Order> orderList = new ArrayList<>();

        for(PurchaseRequest purchaseRequest : purchaseRequestList) {
            orderList.add(createOrder(purchaseRequest));
        }

        return calculateService.getPriceByOrder(orderList);
    }

    private Order createOrder(PurchaseRequest purchaseRequest)
            throws InventoryShortageException {

        final String name = purchaseRequest.getMerchandiseName();

        if(!isExistInventory(purchaseRequest)) {
            throw new InventoryShortageException(name + "の在庫が不足しています。");
        }

        var result = cakeRepository.findByName(purchaseRequest.getMerchandiseName());
        return new Order(name, result.getPrice(), purchaseRequest.getQuantity());
    }

    private boolean isExistInventory(PurchaseRequest purchaseRequest) {
        final var inventoryCount = inventoryRepository
                .getCakeInventoryCount(purchaseRequest.getMerchandiseName());
        return inventoryCount >= purchaseRequest.getQuantity();
    }
}

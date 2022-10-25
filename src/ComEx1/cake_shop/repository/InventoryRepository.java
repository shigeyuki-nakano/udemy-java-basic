package ComEx1.cake_shop.repository;

import ComEx1.cake_shop.entity.CakeInventory;

import java.util.Arrays;
import java.util.List;

public class InventoryRepository {

    private final CakeRepository cakeRepository;

    private List<CakeInventory> cakeInventoryTable = Arrays.asList(
            new CakeInventory(1, 5),
            new CakeInventory(2, 3),
            new CakeInventory(3, 5),
            new CakeInventory(4, 7),
            new CakeInventory(5, 4)
    );

    public InventoryRepository(CakeRepository cakeRepository) {
        this.cakeRepository = cakeRepository;
    }

    public int getCakeInventoryCount(String name) {
        final var searchCakeResult = cakeRepository.findByName(name);

        if(searchCakeResult == null) {
            return 0;
        }

        final var searchInventoryResult = cakeInventoryTable.stream()
                .filter(c -> searchCakeResult.getId() == c.getCakeId())
                .findFirst();

        return searchInventoryResult.map(CakeInventory::getQuantity).orElse(0);
    }
}

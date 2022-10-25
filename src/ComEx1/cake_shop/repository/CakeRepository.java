package ComEx1.cake_shop.repository;

import ComEx1.cake_shop.entity.Cake;

import java.util.Arrays;
import java.util.List;

public class CakeRepository {

    private List<Cake> cakeTable = Arrays.asList(
            new Cake(1, "ショートケーキ", 320),
            new Cake(2, "モンブラン", 350),
            new Cake(3, "チョコレートケーキ", 370),
            new Cake(4, "いちごのタルト", 400),
            new Cake(5, "チーズケーキ", 300)
    );

    public List<Cake> findAll() {
        return cakeTable;
    }

    public Cake findByName(String name) {
         var result = cakeTable.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst();
         return result.isPresent()
                 ? result.get()
                 : null;
    }
}

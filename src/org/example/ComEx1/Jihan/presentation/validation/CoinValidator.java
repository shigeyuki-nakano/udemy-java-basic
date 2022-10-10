package org.example.ComEx1.Jihan.presentation.validation;

import org.example.ComEx1.Jihan.entity.model.Coins;

import java.util.Arrays;
import java.util.List;

public class CoinValidator {
    public static boolean isAvailable(Coins coin) {
        List<Coins> availableCoins = Arrays.asList(
                Coins.GoJuYen,
                Coins.GoJuYen,
                Coins.HyakuYen,
                Coins.GoHyakuYen
        );

        return availableCoins.contains(coin);
    }
}

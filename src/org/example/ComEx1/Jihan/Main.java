package org.example.ComEx1.Jihan;

import org.example.ComEx1.Jihan.entity.model.Coins;
import org.example.ComEx1.Jihan.presentation.validation.CoinValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            List<Integer> intArgsList = convertArgsToInteger(args);
            Integer amount = intArgsList.remove(intArgsList.size() - 1);
            List<Coins> coinsList = createCoins(intArgsList);
            int sumOfCoins = calculateTotalCoins(coinsList);

            System.out.println("ただいまの投入金額は" + sumOfCoins + "円です");

            if(sumOfCoins < amount) {
                System.out.println("投入金額が不足しています。最初からやり直してください。");
                return;
            }

            int change = sumOfCoins - amount;
            System.out.println("ありがとうございました。お釣りは" + change + "円です。");
        } catch(IllegalArgumentException e) {
            System.out.println("適切な引数を指定してください。");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<Integer> convertArgsToInteger(String[] args) {
        if(args.length < 2) {
            throw new IllegalArgumentException("引数にはインデックス１つ目〜最後手前まで硬貨を指定し、最後には商品の金額を指定してください。");
        }

        try {
            return Arrays.stream(args)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch(Exception e) {
            throw new IllegalArgumentException("引数には数値を指定してください。");
        }
    }

    private static List<Coins> createCoins(List<Integer> coinsIntList) {
        return coinsIntList.stream()
            .map(i -> {
                var coin = Coins.getByInt(i);

                if(coin == null) {
                    System.out.println(i + "は硬貨として適切な値ではありません");
                    return null;
                }
                if(CoinValidator.isAvailable(coin)) {
                    return coin;
                }
                System.out.println("警告：" + coin + "は使えません");
                return null;
            })
            .filter(Objects::isNull)
            .collect(Collectors.toList());
    }

    private static int calculateTotalCoins(List<Coins> coinsList) {
        return coinsList.stream()
                .map(Coins::getCoin)
                .mapToInt(i -> i)
                .sum();
    }
}

package object_oriented.monster_battle.Main;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Monster1 {
    String character = "(unknown)";
    String trainer = "(wild)";
    String name = "(noname)";
    int lv = 1;
    int hp = 80;
    int atk = 15;
    int def = 10;
    int spd = 10;
    int hpMax = 80;
    String wazaNm = "たいあたり";
    String wazaDmgRate = "1.0";

    @Override
    public String toString() {
        return "<フィールド確認>"
                + " character:" + character
                + " / trainer:" + trainer
                + " / name:" + name
                + " / lv:" + lv
                + " / hp:" + hp
                + " / atk:"+ atk
                + " / def:" + def
                + " / spd:" + spd
                + " / hpMax:" + hpMax
                + " / wazaNm:" + wazaNm
                + " / wazaDmgRate:" + wazaDmgRate;
    }

    public void levelUp(int level) {
        lv += level;
        hpMax += level * 30;
        atk += level * 5;
        def += level * 5;
        spd += level * 5;
        hp = hpMax;
    }

    public void setWaza(String wazaNm, String wazaDmgRate) {
        final String dmgRateRegex = "^[0-9]*\\.[0-9]$";

        if(!wazaDmgRate.matches(dmgRateRegex)){
            throw new IllegalArgumentException("[ERROR]わざの設定に失敗しました");
        }

        this.wazaNm = wazaNm;
        this.wazaDmgRate = wazaDmgRate;
    }

    public int useWaza() {
        var _atk = BigDecimal.valueOf(atk);
        var _wazaDmgRate = BigDecimal.valueOf(Double.valueOf(wazaDmgRate));

        return _atk.multiply(_wazaDmgRate).intValue();
    }

    public String getStatus() {
        return "[" + name + " lv" + lv + " HP" + hp + "/" + hpMax + "]";
    }

    public int damaged(int damage) {
        var subtractionRatioNumerator = BigDecimal.valueOf(1);
        var subtractionRatioDenominator = BigDecimal.valueOf(1).add(
                BigDecimal.valueOf(def)
                .divide(BigDecimal.valueOf(120), 3, RoundingMode.FLOOR)
        );
        var subtractionRatio = subtractionRatioNumerator.divide(subtractionRatioDenominator, 3, RoundingMode.FLOOR);

        return BigDecimal.valueOf(damage).multiply(subtractionRatio).intValue();
    }
}

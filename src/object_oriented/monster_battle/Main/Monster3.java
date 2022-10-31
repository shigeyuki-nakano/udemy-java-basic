package object_oriented.monster_battle.Main;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Monster3 {
    private String character = "(unknown)";
    private String trainer = "(wild)";
    private String name = "(noname)";
    private int lv = 1;
    private int hp = 80;
    private int atk = 15;
    private int def = 10;
    private int spd = 10;
    private int hpMax = 80;
    private String wazaNm = "たいあたり";
    private String wazaDmgRate = "1.0";

    public Monster3() {
        character = "(unknown)";
        trainer = "(wild)";
        name = "(noname)";
        lv = 1;
        hp = 80;
        atk = 15;
        def = 10;
        spd = 10;
        hpMax = 80;
        wazaNm = "たいあたり";
        wazaDmgRate = "1.0";
    }

    public Monster3(String trainer, String name) {
        this();
        this.trainer = trainer;
        this.name = name;
    }

    public Monster3(String trainer, String name, int initLevel) {
        this(trainer, name);

        if(initLevel <= 1) {
            this.lv = 1;
            return;
        }
        levelUp(initLevel - 1);
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLv() {
        return lv;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public int getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public String getWazaNm() {
        return wazaNm;
    }

    public void setWazaNm(String wazaNm) {
        this.wazaNm = wazaNm;
    }

    public String getWazaDmgRate() {
        return wazaDmgRate;
    }

    public void setWazaDmgRate(String wazaDmgRate) {
        this.wazaDmgRate = wazaDmgRate;
    }

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

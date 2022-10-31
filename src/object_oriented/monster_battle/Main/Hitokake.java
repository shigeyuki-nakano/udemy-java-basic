package object_oriented.monster_battle.Main;

public class Hitokake extends Monster3 {
    public Hitokake() {
        super();
        this.setCharacter("ヒトカケ");
    }

    public Hitokake(String trainer, String name) {
        super(trainer, name);
        this.setCharacter("ヒトカケ");
    }

    public Hitokake(String trainer, String name, int initLevel) {
        super(trainer, name, initLevel);
        this.setCharacter("ヒトカケ");
    }

    @Override
    public void levelUp(int level) {
        if(level <= 0) {
            return;
        }

        setLv(getLv() + level);
        setHp(getHp() + (level * 29));
        setAtk(getAtk() + (level * 8));
        setDef(getDef() + (level * 5));
        setSpd(getSpd() + (level * 9));
        setHpMax(getHp());
    }
}

package object_oriented.monster_battle.Main;

public class Fushigiyade extends Monster3 {
    public Fushigiyade() {
        setCharacter("フシギヤデ");
    }

    public Fushigiyade(String trainer, String name) {
        super(trainer, name);
        setCharacter("フシギヤデ");
    }

    public Fushigiyade(String trainer, String name, int initLevel) {
        super(trainer, name, initLevel);
        setCharacter("フシギヤデ");
    }

    @Override
    public void levelUp(int level) {
        if(level <= 0) {
            return;
        }

        setLv(getLv() + level);
        setHp(getHp() + (level * 31));
        setAtk(getAtk() + (level * 6));
        setDef(getDef() + (level * 7));
        setSpd(getSpd() + (level * 8));
        setHpMax(getHp());
    }
}

package object_oriented.monster_battle.Main;

public class Main {
    public static void main(String[] args) {
        try {
            var monster = new Monster2("トレーナー", "モンスター");
            System.out.println(monster.toString());

            var hitokake = new Hitokake();
            hitokake.levelUp(1);
            System.out.println(hitokake.toString());

            var fushigiyade = new Fushigiyade();
            fushigiyade.levelUp(4);
            System.out.println(fushigiyade.toString());
            fushigiyade.levelUp(-1);
            System.out.println(fushigiyade.toString());
        } catch(IllegalArgumentException e) {
            System.err.println("引数の形式が誤っています");
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

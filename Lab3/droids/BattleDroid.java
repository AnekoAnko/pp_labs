package droids;

import droids.Droid;

public class BattleDroid extends Droid {
    public BattleDroid(String name, int health, int damage) {
        super(name, health, damage);
    }

    public void skill(Droid opponent) {
        opponent.setHealth(opponent.getHealth() - getDamage() * 2);
    }
}



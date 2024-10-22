package droids;

import droids.Droid;

public class RepairDroid extends Droid {
    public RepairDroid(String name, int health, int damage) {
        super(name, health, damage);
    }

    public void skill(Droid opponent) {
        setHealth(getHealth() + opponent.getDamage()*2);
    }
}

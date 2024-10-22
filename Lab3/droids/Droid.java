package droids;

public class Droid {
    private String name;
    private int health;
    private int damage;

    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void attack(Droid opponent) {
        opponent.setHealth(opponent.getHealth() - this.damage);
    }

    public void skill(Droid opponent){
        System.out.println("Droid has used special skill!");
    }

    public String toString() {
        return "Droid{name='" + name + "', health=" + health + ", damage=" + damage + '}';
    }
}

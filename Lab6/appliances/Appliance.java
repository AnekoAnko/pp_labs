package appliances;

public abstract class Appliance {
    private String name;
    private int power;
    private boolean pluggedIn;

    public Appliance(String name, int power) {
        this.name = name;
        this.power = power;
        this.pluggedIn = false;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public boolean isPluggedIn() {
        return pluggedIn;
    }

    public void plugIn() {
        this.pluggedIn = true;
    }

    public void unplug() {
        this.pluggedIn = false;
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", pluggedIn=" + pluggedIn +
                '}';
    }
}

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
        //Реалізація буде пізніше
    }

    public int getPower() {
        //Реалізація буде пізніше
    }

    public boolean isPluggedIn() {
        //Реалізація буде пізніше
    }

    public void plugIn() {
        //Реалізація буде пізніше
    }

    public void unplug() {
        //Реалізація буде пізніше
    }

    @Override
    public String toString() {
        //Реалізація буде пізніше
    }
}

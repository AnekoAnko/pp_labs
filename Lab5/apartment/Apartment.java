package apartment;

import appliances.Appliance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Apartment {
    private List<Appliance> appliances;

    public Apartment() {
        appliances = new ArrayList<>();
    }

    public void addAppliance(Appliance appliance) {
        //Реалізація буде пізніше
    }

    public void showAllAppliances() {
        //Реалізація буде пізніше
    }

    public void showPluggedInAppliances() {
        //Реалізація буде пізніше
    }

    public int calculateTotalPowerConsumption() {
        //Реалізація буде пізніше
    }

    public void sortAppliancesByPower(boolean ascending) {
        //Реалізація буде пізніше
    }

    public Appliance findApplianceByPowerRange(int minPower, int maxPower) {
        //Реалізація буде пізніше
    }

    public List<Appliance> getAppliances() {
        //Реалізація буде пізніше
    }
}

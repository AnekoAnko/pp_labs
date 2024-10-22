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
        appliances.add(appliance);
    }

    public void showAllAppliances() {
        for (Appliance appliance : appliances) {
            System.out.println(appliance);
        }
    }

    public void showPluggedInAppliances() {
        List<Appliance> pluggedIn = appliances.stream()
                .filter(Appliance::isPluggedIn)
                .collect(Collectors.toList());

        if (pluggedIn.isEmpty()) {
            System.out.println("No appliances are plugged in.");
        } else {
            pluggedIn.forEach(System.out::println);
        }
    }

    public int calculateTotalPower() {
        return appliances.stream()
                .filter(Appliance::isPluggedIn)
                .mapToInt(Appliance::getPower)
                .sum();
    }

    public void sortAppliancesByPower(boolean ascending) {
        appliances.sort(ascending ? Comparator.comparingInt(Appliance::getPower) :
                Comparator.comparingInt(Appliance::getPower).reversed());
    }

    public Appliance findApplianceByPowerRange(int minPower, int maxPower) {
        return appliances.stream()
                .filter(appliance -> appliance.getPower() >= minPower && appliance.getPower() <= maxPower)
                .findFirst()
                .orElse(null);
    }

    public List<Appliance> getAppliances() {
        return appliances;
    }
}

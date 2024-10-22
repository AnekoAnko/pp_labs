package commands;

import apartment.Apartment;

public class CalculatePowerCommand implements Command {
    private Apartment apartment;

    public CalculatePowerCommand(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public void execute() {
        int totalPower = apartment.calculateTotalPower();
        System.out.println("Total power consumption: " + totalPower + " watts");
    }

    @Override
    public String description() {
        return "Calculate total power consumption"; 
    }
}

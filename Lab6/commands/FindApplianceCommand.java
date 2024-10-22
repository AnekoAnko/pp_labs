package commands;

import apartment.Apartment;

import java.util.Scanner;

public class FindApplianceCommand implements Command {
    private Apartment apartment;
    private Scanner scanner;

    public FindApplianceCommand(Apartment apartment, Scanner scanner) {
        this.apartment = apartment;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter minimum power: ");
        int minPower = scanner.nextInt();
        System.out.print("Enter maximum power: ");
        int maxPower = scanner.nextInt();
        apartment.findApplianceByPowerRange(minPower, maxPower);
    }

    @Override
    public String description() {
        return "Find appliance by power range"; 
    }
}

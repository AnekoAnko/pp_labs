package commands;

import apartment.Apartment;
import java.util.Scanner;

public class SortCommand implements Command {
    private Apartment apartment;
    private Scanner scanner;

    public SortCommand(Apartment apartment, Scanner scanner) {
        this.apartment = apartment;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Sort in ascending order (true/false): ");
        boolean ascending = scanner.nextBoolean();
        apartment.sortAppliancesByPower(ascending);
        System.out.println("Appliances sorted.");
    }

    @Override
    public String description() {
        return "Sort appliances by power"; 
    }
}

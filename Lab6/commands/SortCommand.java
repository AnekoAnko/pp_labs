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
        System.out.print("Sort appliances by power (asc/desc): ");
        String sortOrder = scanner.next();
        apartment.sortAppliancesByPower(sortOrder.equalsIgnoreCase("asc"));
        apartment.showAllAppliances();
    }

    @Override
    public String description() {
        return "Sort appliances by power"; 
    }
}

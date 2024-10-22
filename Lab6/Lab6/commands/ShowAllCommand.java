package commands;

import apartment.Apartment;

public class ShowAllCommand implements Command {
    private Apartment apartment;

    public ShowAllCommand(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public void execute() {
        apartment.showAllAppliances();
    }

    @Override
    public String description() {
        return "Show all appliances"; 
    }
}

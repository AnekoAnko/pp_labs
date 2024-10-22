package commands;

import apartment.Apartment;

public class ShowPluggedInCommand implements Command {
    private Apartment apartment;

    public ShowPluggedInCommand(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public void execute() {
        apartment.showPluggedInAppliances();
    }

    @Override
    public String description() {
        return "Show plugged-in appliances"; 
    }
}

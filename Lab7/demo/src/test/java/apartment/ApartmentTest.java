package apartment;

import appliances.Appliance;
import appliances.WashingMachine;
import appliances.Fridge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentTest {

    private Apartment apartment;
    private Appliance washingMachine;

    @BeforeEach
    void setUp() {
        apartment = new Apartment();
        washingMachine = new WashingMachine("Washing Machine", 2000);
        apartment.addAppliance(washingMachine);
    }

    @Test
    void testAddAppliance() {
        assertEquals(1, apartment.getAppliances().size(), "The appliance should be added.");
    }

    @Test
    void testShowAllAppliances() {
        apartment.showAllAppliances(); // Should print out the washing machine info
        // Checking if the washing machine name is correct
        assertTrue(washingMachine.getName().equals("Washing Machine"));
    }

    @Test
    void testCalculateTotalPowerConsumption() {
        washingMachine.plugIn();  // Ensure it's plugged in
        int totalPower = apartment.calculateTotalPower();
        assertEquals(2000, totalPower, "The power consumption should be correctly calculated.");
    }

    @Test
    void testSortAppliancesByPower() {
        // Add another appliance with different power
        Appliance fridge = new Fridge("Fridge", 150);
        apartment.addAppliance(fridge);
        
        apartment.sortAppliancesByPower(true);  // Sorting in ascending order

        // After sorting, the washing machine should be first (since it has higher power)
        assertEquals(washingMachine, apartment.getAppliances().get(1));
        assertEquals(fridge, apartment.getAppliances().get(0));
    }
}

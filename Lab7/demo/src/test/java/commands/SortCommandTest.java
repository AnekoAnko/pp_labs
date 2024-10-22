package commands;

import apartment.Apartment;
import appliances.Appliance;
import appliances.Fridge;
import appliances.WashingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortCommandTest {

    private Apartment apartment;

    @BeforeEach
    void setUp() {
        apartment = new Apartment();

        // Додаємо кілька приладів
        Appliance fridge = new Fridge("Fridge", 150);
        Appliance washingMachine = new WashingMachine("Washing Machine", 2000);

        apartment.addAppliance(fridge);
        apartment.addAppliance(washingMachine);
    }

    @Test
    void testSortAppliancesByPowerAscending() {
        // Імітуємо введення true (сортування за зростанням)
        String input = "true";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Використовуємо правильний клас для сортування
        SortCommand sortCommand = new SortCommand(apartment, new java.util.Scanner(System.in));
        sortCommand.execute();  // Викликаємо команду для сортування

        // Перевіряємо, чи прилади відсортовані за зростанням потужності
        List<Appliance> sortedAppliances = apartment.getAppliances();
        assertEquals("Fridge", sortedAppliances.get(0).getName());
        assertEquals("Washing Machine", sortedAppliances.get(1).getName());
    }

    @Test
    void testSortAppliancesByPowerDescending() {
        // Імітуємо введення false (сортування за спаданням)
        String input = "false";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Використовуємо правильний клас для сортування
        SortCommand sortCommand = new SortCommand(apartment, new java.util.Scanner(System.in));
        sortCommand.execute();  // Викликаємо команду для сортування

        // Перевіряємо, чи прилади відсортовані за спаданням потужності
        List<Appliance> sortedAppliances = apartment.getAppliances();
        assertEquals("Washing Machine", sortedAppliances.get(0).getName());
        assertEquals("Fridge", sortedAppliances.get(1).getName());
    }
}

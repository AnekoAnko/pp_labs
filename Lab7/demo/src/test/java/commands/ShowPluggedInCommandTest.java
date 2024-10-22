package commands;

import apartment.Apartment;
import appliances.Appliance;
import appliances.WashingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShowPluggedInCommandTest {

    private Apartment apartment;
    private Appliance washingMachine;
    private ShowPluggedInCommand showPluggedInCommand;

    @BeforeEach
    void setUp() {
        apartment = mock(Apartment.class);  // Мокапимо Apartment для тесту
        washingMachine = new WashingMachine("Washing Machine", 2000);
        showPluggedInCommand = new ShowPluggedInCommand(apartment);
    }

    @Test
    void testShowPluggedInAppliances() {
        // Налаштовуємо мокап так, щоб метод showPluggedInAppliances виконувався правильно
        doNothing().when(apartment).showPluggedInAppliances(); // Якщо метод не повертає результат, використовуємо doNothing()

        // Виконуємо команду
        showPluggedInCommand.execute();

        // Перевіряємо, чи викликається метод showPluggedInAppliances
        verify(apartment).showPluggedInAppliances();
    }

    @Test
    void testDescription() {
        // Перевіряємо правильність опису
        String expectedDescription = "Show plugged-in appliances";
        assertEquals(expectedDescription, showPluggedInCommand.description());
    }
}

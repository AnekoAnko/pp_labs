package commands;

import apartment.Apartment;
import appliances.Appliance;
import appliances.WashingMachine;
import appliances.Fridge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CalculatePowerCommandTest {

    private Apartment apartment;
    private Appliance washingMachine;
    private Appliance fridge;
    private CalculatePowerCommand calculatePowerCommand;

    @BeforeEach
    void setUp() {
        // Створюємо моки для приладів
        apartment = mock(Apartment.class);
        washingMachine = mock(WashingMachine.class);
        fridge = mock(Fridge.class);

        // Імітуємо поведінку приладів
        when(washingMachine.isPluggedIn()).thenReturn(true);
        when(washingMachine.getPower()).thenReturn(2000);

        when(fridge.isPluggedIn()).thenReturn(true);
        when(fridge.getPower()).thenReturn(150);

        // Створюємо команду
        calculatePowerCommand = new CalculatePowerCommand(apartment);
    }

    @Test
    void testCalculateTotalPowerConsumption() {
        // Підключаємо прилади до квартири
        when(apartment.calculateTotalPower()).thenReturn(2150);

        // Виконуємо команду
        calculatePowerCommand.execute();

        // Перевірка: Має бути виведено 2150W як споживану потужність
        verify(apartment).calculateTotalPower();
    }
}

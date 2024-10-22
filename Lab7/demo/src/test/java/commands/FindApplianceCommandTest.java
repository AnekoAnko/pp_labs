package commands;

import apartment.Apartment;
import appliances.Appliance;
import appliances.WashingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.mockito.Mockito.*;

class FindApplianceCommandTest {

    private Apartment apartment;
    private Scanner scanner;
    private FindApplianceCommand findApplianceCommand;

    @BeforeEach
    void setUp() {
        apartment = Mockito.mock(Apartment.class);  // Створюємо mock для Apartment
        scanner = Mockito.mock(Scanner.class);      // Створюємо mock для Scanner
        findApplianceCommand = new FindApplianceCommand(apartment, scanner);
    }

    @Test
    void testFindApplianceByPowerRange() {
        // Симулюємо введення даних у Scanner
        when(scanner.nextInt()).thenReturn(100, 2000); // Мінімум 100, максимум 2000

        // Створюємо appliance, який повернеться під час виклику findApplianceByPowerRange
        Appliance washingMachine = new WashingMachine("Washing Machine", 1500);
        when(apartment.findApplianceByPowerRange(100, 2000)).thenReturn(washingMachine);

        // Виконуємо команду
        findApplianceCommand.execute();

        // Перевіряємо, що метод findApplianceByPowerRange був викликаний з правильними параметрами
        verify(apartment).findApplianceByPowerRange(100, 2000);

        // Перевіряємо, що Scanner запитував двічі наступні цілі значення
        verify(scanner, times(2)).nextInt();
    }
}

package main;

import apartment.Apartment;
import commands.Command;
import commands.ShowAllCommand;
import commands.ShowPluggedInCommand;
import commands.CalculatePowerCommand;
import commands.SortCommand;
import commands.FindApplianceCommand;
import commands.Invoker;

import appliances.WashingMachine;
import appliances.Fridge;
import appliances.TV;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Apartment apartment = new Apartment();
        Scanner scanner = new Scanner(System.in);

        apartment.addAppliance(new WashingMachine("Washing Machine", 2000));
        apartment.addAppliance(new Fridge("Fridge", 150));
        apartment.addAppliance(new TV("Television", 100));

        Invoker invoker = new Invoker();

        Map<Integer, Command> commandMap = new HashMap<>();
        commandMap.put(1, new ShowAllCommand(apartment));
        commandMap.put(2, new ShowPluggedInCommand(apartment));
        commandMap.put(3, new CalculatePowerCommand(apartment));
        commandMap.put(4, new SortCommand(apartment, scanner));
        commandMap.put(5, new FindApplianceCommand(apartment, scanner));

        while (true) {
            printMenu(commandMap);
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            if (choice == 6) {
                System.out.println("Exiting...");
                break; 
            }

            Command command = commandMap.get(choice);
            if (command != null) {
                invoker.setCommand(command); 
                invoker.executeCommand();
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void printMenu(Map<Integer, Command> commandMap) {
        System.out.println("\nMenu:");
        for (Map.Entry<Integer, Command> entry : commandMap.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().description());
        }
        System.out.println("6. Exit");
    }
}

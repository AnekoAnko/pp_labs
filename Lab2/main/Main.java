package main;

import customer.Customer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Customer[] customers = createCustomers();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name to search for customers:");
        String name = scanner.nextLine();
        printByName(customers, name);

        System.out.println("\nEnter the minimum credit card number:");
        long min = scanner.nextLong();
        System.out.println("Enter the maximum credit card number:");
        long max = scanner.nextLong();
        printByRange(customers, min, max);

        System.out.println("\nCustomers with negative balance:");
        printByNegativeBalance(customers);
    }

    public static Customer[] createCustomers() {
        return new Customer[]{
                new Customer(1, "Doe", "John", "A", "123 Main St", "1234", 100.0),
                new Customer(2, "Smith", "Jane", "B", "456 Elm St", "5000", -50.0),
                new Customer(3, "Brown", "John", "C", "789 Oak St", "9500", 200.0)
        };
    }

    public static void printByName(Customer[] customers, String name) {
        for (Customer customer : customers) {
            if (customer.getFirstName().equalsIgnoreCase(name)) {
                System.out.println(customer);
            }
        }
    }

    public static void printByRange(Customer[] customers, long min, long max) {
        for (Customer customer : customers) {
            int creditCardNumber = Integer.parseInt(customer.getCreditCardNumber());
            if (creditCardNumber >= min && creditCardNumber <= max) {
                System.out.println(customer);
            }
        }
    }

    public static void printByNegativeBalance(Customer[] customers) {
        for (Customer customer : customers) {
            if (customer.getBalance() < 0) {
                System.out.println(customer);
            }
        }
    }
}

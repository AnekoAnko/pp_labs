// Пакет для головного класу
package main;

import droids.Droid;
import droids.BattleDroid;
import droids.RepairDroid;
import battles.Battle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ArrayList<Droid> droids = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lastBattleResult = "";
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Create droid");
            System.out.println("2. Show the list of droids");
            System.out.println("3. Play 1 vs 1");
            System.out.println("4. Play team vs team");
            System.out.println("5. Log fight");
            System.out.println("6. Recreate fight from file");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createDroid(scanner);
                    break;
                case 2:
                    showDroids();
                    break;
                case 3:
                    lastBattleResult = startSoloBattle(scanner);
                    break;
                case 4:
                    lastBattleResult = startTeamBattle(scanner);
                    break;
                case 5:
                    if(lastBattleResult != "") {
                        saveToFile(lastBattleResult);
                    } else{
                        System.out.println("There weren't any battles!");
                    }
                    break;
                case 6:
                    loadFromFile();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice! Try again!");
            }
        }
    }

    private static void createDroid(Scanner scanner) {
        System.out.print("Enter a name of droid: ");
        String name = scanner.next();
        System.out.print("Enter droid's health: ");
        int health = scanner.nextInt();
        System.out.print("Enter droid's damage: ");
        int damage = scanner.nextInt();
        System.out.print("Choose type of droid (1 - BattleDroid, 2 - RepairDroid): ");
        int type = scanner.nextInt();

        Droid droid;
        if (type == 1) {
            droid = new BattleDroid(name, health, damage);
        } else {
            droid = new RepairDroid(name, health, damage);
        }
        droids.add(droid);
        System.out.println("Droid is created!");
    }

    private static void showDroids() {
        for (Droid droid : droids) {
            System.out.println(droid.getName() + " - Health: " + droid.getHealth() + ", Damage: " + droid.getDamage());
        }
    }

    private static String startSoloBattle(Scanner scanner) {
        System.out.print("Enter a number of first droid: ");
        int droid1Index = scanner.nextInt() - 1;
        System.out.print("Enter a number of second droid: ");
        int droid2Index = scanner.nextInt() - 1;
    
        if (droid1Index < droids.size() && droid2Index < droids.size()) {
            List<Droid> originalDroids = copyDroids(droids); // Копіюємо список дронів
            String battleResult = Battle.oneOnOne(droids.get(droid1Index), droids.get(droid2Index));
            
            // Відновлюємо дронів з копії
            droids.clear();
            droids.addAll(originalDroids);
            
            return battleResult;
        } else {
            System.out.println("Невірний вибір дроїдів.");
            return "Invalid droid selection";
        }
    }
    
    private static String startTeamBattle(Scanner scanner) {
        List<Droid> team1 = new ArrayList<>();
        List<Droid> team2 = new ArrayList<>();
    
        System.out.println("Creating team 1:");
        formTeam(scanner, team1);
    
        System.out.println("Creating team 2:");
        formTeam(scanner, team2);
    
        List<Droid> originalDroids = copyDroids(droids); // Копіюємо список дронів
        String battleResult = Battle.teamBattle(team1, team2);
        
        // Відновлюємо дронів з копії
        droids.clear();
        droids.addAll(originalDroids);
    
        return battleResult;
    }
    

    private static void formTeam(Scanner scanner, List<Droid> team) {
        while (true) {
            System.out.println("Enter droid to add to team (enter '-1' to finish): ");
            showDroids();
            int index = scanner.nextInt();
            if (index == -1) {
                break;
            }
            if (index >= 0 && index < droids.size()) {
                team.add(droids.get(index));
            } else {
                System.out.println("Error! Try again!");
            }
        }
    }

    private static List<Droid> copyDroids(List<Droid> originalDroids) {
        List<Droid> copiedDroids = new ArrayList<>();
        for (Droid droid : originalDroids) {
            Droid copiedDroid;
            if (droid instanceof BattleDroid) {
                copiedDroid = new BattleDroid(droid.getName(), droid.getHealth(), droid.getDamage());
            } else {
                copiedDroid = new RepairDroid(droid.getName(), droid.getHealth(), droid.getDamage());
            }
            copiedDroids.add(copiedDroid);
        }
        return copiedDroids;
    }
    

    private static void saveToFile(String battleResult) {
        try (FileWriter writer = new FileWriter("../battle_log.txt", true)) {
            writer.write(battleResult + "\n");
            System.out.println("Battle results are saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    private static void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("../battle_log.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
}

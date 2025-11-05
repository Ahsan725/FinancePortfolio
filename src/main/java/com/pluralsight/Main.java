package com.pluralsight;

import com.pluralsight.finance.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Portfolio folio = new Portfolio("my folio", "Ahsan");

    public static void main(String[] args) {
//      testClasses(); //to test and see the output for classes
        testPortfolio();

    }

    public static void testClasses(){
        //list of Valuable objects
        ArrayList<Valuable> assets = new ArrayList<>();

        assets.add(new Gold("Gold Bar", 128, 10));
        assets.add(new Jewelry("Necklace", 8, 14));
        assets.add(new House("Home", 250000, 1995, 2200, 3));
        assets.add(new BankAccount("Checking", "12345", 5000));
        assets.add(new CreditCard("Visa", "99999", 1200));

        // Looping through all Valuables
        for (Valuable item : assets) {

            // Print common info
            System.out.println();
            System.out.println("Asset Class: " + item.getClass().getSimpleName());
            System.out.println("Value: $" + item.getValue());

            if (item instanceof Gold gold) {
                System.out.println("Name: " + gold.getName());
                System.out.println("Weight: " + gold.getMarketValue());
            }
            else if (item instanceof Jewelry jewelry) {
                System.out.println("Name: " + jewelry.getName());
                System.out.println("Karat: " + jewelry.getKarat());
            }
            else if (item instanceof House house) {
                System.out.println("Name: " + house.getName());
                System.out.println("Bedrooms: " + house.getBedrooms());
                System.out.println("SquareFoot: " + house.getSquareFeet());
            }
            else if (item instanceof BankAccount account) {
                System.out.println("Account Name: " + account.getName());
                System.out.println("Balance: $" + account.getValue());
            }
            else if (item instanceof CreditCard card) {
                System.out.println("Card Name: " + card.getName());
                System.out.println("Liability: $" + card.getValue());
            }
            else {
                System.out.println("Unknown asset type IRS wants to investigate this further");
            }
        }
    }

    public static void testPortfolio() {
        System.out.println("Welcome to your portfolio manager!");

        char command;
        do {
            System.out.println("""
   
                Portfolio Menu

                (A) Add Asset
                (V) View Portfolio Summary
                (X) Exit
                Enter command:
                """);

            String input = sc.nextLine().trim().toLowerCase();
            command = input.isEmpty() ? ' ' : input.charAt(0);

            switch (command) {
                case 'a' -> createAndAddAsset();
                case 'v' -> displayPortfolio();
                case 'x' -> System.out.println("Exiting portfolio manager...");
                default -> System.out.println("Invalid command. Please try again.");
            }

        } while (command != 'x');
    }
    //I was tired of making sure double was entered properly by the user
    private static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    private static void displayPortfolio() {
        System.out.println("\nPortfolio Summary");
        System.out.println("Least Valuable: $" + folio.getLeastValuable());
        System.out.println("Most Valuable: $" + folio.getMostValuable());
        System.out.println("Total Portfolio Value: $" + folio.getValue());
    }

    private static void createAndAddAsset() {
        System.out.println("\nLet's add a new asset to your portfolio.");

        char type;
        while (true) {
            System.out.println("""
                
                What type of asset are you adding?
                (G) Gold
                (J) Jewelry
                (H) House
                (X) Cancel
                Enter command:
                """);

            String input = sc.nextLine().trim().toLowerCase();
            type = input.isEmpty() ? ' ' : input.charAt(0);

            if (type == 'x') {
                System.out.println("Cancelled adding asset.");
                return;
            }

            if ("gjh".indexOf(type) == -1) {
                System.out.println("Invalid option, please try again.");
                continue;
            }

            System.out.print("Enter asset name: ");
            String name = sc.nextLine().trim();

            double value = getDoubleInput("Enter market value: $");

            switch (type) {
                case 'g' -> {
                    double weight = getDoubleInput("Enter weight in grams: ");
                    folio.add(new Gold(name, value, weight));
                    System.out.println("Gold asset added successfully!");
                }
                case 'j' -> {
                    double karat = getDoubleInput("Enter karat: ");
                    folio.add(new Jewelry(name, value, karat));
                    System.out.println("Jewelry asset added successfully!");
                }
                case 'h' -> {
                    int year = (int) getDoubleInput("Enter year built: ");
                    int sqft = (int) getDoubleInput("Enter square footage: ");
                    int bedrooms = (int) getDoubleInput("Enter number of bedrooms: ");
                    folio.add(new House(name, value, year, sqft, bedrooms));
                    System.out.println("House asset added successfully!");
                }
            }
            break;
        }
    }
}

package com.pluralsight;

import com.pluralsight.finance.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

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
}

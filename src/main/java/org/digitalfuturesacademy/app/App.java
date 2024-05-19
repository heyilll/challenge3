package org.digitalfuturesacademy.app;

import java.util.Scanner;

public class App {
    private static final AddressBook addressBook = new AddressBook();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Some contacts have been added to the address book for DEMO purposes. Input 4 to view all contacts added.");
        Contact demoContact1 = new Contact("John Smith", "07835321211", "john.smith@example.com");
        Contact demoContact2 = new Contact("Jadon Smith", "07962614681", "jadon.smith@example.com");
        addressBook.addContact(demoContact1);
        addressBook.addContact(demoContact2);

        while (true) {
            ConsoleUI.displayMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            try {
                ConsoleUI.handleChoice(addressBook, scanner, choice);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

package org.digitalfuturesacademy.app;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    public static void displayMenu() {
        System.out.println("\nAddress Book Menu");
        System.out.println("1. Add contact");
        System.out.println("2. Edit contact");
        System.out.println("3. Remove contact");
        System.out.println("4. View all contacts");
        System.out.println("5. Search for contacts");
        System.out.println("6. Exit");
    }

    public static void handleChoice(AddressBook addressBook, Scanner scanner, String choice) {
        switch (choice) {
            case "1":
                Contact contact = createContactFromInput(scanner);
                addressBook.addContact(contact);
                break;
            case "2":
                Contact oldcontact = createContactFromInput(scanner);
                Contact newcontact = createContactFromInput(scanner);
                addressBook.editContact(oldcontact, newcontact);
                break;
            case "3":
                Contact rcontact = createContactFromInput(scanner);
                addressBook.removeContact(rcontact);
                break;
            case "4":
                displayContacts(addressBook.getAllContacts());
                break;
            case "5":
                displayContacts(searchContacts(addressBook, scanner));
                break;
            case "6":
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void displayContacts(List<Contact> contacts) {
        for (Contact contact: contacts) {
            System.out.println("Name: " + contact.getName() + ", Phone Number: " + contact.getPhoneNumber() + ", Email: " + contact.getEmail());
        }
    }

    private static Contact createContactFromInput(Scanner scanner) {
        System.out.println("Enter contact details...");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        return new Contact(name, phoneNumber, email);
    }

    private static List<Contact> searchContacts(AddressBook addressBook, Scanner scanner) {
        System.out.println("Enter a name to search for...");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        return addressBook.searchContact(name);
    }
}


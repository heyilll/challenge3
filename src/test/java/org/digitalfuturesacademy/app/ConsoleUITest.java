package org.digitalfuturesacademy.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConsoleUITest {
    private static final AddressBook addressBook = new AddressBook();
    private static Scanner scanner;
    private static final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Nested
    @DisplayName("Menu tests")
    class MenuTests {

        @Test
        @DisplayName("Constructor sets expected values")
        public void testDisplayMenu() {
            // Arrange
            System.setOut(new PrintStream(outputStreamCaptor));

            // Act
            ConsoleUI.displayMenu();

            //Assert
            String consoleOutput = outputStreamCaptor.toString().trim();
            assertAll("Menu is displayed properly",
                    () -> assertTrue(consoleOutput.contains("Address Book Menu")),
                    () -> assertTrue(consoleOutput.contains("1. Add contact")),
                    () -> assertTrue(consoleOutput.contains("2. Edit contact")),
                    () -> assertTrue(consoleOutput.contains("3. Remove contact")),
                    () -> assertTrue(consoleOutput.contains("4. View all contacts")),
                    () -> assertTrue(consoleOutput.contains("5. Search for contacts")),
                    () -> assertTrue(consoleOutput.contains("6. Exit")));
        }
    }

    @Nested
    @DisplayName("Functionality tests")
    class FunctionalityTests {

        @BeforeEach
        void setUp() {
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn("07123456789");
            when(contact.getEmail()).thenReturn("john.smith@example.com");
            List<Contact> testContacts = new ArrayList<>();
            testContacts.add(contact);

            addressBook.setContacts(testContacts);
        }

        @Test
        @DisplayName("Handles Choice of Add")
        public void testHandleChoiceAdd() {
            // Arrange
            scanner = mock(Scanner.class);
            when(scanner.nextLine()).thenReturn("John Smith", "07123456789", "john.smith@example.com");

            List<Contact> testContacts = new ArrayList<>();
            addressBook.setContacts(testContacts);

            // Act
            ConsoleUI.handleChoice(addressBook, scanner, "1");

            //Assert
            assertAll("Menu is displayed properly",
                    () -> assertEquals(1, addressBook.getContacts().size()),
                    () -> assertEquals("John Smith", addressBook.getContacts().get(0).getName()),
                    () -> assertEquals("07123456789", addressBook.getContacts().get(0).getPhoneNumber()),
                    () -> assertEquals("john.smith@example.com", addressBook.getContacts().get(0).getEmail()));
        }

        @Test
        @DisplayName("Handles Choice of Edit")
        public void testHandleChoiceEdit() {
            // Arrange
            scanner = mock(Scanner.class);
            when(scanner.nextLine()).thenReturn("John Smith", "07123456789", "john.smith@example.com","Ed Wright", "07654783457", "ed.wright@example.com");

            // Act
            ConsoleUI.handleChoice(addressBook, scanner, "2");

            //Assert
            assertAll("Menu is displayed properly",
                    () -> assertEquals(1, addressBook.getContacts().size()),
                    () -> assertEquals("Ed Wright", addressBook.getContacts().get(0).getName()),
                    () -> assertEquals("07654783457", addressBook.getContacts().get(0).getPhoneNumber()),
                    () -> assertEquals("ed.wright@example.com", addressBook.getContacts().get(0).getEmail()));
        }

        @Test
        @DisplayName("Handles Choice of Remove")
        public void testHandleChoiceRemove() {
            // Arrange
            scanner = mock(Scanner.class);
            when(scanner.nextLine()).thenReturn("John Smith", "07123456789", "john.smith@example.com");

            // Act
            ConsoleUI.handleChoice(addressBook, scanner, "3");

            //Assert
            assertEquals(0, addressBook.getContacts().size());
        }

        @Test
        @DisplayName("Handles Choice of View All")
        public void testHandleChoiceViewAll() {
            // Arrange
            System.setOut(new PrintStream(outputStreamCaptor));

            // Act
            ConsoleUI.handleChoice(addressBook, scanner, "4");

            //Assert
            String consoleOutput = outputStreamCaptor.toString().trim();
            assertTrue(consoleOutput.contains("Name: John Smith, Phone Number: 07123456789, Email: john.smith@example.com"));
        }

        @Test
        @DisplayName("Handles Choice of Search")
        public void testHandleChoiceSearch() {
            // Arrange
            System.setOut(new PrintStream(outputStreamCaptor));

            scanner = mock(Scanner.class);
            when(scanner.nextLine()).thenReturn("John Smith");

            // Act
            ConsoleUI.handleChoice(addressBook, scanner, "5");

            //Assert
            String consoleOutput = outputStreamCaptor.toString().trim();
            assertTrue(consoleOutput.contains("Name: John Smith, Phone Number: 07123456789, Email: john.smith@example.com"));
        }
    }
}

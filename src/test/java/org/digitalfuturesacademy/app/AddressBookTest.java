package org.digitalfuturesacademy.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressBookTest {
    @Nested
    @DisplayName("Address Book Constructor Tests")
    class AddressBookConstructorTests {

        @Test
        public void testConstructorReturnsExpectedValues() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            // Act
            // Assert
            assertAll(
                    () -> assertEquals(0, testAddressBook.getContacts().size())
            );
        }
    }

    @Nested
    @DisplayName("Address Book AddContact Tests")
    class AddressBookAddContactTests {
        private AddressBook testAddressBook;

        @BeforeEach
        void setUp() {
            testAddressBook = new AddressBook();
        }

        @Test
        @DisplayName("Test addContact works when contact is correct")
        public void testAddContactWorksWhenContactIsCorrect() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("example@e.com");

            // Act
            testAddressBook.addContact(contact);
            // Assert
            assertEquals(1, testAddressBook.getContacts().size());
        }
    }

    @Nested
    @DisplayName("Address Book removeContact Tests")
    class AddressBookRemoveContactTests {
        private AddressBook testAddressBook;

        @BeforeEach
        void setUp() {
            testAddressBook = new AddressBook();
        }

        @Test
        @DisplayName("Test removeContact works when contact is correct")
        public void testRemoveContactWorksWhenContactIsCorrect() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("example@e.com");
            List<Contact> testContacts = new ArrayList<Contact>();
            testContacts.add(contact);

            testAddressBook.setContacts(testContacts);
            // Act
            testAddressBook.removeContact(contact);
            // Assert
            assertEquals(0, testAddressBook.getContacts().size());
        }

        @Test
        @DisplayName("Test removeContact throws exception when contacts is empty")
        public void testRemoveContactThrowsExceptionWhenContactsIsEmpty() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("example@e.com");
            // Act
            // Assert
            assertThrows(NoSuchElementException.class, () -> {
                testAddressBook.removeContact(contact);
            });
        }
    }
}

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
            when(contact.getName()).thenReturn("John Smith");
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
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("example@e.com");
            List<Contact> testContacts = new ArrayList<>();
            testContacts.add(contact);

            testAddressBook.setContacts(testContacts);
        }

        @Test
        @DisplayName("Test removeContact works when contact is correct")
        public void testRemoveContactWorksWhenContactIsCorrect() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("example@e.com");
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
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("example@e.com");
            // Act
            // Assert
            assertThrows(NoSuchElementException.class, () -> {
                testAddressBook.removeContact(contact);
            });
        }
    }

    @Nested
    @DisplayName("Address Book editContact Tests")
    class AddressBookEditContactTests {
        private AddressBook testAddressBook;

        @BeforeEach
        void setUp() {
            testAddressBook = new AddressBook();
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("example@e.com");
            List<Contact> testContacts = new ArrayList<>();
            testContacts.add(contact);

            testAddressBook.setContacts(testContacts);
        }

        @Test
        @DisplayName("Test editContact works when contact is correct")
        public void testEditContactWorksWhenContactIsCorrect() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("example@e.com");

            Contact testContact = mock(Contact.class);
            when(testContact.getName()).thenReturn("John Smith");
            when(testContact.getPhoneNumber()).thenReturn("07912345678");
            when(testContact.getEmail()).thenReturn("example@e.com");
            // Act
            testAddressBook.editContact(contact, testContact);
            // Assert
            assertTrue(testAddressBook.getContacts().contains(testContact));
        }

        @Test
        @DisplayName("Test editContact works when old contact is not correct")
        public void testEditContactWorksWhenOldContactIsNotCorrect() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("Jssssssssss");
            when(contact.getPhoneNumber()).thenReturn("sssssssssssss");
            when(contact.getEmail()).thenReturn("sssssssssssssssss");

            Contact testContact = mock(Contact.class);
            when(testContact.getName()).thenReturn("Tyler Smith");
            when(testContact.getPhoneNumber()).thenReturn("07912345678");
            when(testContact.getEmail()).thenReturn("example@error.com");
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                testAddressBook.editContact(contact, testContact);
            });
        }

        @Test
        @DisplayName("Test editContact works when new contact is not correct")
        public void testEditContactWorksWhenNewContactIsNotCorrect() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("example@e.com");

            Contact testContact = mock(Contact.class);
            when(testContact.getName()).thenReturn("ssssssssssssss");
            when(testContact.getPhoneNumber()).thenReturn("ssssssssssssss");
            when(testContact.getEmail()).thenReturn("ssssssssssssssssssssss");
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                testAddressBook.editContact(contact, testContact);
            });
        }
    }

    @Nested
    @DisplayName("Address Book getAllContacts Tests")
    class AddressBookGetAllContactsTests {
        private AddressBook testAddressBook;

        @BeforeEach
        void setUp() {
            testAddressBook = new AddressBook();
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("example@e.com");
            Contact contact2 = mock(Contact.class);
            when(contact2.getName()).thenReturn("John Smith");
            when(contact2.getPhoneNumber()).thenReturn("07912345678");
            when(contact2.getEmail()).thenReturn("example@e.com");

            List<Contact> testContacts = new ArrayList<>();
            testContacts.add(contact);
            testContacts.add(contact2);

            testAddressBook.setContacts(testContacts);
        }

        @Test
        @DisplayName("Test getAllContacts works when contacts is correct")
        public void testGetAllContactsWorksWhenContactsIsCorrect() {
            // Arrange
            // Act
            // Assert
            assertEquals(2, testAddressBook.getAllContacts().size());
        }

        @Test
        @DisplayName("Test getAllContacts works when contacts is empty")
        public void testGetAllContactsWorksWhenContactsIsEmpty() {
            // Arrange
            List<Contact> testContacts = new ArrayList<>();
            testAddressBook.setContacts(testContacts);
            // Act
            // Assert
            assertEquals(0, testAddressBook.getAllContacts().size());
        }
    }

    @Nested
    @DisplayName("Address Book searchContact Tests")
    class AddressBookSearchContactsTests {
        private AddressBook testAddressBook;

        @BeforeEach
        void setUp() {
            testAddressBook = new AddressBook();
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("example@e.com");
            Contact contact2 = mock(Contact.class);
            when(contact2.getName()).thenReturn("Tyler Smith");
            when(contact2.getPhoneNumber()).thenReturn("0795467487");
            when(contact2.getEmail()).thenReturn("5645645e@e.com");

            List<Contact> testContacts = new ArrayList<>();
            testContacts.add(contact);
            testContacts.add(contact2);
            testAddressBook.setContacts(testContacts);
        }

        @Test
        @DisplayName("Test searchContact works when contacts is correct")
        public void testSearchContactWorksWhenContactsIsCorrect() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("example@e.com");
            // Act
            // Assert
            assertAll(
                    () -> assertEquals(contact.getName(), testAddressBook.searchContact("John Smith").get(0).getName()),
                    () -> assertEquals(1, testAddressBook.searchContact("John Smith").size())
            );

        }

        @Test
        @DisplayName("Test searchContact works when contacts is empty")
        public void testSearchContactWorksWhenContactsIsEmpty() {
            // Arrange
            List<Contact> testContacts = new ArrayList<>();
            testAddressBook.setContacts(testContacts);
            // Act
            // Assert
            assertThrows(NoSuchElementException.class, () -> {
                testAddressBook.searchContact("John Smith");
            });
        }
    }

    @Nested
    @DisplayName("Address Book Console Interface Tests")
    class AddressBookConsoleInterfaceTests {
        private AddressBook testAddressBook;

        @Test
        @DisplayName("Test ConsoleInterfaceWorks")
        public void testConsoleInterfaceWorks() {
            // Arrange
            // Act
            // Assert
        }
    }
}

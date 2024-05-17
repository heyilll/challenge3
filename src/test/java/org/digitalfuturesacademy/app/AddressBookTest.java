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
            assertEquals(0, testAddressBook.getContacts().size());
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

        @Test
        @DisplayName("Address Book Duplicate Tests")
        public void testAddContactPreventsDuplicateContactsPhoneNumbers() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("example@e.com");
            List<Contact> testContacts = new ArrayList<>();
            testContacts.add(contact);

            testAddressBook.setContacts(testContacts);

            Contact newcontact = mock(Contact.class);
            when(newcontact.getName()).thenReturn("John Smith");
            when(newcontact.getPhoneNumber()).thenReturn("07912345678");
            when(newcontact.getEmail()).thenReturn("different@example.com");

            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                testAddressBook.addContact(newcontact);
            });
        }

        @Test
        @DisplayName("Address Book Duplicate Tests")
        public void testAddContactPreventsDuplicateContactsEmails() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("example@e.com");
            List<Contact> testContacts = new ArrayList<>();
            testContacts.add(contact);

            testAddressBook.setContacts(testContacts);

            Contact newcontact = mock(Contact.class);
            when(newcontact.getName()).thenReturn("John Smith");
            when(newcontact.getPhoneNumber()).thenReturn("07987654321");
            when(newcontact.getEmail()).thenReturn("example@e.com");

            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                testAddressBook.addContact(newcontact);
            });
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
            List<Contact> testContacts = new ArrayList<>();
            testAddressBook.setContacts(testContacts);

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

        @Test
        @DisplayName("Test removeContact does nothing when contact does not exist")
        public void testRemoveContactDoesNothingWhenContactDoesNotExist() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("example@e.com");
            // Act
            // Assert
            assertEquals(1, testAddressBook.getContacts().size());
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
            when(testContact.getPhoneNumber()).thenReturn("07987654321");
            when(testContact.getEmail()).thenReturn("different@example.com");
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

        @Test
        @DisplayName("Test editContact works when old contact does not exist")
        public void testEditContactWorksWhenOldContactDoesNotExist() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("Smith Smith");
            when(contact.getPhoneNumber()).thenReturn("07956781234");
            when(contact.getEmail()).thenReturn("example@example.com");

            Contact testContact = mock(Contact.class);
            when(testContact.getName()).thenReturn("John Smith");
            when(testContact.getPhoneNumber()).thenReturn("07912345678");
            when(testContact.getEmail()).thenReturn("example@e.com");

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
        @DisplayName("Test searchContact throws an exception when contacts is empty")
        public void testSearchContactThrowsExceptionWhenContactsIsEmpty() {
            // Arrange
            List<Contact> testContacts = new ArrayList<>();
            testAddressBook.setContacts(testContacts);
            // Act
            // Assert
            assertThrows(NoSuchElementException.class, () -> {
                testAddressBook.searchContact("John Smith");
            });
        }

        @Test
        @DisplayName("Test searchContact throws an exception when the contact does not exist")
        public void testSearchContactReturnsWhenContactDoesNotExist() {
            // Arrange
            // Act
            // Assert
            assertTrue(testAddressBook.searchContact("Clive Staples Lewis").isEmpty());
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

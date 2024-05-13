package org.digitalfuturesacademy.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

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
        private AddressBook addressBook;

        @BeforeEach
        void setUp() {
            addressBook = new AddressBook();
        }
    }

    @Nested
    @DisplayName("Address Book removeContact Tests")
    class AddressBookRemoveContactTests {
        private AddressBook addressBook;

        @BeforeEach
        void setUp() {
            addressBook = new AddressBook();
        }
    }
}

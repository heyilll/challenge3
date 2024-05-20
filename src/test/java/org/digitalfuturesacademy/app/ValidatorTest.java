package org.digitalfuturesacademy.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ValidatorTest {
    @Nested
    @DisplayName("Validator Tests")
    class ValidatorTests {
        @Test
        @DisplayName("Test validateContact works when contact is right")
        public void testValidateContactWorksWhenContactIsRight() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("example@e.com");
            // Act
            // Assert

            assertDoesNotThrow(() -> {
                Validator.validateContact(contact);
            });
        }

        @Test
        @DisplayName("Test validateContact throws IllegalArgumentException when contact is null")
        public void testValidateContactThrowsIllegalArgumentExceptionWhenContactIsNull() {
            // Arrange
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                Validator.validateContact(null);
            });
        }

        @Test
        @DisplayName("Test validateContact throws IllegalArgumentException when contact name is null")
        public void testValidateContactThrowsIllegalArgumentExceptionWhenContactNameIsNull() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn(null);
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("example@e.com");
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                Validator.validateContact(contact);
            });
        }

        @Test
        @DisplayName("Test validateContact throws IllegalArgumentException when contact email is null")
        public void testValidateContactThrowsIllegalArgumentExceptionWhenContactEmailIsNull() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn(null);
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                Validator.validateContact(contact);
            });
        }

        @Test
        @DisplayName("Test validateContact throws IllegalArgumentException when contact phone number is null")
        public void testValidateContactThrowsIllegalArgumentExceptionWhenContactPhoneNumberIsNull() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn(null);
            when(contact.getEmail()).thenReturn("example@e.com");
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                Validator.validateContact(contact);
            });
        }

        @Test
        @DisplayName("Test validateContact throws IllegalArgumentException when contact name is empty")
        public void testValidateContactThrowsIllegalArgumentExceptionWhenContactNameIsEmpty() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("");
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("example@e.com");
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                Validator.validateContact(contact);
            });
        }

        @Test
        @DisplayName("Test validateContact throws IllegalArgumentException when contact email is empty")
        public void testValidateContactThrowsIllegalArgumentExceptionWhenContactEmailIsEmpty() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("");
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                Validator.validateContact(contact);
            });
        }

        @Test
        @DisplayName("Test validateContact throws IllegalArgumentException when contact phone number is empty")
        public void testValidateContactThrowsIllegalArgumentExceptionWhenContactPhoneNumberIsEmpty() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn("");
            when(contact.getEmail()).thenReturn("example@e.com");
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                Validator.validateContact(contact);
            });
        }

        @Test
        @DisplayName("Test validateContact throws IllegalArgumentException when contact name is wrong")
        public void testValidateContactThrowsIllegalArgumentExceptionWhenContactNameIsWrong() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("67567675635");
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("example@e.com");
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                Validator.validateContact(contact);
            });
        }

        @Test
        @DisplayName("Test validateContact throws IllegalArgumentException when contact phone number is wrong")
        public void testValidateContactThrowsIllegalArgumentExceptionWhenContactPhoneNumberIsWrong() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn("555555555555555555555");
            when(contact.getEmail()).thenReturn("example@e.com");
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                Validator.validateContact(contact);
            });
        }

        @Test
        @DisplayName("Test validateContact throws IllegalArgumentException when contact email is wrong")
        public void testValidateContactThrowsIllegalArgumentExceptionWhenContactEmailIsWrong() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("ggggggggggggggg");

            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                Validator.validateContact(contact);
            });
        }

        @Test
        @DisplayName("Test validateContact throws IllegalArgumentException when contact name is wrong")
        public void testValidateContactThrowsIllegalArgumentExceptionWhenContactNameIsWhitespace() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("            ");
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("example@e.com");
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                Validator.validateContact(contact);
            });
        }

        @Test
        @DisplayName("Test validateContact throws IllegalArgumentException when contact phone number is wrong")
        public void testValidateContactThrowsIllegalArgumentExceptionWhenContactPhoneNumberIsWhitespace() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn("                         ");
            when(contact.getEmail()).thenReturn("example@e.com");
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                Validator.validateContact(contact);
            });
        }

        @Test
        @DisplayName("Test validateContact throws IllegalArgumentException when contact email is wrong")
        public void testValidateContactThrowsIllegalArgumentExceptionWhenContactEmailIsWhitespace() {
            // Arrange
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("John Smith");
            when(contact.getPhoneNumber()).thenReturn("07912345678");
            when(contact.getEmail()).thenReturn("                     ");

            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                Validator.validateContact(contact);
            });
        }
    }
}

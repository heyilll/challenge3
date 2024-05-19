package org.digitalfuturesacademy.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Nested
    @DisplayName("Constructor tests")
    class ConstructorTests {

        @Test
        @DisplayName("Constructor sets expected values")
        public void constructorSetsValues() {
            // Arrange
            String testName = "Jadon Smith";
            String testPhoneNumber = "079023332436";
            String testEmail = "example@e.com";

            // Act
            Contact testContact = new Contact(testName, testPhoneNumber, testEmail);

            //Assert
            assertAll("Constructor sets values",
                    () -> assertEquals(testName, testContact.getName()),
                    () -> assertEquals(testPhoneNumber, testContact.getPhoneNumber()),
                    () -> assertEquals(testEmail, testContact.getEmail()));
        }
    }
}

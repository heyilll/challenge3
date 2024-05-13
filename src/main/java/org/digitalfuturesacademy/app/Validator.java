package org.digitalfuturesacademy.app;

public class Validator {
    public static void validateContact(Contact contact) {
        if(contact == null || contact.toString().isEmpty()) {
            throw new IllegalArgumentException("Contact cannot be null or empty");
        } else {
            validateEmail(contact);
            validatePhoneNumber(contact);
        }
    }

    private static void validateEmail(Contact contact) {
        if (contact.getEmail() == null ||contact.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        } else if(!contact.getEmail().matches("^(.+)@(.+)$")) {
            throw new IllegalArgumentException("Email must be in the form of an email");
        }
    }

    private static void validatePhoneNumber(Contact contact) {
        if (contact.getPhoneNumber() == null || contact.getPhoneNumber().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        } else if(!contact.getPhoneNumber().matches("07+[0-9]{9}")) {
            throw new IllegalArgumentException("Phone number must be in the form of 0712345678");
        }
    }
}

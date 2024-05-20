package org.digitalfuturesacademy.app;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        Validator.validateContact(contact);
        if (checkDuplicate(contact)) {
            throw new IllegalArgumentException("Email address or phone number already exists in the address book");
        }
        this.contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        checkEmpty();
        Validator.validateContact(contact);
        this.contacts.removeIf(existingContact -> existingContact.getPhoneNumber().equals(contact.getPhoneNumber())
                && existingContact.getEmail().equals(contact.getEmail()));
    }

    public void editContact(Contact oldcontact, Contact newcontact) {
        checkEmpty();
        Validator.validateContact(oldcontact);
        Validator.validateContact(newcontact);
        if (!checkDuplicate(oldcontact)) {
            throw new IllegalArgumentException("Contact does not exist in the address book.");
        }
        removeContact(oldcontact);
        addContact(newcontact);
    }

    public List<Contact> searchContact(String name) {
        checkEmpty();
        List<Contact> searchedContacts = new ArrayList<>();
        for (Contact contact: contacts) {
            if (contact.getName().toLowerCase().contains(name.toLowerCase())) {
                searchedContacts.add(contact);
            }
        }
        return searchedContacts;
    }

    private void checkEmpty() {
        if (contacts.isEmpty()) {
            throw new NoSuchElementException("No contacts stored.");
        }
    }

    private boolean checkDuplicate(Contact contact) {
        for (Contact existingContact : contacts) {
            if (existingContact.getEmail().contains(contact.getEmail()) || existingContact.getPhoneNumber().contains(contact.getPhoneNumber())) {
                return true;
            }
        }
        return false;
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}

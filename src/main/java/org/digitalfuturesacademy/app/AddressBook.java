package org.digitalfuturesacademy.app;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public AddressBook(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact contact) {
        Validator.validateContact(contact);
        this.contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        checkEmpty();
        Validator.validateContact(contact);
        this.contacts.remove(contact);
    }

    public void editContact(Contact oldcontact, Contact newcontact) {
        checkEmpty();
        Validator.validateContact(oldcontact);
        Validator.validateContact(newcontact);
        removeContact(oldcontact);
        addContact(newcontact);
    }

    private void checkEmpty() {
        if (contacts.isEmpty()) {
            throw new NoSuchElementException("No contacts stored.");
        }
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

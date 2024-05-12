package org.digitalfuturesacademy.app;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public AddressBook(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact contact) {
        // Implementation
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}

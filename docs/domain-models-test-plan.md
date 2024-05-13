# Domain Models, Class Diagrams and Test Plan
## Task 1 

### What are the benefits of the software to the client? 
 
### What are the benefits of the software to the end user? 
 
---

## Task 2 
### User stories, Domain models and test cases

As a user, I want to validate a new contact has fields of at least a name, phone number and email address, so that I can store contacts in the correct format.

| Requirement | Objects   | Properties                                                                    | Methods                                                                                                                                                                   |
|-------------|-----------|-------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1           | Validator |                                                                               | public static void validateContact(Contact contact) <br> private static void validateEmail(Contact contact) <br> private static void validatePhoneNumber(Contact contact) |
|             | Contact   | private String email <br> private String name <br> private String phoneNumber |                                                                                                                                                                           |

#### Test cases
1. Test that validateContact throws an exception when contacts with null, empty or incorrect values are passed
2. Test that validateContact throws an exception when null, empty or incorrect values are passed as phone numbers and emails

As a user, I want to be able to add a new contact with fields of at least a name, phone number and email address, so that I can store contact information in the address book.

| Requirement | Objects     | Properties                                                                    | Methods                                  |
|-------------|-------------|-------------------------------------------------------------------------------|------------------------------------------|
| 2           | AddressBook | private List<Contact\> contacts                                               | public void addContact(Contact contact)  |
|             | Contact     | private String email <br> private String name <br> private String phoneNumber |                                          |

#### Test cases
1. Test the contact constructor creates a contact object when given input
2. Test that addContact adds a contact to the contacts array

As a user, I want to be able to delete a contact from the address book, so that I can remove unnecessary or outdated information.

| Requirement | Objects     | Properties                                                                    | Messages                                   |
|-------------|-------------|-------------------------------------------------------------------------------|--------------------------------------------|
| 3           | AddressBook | private List<Contact\> contacts                                               | public void removeContact(Contact contact) |
|             | Contact     | private String email <br> private String name <br> private String phoneNumber |                                            |

#### Test cases
1. Test that removeContact removes a contact from the contacts array

As a user, I want to be able to edit an existing contact's information, so that I can update any changes or corrections.

| Requirement | Objects     | Properties                                                                    | Methods                                  | 
|-------------|-------------|-------------------------------------------------------------------------------|------------------------------------------|
| 4           | AddressBook | private List<Contact\> contacts                                               | public void editContact(Contact contact) | 
|             | Contact     | private String email <br> private String name <br> private String phoneNumber |                                          |       

#### Test cases
1. Test 

As a user, I want to be able to view a list of all my contacts, so that I can easily browse and find the contacts I need.

| Requirement | Objects     | Properties                                                                    | Messages                               | 
|-------------|-------------|-------------------------------------------------------------------------------|----------------------------------------|
| 5           | AddressBook | private List<Contact\> contacts                                               | public List<Contact\> getAllContacts() | 
|             | Contact     | private String email <br> private String name <br> private String phoneNumber |                                        |

As a user, I want to be able to search for a specific contact by name, phone number, or email address, so that I can quickly find the contact information I need.

| Requirement | Objects     | Properties                                                                    | Messages                                           |
|-------------|-------------|-------------------------------------------------------------------------------|----------------------------------------------------|
| 6           | AddressBook | private List<Contact\> contacts                                               | public List<Contact\> searchContacts(String query) |
|             | Contact     | private String email <br> private String name <br> private String phoneNumber |                                                    |

#### Test cases
1. T

As a user, I want to use a console interface to interact with the application, so that I can easily use the app.

| Requirement | Objects     | Properties | Messages |
|-------------|-------------|------------|----------|
| 7           | AddressBook |            |          |

---

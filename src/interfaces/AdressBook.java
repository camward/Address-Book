package interfaces;

import objects.Person;

public interface AdressBook {
    void add(Person person);
    void update(Person person);
    void delete(Person person);
}

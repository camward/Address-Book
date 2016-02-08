package interfaces.impl;

import interfaces.AdressBook;
import objects.Person;

import java.util.ArrayList;

public class CollectionAdressBook implements AdressBook {
    private ArrayList<Person> personList = new ArrayList<Person>();

    @Override
    public void add(Person person) {
        personList.add(person);
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {
        personList.remove(person);
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }
}

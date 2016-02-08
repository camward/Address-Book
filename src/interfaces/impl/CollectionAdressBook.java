package interfaces.impl;

import interfaces.AdressBook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import objects.Person;

public class CollectionAdressBook implements AdressBook {
    private ObservableList<Person> personList = FXCollections.observableArrayList();

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

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public void print(){
        int number = 0;
        System.out.println();
        for (Person person : personList) {
            number++;
            System.out.println(number+") fio - "+person.getFio()+"; phone - "+person.getPhone());
        }
    }

    public void fillTestData(){
        personList.add(new Person("Иван", "8-904-456-12-34"));
        personList.add(new Person("Наташа", "8-934-456-12-34"));
        personList.add(new Person("Максим", "8-904-454-12-34"));
        personList.add(new Person("Ирина", "8-904-456-34-34"));
        personList.add(new Person("Сергей", "8-904-342-12-34"));
        personList.add(new Person("Лена", "8-904-456-12-34"));
        personList.add(new Person("Андрей", "8-678-456-12-34"));
        personList.add(new Person("Настя", "8-904-456-78-34"));
        personList.add(new Person("Олег", "8-904-456-12-78"));
        personList.add(new Person("Света", "8-904-457-12-34"));
        personList.add(new Person("Дима", "8-904-456-89-34"));
        personList.add(new Person("Марина", "8-904-456-12-65"));
        personList.add(new Person("Илья", "8-904-453-12-34"));
        personList.add(new Person("Аня", "8-678-456-12-78"));
        personList.add(new Person("Катя", "8-904-887-67-34"));
    }
}

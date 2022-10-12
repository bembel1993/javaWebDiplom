package by.application.javaWeb.service;

import by.application.javaWeb.model.person.Person;

import java.util.List;

public interface PersonService {
    boolean addPerson(Person person);
    List<Person> showPeople();
    Person findPersonByName(String name);
}

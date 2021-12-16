package de.anna.aufgaben;

import de.anna.aufgaben.helper.DatenGenerator;
import de.anna.aufgaben.pojo.Person;

import java.util.List;

public class PersonByAlter {

    public static void main(String[] args) {

        DatenGenerator datenGenerator = new DatenGenerator();
        List<Person> people = datenGenerator.generatePersonen();
        Person aeltestePerson = filterAeltestePerson(people);
        System.out.println(aeltestePerson);
    }


    private static Person filterAeltestePerson(List<Person> personList) {

        Person person = new Person();

        int personZaehler = 0;

        for (Person iterPerson : personList) {

            personZaehler++;

            // zeby obiekt Person nie byl przy pierwszej iteracji null, ustawiam taki warunek
            if (personZaehler == 1) {
                person = iterPerson;
            }

            if (iterPerson.getAlter() > person.getAlter()) {
                person = iterPerson;
            }
        }

        return person;
    }
}

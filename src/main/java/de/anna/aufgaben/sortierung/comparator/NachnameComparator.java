package de.anna.aufgaben.sortierung.comparator;

import de.anna.aufgaben.pojo.Person;

import java.util.Comparator;

/**
 *
 */
public class NachnameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {


        String nachname1 = o1.getNachname();
        String nachname2 = o2.getNachname();

        return nachname1.compareTo(nachname2);
    }
}

package de.anna.aufgaben.sortierung.comparator;

import de.anna.aufgaben.pojo.Person;

import java.util.Comparator;


/**
 * Created by annpo on 18.05.2016.
 */
public class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {

        String name1 = o1.getName();
        String name2 = o2.getName();

        return name1.compareTo(name2);

    }
}

package de.anna.aufgaben.sortierung.comparator;

import de.anna.aufgaben.pojo.Person;

import java.util.Comparator;

/**
 * Created by annpo on 21.05.2016.
 */
public class NachnameUndNameComparator implements Comparator<Person> {


    private static final int ANZAHL = 100;

    private String nachnameUndNameZusammenfassen (String nachname, String name){

        int nachnameLength = nachname.length();
        int anzahlVonBuchstabeA = ANZAHL - nachnameLength;

        for(int i = 0; i < anzahlVonBuchstabeA; i++){
            nachname = nachname + anzahlVonBuchstabeA;
        }

        nachname = nachname + name;

        return nachname;
    }




    @Override
    public int compare(Person o1, Person o2) {

        String person1 = nachnameUndNameZusammenfassen(o1.getNachname(), o1.getName());
        String person2 = nachnameUndNameZusammenfassen(o2.getNachname(), o2.getName());

        return person1.compareTo(person2);
    }
}

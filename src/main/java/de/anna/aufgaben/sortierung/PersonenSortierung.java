package de.anna.aufgaben.sortierung;

import de.anna.aufgaben.helper.DatenGenerator;
import de.anna.aufgaben.pojo.Person;
import de.anna.aufgaben.pojo.enums.PersonSortierungsArt;
import de.anna.aufgaben.sortierung.comparator.NachnameComparator;
import de.anna.aufgaben.sortierung.comparator.NachnameUndNameComparator;
import de.anna.aufgaben.sortierung.comparator.NameComparator;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static de.anna.aufgaben.pojo.enums.PersonSortierungsArt.NACHNAME;
import static de.anna.aufgaben.pojo.enums.PersonSortierungsArt.NACHNAME_UND_NAME;
import static de.anna.aufgaben.pojo.enums.PersonSortierungsArt.NAME;

/**
 * Created by annpo on 18.05.2016.
 */
public class PersonenSortierung {


    public static void main(String[] args) {


        DatenGenerator datenGenerator = new DatenGenerator();
        List<Person> personList = datenGenerator.generatePersonen();

        PersonenSortierung personenSortierung = new PersonenSortierung();
        List<Person> sortiertePersonen = personenSortierung.sortierPersonenNach(personList, NAME);



    }


    private List<Person> sortierPersonenNach(List<Person> personList, PersonSortierungsArt sortierungsArt) {

        Comparator<Person> personComparator = PersonSortierungFabrik.getInstance(sortierungsArt);
        Collections.sort(personList, personComparator);

        return personList;
    }
}











// zamieniłam na PersonSortierungFabrik:



 /*

// zamieniłam na metodę: sortierPersonenNach:

    private List<Person> sortierungVonPersonenNachNachnameUndName(List<Person> personList) {

        Collections.sort(personList, new NachnameUndNameComparator());

        return personList;
    }


    private List<Person> sortierungVonPersonenNachNachname(List<Person> personList) {

        Collections.sort(personList, new NachnameComparator());

        return personList;
    }


    private List<Person> sortierungVonPersonenNachName(List<Person> personList) {

        Collections.sort(personList, new NameComparator());

        return personList;

    }
*/




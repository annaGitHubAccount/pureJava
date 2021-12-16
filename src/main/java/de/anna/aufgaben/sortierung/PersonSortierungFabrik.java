package de.anna.aufgaben.sortierung;

import de.anna.aufgaben.pojo.Person;
import de.anna.aufgaben.pojo.enums.PersonSortierungsArt;
import de.anna.aufgaben.sortierung.comparator.NachnameComparator;
import de.anna.aufgaben.sortierung.comparator.NachnameUndNameComparator;
import de.anna.aufgaben.sortierung.comparator.NameComparator;

import java.util.Comparator;


/**
 * Created by annpo on 21.05.2016.
 */
public final class PersonSortierungFabrik {


    private PersonSortierungFabrik() {

    }

    public static Comparator<Person> getInstance(PersonSortierungsArt personSortierungsArt) {

        if (personSortierungsArt.equals(PersonSortierungsArt.NACHNAME)) {
            return new NachnameComparator();

        } else if (personSortierungsArt.equals(PersonSortierungsArt.NAME)){
            return new NameComparator();

        }else if (personSortierungsArt.equals(PersonSortierungsArt.NACHNAME_UND_NAME)) {
            return new NachnameUndNameComparator();
        }

        throw new RuntimeException("Diese Sortierung ist nicht bedient.");
    }


}

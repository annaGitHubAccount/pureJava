package de.anna.aufgaben.daten.util;

import de.anna.aufgaben.pojo.Person;

import java.util.List;

/**
 * Created by annpo on 16.05.2016.
 */
public class PersonGrossGeschriebenUtils {

    public static List<Person> personGrossGeschrieben(List<Person> personList) {

        for(Person list : personList){

            String nameGrossGeschrieben = list.getName().toUpperCase();
            String nachnameGrossGeschrieben = list.getNachname().toUpperCase();

            list.setName(nameGrossGeschrieben);
            list.setNachname(nachnameGrossGeschrieben);
        }
        return personList;
    }




}

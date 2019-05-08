package de.anna.aufgaben.sortierung;

import de.anna.aufgaben.helper.DatenGenerator;
import de.anna.aufgaben.pojo.Adresse;
import de.anna.aufgaben.pojo.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by annpo on 24.05.2016.
 */
public class PersonenAuflisten {


    public static void main (String[] args){

        DatenGenerator datenGenerator = new DatenGenerator();
        List<Person> personList = datenGenerator.generatePersonen();

        PersonenAuflisten personenAuflisten = new PersonenAuflisten();
        Map<String, List<Person>> personenMitOrt = personenAuflisten.personMitOrtZeigen(personList);

    }



    private Map<String, List<Person>> personMitOrtZeigen(List<Person> personList) {


        Map<String, List<Person>> map = new TreeMap<>();

        for (Person person : personList) {

            List<Adresse> adresseList = person.getAdresseList();

            for (Adresse adresse : adresseList) {

                String ort = adresse.getOrt();

                if(map.get(ort) == null) {
                    map.put(ort, new ArrayList<Person>());
                }

                map.get(ort).add(person);
            }
        }
        return map;
    }

}

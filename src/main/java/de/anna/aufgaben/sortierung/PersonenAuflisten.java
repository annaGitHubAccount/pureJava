package de.anna.aufgaben.sortierung;

import de.anna.aufgaben.helper.DatenGenerator;
import de.anna.aufgaben.pojo.Adresse;
import de.anna.aufgaben.pojo.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Created by annpo on 24.05.2016.
 */
public class PersonenAuflisten {


    public static void main (String[] args){

        DatenGenerator datenGenerator = new DatenGenerator();
        List<Person> personList = datenGenerator.generatePersonen();

        PersonenAuflisten personenAuflisten = new PersonenAuflisten();
        Map<String, List<Person>> personenMitOrt = personenAuflisten.personMitOrtZeigenJava8(personList);

    }


    private Map<String, List<Person>> personMitOrtZeigenJava8(List<Person> personList) {

        return personList.stream().collect(Collectors.groupingBy(PersonenAuflisten::retrieveOerte));
    }

    private static String retrieveOerte(Person person) {
        return person.getAdresseList().stream().map(adresse -> adresse.getOrt()).collect(Collectors.joining(","));
    }


    private Map<String, List<Person>> personMitOrtZeigenJava7(List<Person> personList) {

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

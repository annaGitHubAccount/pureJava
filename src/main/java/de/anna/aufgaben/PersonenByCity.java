package de.anna.aufgaben;

import de.anna.aufgaben.helper.DatenGenerator;
import de.anna.aufgaben.pojo.Adresse;
import de.anna.aufgaben.pojo.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PersonenByCity {

    public static void main(String[] args) {

        DatenGenerator datenGenerator = new DatenGenerator();
        List<Person> personList = datenGenerator.generatePersonen();

        Map<String, List<Person>> cityMitPersonenList = suchAllePersonenPerCityAuf(personList);


    }


    private static Map<String, List<Person>> suchAllePersonenPerCityAuf(List<Person> personList) {

        Map<String, List<Person>> personenMitCityMap = new TreeMap<>();

        for (Person person : personList) {
            List<Adresse> adresseListVonPerson = person.getAdresseList();

            for (Adresse adresse : adresseListVonPerson) {
                String city = adresse.getOrt();

                if (personenMitCityMap.get(city) == null) {
                    List<Person> personListMitCity = new ArrayList<>();
                    personListMitCity.add(person);
                    personenMitCityMap.put(city, personListMitCity);
                } else {
                    List<Person> personListMitCity = personenMitCityMap.get(city);
                    personListMitCity.add(person);
                    personenMitCityMap.put(city, personListMitCity);
                }
            }
        }

        return personenMitCityMap;
    }
}

package de.anna.aufgaben;

import de.anna.aufgaben.helper.DatenGenerator;
import de.anna.aufgaben.pojo.Auto;
import de.anna.aufgaben.pojo.Person;
import de.anna.aufgaben.pojo.enums.AutoMarke;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AutoSelektor {


    public static void main(String[] args) {

        DatenGenerator datenGenerator = new DatenGenerator();
        List<Person> personList = datenGenerator.generatePersonen();

        List<Person> personenMitAutoMarke = suchPersonMitAutoMarke(personList, AutoMarke.AUDI);


    }


    private static List<Person> suchPersonMitAutoMarke(List<Person> personList, AutoMarke marke) {

        List<Person> personListMitAutomarke = new ArrayList<>();

        personList.forEach(person -> {

            List<Auto> autoList = person.getAutoList();

            Stream<Auto> autoStream = autoList.stream().filter(auto -> auto.getMarke().equals(marke)).limit(1);
            autoStream.forEach(auto -> personListMitAutomarke.add(person));
        });

        return personListMitAutomarke;
    }
}

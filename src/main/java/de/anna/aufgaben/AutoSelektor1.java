package de.anna.aufgaben;

import de.anna.aufgaben.helper.DatenGenerator;
import de.anna.aufgaben.pojo.Auto;
import de.anna.aufgaben.pojo.Person;
import de.anna.aufgaben.pojo.enums.AutoMarke;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class AutoSelektor1 {


    public static void main(String[] args) {

        DatenGenerator datenGenerator = new DatenGenerator();
        List<Person> personList = datenGenerator.generatePersonen();

        List<Person> personenMitAutoMarke = suchPersonMitAutoMarkeJava8(personList, AutoMarke.AUDI);

        Map<AutoMarke, List<Person>> suchePersonenMitAutoMarken = suchePersonenMitAutoMarken(personList);
        System.out.println(suchePersonenMitAutoMarken);


    }

    private static Map<AutoMarke, List<Person>> suchePersonenMitAutoMarken(List<Person> personList) {

        Map<AutoMarke, List<Person>> personListMitAutomarkenMap = new TreeMap<>();

        AutoMarke[] autoMarkeEnum = AutoMarke.values();

        for(AutoMarke autoMarke : autoMarkeEnum){

            for(Person person : personList){

                if(pruefeObPersonAutoMarkeEnumHat(person, autoMarke)){

                    putToMap(autoMarke, personListMitAutomarkenMap, person);
                }
            }
        }
        return personListMitAutomarkenMap;
    }


    private static boolean pruefeObPersonAutoMarkeEnumHat(Person person, AutoMarke autoMarke) {

        List<Auto> autoListEinerPerson = person.getAutoList();

        for(Auto autoEierPerson : autoListEinerPerson){

            if(autoEierPerson.getMarke().equals(autoMarke)){
                return true;
            }
        }
        return false;
    }


    private static void putToMap(AutoMarke autoMarke, Map<AutoMarke, List<Person>> personListMitAutomarkenMap, Person person){

        if(personListMitAutomarkenMap.get(autoMarke) == null){
            personListMitAutomarkenMap.put(autoMarke, new ArrayList<>());

        }else {
            List<Person> personListMitAutoMarke = personListMitAutomarkenMap.get(autoMarke);
            personListMitAutoMarke.add(person);
            personListMitAutomarkenMap.put(autoMarke, personListMitAutoMarke);
        }

    }

    private static List<Person> suchPersonMitAutoMarkeJava8(List<Person> personList, AutoMarke marke) {

        List<Person> personListMitAutomarke = new ArrayList<>();

        personList.forEach(person -> {

            List<Auto> autoList = person.getAutoList();

            Stream<Auto> autoStream = autoList.stream().filter(auto -> auto.getMarke().equals(marke)).limit(1);
            autoStream.forEach(auto -> personListMitAutomarke.add(person));
        });

        return personListMitAutomarke;
    }
}

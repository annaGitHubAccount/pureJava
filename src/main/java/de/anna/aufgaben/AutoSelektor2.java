package de.anna.aufgaben;

import de.anna.aufgaben.helper.DatenGenerator;
import de.anna.aufgaben.pojo.Auto;
import de.anna.aufgaben.pojo.Person;
import de.anna.aufgaben.pojo.enums.AutoMarke;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AutoSelektor2 {

    public static void main(String[] args) {

        DatenGenerator datenGenerator = new DatenGenerator();
        List<Person> personList = datenGenerator.generatePersonen();

        Map<AutoMarke, Integer> autoMarkeIntegerMap = gibZahlVonPersonenMitAutoMarkenInMap(personList);
        System.out.println(autoMarkeIntegerMap);
    }


    private static Map<AutoMarke, Integer> gibZahlVonPersonenMitAutoMarkenInMap(List<Person> personList) {

        Map<AutoMarke, Integer> personZahlMitAutomarkenMap = new TreeMap<>();

        AutoMarke[] autoMarkeEnum = AutoMarke.values();

        for(AutoMarke autoMarke : autoMarkeEnum){

            for(Person person : personList){

                if(pruefeObPersonAutoMarkeEnumHat(person, autoMarke)){

                    putToMap(autoMarke, personZahlMitAutomarkenMap);
                }
            }
        }
        return personZahlMitAutomarkenMap;
    }


    private static boolean pruefeObPersonAutoMarkeEnumHat(Person person, AutoMarke autoMarke) {

        List<Auto> autoListEinerPerson = person.getAutoList();

        return autoListEinerPerson.stream()
                .anyMatch(auto -> auto.getMarke().equals(autoMarke));

        /*for(Auto autoEinerPerson : autoListEinerPerson){

            if(autoEinerPerson.getMarke().equals(autoMarke)){
                return true;
            }
        }
        return false;*/
    }


    private static void putToMap(AutoMarke autoMarke, Map<AutoMarke, Integer> personZahlMitAutomarkenMap){

        if(personZahlMitAutomarkenMap.get(autoMarke) == null){
            personZahlMitAutomarkenMap.put(autoMarke, 0);

        }else {
            Integer personZahlMitAutoMarke = personZahlMitAutomarkenMap.get(autoMarke);
            personZahlMitAutoMarke++;
            personZahlMitAutomarkenMap.put(autoMarke, personZahlMitAutoMarke);
        }

    }
}

package de.anna.aufgaben;

import de.anna.aufgaben.helper.DatenGenerator;
import de.anna.aufgaben.pojo.Person;
import de.anna.aufgaben.pojo.enums.AutoMarke;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonenAufBuchstabe {

    public static void main(String[] args) {

        DatenGenerator datenGenerator = new DatenGenerator();
        List<Person> generatePersonen = datenGenerator.generatePersonen();

        Map<Character, List<Person>> stringListMap = holeMapVonPersonenAufBuchstabe(generatePersonen);

        List<Person> personList = suchPersonAufBuchstabeJava8(generatePersonen, "P");

        List<Person> personListMitAutoMarkeJava8 = suchPersonMitAutoMarkeJava8(generatePersonen, AutoMarke.BMW);

    }

    private static List<Person> suchPersonMitAutoMarkeJava8(List<Person> personList, AutoMarke autoMarke) {

        return personList.stream().filter(person -> prüfeObPersonAutoMarkeBesitzt(person, autoMarke)).collect(Collectors.toList());
    }


    private static boolean prüfeObPersonAutoMarkeBesitzt(Person person, AutoMarke autoMarke){

        return person.getAutoList().stream().anyMatch(auto -> auto.getMarke().equals(autoMarke));
    }


    private static List<Person> suchPersonAufBuchstabeJava8(List<Person> personList, String buchstabe) {

        return personList.stream().filter(person -> person.getNachname().startsWith(buchstabe)).collect(Collectors.toList());
    }


    private static Map<Character, List<Person>> holeMapVonPersonenAufBuchstabe(List<Person> personList) {

        return personList.stream().collect(Collectors.groupingBy(PersonenAufBuchstabe::holeErsterBuchstabeVonNachnamen));

        // albo przez lambde:
        //  return personList.stream().collect(Collectors.groupingBy(person -> person.getNachname().charAt(0)));
    }

    private static Character holeErsterBuchstabeVonNachnamen(Person person) {
        return person.getNachname().charAt(0);
    }

}

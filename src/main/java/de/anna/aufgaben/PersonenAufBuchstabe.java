package de.anna.aufgaben;

import de.anna.aufgaben.helper.DatenGenerator;
import de.anna.aufgaben.pojo.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonenAufBuchstabe {

    public static void main(String[] args) {

        DatenGenerator datenGenerator = new DatenGenerator();
        List<Person> generatePersonen = datenGenerator.generatePersonen();

        Map<Character, List<Person>> stringListMap = holeMapVonPersonenAufBuchstabe(generatePersonen);


    }



    private static Map<Character, List<Person>> holeMapVonPersonenAufBuchstabe(List<Person> personList) {

        //  return personList.stream().collect(Collectors.groupingBy(person -> person.getNachname().substring(0, 1)));

        return personList.stream().collect(Collectors.groupingBy(PersonenAufBuchstabe::holeErsterBuchstabeVonNachnamen));
    }

    private static Character holeErsterBuchstabeVonNachnamen(Person person){
        return person.getNachname().charAt(0);
    }

}

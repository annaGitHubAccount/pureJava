package de.anna.aufgaben;

import de.anna.aufgaben.helper.DatenGenerator;
import de.anna.aufgaben.pojo.Auto;
import de.anna.aufgaben.pojo.Person;
import de.anna.aufgaben.pojo.PersonZeile;
import de.anna.aufgaben.pojo.enums.AutoMarke;

import java.util.ArrayList;
import java.util.List;

public class PersonZeileMain {


    public static final String WIEDERHOLUNG = "--||--";


    public static void main(String[] args) {

        DatenGenerator datenGenerator = new DatenGenerator();
        List<Person> generatePersonen = datenGenerator.generatePersonen();

        List<PersonZeile> holeListVonPersonZeile = holeListVonPersonZeileMitWiedeholung(generatePersonen);
    }


    private static List<PersonZeile> holeListVonPersonZeileMitWiedeholung(List<Person> generatePersonen) {

        List<PersonZeile> personZeileList = new ArrayList<>();


        String vorherigesPesel = "";
        String vorherigeMarke = "";

        for (Person person : generatePersonen) {

            String name = person.getName();
            String nachname = person.getNachname();
            List<Auto> autoList = person.getAutoList();
            String pesel = person.getPesel();

            for (Auto auto : autoList) {

                AutoMarke marke = auto.getMarke();
                List<String> versicherungsFirmaList = auto.getVersicherungsFirma();

                for (String versicherungsFirma : versicherungsFirmaList) {

                    if (vorherigesPesel.equals(pesel) && vorherigeMarke.equals(marke.toString())) {
                        PersonZeile personZeile = new PersonZeile(WIEDERHOLUNG, WIEDERHOLUNG, WIEDERHOLUNG, WIEDERHOLUNG, versicherungsFirma);
                        personZeileList.add(personZeile);

                    } else if (vorherigesPesel.equals(pesel) && !vorherigeMarke.equals(marke.toString())) {
                        PersonZeile personZeile = new PersonZeile(WIEDERHOLUNG, WIEDERHOLUNG, WIEDERHOLUNG, marke.toString(), versicherungsFirma);
                        personZeileList.add(personZeile);

                    } else if (!pesel.equals(vorherigesPesel)) {
                        PersonZeile personZeile = new PersonZeile(pesel, name, nachname, marke.toString(), versicherungsFirma);
                        personZeileList.add(personZeile);

                        vorherigesPesel = pesel;
                        vorherigeMarke = marke.toString();
                    }
                }
            }
        }

        return personZeileList;
    }
}

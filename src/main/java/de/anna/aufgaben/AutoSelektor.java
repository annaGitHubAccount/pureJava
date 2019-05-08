package de.anna.aufgaben;

import de.anna.aufgaben.helper.DatenGenerator;
import de.anna.aufgaben.pojo.Auto;
import de.anna.aufgaben.pojo.Person;
import de.anna.aufgaben.pojo.enums.AutoMarke;

import java.util.ArrayList;
import java.util.List;

public class AutoSelektor {


    public static void main(String[] args) {

        DatenGenerator datenGenerator = new DatenGenerator();
        List<Person> personList = datenGenerator.generatePersonen();

        List<Person> personenMitAutoMarke = zeigePersonMitAutoMarkeAn(personList, AutoMarke.AUDI);


    }


    private static List<Person> zeigePersonMitAutoMarkeAn(List<Person> personList, AutoMarke marke) {

        List<Person> personListMitAutomarke = new ArrayList<>();

        for(Person person : personList){

            List<Auto> autoList = person.getAutoList();

            autoList.stream().forEach(
                    (auto) -> {
                        AutoMarke autoMarke = auto.getMarke();

                        if(autoMarke.equals(marke)){
                            personListMitAutomarke.add(person);
                        }
                    }
                    );

            /*

            for(Auto auto : autoList){
                AutoMarke autoMarke = auto.getMarke();

                if(autoMarke.equals(marke)){
                    personListMitAutomarke.add(person);
                }

            }
            */

        }


        return personListMitAutomarke;
    }
}

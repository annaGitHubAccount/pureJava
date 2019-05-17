package de.anna.aufgaben;

import de.anna.aufgaben.helper.DatenGenerator;
import de.anna.aufgaben.pojo.Auto;
import de.anna.aufgaben.pojo.Person;
import de.anna.aufgaben.pojo.enums.AutoMarke;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AutoMarkeZussammenzaehlen {

    public static void main(String[] args) {

        DatenGenerator datenGenerator = new DatenGenerator();
        List<Person> generatePersonen = datenGenerator.generatePersonen();

        TreeMap<String, Integer> autoMarkeZussammenzaehlen = autoMarkeZussammenzaehlen(generatePersonen);


    }

    private static TreeMap<String, Integer> autoMarkeZussammenzaehlen(List<Person> personList) {

        TreeMap<String, Integer> autoMarkegezaehlt = new TreeMap<>();

        for(Person person : personList){
            List<Auto> autoList = person.getAutoList();
            for(Auto auto : autoList){
                AutoMarke marke = auto.getMarke();

                //if(autoMarkegezaehlt.get(marke.toString()) == null)
                autoMarkegezaehlt.putIfAbsent(marke.toString(), 0);

                Integer anzahlVonAutomarke = autoMarkegezaehlt.get(marke.toString());
                anzahlVonAutomarke ++;

                autoMarkegezaehlt.put(marke.toString(), anzahlVonAutomarke);
            }
        }

        return autoMarkegezaehlt;
    }
}

package de.anna.aufgaben;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CityAufBuchstabeZeigen {


    public static void main(String[] args) {

        String cities = "Hamburg, Frankfurt, Fürth, Boston, Bombaj";
        HashMap<String, List<String>> cityAufBuchstabeAuflisten = cityAufBuchstabeAuflisten(cities);

    }

    private static HashMap<String, List<String>> cityAufBuchstabeAuflisten(String cities){

        HashMap<String, List<String>> citiesMap = new HashMap<>();

        String[] citiesArray = cities.split(",");

        List<String> citiesList = Arrays.asList(citiesArray);


        for(String city : citiesList) {

            String cityTrim = city.trim();

            String ersterBuchstabeVonCityKey = cityTrim.substring(0, 1);

            List<String> cityListValue = citiesMap.get(ersterBuchstabeVonCityKey);

            if(cityListValue != null){
                cityListValue.add(cityTrim);
            }else {
                List<String> newCityListValue = new ArrayList<>();
                newCityListValue.add(cityTrim);
                citiesMap.put(ersterBuchstabeVonCityKey, newCityListValue);
            }
        }

        return citiesMap;
    }
}

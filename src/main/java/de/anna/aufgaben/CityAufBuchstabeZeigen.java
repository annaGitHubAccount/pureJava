package de.anna.aufgaben;

import de.anna.aufgaben.daten.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CityAufBuchstabeZeigen {


    public static void main(String[] args) {

        String cities = "Hamburg, Frankfurt, Fürth, Boston, Bombaj";
        String leeresText = "";

         try {
             HashMap<String, List<String>> cityAufBuchstabeAuflisten = cityAufBuchstabeAuflisten(null);
         } catch (RuntimeException e){
             System.out.println(e + ": Es gibt solche Städte nicht !");
         }



    }

    private static HashMap<String, List<String>> cityAufBuchstabeAuflisten(String cities) {

        if(StringUtils.isEmpty(cities)){
            throw new RuntimeException();
        }

        HashMap<String, List<String>> citiesMap = new HashMap<>();

        String[] citiesSplitted = cities.split(",");

        for(String city : citiesSplitted){

            String cityTrim = city.trim();

            String ersterBuchstabeKey = cityTrim.substring(0, 1);

            List<String> citiesListValue = citiesMap.get(ersterBuchstabeKey);

            if(citiesListValue != null){

                citiesListValue.add(cityTrim);
                citiesMap.put(ersterBuchstabeKey, citiesListValue);
            }else {

                List<String> newCityList = new ArrayList<>();
                newCityList.add(cityTrim);
                citiesMap.put(ersterBuchstabeKey, newCityList);
            }
        }

        return citiesMap;
    }
}

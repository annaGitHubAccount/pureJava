package de.anna.aufgaben;

import de.anna.aufgaben.daten.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CollectCityByLetter {

    public Map<String, List<String>> citiesByLetter(String cities) {

        Map<String, List<String>> citiesMap = new TreeMap<>();

        if(StringUtils.isEmpty(cities)) {
            return citiesMap;
        }

        String[] citiesSplit = cities.split(",");

        for(String city : citiesSplit) {

            String cityTrim = city.trim();
            String firstLetterCityUpperCase = StringUtils.firstLetterUpperCase(cityTrim);
            String firstLetterOfCityMapKey = firstLetterCityUpperCase.substring(0, 1);

            citiesMap.putIfAbsent(firstLetterOfCityMapKey, new ArrayList<>());
            List<String> citiesFromMapValue = citiesMap.get(firstLetterOfCityMapKey);
            citiesFromMapValue.add(cityTrim);

           /* if(citiesFromMapValue == null) {
               List<String> citiesList = new ArrayList<>();
               citiesList.add(cityTrim);
               citiesMap.put(firstLetterOfCityMapKey,citiesList);
            } else {
                citiesFromMapValue.add(cityTrim);
            }*/
        }
        return citiesMap;
    }
}

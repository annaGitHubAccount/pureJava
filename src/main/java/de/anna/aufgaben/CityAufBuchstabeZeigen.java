package de.anna.aufgaben;

import de.anna.aufgaben.daten.util.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class CityAufBuchstabeZeigen {


    public static void main(String[] args) {

        String cities = "Hamburg, Frankfurt, Fürth, Boston, Bombaj";
        String leeresText = "";

        try {
            Map<String, List<String>> cityAufBuchstabeAuflisten = cityAufBuchstabeAuflistenJava8(cities);
            mapAuflisten(cityAufBuchstabeAuflisten);

        } catch (RuntimeException e) {
            System.out.println("Es gibt solche Städte nicht !");
        }
    }

    private static Map<String, List<String>> cityAufBuchstabeAuflistenJava8(String cities) {

        if (StringUtils.isEmpty(cities)) {
            throw new RuntimeException();
        }

        String[] citiesSplitted = cities.split(",");

        return Arrays.stream(citiesSplitted).collect(Collectors.groupingBy(city -> city.trim().substring(0, 1)));
    }



    private static void mapAuflisten(Map<String, List<String>> cityMap){

        StringBuffer stringBuffer = new StringBuffer();

        for (Map.Entry<String, List<String>> entry : cityMap.entrySet()) {

            String ersterBuchstabeKey = entry.getKey();
            List<String> citiesListValue = entry.getValue();

            stringBuffer.append(ersterBuchstabeKey).append(" - ");

            int index = 1;
            int citiesListValueSize = citiesListValue.size();
            for(String city : citiesListValue){

                stringBuffer.append(city);

                if(index < citiesListValueSize) {
                    stringBuffer.append(", ");
                }
                index ++;
            }

            stringBuffer.append("\n");
        }
        String strBufferToString = stringBuffer.toString();
        System.out.println(strBufferToString);
    }


    private static HashMap<String, List<String>> cityAufBuchstabeAuflisten(String cities) {

        if (StringUtils.isEmpty(cities)) {
            throw new RuntimeException();
        }

        HashMap<String, List<String>> citiesMap = new HashMap<>();

        String[] citiesSplitted = cities.split(",");

        for (String city : citiesSplitted) {

            String cityTrim = city.trim();

            String ersterBuchstabeKey = cityTrim.substring(0, 1);

            List<String> citiesListValue = citiesMap.get(ersterBuchstabeKey);

            if (citiesListValue != null) {

                citiesListValue.add(cityTrim);
                citiesMap.put(ersterBuchstabeKey, citiesListValue);
            } else {

                List<String> newCityList = new ArrayList<>();
                newCityList.add(cityTrim);
                citiesMap.put(ersterBuchstabeKey, newCityList);
            }
        }

        return citiesMap;
    }
}

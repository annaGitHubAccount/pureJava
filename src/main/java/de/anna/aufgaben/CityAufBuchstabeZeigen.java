package de.anna.aufgaben;

import de.anna.aufgaben.daten.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class CityAufBuchstabeZeigen {


    public static void main(String[] args) {

        String cities = "Hamburg, Frankfurt, Fürth, Boston, Bombaj";
        String leeresText = "";

        try {
            Map<String, List<String>> cityAufBuchstabeAuflisten = cityAufBuchstabeAuflistenJava8(cities);
            mapAnzeigenJava8(cityAufBuchstabeAuflisten);

        } catch (RuntimeException e) {
            System.out.println("Es gibt solche Städte nicht !");
        }
    }

    private static Map<String, List<String>> cityAufBuchstabeAuflistenJava8(String cities) {

        if (StringUtils.isEmpty(cities)) {
            throw new RuntimeException();
        }

        String[] citiesSplitted = cities.split(",");

        // groupingBy zwraca mape !!!
        return Arrays.stream(citiesSplitted).collect(Collectors.groupingBy(city -> city.trim().substring(0, 1)));
    }


    private static void mapAnzeigenJava8(Map<String, List<String>> cityMap) {

        cityMap.forEach((ersterBuchstabe, citiesList) -> {

            List<String> meineArrayList = new ArrayList<String>(citiesList) {

                @Override
                public String toString() {

                    Iterator<String> iterator = iterator();
                    if (! iterator.hasNext())
                        return "[]";

                    StringBuilder sb = new StringBuilder();
                    sb.append('<');

                    while(iterator.hasNext()){
                        String next = iterator.next();

                        if(next.equals("Hamburg")){
                            String nextToUpperCase = next.toUpperCase();
                            sb.append(nextToUpperCase);
                        }else {
                            sb.append(next);
                        }

                        if(iterator.hasNext()) {
                            sb.append(',');
                        }
                    }
                    sb.append('>');

                    return sb.toString();
                }
            };

            System.out.println((ersterBuchstabe + " - " + meineArrayList));
        });

    }


    private static void mapAnzeigen(Map<String, List<String>> cityMap) {

        StringBuffer stringBuffer = new StringBuffer();

        for (Map.Entry<String, List<String>> entry : cityMap.entrySet()) {

            String ersterBuchstabeKey = entry.getKey();
            List<String> citiesListValue = entry.getValue();

            stringBuffer.append(ersterBuchstabeKey).append(" - ");

            int index = 1;
            int citiesListValueSize = citiesListValue.size();
            for (String city : citiesListValue) {

                stringBuffer.append(city);

                if (index < citiesListValueSize) {
                    stringBuffer.append(", ");
                }
                index++;
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
            } else {

                List<String> newCityList = new ArrayList<>();
                newCityList.add(cityTrim);
                citiesMap.put(ersterBuchstabeKey, newCityList);
            }
        }

        return citiesMap;
    }
}

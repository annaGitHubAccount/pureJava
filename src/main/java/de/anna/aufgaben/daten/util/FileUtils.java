package de.anna.aufgaben.daten.util;

import de.anna.aufgaben.helper.WortData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FileUtils {


    public static String readFile(Path path) {

        StringBuilder stringBuilder = new StringBuilder();

        try {
            Files.lines(path).forEach(str -> stringBuilder.append(str).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }


    public static Map<String, Integer> woerterImTextZusammenZaehlen(String text) {

        Map<String, Integer> map = new TreeMap<>();

        String[] textSplitted = text.split("\\s+");

        for (String word : textSplitted) {

            if (word.length() < 3) {
                continue;
            }

            word = filternDenText(word);

            if (map.get(word) == null) {
                map.put(word, 1);
            } else {
                Integer anzahlEinesWortes = map.get(word);
                anzahlEinesWortes++;
                map.put(word, anzahlEinesWortes);
            }
        }

        return map;
    }


    public static String filternDenText(String word) {

        return word.toLowerCase().
                replace("\"", "").
                replace(",", "").
                replace(".", "").
                replace("'", "").
                replace(":", "");

    }


    public static List<WortData> mapToListVonWortData(Map<String, Integer> map){

        //klasa pomocnicza do zmiany mapy na liste
        List<WortData> wortDataList = new ArrayList<>();

        Set<String> setVonWords = map.keySet();

        for(String word : setVonWords) {

            Integer anzahlVonWord = map.get(word);
            WortData wortData = new WortData(word, anzahlVonWord);
            wortDataList.add(wortData);
        }

        return wortDataList;
    }



    public static List<WortData> wortDataListSortPerAnzahl(List<WortData> wortDataList){

        Comparator<WortData> wortDataComparator = (wortData1, wortData2) -> {

            return wortData1.getAnzahl().compareTo(wortData2.getAnzahl());
        };

        wortDataList.sort(wortDataComparator.reversed());

       return wortDataList;
    }

}

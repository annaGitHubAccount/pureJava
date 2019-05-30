package de.anna.aufgaben.daten.util;


import de.anna.aufgaben.helper.WortData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FileUtils {


    private static final String EMPTY_STRING = "";

    public static String readFile(Path path) {

        StringBuilder stringBuilder = new StringBuilder();

        try {
            Files.lines(path).forEach(str -> stringBuilder.append(str).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }


    public static Map<String, Integer> woerterImTextZusammenZaehlen(String textVomFile) {

        Map<String, Integer> map = new TreeMap<>();

        //   \\s - to jest whitespace; \\s+ - to jest wiecej whitespace niz 1
        String[] textSplitted = textVomFile.split("\\s+");

        for (String word : textSplitted) {

            if (word.length() < 3) {
                continue;
            }

            word = filternDenText(word, "\"", ",", ".", "'", ":");

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

    // String... signsVonText - argumenty dopisuje do metody dynamicznie, ile chce
    public static String filternDenText(String word, String... signsVonText) {

        for (String sign : signsVonText) {
            word = word.toLowerCase().replace(sign, EMPTY_STRING);
        }

        return word;
    }


    public static List<WortData> mapToListVonWortData(Map<String, Integer> map) {

        //klasa pomocnicza do zmiany mapy na liste
        List<WortData> wortDataList = new ArrayList<>();

        Set<String> setVonWords = map.keySet();

        for (String word : setVonWords) {

            Integer anzahlVonWord = map.get(word);
            WortData wortData = new WortData(word, anzahlVonWord);
            wortDataList.add(wortData);
        }

        return wortDataList;
    }


    public static List<WortData> wortDataListSortPerAnzahl(List<WortData> wortDataList) {

        Comparator<WortData> wortDataComparator = (wortData1, wortData2) -> {

            return wortData1.getAnzahl().compareTo(wortData2.getAnzahl());
        };

        wortDataList.sort(wortDataComparator.reversed());

        return wortDataList;
    }



    public static Map<Integer, List<String>> createNewMapForFileStatistics(Map<String, Integer> woerterImTextZusammenZaehlen){

        // sortowanie mapy w odwrotnej kolejnosci
        Map<Integer, List<String>> newMap = new TreeMap<>(Comparator.reverseOrder());

        Set<String> wordsSetOfKeys = woerterImTextZusammenZaehlen.keySet();

        for(String word : wordsSetOfKeys){

            Integer anzahlVonWords = woerterImTextZusammenZaehlen.get(word);


            if(newMap.get(anzahlVonWords) == null) {

                List<String> wordsList = new ArrayList<>();
                wordsList.add(word);
                newMap.put(anzahlVonWords, wordsList);

            }else {

                List<String> wordsList = newMap.get(anzahlVonWords);
                wordsList.add(word);
            }
        }

        return newMap;
    }



}

package de.anna.aufgaben;

import de.anna.aufgaben.helper.WortData;
import de.anna.commons.file.FileUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileTextStatisticsMain {

    private static final int MAP_LIMIT = 2;
    private static final String SEPARATOR = "-------------------------------------";
    private static final String ABSATZ = "              ";
    private static final String EMPTY_STRING = "";


    public static void main(String[] args) throws IOException {

        Path tempPath = Paths.get("d:\\Workspace\\temp\\beispiel.txt");

        // showOnScreenWithWordData(retrieveFileWordStatisticWithWordData(tempPath));

        Map<Integer, List<String>> integerListOfStringMap = retrieveFileWordStatisticWithMap(tempPath);

        showOnScreenWithMap(integerListOfStringMap, MAP_LIMIT);
    }


    private static void showOnScreenWithMap(Map<Integer, List<String>> integerListOfStringMap, int mapLimit) {

        Set<Integer> anzahlSetOfKeys = integerListOfStringMap.keySet();

        int zaehler = 0;

        for (Integer anzahl : anzahlSetOfKeys) {

            if (zaehler == mapLimit) {
                break;
            }

            System.out.println(SEPARATOR);
            System.out.println(anzahl);

            List<String> listOfWords = integerListOfStringMap.get(anzahl);

            for (String word : listOfWords) {
                System.out.println(ABSATZ + word);
            }
            zaehler++;
        }

    }


    private static void showOnScreenWithWordData(List<WortData> retrieveFileWordStatistic) {

        retrieveFileWordStatistic.forEach(System.out::println);

    }


    private static List<WortData> retrieveFileWordStatisticWithWordData(Path tempPath) throws IOException {

        String inhaltEinesFiles = FileUtils.readFile(tempPath);

        Map<String, Integer> woerterImTextZusammenZaehlen = woerterImTextZusammenZaehlen(inhaltEinesFiles);

        List<WortData> wortDataList = mapToListVonWortData(woerterImTextZusammenZaehlen);

        return wortDataListSortPerAnzahl(wortDataList);

    }

    private static Map<Integer, List<String>> retrieveFileWordStatisticWithMap(Path tempPath) throws IOException {

        String inhaltEinesFiles = FileUtils.readFile(tempPath);

        Map<String, Integer> woerterImTextZusammenZaehlen = woerterImTextZusammenZaehlen(inhaltEinesFiles);

        return createNewMapForFileStatistics(woerterImTextZusammenZaehlen);

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

    // String... signsVonText - argumenty dopisuje do metody dynamicznie, ile chce. To jest jak tablica.
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


    public static Map<Integer, List<String>> createNewMapForFileStatistics(Map<String, Integer> woerterImTextZusammenZaehlen) {

        // sortowanie mapy w odwrotnej kolejnosci
        Map<Integer, List<String>> newMap = new TreeMap<>(Comparator.reverseOrder());

        Set<String> wordsSetOfKeys = woerterImTextZusammenZaehlen.keySet();

        for (String word : wordsSetOfKeys) {

            Integer anzahlVonWords = woerterImTextZusammenZaehlen.get(word);


            if (newMap.get(anzahlVonWords) == null) {

                List<String> wordsList = new ArrayList<>();
                wordsList.add(word);
                newMap.put(anzahlVonWords, wordsList);

            } else {

                List<String> wordsList = newMap.get(anzahlVonWords);
                wordsList.add(word);
            }
        }

        return newMap;
    }


}

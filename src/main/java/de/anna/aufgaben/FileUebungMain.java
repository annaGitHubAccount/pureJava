package de.anna.aufgaben;

import de.anna.aufgaben.daten.util.FileUtils;
import de.anna.aufgaben.helper.WortData;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileUebungMain {

    private static final int MAP_LIMIT = 2;
    private static final String SEPARATOR = "-------------------------------------";
    private static final String ABSATZ = "              ";

    public static void main(String[] args) {

        Path tempPath = Paths.get("d:\\Workspace\\temp\\beispiel.txt");

        //FileUtils.showOnScreenWithWordData(retrieveFileWordStatisticWithWordData(tempPath));

        Map<Integer, List<String>> integerListOfStringMap = retrieveFileWordStatisticWithMap(tempPath);

        showOnScreenWithMap(integerListOfStringMap, MAP_LIMIT);
    }






    private static void showOnScreenWithMap(Map<Integer, List<String>> integerListOfStringMap, int mapLimit){

        Set<Integer> anzahlSetOfKeys = integerListOfStringMap.keySet();

        int zaehler = 0;

        for(Integer anzahl : anzahlSetOfKeys) {

            if(zaehler == mapLimit){
                break;
            }

            System.out.println(SEPARATOR);
            System.out.println(anzahl);

            List<String> listOfWords = integerListOfStringMap.get(anzahl);

            for(String word : listOfWords){
                System.out.println(ABSATZ + word);
            }
            zaehler++;
        }

    }


    private static void showOnScreenWithWordData(List<WortData> retrieveFileWordStatistic) {

        retrieveFileWordStatistic.forEach(System.out::println);

    }



    private static List<WortData> retrieveFileWordStatisticWithWordData(Path tempPath) {

        String inhaltEinesFiles = FileUtils.readFile(tempPath);

        Map<String, Integer> woerterImTextZusammenZaehlen = FileUtils.woerterImTextZusammenZaehlen(inhaltEinesFiles);

        List<WortData> wortDataList = FileUtils.mapToListVonWortData(woerterImTextZusammenZaehlen);

        return FileUtils.wortDataListSortPerAnzahl(wortDataList);

    }

    private static Map<Integer, List<String>> retrieveFileWordStatisticWithMap(Path tempPath) {

        String inhaltEinesFiles = FileUtils.readFile(tempPath);

        Map<String, Integer> woerterImTextZusammenZaehlen = FileUtils.woerterImTextZusammenZaehlen(inhaltEinesFiles);

        return FileUtils.createNewMapForFileStatistics(woerterImTextZusammenZaehlen);

    }


}

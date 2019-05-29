package de.anna.aufgaben;

import de.anna.aufgaben.daten.util.FileUtils;
import de.anna.aufgaben.helper.WortData;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class FileUebungMain {

    public static void main(String[] args) {

        Path tempPath = Paths.get("d:\\Workspace\\temp\\beispiel.txt");

        showOnScreen(retrieveFileWordStatistic(tempPath));


    }

    private static void showOnScreen(List<WortData> retrieveFileWordStatistic) {

        retrieveFileWordStatistic.forEach(System.out::println);

    }


    private static List<WortData> retrieveFileWordStatistic(Path tempPath) {

        String inhaltEinesFiles = FileUtils.readFile(tempPath);

        Map<String, Integer> woerterImTextZusammenZaehlen = FileUtils.woerterImTextZusammenZaehlen(inhaltEinesFiles);

        List<WortData> wortDataList = FileUtils.mapToListVonWortData(woerterImTextZusammenZaehlen);

        return FileUtils.wortDataListSortPerAnzahl(wortDataList);
    }


}

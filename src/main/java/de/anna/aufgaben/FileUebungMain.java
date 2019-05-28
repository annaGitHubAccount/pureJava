package de.anna.aufgaben;

import de.anna.aufgaben.daten.util.FileUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class FileUebungMain {

    public static void main(String[] args) {

        Path tempPath = Paths.get("d:\\Workspace\\temp\\beispiel.txt");
        Map<String, Integer> woerterImTextZusammenZaehlen = countWords(tempPath);




    }



    private static Map<String, Integer> countWords(Path tempPath) {

        String inhaltEinesFiles = FileUtils.readFile(tempPath);
        return FileUtils.woerterImTextZusammenZaehlen(inhaltEinesFiles);
    }
}

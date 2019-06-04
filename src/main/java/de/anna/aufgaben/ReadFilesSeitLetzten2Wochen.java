package de.anna.aufgaben;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


// File reprezentuje plik albo katalog. Jak chce zbadac co jest czym to uzywam metod z File
//File tempPath = new File("D:\\Workspace\\temp");

public class ReadFilesSeitLetzten2Wochen {


    public static void main(String[] args) {

        Path tempPath = Paths.get("d:\\Workspace\\temp");
        Instant instantMinus14Days = Instant.now().minus(14, ChronoUnit.DAYS);

        List<Path> datenBis2WochenZurueckliefern = datenBis2WochenZurueckliefern(tempPath, instantMinus14Days);

        datenBis2WochenZurueckliefern.forEach(filePath -> {
            Path fileName = filePath.getFileName();
            String toString = fileName.toString();
            System.out.println(toString);
        });


    }


    private static List<Path> datenBis2WochenZurueckliefern(Path filesPath, Instant timeInDays) {

        List<Path> pathListWithDatum = new ArrayList<>();

        try {
            List<Path> pathList = Files.list(filesPath).collect(Collectors.toList());

            for (Path path : pathList) {

                Instant lastModifiedInstant = Files.getLastModifiedTime(path).toInstant();
                if (lastModifiedInstant.isAfter(timeInDays)) {
                    pathListWithDatum.add(path);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return pathListWithDatum;
    }


    private static List<Path> datenBis2WochenZurueckliefernJava8(Path filesPath, Instant timeInDays) throws IOException {

        Stream<Path> pathStream = Files.list(filesPath);

        return pathStream.filter(path -> {
                return pathPredicate(path, timeInDays);
        }).collect(Collectors.toList());
    }


    private static boolean pathPredicate(Path path, Instant timeInDays) {
        try {
            Instant lastModifiedInstant = Files.getLastModifiedTime(path).toInstant();
            if (lastModifiedInstant.isAfter(timeInDays)) {
                return true;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}

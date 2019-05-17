package de.anna.aufgaben;

import java.util.*;

public class IDSearcher {


    public static void main(String[] args) {

        String fehlerText = "MetadataStore:item/{680FF9B6-7401-4E82-AF88-90B96E6D28D2},MetadataStore:item/{AE7A33F9-5762-408A-BF09-71547963C757},MetadataStore:item/{080FF9B6-7401-4E82-AF88-90B96E6D2876}";
        List<String> listVonDokumentIDs = findeDokumentID(fehlerText);
        System.out.println(listVonDokumentIDs);

        String text = "[klucz1, wartosc1][klucz2, wartosc2][klucz3, wartosc3]";
        Map<String, String> findeMapVomText = findeMapVomText(text);
        System.out.println(findeMapVomText);

        String text2 = "[1,2,(3)][1,2][1],[1,(2),3,4]";
        List<List<String>> listeVonZifferOhneEinfacheKlammer = findeListeVonZifferOhneEinfacheKlammer(text2);
        System.out.println(listeVonZifferOhneEinfacheKlammer);

    }


    private static List<String> findeDokumentID(String fehlerText) {

        List<String> listMitDokumentID = new ArrayList<>();

        int startIndexOfKlammer = 0;
        int endIndexOfKlammer = 0;
        String dokumentID;

        while (true) {

            startIndexOfKlammer = fehlerText.indexOf("{", endIndexOfKlammer);
            endIndexOfKlammer = fehlerText.indexOf("}", startIndexOfKlammer);

            if (startIndexOfKlammer == -1 || endIndexOfKlammer == -1) {
                break;
            }

            dokumentID = fehlerText.substring(startIndexOfKlammer, endIndexOfKlammer + 1);
            listMitDokumentID.add(dokumentID);
        }
        return listMitDokumentID;
    }


    private static Map<String, String> findeMapVomText(String text) {

        Map<String, String> stringMap = new TreeMap<>();

        int startIndexOfKlammer = 0;
        int endIndexOfKlammer = 0;

        while (true) {

            startIndexOfKlammer = text.indexOf("[", endIndexOfKlammer);
            endIndexOfKlammer = text.indexOf("]", startIndexOfKlammer);

            if (startIndexOfKlammer == -1 || endIndexOfKlammer == -1) {
                break;
            }

            String keyValueString = text.substring(startIndexOfKlammer, endIndexOfKlammer + 1);
            String[] keyValueStringGesplitted = keyValueString.split(",");
            String key = keyValueStringGesplitted[0];
            String value = keyValueStringGesplitted[1];
            stringMap.put(key, value);
        }
        return stringMap;
    }


    private static List<List<String>> findeListeVonZifferOhneEinfacheKlammer(String text) {

        List<List<String>> zifferList = new ArrayList<>();

        int startIndexOfKlammer = 0;
        int endIndexOfKlammer = 0;

        while (true) {

            startIndexOfKlammer = text.indexOf("[", endIndexOfKlammer);
            endIndexOfKlammer = text.indexOf("]", startIndexOfKlammer);

            if (startIndexOfKlammer == -1 || endIndexOfKlammer == -1) {
                break;
            }


            String ziffernInEckigenKlammar = text.substring(startIndexOfKlammer, endIndexOfKlammer + 1);
            String[] ziffernInEckigenKlammarSplittet = ziffernInEckigenKlammar.split(",");


            List<String> ziffernInEckigenKlammarList = new ArrayList<>();

            for (String ziffer : ziffernInEckigenKlammarSplittet) {

                if (!ziffer.startsWith("(") && !ziffer.endsWith(")")) {
                    ziffernInEckigenKlammarList.add(ziffer);
                }

            }

            zifferList.add(ziffernInEckigenKlammarList);
        }


        return zifferList;
    }
}

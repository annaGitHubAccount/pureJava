package de.anna.aufgaben;

import de.anna.aufgaben.daten.util.StringUtils;

import java.util.*;

public class AufgabenAufText1 {


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

        String text3 = "<key1, value1><key2, value2><key3, value3><key4, value4><key5, value5>";
        Map<String, String> findeMapInText2 = parseMapInTextMitEckigenKlammern(text3);
        System.out.println(findeMapInText2);

        int charakterInString = StringUtils.zaehleCharakterInString("Alabama", 'a');
        System.out.println(charakterInString);

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


    private static Map<String, String> parseMapInTextMitEckigenKlammern(String text) {

        validieren(text);

        Map<String, String> map = new TreeMap<>();

        String[] textSplitted = text.split("<");

        for (String textString : textSplitted) {

            if (textString.equals("")) {
                continue;
            }

            int strLength = textString.length() - 1;
            String strOhneKlammer = textString.substring(0, strLength);
            String[] keyValueString = strOhneKlammer.split(",");
            String key = keyValueString[0];
            String value = keyValueString[1].trim();
            map.put(key, value);
        }

        return map;
    }

    private static void validieren(String text) {

        if(text == null || text.equals("")){
            throw new RuntimeException("Ihr Text ist leer !");
        }

        int anzahlVonLinksKlammer = StringUtils.zaehleCharakterInString(text, '<');
        int anzahlVonRechtsKlammer = StringUtils.zaehleCharakterInString(text, '>');

        if (anzahlVonLinksKlammer != anzahlVonRechtsKlammer){
            throw new RuntimeException("Anzahl von Klammer unterscheidet sich !");
        }

    }


}





package de.anna.aufgaben.daten.util;

public class StringUtils {

    public static boolean isEmpty(String text) {

        return text == null || text.trim().equals("");

    }


    public static int zaehleCharakterInString(String string, char zeichen) {

        char[] stringToCharArray = string.toCharArray();

        int anzahl = 0;
        for (char zeichenInScheife : stringToCharArray) {

            if (zeichenInScheife == zeichen) {
                anzahl++;
            }
        }
        return anzahl;
    }


    public static String firstLetterUpperCase(String text) {

        if(text == null) {
            return "";
        }

        String firstLetter = text.substring(0, 1);
        String restOfText = text.substring(1);

        return firstLetter.toUpperCase() + restOfText;
    }
}

package de.anna.aufgaben.daten.util;

public class StringUtils {

    public static boolean isEmpty(String text) {

        return text == null || text.equals("");

    }


    public static String ersterBuchstabeGrossSchreiben(String string){

        String ersterBuchstabe = string.substring(0, 1);
        String rest = string.substring(1);
        String ersterBuchstabeToUpperCase = ersterBuchstabe.toUpperCase();

        return ersterBuchstabeToUpperCase + rest;
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
}

package de.anna.aufgaben;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AufgabenAufText2 {


    public static void main(String[] args) {



        String regex = entferneTextImKlammernRegex("aa(bb)cc(dd)ee(ff)gg(hh)");
        System.out.println("Regex: " +  regex);



    }


    public static String entferneTextImKlammernRegex(String text) {

        // Pattern: 1. nawias ')' 2. litery 3. nawias '('
        Pattern pattern = Pattern.compile("(\\))(\\w+)(\\()");
        Matcher matcher = pattern.matcher(text);

        StringBuilder stringBuilder = new StringBuilder();

        int indexOfStartKlammer = text.indexOf("(");
        String substringVorErstenKlammern = text.substring(0, indexOfStartKlammer);
        stringBuilder.append(substringVorErstenKlammern);

        while (matcher.find()) {
            stringBuilder.append(matcher.group(2));
        }

        int indexOfEndKlammer = text.lastIndexOf(")");
        String substringBisEndeString = text.substring(indexOfEndKlammer +1);
        stringBuilder.append(substringBisEndeString);


        return stringBuilder.toString();
    }


    public static String entferneTextImKlammern(String text) {

        StringBuffer stringBuffer = new StringBuffer();

        int indexOfStartKlammer = 0;

        indexOfStartKlammer = text.indexOf("(");
        String substringVorErstenKlammern = text.substring(0, indexOfStartKlammer);
        stringBuffer.append(substringVorErstenKlammern);

        while (true) {

            int indexOfEndKlammer = text.indexOf(")", indexOfStartKlammer);
            indexOfStartKlammer = text.indexOf("(", indexOfStartKlammer + 1);

            if (indexOfStartKlammer == -1 || indexOfEndKlammer == -1) {
                String substringBisEndeString = text.substring(indexOfEndKlammer + 1);
                stringBuffer.append(substringBisEndeString);
                break;
            }

            String substringZwischenKlammern = text.substring(indexOfEndKlammer + 1, indexOfStartKlammer);
            stringBuffer.append(substringZwischenKlammern);
        }

        return stringBuffer.toString();
    }
}
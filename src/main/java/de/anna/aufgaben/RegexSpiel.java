package de.anna.aufgaben;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSpiel {

    public static void main(String[] args) {
        //String str = "aa((bb))cc((dd))ee((ff))gg";


        find();

    }

    private static void replaceAll() {
        String example = "yfdghbxfghcjhdfcgjdfcg   .";
        String pattern = "(\\w)(\\s+)([\\.,])";
        System.out.println(example.replaceAll(pattern, "$1$3"));
    }


    private static void find() {

        String stringToSearch = "aaa(bbb)ccc(ddd)eee";

        //Pattern pattern = Pattern.compile("(\\()(\\w+)(\\))");
        Pattern pattern = Pattern.compile("(\\()(\\w+)(\\))");
        Matcher matcher = pattern.matcher(stringToSearch);

        StringBuffer stringBuffer = new StringBuffer();

        while(matcher.find()) {
            stringBuffer.append(matcher.group(2));
        }

        System.out.println(stringBuffer);
    }
}

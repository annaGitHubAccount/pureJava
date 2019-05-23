package de.anna.aufgaben;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSpiel {

    public static void main(String[] args) {
        //String str = "aa((bb))cc((dd))ee((ff))gg";


        find1();

    }

    private static void ex1() {
        String example = "yfdghbxfghcjhdfcgjdfcg   .";
        String pattern = "(\\w)(\\s+)([\\.,])";
        System.out.println(example.replaceAll(pattern, "$1$3"));
    }


    private static void find1() {

        String stringToSearch = "aaa(bbb)ccc(ddd)eee";

        Pattern p = Pattern.compile("(\\()(\\w+)(\\))");
        Matcher m = p.matcher(stringToSearch);

        StringBuffer theGroup = new StringBuffer();

        while(m.find()) {
            theGroup.append(m.group(2));
        }

        System.out.println(theGroup);
    }
}

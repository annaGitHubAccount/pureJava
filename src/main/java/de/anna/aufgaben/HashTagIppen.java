package de.anna.aufgaben;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HashTagIppen {

    public static String sanitizeHashTagVonZoltan(String hashTag) {

        // z.B. hashTag = "tag one" Pattern.compile("(#?)([a-zA-Z0-9_]+)") prüft zuerst "tag" -> "#tag"
        // und dann prüft "one" -> "#one". Am Ende verbinden sie mit ","
        Pattern pattern = Pattern.compile("(#?)([a-zA-Z0-9_]+)");
        Matcher matcher = pattern.matcher(hashTag);
        Set<String> hashTagSet = new LinkedHashSet<>();

        while (matcher.find()) {
            hashTagSet.add("#" + matcher.group(2));
        }
        return StringUtils.join(hashTagSet, ",");
    }

    public static String sanitizeHashTagVonAnna(String hashTag) {
        String hashTagStr = hashTag
                .replaceAll("(^|\\s)(#[a-zA-Z0-9]*)\\s([^#][a-zA-Z0-9]*)", "$2_$3")
                .replaceAll("(^|\\s)([^#][a-zA-Z0-9]*)_([^#][a-zA-Z0-9]*)", "#$2_$3");

        String noDuplicateInHashTag = removeDuplicatesFromHashTag(hashTagStr);

        String hashTagStrResult = noDuplicateInHashTag
                .replaceAll("(^|\\s)(#[a-zA-Z0-9]*[^,])\\s(#[a-zA-Z0-9]*)", "$2,$3")
                .replaceAll("(^|\\s)([^#][a-zA-Z0-9]*)\\s([^#][a-zA-Z0-9]*)", "#$2,#$3");
        return hashTagStrResult.replaceAll(", ", ",").trim();
    }

    private static String removeDuplicatesFromHashTag(String hashTagStr) {
        String hashTagWithHash = null;
        StringBuilder stringBuilder = new StringBuilder();
        String[] hashTagsArray = hashTagStr.split("\\s");
        Set<String> hashTagSet = new LinkedHashSet<>(Arrays.asList(hashTagsArray));
        for (String hashTag : hashTagSet) {
            if (!hashTag.startsWith("#")) {
                hashTagWithHash = "#" + hashTag;
                stringBuilder.append(hashTagWithHash).append(" ").toString();
            } else {
                stringBuilder.append(hashTag).append(" ").toString();
            }
        }
        return stringBuilder.toString().trim();
    }
}

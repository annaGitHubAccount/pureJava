package de.anna.aufgaben;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BuchstabeZusammenzaehlen {

    public static void main(String[] args) {

        System.out.println("Geben Sie einen Satz ein: ");
        Scanner scanner = new Scanner(System.in);
        String satz = scanner.nextLine();
        String satzToUpperCase = satz.toUpperCase();
        char[] satzToCharArray = satzToUpperCase.toCharArray();
        Map<Character, Integer> anzahlVonBuchstabenAusgeben = anzahlVonBuchstabenAusgeben(satzToCharArray);


    }


    private static Map<Character, Integer> anzahlVonBuchstabenAusgeben(char[] buchstabenArray) {

        Map<Character, Integer> mapVonBuchstaben = new TreeMap<>();

        for(char buchstabe : buchstabenArray){

            if(buchstabe == ' '){
                continue;
            }

            mapVonBuchstaben.putIfAbsent(buchstabe, 0);
            Integer anzahlEinerBuchstabe = mapVonBuchstaben.get(buchstabe);
            anzahlEinerBuchstabe ++;
            mapVonBuchstaben.put(buchstabe, anzahlEinerBuchstabe);

        }


        return mapVonBuchstaben;
    }
}

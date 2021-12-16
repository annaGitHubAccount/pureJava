package de.anna.aufgaben;

import java.util.*;

public class WoerterAuflisten {


    public static void main(String[] args) {

        List<String> namenAuflisten = namenAuflistenASCOderDESC();
        System.out.println(namenAuflisten);
    }



    private static List<String> namenAuflistenASCOderDESC(){

        List<String> namenList = new ArrayList<>();

        String asc = "ASC";
        String desc = "DESC";

        while(true) {

            System.out.println("Gebe einen Namen ein: ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();

            if(name.equals(asc)){
                Collections.sort(namenList);
                break;
            }


            if(name.equals(desc)){
                // Collections.sort(namenList, Comparator.reverseOrder());
                namenList.sort(Comparator.reverseOrder());
                break;
            }


            namenList.add(name);
        }

        return namenList;

    }
}

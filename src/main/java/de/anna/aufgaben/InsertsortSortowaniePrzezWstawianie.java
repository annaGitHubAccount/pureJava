package de.anna.aufgaben;


// https://javabeginners.de/Algorithmen/Sortieralgorithmen/Insertsort.php

import java.util.Arrays;
import java.util.List;

public class InsertsortSortowaniePrzezWstawianie {


    public static void main(String[] args) {

        InsertsortSortowaniePrzezWstawianie insertsortSortowaniePrzezWstawianie = new InsertsortSortowaniePrzezWstawianie();

        int[] intArr = {16, 23, 14, 7, 21, 20, 6, 1, 17, 13, 12, 9, 3, 19};
        int[] insertSort = insertsortSortowaniePrzezWstawianie.insertSort(intArr);

        Arrays.stream(insertSort).forEach(System.out::println);
    }




    private int[] insertSort(int[] intArr) {

        int k;

        // dla kazdego indexu "i" beda kazdorazowo sprawdzane wszystkie liczby przy pomocy indexu "j" od tylu.
        // po kazdym sprawdzeniu idex "i" przesuwa sie do przodu i dana liczba jest przesuwana na nowe miejsce
        for (int i = 0; i < intArr.length; i++) {

            for (int j = intArr.length - 1; j > 0; j--) {

                // jesli poprzednia liczba jest wieksza od nastepnej to
                if (intArr[j - 1] > intArr[j]) {

                    // zamien liczby miejscami przy pomocy zmiennej pomocniczej k:
                    k = intArr[j];
                    intArr[j] = intArr[j - 1];
                    intArr[j - 1] = k;
                }
            }
        }
        return intArr;
    }

}

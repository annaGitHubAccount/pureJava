package de.anna.aufgaben;


/*Fakultät - silnia

Was ist Rekursion?
Unter Rekursion versteht man in der Programmierung ein Verfahren, bei dem sich eine Methode selbst aufruft, sodass,
ähnlich einer Endlosschleife, ein potentiell unendlicher Programmablauf entsteht.
Setzt man die Abbruchbedingung korrekt, so kann durch Rekursion ein und der selbe Algorithmus auf oft recht elegant Weise mehrfach wiederholt werden.

https://javabeginners.de/Grundlagen/Rekursion.php
 */

public class RekursionUndFakultaet {


    public static void main(String[] args) {

        RekursionUndFakultaet rekursionUndFakultaet = new RekursionUndFakultaet();

        int fakultaetRekursive = rekursionUndFakultaet.fakultaetRekursive(3);

        // Die o.a. Berechnung der Fakultät kann auch iterativ gelöst werden:
        int fakultaetIterativ = rekursionUndFakultaet.fakultaetIterativ(5);
    }



    private int fakultaetRekursive(int n){
        if (n == 1){
            return 1;
        } else {
            return n * fakultaetRekursive(n-1);
        }
    }

    private int fakultaetIterativ(int n) {
        int i = 1;
        int result = 1;
        while(i<n) {
            result *= (++i);
        }
        return result;
    }
}

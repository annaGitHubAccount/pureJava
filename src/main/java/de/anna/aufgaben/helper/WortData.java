package de.anna.aufgaben.helper;

import java.util.Comparator;

public class WortData {

    String wort;
    Integer anzahl;

    public WortData(String wort, Integer anzahl) {
        this.wort = wort;
        this.anzahl = anzahl;
    }

    public String getWort() {
        return wort;
    }

    public void setWort(String wort) {
        this.wort = wort;
    }

    public Integer getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(Integer anzahl) {
        this.anzahl = anzahl;
    }

    @Override
    public String toString() {

        return "Ein Word: " + "\"" + wort + "\"" + " tritt " + anzahl + "-mal auf";
    }
}

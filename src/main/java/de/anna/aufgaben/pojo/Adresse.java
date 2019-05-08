package de.anna.aufgaben.pojo;

/**
 * Created by annpo on 16.05.2016.
 */


public class Adresse {

    private String strasse;
    private int hausNummer;
    private String ort;


    public Adresse(String strasse, int hausNummer, String ort){

        this.strasse = strasse;
        this.hausNummer = hausNummer;
        this.ort = ort;
    }


    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getHausNummer() {
        return hausNummer;
    }

    public void setHausNummer(int hausNummer) {
        this.hausNummer = hausNummer;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    @Override
    public String toString() {
        return strasse + " " + hausNummer + " in " + ort;
    }
}

package de.anna.aufgaben.pojo;

import java.util.List;

import de.anna.aufgaben.pojo.enums.AutoMarke;

/**
 * Created by annpo on 17.05.2016.
 */
public class Auto {

    private AutoMarke marke;
    private String kennzeichen;
    private int baujahr;
    private List<String> versicherungsFirmaList;

    public Auto(AutoMarke marke, String kennzeichen, int baujahr, List<String> versicherungsFirmaList){

        this.marke = marke;
        this.kennzeichen = kennzeichen;
        this.baujahr = baujahr;
        this.versicherungsFirmaList = versicherungsFirmaList;
    }

    public List<String> getVersicherungsFirma() {
		return versicherungsFirmaList;
	}

	public void setVersicherungsFirma(List<String> versicherungsFirma) {
		this.versicherungsFirmaList = versicherungsFirma;
	}

	public AutoMarke getMarke() {
        return marke;
    }

    public void setMarke(AutoMarke marke) {
        this.marke = marke;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }
}

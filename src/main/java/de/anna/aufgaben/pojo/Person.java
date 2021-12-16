package de.anna.aufgaben.pojo;

import de.anna.aufgaben.pojo.enums.PersonSortierungsArt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Person {

    private String name;
    private String nachname;
    private Integer alter;
    private Date geburtsDatum;
    private List<Adresse> adresseList = new ArrayList<>();
    private List<Auto> autoList = new ArrayList<>();
    private String pesel;



    public Person(String pesel, String name, String nachname, Integer alter){
        this.name = name;
        this.nachname = nachname;
        this.alter = alter;
        this.pesel = pesel;
    }

    public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Integer getAlter() {
        return alter;
    }

    public void setAlter(Integer alter) {
        this.alter = alter;
    }

    public List<Adresse> getAdresseList() {
        return adresseList;
    }

    public void setAdresseList(List<Adresse> adresseList) {
        this.adresseList = adresseList;
    }

    public List<Auto> getAutoList() {
        return autoList;
    }

    public void setAutoList(List<Auto> autoList) {
        this.autoList = autoList;
    }

    public Date getGeburtsDatum() {
        return geburtsDatum;
    }

    public void setGeburtsDatum(Date geburtsDatum) {
        this.geburtsDatum = geburtsDatum;
    }



    @Override
    public String toString() {
        return name + " " + nachname + " " + alter;
    }


}
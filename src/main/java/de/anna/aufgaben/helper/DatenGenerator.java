package de.anna.aufgaben.helper;

import de.anna.aufgaben.daten.util.DateUtils;
import de.anna.aufgaben.pojo.Adresse;
import de.anna.aufgaben.pojo.Auto;
import de.anna.aufgaben.pojo.enums.AutoMarke;
import de.anna.aufgaben.pojo.Person;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by robert on 21.03.16.
 */
public class DatenGenerator {
	
	private List <String> versicherungsListe1 = new ArrayList<>();
	private List <String> versicherungsListe2 = new ArrayList<>();
	private List <String> versicherungsListe3 = new ArrayList<>();
	
	public DatenGenerator() {
		
		versicherungsListe1.add("PZU");
		
		versicherungsListe2.add("Warta");
		versicherungsListe2.add("PZU");
		
		versicherungsListe3.add("Hestia");
		versicherungsListe3.add("PZU");
		versicherungsListe3.add("Warta");
		}
	

    public List<Person> generatePersonen(){
    	
    	

        List<Person> personList = new ArrayList<>();

        personList.add(createPerson1());
        personList.add(createPerson2());
        personList.add(createPerson3());
        personList.add(createPerson4());
        personList.add(createPerson5());
        personList.add(createPerson6());
        personList.add(createPerson7());

        return personList;
    }





    private void fuegeAutoinListeHinzu(List<Auto> autoList, AutoMarke marke, String kennzeichen, int baujahr, List<String> versicherungsFirmaList){

        Auto auto = new Auto(marke, kennzeichen, baujahr, versicherungsFirmaList);
        
        autoList.add(auto);

    }


    private void fuegeAdresseinListeHinzu(List<Adresse> adresseList, String strasse, int hausNummer, String ort){

        Adresse adresse = new Adresse(strasse, hausNummer, ort);
        adresseList.add(adresse);
    }




    private Person createPerson1(){

        Person person = new Person("12345", "Anna", "Polanska", 37);

        List<Adresse> adresseList = new ArrayList<>();
        fuegeAdresseinListeHinzu(adresseList, "AAA", 78, "Nurnberg");
        person.setAdresseList(adresseList);

        List<Auto> autoList = new ArrayList<>();
        fuegeAutoinListeHinzu(autoList, AutoMarke.AUDI, "1234", 2000, versicherungsListe1);
        fuegeAutoinListeHinzu(autoList, AutoMarke.BMW, "3456", 1999, versicherungsListe2);
        person.setAutoList(autoList);

        Date geburtsDatum = DateUtils.createDate(1979, 10, 22);
        person.setGeburtsDatum(geburtsDatum);

        return person;
    }


    private Person createPerson2(){

        Person person = new Person("345566", "Robert", "Polanski", 39);

        List<Adresse> adresseList = new ArrayList<>();
        fuegeAdresseinListeHinzu(adresseList, "BBB", 65, "Nurnberg");
        fuegeAdresseinListeHinzu(adresseList, "CCC", 90, "Furth");
        person.setAdresseList(adresseList);

        List<Auto> autoList = new ArrayList<>();
        fuegeAutoinListeHinzu(autoList, AutoMarke.OPEL, "6789", 2015, versicherungsListe3);
        fuegeAutoinListeHinzu(autoList, AutoMarke.BMW, "8765", 2000, versicherungsListe1);
        person.setAutoList(autoList);

        Date geburtsDatum = DateUtils.createDate(1977, 3, 14);
        person.setGeburtsDatum(geburtsDatum);

        return person;
    }

    private Person createPerson3(){

        Person person = new Person("556677", "Adam", "Polanski", 6);

        List<Adresse> adresseList = new ArrayList<>();
        fuegeAdresseinListeHinzu(adresseList, "FFF", 87, "Nurnberg");
        person.setAdresseList(adresseList);

        List<Auto> autoList = new ArrayList<>();
        fuegeAutoinListeHinzu(autoList, AutoMarke.OPEL, "0987", 2000, versicherungsListe2);
        person.setAutoList(autoList);

        Date geburtsDatum = DateUtils.createDate(2010, 7, 27);
        person.setGeburtsDatum(geburtsDatum);

        return person;
    }

    private Person createPerson4(){

        Person person = new Person("344556", "Kasia", "Kowalska", 41);

        List<Adresse> adresseList = new ArrayList<>();
        fuegeAdresseinListeHinzu(adresseList,"GGG", 43, "Wroclaw");
        person.setAdresseList(adresseList);

        List<Auto> autoList = new ArrayList<>();
        fuegeAutoinListeHinzu(autoList, AutoMarke.AUDI, "7654", 2010, versicherungsListe3);
        person.setAutoList(autoList);

        Date geburtsDatum = DateUtils.createDate(1975, 4, 4);
        person.setGeburtsDatum(geburtsDatum);


        return person;
    }

    private Person createPerson5(){

        Person person = new Person("3475566", "Kuba", "Wojewodzki", 36);

        List<Adresse> adresseList = new ArrayList<>();
        fuegeAdresseinListeHinzu(adresseList, "HHH", 90, "Bialystok");
        fuegeAdresseinListeHinzu(adresseList, "III", 78, "Radom");
        person.setAdresseList(adresseList);

        List<Auto> autoList = new ArrayList<>();
        fuegeAutoinListeHinzu(autoList, AutoMarke.OPEL, "2345", 2010, versicherungsListe1);
        fuegeAutoinListeHinzu(autoList, AutoMarke.NISSAN, "2378", 1987, versicherungsListe2);
        person.setAutoList(autoList);

        Date geburtsDatum = DateUtils.createDate(1980, 5, 25);
        person.setGeburtsDatum(geburtsDatum);


        return person;
    }

    private Person createPerson6(){

        Person person = new Person("44565377", "Anna", "Kwiatkowska", 34);

        List<Adresse> adresseList = new ArrayList<>();
        fuegeAdresseinListeHinzu(adresseList, "JJJ", 54, "Poznan");
        person.setAdresseList(adresseList);

        List<Auto> autoList = new ArrayList<>();
        fuegeAutoinListeHinzu(autoList, AutoMarke.NISSAN, "7654", 2004, versicherungsListe3);
        person.setAutoList(autoList);

        Date geburtsDatum = DateUtils.createDate(1982, 11, 5);
        person.setGeburtsDatum(geburtsDatum);

        return person;
    }


    private Person createPerson7(){

        Person person = new Person("44560977", "Zosia", "Przybylska", 4);

        List<Adresse> adresseList = new ArrayList<>();
        fuegeAdresseinListeHinzu(adresseList, "KKK", 87, "Gdansk");
        fuegeAdresseinListeHinzu(adresseList, "LLL", 90, "Warszawa");
        fuegeAdresseinListeHinzu(adresseList, "MMM", 34, "Bialystok");
        person.setAdresseList(adresseList);

        List<Auto> autoList = new ArrayList<>();
        fuegeAutoinListeHinzu(autoList, AutoMarke.AUDI, "7654", 2008, versicherungsListe1);
        person.setAutoList(autoList);

        Date geburtsDatum = DateUtils.createDate(2012, 1, 20);
        person.setGeburtsDatum(geburtsDatum);

        return person;
    }

}

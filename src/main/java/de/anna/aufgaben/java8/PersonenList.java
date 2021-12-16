package de.anna.aufgaben.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.anna.aufgaben.helper.DatenGenerator;
import de.anna.aufgaben.pojo.Person;

public class PersonenList {

	
	public static void main(String[] args) {

        DatenGenerator datenGenerator = new DatenGenerator();
        List<Person> personenList = datenGenerator.generatePersonen();
        
        List<String> holeNachnamenVonPersonenJava7 = holeNachnamenVonPersonenJava7(personenList);
        System.out.println("Java7: " + holeNachnamenVonPersonenJava7);
        
        List<String> holeNachnamenVonPersonenJava8 = holeNachnamenVonPersonenJava8(personenList);
        System.out.println("Java8: " + holeNachnamenVonPersonenJava8);
        
        double holeDurschnittVonPersonenAlterJava7 = holeDurschnittVonPersonenAlterJava7(personenList);
        System.out.println("Java7: " + holeDurschnittVonPersonenAlterJava7);
        
        double holeDurschnittVonPersonenAlterJava8 = holeDurschnittVonPersonenAlterJava8(personenList);
        System.out.println("Java8: " + holeDurschnittVonPersonenAlterJava8);
        
        
        
        
	}

	
	private static double holeDurschnittVonPersonenAlterJava7 (List<Person> personList) {

		int summeVonAlter = 0;

		for (Person person : personList) {

			Integer alter = person.getAlter();
			summeVonAlter = summeVonAlter + alter;
		}

		double durchnittlichesAlter = summeVonAlter / personList.size();

		return durchnittlichesAlter;
	}
	
	
	private static double holeDurschnittVonPersonenAlterJava8 (List<Person> personList) {
		
		Double durschnitt = personList.stream().
				map(person -> person.getAlter()).
				collect(Collectors.averagingDouble(person -> person));
		
		return durschnitt;
	}
	
	
	private static List<String> holeNachnamenVonPersonenJava7(List<Person> personenList){
		
		List<String> listVonNachnamen = new ArrayList<>();
		
		for(Person person : personenList) {
			
			String nachname = person.getNachname();
			listVonNachnamen.add(nachname);
		}
		
		return listVonNachnamen;
		
	}
	
	
	private static List<String> holeNachnamenVonPersonenJava8(List<Person> personenList){
		
		Stream<Person> stream = personenList.stream();
		Stream<String> map = stream.map(person -> person.getNachname());
		List<String> listVonNachnamen = map.collect(Collectors.toList());
		
		return listVonNachnamen;
		
	}
	
	
	
	
}




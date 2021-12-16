package de.anna.aufgaben;


import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CollectCityByLetterTest {

    private final Map<String, List<String>> emptyCitiesMap = new TreeMap<>();

    @Test
    public void shouldCollectCitiesByFirstLetter() {
        //Given
        String cities = "Hamburg, Frankfurt, Fürth, Boston, Bombaj";
        CollectCityByLetter collectCityByLetter = new CollectCityByLetter();

        //When
        Map<String, List<String>> citiesMap = collectCityByLetter.citiesByLetter(cities);

        //Then
        Assert.assertEquals(3, citiesMap.size());
        List<String> citiesH = citiesMap.get("H");
        Assert.assertEquals(1,citiesH.size());
        List<String> citiesF = citiesMap.get("F");
        Assert.assertEquals(2,citiesF.size());
        List<String> citiesB = citiesMap.get("B");
        Assert.assertEquals(2,citiesB.size());
    }

    @Test
    public void shouldReturnEmptyMapWhenGivenEmptyString() {
        //Given
        String cities = " ";
        CollectCityByLetter collectCityByLetter = new CollectCityByLetter();

        //When
        Map<String, List<String>> citiesMap = collectCityByLetter.citiesByLetter(cities);

        //Then
        Assert.assertEquals(emptyCitiesMap, citiesMap);
    }

    @Test
    public void shouldReturnEmptyMapWhenGivenNull() {
        //Given
        CollectCityByLetter collectCityByLetter = new CollectCityByLetter();

        //When
        Map<String, List<String>> citiesMap = collectCityByLetter.citiesByLetter(null);

        //Then
        Assert.assertEquals(emptyCitiesMap, citiesMap);
    }
}

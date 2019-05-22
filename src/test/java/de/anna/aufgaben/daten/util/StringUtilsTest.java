package de.anna.aufgaben.daten.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {



    @Test
    public void ersterBuchstabeGrossSchreibenTest(){

        String string = "hamburg";
        String grossSchreiben = StringUtils.ersterBuchstabeGrossSchreiben(string);
        Assert.assertEquals("Hamburg", grossSchreiben);


    }
}

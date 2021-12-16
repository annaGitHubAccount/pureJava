package de.anna.aufgaben.daten.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {



    @Test
    public void shouldReturnStringWithCapitalLetter(){

        String string = "hamburg";
        String strWithCapitalLetter = StringUtils.firstLetterUpperCase(string);

        Assert.assertEquals("Hamburg", strWithCapitalLetter);
    }

    @Test
    public void shouldReturnEmptyStringWhenStringNull(){

        String strWithCapitalLetter = StringUtils.firstLetterUpperCase(null);

        Assert.assertEquals("", strWithCapitalLetter);
    }
}

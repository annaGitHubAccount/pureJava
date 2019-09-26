package de.anna.jdbc.util;

import de.anna.jdbc.exercise.MyPostgreSQLDatabaseConnection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfiguration {

    // obiekt Properties jest tworzony tylko 1 raz na cala aplikacje - Singleton
    private static Properties properties;


    public static Properties retrieveDatabaseProperties() throws IOException {

        if (properties == null) {

            properties = new Properties();

            InputStream fileInputStream = MyPostgreSQLDatabaseConnection.class.getResourceAsStream("/database.properties");

            properties.load(fileInputStream);

            return properties;

        } else {

            return properties;
        }


    }
}

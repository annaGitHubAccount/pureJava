package de.anna.jdbc.exercise;

import de.anna.jdbc.dao.PersonDAO;
import de.anna.jdbc.dao.PersonDAOImpl;
import de.anna.jdbc.dto.PersonDTO;
import de.anna.jdbc.util.DatabaseConfiguration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Properties;


public class MyPostgreSQLDatabaseConnection {

    private PersonDAO personDAO;

    private MyPostgreSQLDatabaseConnection() {
        personDAO = new PersonDAOImpl();
    }

    public static void main(String[] args) throws SQLException, IOException {

        MyPostgreSQLDatabaseConnection myPostgreSQLDatabaseConnection = new MyPostgreSQLDatabaseConnection();
        myPostgreSQLDatabaseConnection.personOperationen();

    }


    private void personOperationen() throws IOException, SQLException {

        Properties properties = DatabaseConfiguration.retrieveDatabaseProperties();

        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            personDAO.removeAllPersonen(connection);

            PersonDTO personDTO = new PersonDTO("Adas", "Niezgodka", new Timestamp(new Date().getTime()));
            personDAO.insertPerson(personDTO, connection);

            List<PersonDTO> personDTOList = personDAO.retrieveListVonPersonen(connection);

        }

    }
}


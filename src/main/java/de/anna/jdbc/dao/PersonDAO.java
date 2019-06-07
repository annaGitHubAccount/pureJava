package de.anna.jdbc.dao;


import de.anna.jdbc.dto.PersonDTO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface PersonDAO {

    List<PersonDTO> retrieveListVonPersonen(Connection connection) throws SQLException, IOException;

    void insertPerson(PersonDTO personDTO, Connection connection) throws IOException, SQLException;

    void removeAllPersonen(Connection connection) throws IOException, SQLException;


}

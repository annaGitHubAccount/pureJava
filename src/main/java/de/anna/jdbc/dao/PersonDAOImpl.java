package de.anna.jdbc.dao;

import de.anna.jdbc.dto.PersonDTO;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {


    @Override
    public List<PersonDTO> retrieveListVonPersonen(Connection connection) throws SQLException, IOException {

        List<PersonDTO> personDTOList = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT id, vorname, nachname, dateofbirth FROM person");

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String vorname = resultSet.getString("vorname");
                String nachname = resultSet.getString("nachname");
                Timestamp dateOfBorn = resultSet.getTimestamp("dateofbirth");
                personDTOList.add(new PersonDTO(id, vorname, nachname, dateOfBorn));
            }

        }


        return personDTOList;
    }


    @Override
    public void insertPerson(PersonDTO personDTO, Connection connection) throws IOException, SQLException {


        String vorname = personDTO.getVorname();
        String nachname = personDTO.getNachname();
        Timestamp dateOfBirth = personDTO.getDateOfBirth();

        String sql = "INSERT INTO person(vorname, nachname, dateofbirth) VALUES(?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, vorname);
            preparedStatement.setString(2, nachname);
            preparedStatement.setTimestamp(3, dateOfBirth);

            preparedStatement.executeUpdate();
        }


    }

    @Override
    public void removeAllPersonen(Connection connection) throws IOException, SQLException {

        try (Statement statement = connection.createStatement()) {

            statement.executeUpdate("DELETE FROM person");
        }
    }


}

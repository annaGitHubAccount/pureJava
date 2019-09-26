package de.anna.jdbc.dto;

import java.sql.Timestamp;

public class PersonDTO {

    private Long id;
    private String vorname;
    private String nachname;
    private Timestamp dateOfBirth;


    public PersonDTO(String vorname, String nachname, Timestamp dateOfBirth) {

        this.vorname = vorname;
        this.nachname = nachname;
        this.dateOfBirth = dateOfBirth;
    }

    public PersonDTO(Long id, String vorname, String nachname, Timestamp dateOfBirth) {

        this(vorname, nachname, dateOfBirth);
        this.id = id;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

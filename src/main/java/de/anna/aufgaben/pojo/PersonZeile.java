package de.anna.aufgaben.pojo;



public class PersonZeile {
	
	private String pesel;
	private String name;
    private String nachname;
    private String automarke;
    private String versicherungsFirma;
  
    
    
	public PersonZeile(String pesel, String name, String nachname, String automarke, String versicherungsFirma) {
		super();
		this.pesel = pesel;
		this.name = name;
		this.nachname = nachname;
		this.automarke = automarke;
		this.versicherungsFirma = versicherungsFirma;
	}
	
	
	public String getVersicherungsFirma() {
		return versicherungsFirma;
	}


	public void setVersicherungsFirma(String versicherungsFirma) {
		this.versicherungsFirma = versicherungsFirma;
	}


	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getAutomarke() {
		return automarke;
	}
	public void setAutomarke(String automarke) {
		this.automarke = automarke;
	}


	@Override
	public String toString() {
		return "pesel = " + pesel + ", name = " + name + ", nachname = " + nachname + ", automarke = " + automarke + ", versicherungsFirma = " + versicherungsFirma;
	}
	
	
	
	

}

package bankprojekt;

import kommunikation.EinAusgabe;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

/**
 * Kunde einer Bank
 */
public class Kunde {
	
	public static final Kunde MUSTERMANN = new Kunde("Hinz", "oder Kunz");
	/**
	 * der Vorname
	 */
	private String vorname;
	/**
	 * Der Nachname
	 */
	private String nachname;

	private String address;

	private LocalDate birthDate;

	/**
	 * erstellt den Kunden mit dem angegebenen Namen
	 * @param vorname Vorname des Kunden
	 * @param nachname Nachname des Kunden
	 * @throws IllegalArgumentException wenn einer der Parameter null ist
	 */
	public Kunde(String vorname, String nachname) {
		this.setVorname(vorname);
		this.setNachname(nachname);
		this.setAddress("Default Address");
		this.setBirthDate(LocalDate.now());
	}

	public Kunde(String vorname, String nachname, String address, LocalDate birthDate) {
		this.setVorname(vorname);
		this.setNachname(nachname);
		this.setAddress(address);
		this.setBirthDate(birthDate);
	}

	public Kunde(String vorname, String nachname, String address, String birthDate) {
		LocalDate date;
		DateTimeFormatter formatter;

		this.setVorname(vorname);
		this.setNachname(nachname);
		this.setAddress(address);

		try {
			date = LocalDate.parse(birthDate);
		} catch (Exception e) {
			try {
				formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
				date = LocalDate.parse(birthDate, formatter);
			} catch (Exception e1) {
				try {
					formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
					date = LocalDate.parse(birthDate, formatter);
				} catch (Exception e2) {
					try {
					formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
					date = LocalDate.parse(birthDate, formatter);
					} catch (Exception e3) {
						throw new IllegalArgumentException("Failed to read Date");
					}
				}
			}
		}
		this.setBirthDate(date);
	}

	public Kunde() {
		this.setVorname("Max");
		this.setNachname("Mustermann");
		this.setAddress("Musterstraße 1");
		this.setBirthDate(LocalDate.now());
	}

	/**
	 * Nachname des Kunden
	 * 
	 * @return Nachname des Kunden
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * setzt den Nachnamen auf den angegebenen Wert
	 * 
	 * @param nachname neuer Nachname
	 * @throws IllegalArgumentException wenn nachname null ist
	 */
	public void setNachname(String nachname) {
		if(nachname == null)
			throw new IllegalArgumentException("Nachname darf nicht null sein");
		this.nachname = nachname;
	}

	/**
	 * Vorname des Kunden
	 * 
	 * @return Vorname des Kunden
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * setzt den Vornamen auf den angegebenen Wert
	 * 
	 * @param vorname neuer Vorname
	 * @throws IllegalArgumentException wenn vorname null ist
	 */
	public void setVorname(String vorname) {
		if(vorname == null)
			throw new IllegalArgumentException("Vorname darf nicht null sein");
		this.vorname = vorname;
	}

	/**
	 * if you don't understand this you shouldn't program
	 * @return
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * if you don't understand this you shouldn't program
	 * @return
	 */
	public void setAddress(String address) {
		if (address == "") {
			throw new IllegalArgumentException("Address can't be empty");
		} else {
			this.address = address;
		}
	}

	/**
	 * if you don't understand this you shouldn't program
	 * @return
	 */
	public LocalDate getBirthDate() {
		return birthDate;
	}

	/**
	 * if you don't understand this you shouldn't program
	 * @return
	 */
	public void setBirthDate(LocalDate birthDate) {
		if (birthDate == null) {
			throw new IllegalArgumentException("Birth Date can't be null");
		} else {
			// if (birthDate.isBefore(LocalDate.now())) {
				this.birthDate = birthDate;
			/*
			} else {
				throw new IllegalArgumentException("Birth date can't be in the future");
			}
			*/
		}
	}

	public String getName() {
		return this.getVorname() + " " + this.getNachname();
	}

	public int getAlter() {
		Period period = Period.between(this.getBirthDate(), LocalDate.now());

		return period.getYears();
	}

	public String toString(){
		return "Name: " + this.getName() + "\nAddress: " + this.getAddress() + "\nBirth Date: " + this.getBirthDate().toString() + "\nAge: " + this.getAlter() + "\n";
	}

}

package bankprojekt;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Kunde einer Bank
 */
public class Kunde implements Comparable<Kunde> {
	/**
	 * Ein Musterkunde
	 */
	public static final Kunde MUSTERMANN = new Kunde("Max", "Mustermann", "zuhause", LocalDate.of(1990, 1, 1));
	/**
	 * der Vorname
	 */
	private String vorname;
	/**
	 * Der Nachname
	 */
	private String nachname;
	/**
	 * Die Adresse
	 */
	private String adresse;
	/**
	 * Geburtstag
	 */
	private LocalDate geburtstag;
	
	/**
	 * erstellt den Kunden mit dem angegebenen Namen
	 * @param vorname Vorname des Kunden
	 * @param nachname Nachname des Kunden
	 * @throws IllegalArgumentException wenn einer der Parameter null ist
	 */
	public Kunde(String vorname, String nachname) {
		this.setVorname(vorname);
		this.setNachname(nachname);
		this.adresse = "Adresse";
		this.geburtstag = LocalDate.now();
	}
	/**
	 * erzeugt einen Standardkunden
	 */
	public Kunde() {
		this("Max", "Mustermann", "Adresse", LocalDate.now());
	}

	/**
	 * Erzeugt einen Kunden mit den übergebenen Werten
	 * 
	 * @param vorname Vorname
	 * @param nachname Nachname
	 * @param adresse Adresse
	 * @param gebdat Geburtstag
	 * @throws IllegalArgumentException wenn einer der Parameter null ist
	 */
	public Kunde(String vorname, String nachname, String adresse, LocalDate gebdat) {
		if(vorname == null || nachname == null || adresse == null || gebdat == null)
			throw new IllegalArgumentException("null als Parameter nich erlaubt");
		this.vorname = vorname;
		this.nachname = nachname;
		this.adresse = adresse;
		this.geburtstag = gebdat;
	}

	/**
	 * Erzeugt einen Kunden mit den übergebenen Werten
	 * 
	 * @param vorname Vorname
	 * @param nachname Nachname
	 * @param adresse Adresse
	 * @param gebdat Geburtstag im Format tt.mm.yyyy
	 * @throws IllegalArgumentException wenn einer der Parameter null ist
	 */
	public Kunde(String vorname, String nachname, String adresse, String gebdat)  {
		this(vorname, nachname, adresse, LocalDate.parse(gebdat,DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
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
	 * die Adresse des Kunden
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * lässt den Kunden an die neue adresse umziehen
	 * @param adresse neue Adresse
	 * @throws IllegalArgumentException wenn adresse null ist
	 */
	public void setAdresse(String adresse) {
		if(adresse == null)
			throw new IllegalArgumentException("Vorname darf nicht null sein");
		this.adresse = adresse;
	}
	/**
	 * Geburtstag des Kunden
	 * @return the geburtstag
	 */
	public LocalDate getGeburtstag() {
		return geburtstag;
	}
	
	/**
	 * vollständiger Name des Kunden in der Form "Nachname, Vorname"
	 * 
	 * @return vollständiger Name des Kunden
	 */
	public String getName() {
		return this.nachname + ", " + this.vorname;
	}
	
	/**
	 * liefert das aktuelle Alter des Kunden
	 * @return aktueller Alter in Jahren
	 */
	public int getAlter()
	{
		Period dauer = Period.between(geburtstag, LocalDate.now());
		return dauer.getYears();
	}

	
	/**
	 * gibt alle Daten des Kunden aus
	 */
	@Override
	public String toString() {
		String ausgabe;
		DateTimeFormatter df = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		ausgabe = this.getName() + System.getProperty("line.separator");
		ausgabe += this.adresse + System.getProperty("line.separator");
		ausgabe += df.format(this.geburtstag) +  "(" + this.getAlter() +")" + System.getProperty("line.separator");
		return ausgabe;
	}

	@Override
	public int compareTo(Kunde o) {
		return this.nachname.compareTo(o.nachname);
	}
}
package interfacebenutzung;
/**
 * stellt ein ganz einfaches Konto dar
 */
public class KontoEinfach implements Comparable<KontoEinfach>
{
	/**
	 * der Name des Kontoinhabers
	 */
	private String inhaber;
	/**
	 * die Kontonummer
	 */
	private int nummer;

	/**
	 * der aktuelle Kontostand
	 */
	private double kontostand;

	/**
	 * Setzt die beiden Eigenschaften kontoinhaber und kontonummer auf die angegebenen Werte,
	 * der anfängliche Kontostand wird auf 0 gesetzt.
	 *
	 * @param inhaber Kontoinhaber
	 * @param kontonummer Kontonummer
	 * @param betrag anfänglicher Kontostand
	 * @throws IllegalArgumentException wenn der Inhaber null oder betrag kleiner 0
	 */
	public KontoEinfach(String inhaber, int kontonummer, double betrag) {
		if(inhaber == null)
			throw new IllegalArgumentException("Inhaber darf nicht null sein!");
		if(betrag < 0)
			throw new IllegalArgumentException("Betrag darf nicht negativ sein!");
		this.inhaber = inhaber;
		this.nummer = kontonummer;
		this.kontostand = betrag;
	}
	
	/**
	 * setzt alle Eigenschaften des Kontos auf Standardwerte
	 */
	public KontoEinfach() {
		this("Unbekannt", 1234567, 0);
	}

	/**
	 * liefert den Kontoinhaber zurück
	 * @return   Kontoinhaber
	 */
	public String getInhaber() {
		return this.inhaber;
	}
	
	/**
	 * liefert den aktuellen Kontostand
	 * @return   Kontostand
	 */
	public double getKontostand() {
		return kontostand;
	}

	/**
	 * liefert die Kontonummer zurück
	 * @return   Kontonummer
	 */
	public int getKontonummer() {
		return nummer;
	}
	
	@Override
	public String toString() {
		String ausgabe;
		ausgabe = "Nummer: " + this.getKontonummerFormatiert() + System.lineSeparator()
			+ "Inhaber: " + this.inhaber + System.lineSeparator()
			+ ": " + this.kontostand + " €";
		return ausgabe;
	}
	
	/**
	 * liefert die ordentlich formatierte Kontonummer
	 * @return auf 10 Stellen formatierte Kontonummer
	 */
	public String getKontonummerFormatiert()
	{
		return String.format("%10d", this.nummer);
	}

	@Override
	public int compareTo(KontoEinfach kontoEinfach) {
		if(this.getKontostand() > kontoEinfach.getKontostand())
			return 1;
		if(this.getKontostand() < kontoEinfach.getKontostand())
			return -1;
		return 0;
		//return this.getKontonummer() - kontoEinfach.getKontonummer();
	}

}

package bankprojekt;

import bankrechnereien.IbanMain;
import bankprojekt.exceptions.*;

/**
 * Diese Klasse stellt ein Bankkonto dar
 */
public class Konto {
	/**
	 * Der Kontostand
	 */
	private double kontostand;
	/**
	 * Die Kontonummer
	 * TODO: muss noch für jedes Kobto eindeutig gemacht werden
	 */
	private final long nummer;
	/**
	 * true, wenn das Konto gesperrt ist. Abhebungen und sonstige
	 * Aktionen zum Schaden des Besitzers sind dann nicht möglich
	 */
	private boolean gesperrt;
	/**
	 * Der Kontoinhaber
	 */
	private Kunde inhaber;
	
	/**
	 * der auf zwei Stellen nach dem Komma gerundete Kontostand
	 * @return the kontostand
	 */
	public double getKontostand() {
		return Math.round(this.kontostand * 100)/100;
	}

	/**
	 * gesperrt-Zustand von this
	 * @return the gesperrt
	 */
	public boolean isGesperrt() {
		return gesperrt;
	}

	/**
	 * sperrt (true) bzw. entsperrt (false) das Konto
	 * @param gesperrt the gesperrt to set
	 */
	public void setGesperrt(boolean gesperrt) {
		this.gesperrt = gesperrt;
	}

	/**
	 * Kontoinhaber
	 * @return the inhaber
	 */
	public Kunde getInhaber() {
		return inhaber;
	}

	/**
	 * Ändert den Kontoinhaber
	 * @param inhaber the inhaber to set
	 */
	public void setInhaber(Kunde inhaber) {
		if(inhaber != null )
			this.inhaber = inhaber;
		/*else
			throw new IllegalArgumentException();
			*/
	}

	/**
	 * Die Kontonummer
	 * @return the nummer
	 */
	public long getNummer() {
		return nummer;
	}

	/**
	 * erstellt ein leeres Standardkonto von Mustermann
	 */
	public Konto()
	{
		this(Kunde.MUSTERMANN, 0.0);
	}
	/**
	 * erstellt ein Konto mit dem angegebenen Kontostand, das
	 * inhaber gehört
	 * @param inhaber der Kontoninhabe
	 * @param anfangsstand der anfängliche Kontostand; Ist er negativ,
	 *        ist das Konto leer
	 * @throws IllegalArgumentException wenn inhaber null ist
	 */
	public Konto(Kunde inhaber, double anfangsstand)
	{
		//alle Attribute mit Startwerten versorgen:
		this.kontostand = Math.max(0.0, anfangsstand);
		this.nummer = 12345;
		this.gesperrt = false;
		if(inhaber == null)
			throw new IllegalArgumentException("null als Inhaber nicht erlaubt");
		this.inhaber = inhaber;
	}
	
	/**
	 * nur zum Ausprobieren
	 * @param args wird nicht genutzt
	 */
	public static void main(String[] args) {
		Konto meins = new Konto();
		System.out.println(meins.kontostand);
		meins.kontostand = 234567897654.0;
		System.out.println("Nummer: " + meins.nummer);
		Konto deins = new Konto();
		
	}
	
	/**
	 * zahlt betrag auf das this-Konto ein
	 * @param betrag
	 * @throws IllegalArgumentException wenn betrag Quatsch ist
	 */
	public void einzahlen(double betrag)
	{
		if(betrag < 0 || !Double.isFinite(betrag) 
				|| Double.isNaN(betrag))
			throw new IllegalArgumentException();
		this.kontostand += betrag;
	}
	
	/**
	 * hebt betrag vom this-Konto ab
	 * @param betrag der gewünschte betrag
	 * @return true, wenn die Abhebung nach den regeln dieses Kontos
	 * 	       durchgeführt werden konnte
	 * @throws GesperrtException wenn das Konto gesperrt ist
	 * @throws IllegalArgumentException wenn betrag Quatsch ist
	 */
	public boolean abheben(double betrag) throws bankprojekt.GesperrtException
	{
		if(betrag < 0 || !Double.isFinite(betrag) 
				|| Double.isNaN(betrag))
			throw new IllegalArgumentException();
		if(this.gesperrt)
			throw new bankprojekt.GesperrtException();
		this.kontostand -= betrag;
		return true;
	}
	
	/**
	 * IBan aus der Kontonummer von this und der angegebenen BLZ
	 * @param blz gewünschte Bankleitzahl
	 * @return IBan
	 */
	public String getIban(long blz)
	{
		return IbanMain.iban(this.nummer, blz);
	}

}

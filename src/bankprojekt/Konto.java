package bankprojekt;

import java.text.NumberFormat;
import java.util.Locale;

import bankprojekt.exceptions.GesperrtException;
import bankrechnereien.IbanMain;

/**
 * Die Objekte dieser Klasse stellen Konten bei einer Bank dar. 
 * Modelliert werden der Inhaber, die Kontonummer und der Kontostand des
 * Kontos.
 * @author Dorothea Hubrich
 *
 */
public class Konto {
	/**
	 * die größte bisher vergebene Kontonummer aller Konto-Objekte im
	 * Programm
	 */
	private static long anzahlBisherErstellterKonten = 0;
	
	/**
	 * liefert eine neue noch nicht vergebene Kontonummer
	 * und merkt sich, dass diese nun verwendet wird
	 * @return neue Kontonummer
	 */
	public static long holeNeueNummer()
	{
		Konto.anzahlBisherErstellterKonten++;
		return Konto.anzahlBisherErstellterKonten;
	}

	/**
	 * die Kontonummer
	 */
	private final long nummer;
	/**
	 * der Kontostand, nicht negativ
	 */
	private double kontostand;
	/**
	 * Der Name des Inhabers
	 */
	private Kunde inhaber;
	/**
	 * ggf zweiter Inhaber des Kontos
	 */
	private Kunde inhaber2;
	/**
	 * gibt an, ob das Konto gesperrt ist. Aktionen zum Schaden des Inhabers sind dann
	 * nicht möglich
	 */
	private boolean gesperrt;

	private Waehrung currency;
	
	/**
	 * dieser Konstruktor erstellt ein Standardkonto
	 * mit einem Anfangskontostand von 0 und einem
	 * unbekannten Kontoinhaber
	 */
	public Konto() {
		this(Kunde.MUSTERMANN, 0.0);
		this.currency = Waehrung.EURO;
	}
	
	/**
	 * Dieser Konstruktor erstellt ein leeres Konto
	 * für den angegebenen Inhaber
	 * @param inhaber der neue Kontoinhaber
	 */
	public Konto(Kunde inhaber) {
		this(inhaber, 0.0);
		this.currency = Waehrung.EURO;
	}
	
	/**
	 * Dieser Konstruktor erstellt ein Konto
	 * für den angegebenen Inhaber mit dem angegebenen Kontostand
	 * @param inhaber der neue Kontoinhaber
	 * @param anfangsstand der anfängliche Kontostand; darf nicht negativ sein
	 */
	public Konto(Kunde inhaber, double anfangsstand) {
		this.inhaber = Kunde.MUSTERMANN;
		boolean inOrdnung = inhaber != null && !inhaber.equals("");
		if(inOrdnung)
		{	
			this.inhaber = inhaber;
		}
		this.kontostand = 0.0;
		if(anfangsstand >= 0)
		{
			this.kontostand = anfangsstand;
		}
		this.nummer = Konto.holeNeueNummer();
		this.gesperrt = false;
		this.currency = Waehrung.EURO;
	}

	/**
	 * @return the gesperrt
	 */
	public boolean isGesperrt() {
		return gesperrt;
	}

	/**
	 * @param gesperrt the gesperrt to set
	 */
	public void setGesperrt(boolean gesperrt) {
		this.gesperrt = gesperrt;
	}

	/**
	 * @return die Kontonummer
	 */
	public long getNummer() {
		return this.nummer;
	}
	/**
	 * @return aktueller Kontostand
	 */
	public double getKontostand() {
		return this.kontostand;
	}

	public void setKontostand(double kontostand) {
		this.kontostand = kontostand;
	}

	/**
	 * @return Name des Inhabers
	 */
	public Kunde getInhaber() {
		return this.inhaber;
	}

	/**
	 * @param inhaber der Name des neuen Inhabers
	 */
	public void setInhaber(Kunde inhaber) {
		boolean inOrdnung = inhaber != null;
		if(inOrdnung == true)

		{
			this.inhaber = inhaber;
		}
	}
	
	/**
	 * @param inhaber der neue zweite Kontoninhaber
	 */
	public void setZweiterInhaber(Kunde inhaber) {
		boolean inOrdnung = inhaber != null;
		if(inOrdnung == true)

		{
			this.inhaber2 = inhaber;
		}
	}
	
	/**
	 * entfernt den zweiten Kontoinhaber
	 */
	public void removeZweiterInhaber()
	{
		this.inhaber2 = null;
	}
	
	/**
	 * gibt die IBAN dieses Kontos zurück
	 * @param bankleitzahl BLZ der Bank, bei der dieses Konto geführt wird
	 * @return IBAN aus bankleitzahl und der Kontonummer von this
	 */
	public String getIban(long bankleitzahl) 
	{
		return IbanMain.iban(this.nummer, bankleitzahl);
	}
	/**
	 * zahlt den Betrag auf this ein
	 * @param betrag der einzuzahlender Betrag, darf nicht negativ sein
	 */
	public void einzahlen(double betrag)
	{
		if(betrag > 0) {
			this.kontostand = this.kontostand + betrag;
		}
	}

	/**
	 * zahls the betrag onto the konto ein
	 * @param betrag the amount of money to add
	 * @param currency the currency to einzahl
	 */
	public void einzahlen(double betrag, Waehrung currency) {
		if(betrag > 0) {
			this.kontostand = this.kontostand + betrag * currency.vonThisInZielUmrechnen(this.currency, betrag);
		}
	}

	/**
	 * hebt den gewünschten betrag von this ab
	 * @param betrag der gewünschte Abhebungsbetrag, darf nicht negativ sein
	 * @return true, wenn die Abhebung möglich war; false, wenn
	 * 		   das Konto nicht ausreichend gedeckt ist
	 * @throws GesperrtException wenn das Konto gesperrt ist
	 */
	public boolean abheben(double betrag) throws GesperrtException
	{
		if(this.isGesperrt())
			throw new GesperrtException();
		if(betrag > 0)
		{
			this.kontostand = this.kontostand - betrag;
			return true;
		}
		return false;
	}

	public boolean abheben(double betrag, Waehrung currency) throws GesperrtException
	{
		if(this.isGesperrt())
			throw new GesperrtException();
		if(betrag > 0)
		{
			this.kontostand = this.kontostand - betrag;
			return true;
		}
		return false;
	}

    /**
     * liefert eine String-Ausgabe, wenn das Konto gesperrt ist
     *
     * @return "GESPERRT", wenn das Konto gesperrt ist, ansonsten ""
     */
    public String getGesperrtText() {
        if (this.gesperrt) {
            return "GESPERRT";
        } else {
            return "";
        }
    }
    
    /**
     * liefert den ordentlich formatierten Kontostand
     *
     * @return formatierter Kontostand 
     */
    public String getKontostandFormatiert() {
        return NumberFormat.getCurrencyInstance(Locale.GERMAN).format(this.kontostand);
    }

	/**
	 * This is a getter, if you don't get it (haha) you are dumb
	 * @return
	 */
	public Waehrung getCurrency() {
		return currency;
	}

	public void setCurrency(Waehrung currency) {
		try {

			this.currency = currency;
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String toString()
	{
		String ausgabe;
		ausgabe = "Auf dem Konto " + this.nummer + " von " + this.inhaber.getName();
		if(this.inhaber2 != null)
			ausgabe += " und " + this.inhaber2.getName();
		ausgabe += " sind " + this.getKontostandFormatiert() + ".";
		if(this.gesperrt)
			ausgabe += System.lineSeparator() + this.getGesperrtText();
		return ausgabe;
	}
}

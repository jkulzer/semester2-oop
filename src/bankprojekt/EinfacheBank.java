package bankprojekt;

import java.util.Arrays;
import java.util.Scanner;

import bankprojekt.exceptions.KontonummerNichtVorhandenException;
import kommunikation.EinAusgabe;

/**
 * ein Programm für Kontobewegungen
 *
 */
public class EinfacheBank {
	private Konto[] konten = new Konto[0];

	/**
	 * gibt das Textmenü, also die Auswahl der angebotenen
	 * Möglichkeiten aus
	 */
	public void menueausgeben()
	{
		System.out.println("(1) neues Konto anlegen");
		System.out.println("(2) einzahlen");
		System.out.println("(3) abheben");
		System.out.println("(4) sperren");
		System.out.println("(5) entsperren");
		System.out.println("(6) Kontoinformationen");
		System.out.println("(7) Inhaberwechsel");
		System.out.println("(0) beenden");
	}
	
	/**
	 * fragt den Benutzer nach seinem Namen und legt ein neues
	 * Konto-Objekt in der Bank an
	 * @param wer der Kontoinhaber
	 * @return Kontonummer des neuen Kontos, -1, wenn wer leer ist
	 */
	public long neuesKontoAnlegen(Kunde wer)
	{

	}
	
	/**
	 * speichert k in this.konten
	 * @param k ein neues Konto
	 * @return
	 */
	private void kontoEinfuegen(Konto k)
	{
		this.konten = Arrays.copyOf(konten, konten.length +1);
		this.konten[konten.length -1] = k;
	}
	
	/**
	 * sucht das Konto mit der gewünschten nr
	 * @param nr gesuchte Kontonummer
	 * @return zugehöriges Konto
	 * @throws KontonummerNichtVorhandenException wenn es die Nr in der Bank nicht gibt
	 */
	private Konto findeKontoZuNr(long nr) throws KontonummerNichtVorhandenException
	{
		for(int i =0; i < this.konten.length; i++)
		{
			if(this.konten[i].getNummer() == nr)
				return this.konten[i];
		}
		throw new KontonummerNichtVorhandenException();
	}
	
	/**
	 * führt eine Einzahlung durch
	 * @param nr Kontonummer des gewünschten Girokontos
	 * @param betrag einzuzahlender betrag
	 * @throws KontonummerNichtVorhandenException wenn es die Nr in der Bank nicht gibt
	 */
	public void einzahlung(long nr, double betrag)throws KontonummerNichtVorhandenException
	{
		
	}
	
	/**
	 * führt eine Abhebung durch
	 * @param nr Kontonummer des gewünschten Girokontos
	 * @param betrag abzuhebender Betrag
	 * @throws KontonummerNichtVorhandenException wenn es die Nr in der Bank nicht gibt
	 * @return true, wenn die Abhebung durchgeführt werden konnte
	 */
	public boolean abhebung(long nr, double betrag)throws KontonummerNichtVorhandenException {
		
	}
	
	/**
	 * sperrt bzw. entsperrt das gewünschte Konto
	 * @param nr Kontonummer des gewünschten Kontos
	 * @param sperren true, wenn gesperrt werden soll, false für entsperren
	 * @throws KontonummerNichtVorhandenException wenn es die Nr in der Bank nicht gibt
	 */
	public void sperrenEntsperren(long nr, boolean sperren)throws KontonummerNichtVorhandenException {
		
	}
	
	/**
	 * liefert einen String mit Informationen zu allen Konten der Bank zurück
	 * @return String-Darstellung aller Konten
	 */
	public String kontoinformationen() {
		String ausgabe = "";
		for(int i =0; i < this.konten.length; i++) {
			ausgabe += this.konten[i] + System.lineSeparator();
		}
		return ausgabe;	
	}
	
	/**
	 * Setzt den neuen Inhaber des gewünschten Kontos
	 * @param nr Kontonummer des gewünschten Kontos
	 * @param neuerInhaber der neue Inhaber dieses Kontos; wenn null angegeben wird, wird
	 *                     kein Inhaberwechsel durchgeführt
	 * @throws KontonummerNichtVorhandenException wenn es die Nr in der Bank nicht gibt
	 */
	public void inhaberwechsel(long nr, Kunde neuerInhaber)throws KontonummerNichtVorhandenException {
		
	}
	
	/**
	 * stellt eine kleine Oberfläche für die Verwaltung eines
	 * einzelnen Kontos zur Verfügung
	 * @param args wird nicht verwendet.
	 */
	public static void main(String[] args) {
		EinfacheBank hwrBank = new EinfacheBank();
		int auswahl;
		Scanner tastatur = new Scanner(System.in);

		do
		{
			hwrBank.menueausgeben();
			auswahl = EinAusgabe.eingabeGanzzahl("Ihre Auswahl bitte: ");
			switch(auswahl)
			{
				case 1 -> {
					System.out.println("Ihr Vorname: ");
					String vorname = tastatur.nextLine();
					System.out.println("Ihr Nachname: ");
					String nachname = tastatur.nextLine();
					Kunde wer = new Kunde(vorname, nachname);
					long nr = hwrBank.neuesKontoAnlegen(wer);
					System.out.println("Ihre neue Kontonummer lautet: " + nr);
				}
				case 2 -> {
					long nr = EinAusgabe.eingabeGanzzahl("Ihre Kontonummer: ");
					double betrag = EinAusgabe.eingabeKommazahl("Der Betrag: ");
					try {
						hwrBank.einzahlung(nr, betrag);
					} catch (KontonummerNichtVorhandenException e) {
						System.out.println("Diese Kontonummer gibt es nicht!");
					}
				}
				case 3 -> {
					long nr = EinAusgabe.eingabeGanzzahl("Ihre Kontonummer: ");
					double betrag = EinAusgabe.eingabeKommazahl("Der Betrag: ");
					try {
						if(!hwrBank.abhebung(nr, betrag)) {
							System.out.println("Abhebung konnte nicht durchgeführt werden.");
						}
					} catch (KontonummerNichtVorhandenException e) {
						System.out.println("Diese Kontonummer gibt es nicht!");
					}
				}
				case 4 -> {
					long nr = EinAusgabe.eingabeGanzzahl("Ihre Kontonummer: ");
					hwrBank.sperrenEntsperren(nr, true);
				}
				case 5 -> {
					long nr = EinAusgabe.eingabeGanzzahl("Ihre Kontonummer: ");
					hwrBank.sperrenEntsperren(nr, false);
				}
				case 6 -> System.out.println(hwrBank.kontoinformationen());
				case 7 -> {
					long nr = EinAusgabe.eingabeGanzzahl("Ihre Kontonummer: ");
					System.out.println("Vorname des neuen Inhabers: ");
					String vorname = tastatur.nextLine();
					System.out.println("Nachname des neuen Inhabers: ");
					String nachname = tastatur.nextLine();
					Kunde wer = new Kunde(vorname, nachname);
					try {
						hwrBank.inhaberwechsel(nr, wer);
					} catch (KontonummerNichtVorhandenException e) {
						System.out.println("Diese Kontonummer gibt es nicht!");
					}
					System.out.println(hwrBank.kontoinformationen());
				}
			}
				
		}while (auswahl != 0);

	}
}
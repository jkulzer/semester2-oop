import java.time.LocalDate;
import java.util.Scanner;

import bankprojekt.Kunde;
import bankprojekt.exceptions.AccountNotFoundException;
import bankprojekt.exceptions.BetrugsversuchException;
import bankprojekt.exceptions.GesperrtException;
import bankprojekt.exceptions.PoorCustomerException;
import kommunikation.EinAusgabe;
import bankprojekt.Bank;
import bankprojekt.Kontoart;

/**
 * ein kleines Testprogramm für eine Bank
 */
public class Bankprogramm {
	/**
	 * gibt das Textmenü, also die Auswahl der angebotenen
	 * Möglichkeiten aus
	 */
	private static void menueausgeben()
	{
		System.out.println("(1) neues Konto anlegen");
		System.out.println("(2) einzahlen");
		System.out.println("(3) abheben");
		System.out.println("(4) überweisen");
		System.out.println("(5) Kontoinformationen");
		System.out.println("(0) beenden");
	}

	/**
	 * stellt eine kleine Oberfläche für die Verwaltung eines
	 * einzelnen Kontos zur Verfügung
	 * @param args wird nicht verwendet.
	 */
	public static void main(String[] args) throws GesperrtException, BetrugsversuchException, PoorCustomerException, AccountNotFoundException {
		Bank hwrBank = new Bank(12345, "Berlin");
		int auswahl;
		Scanner tastatur = new Scanner(System.in);

		do
		{
			menueausgeben();
			auswahl = EinAusgabe.eingabeGanzzahl("Ihre Auswahl bitte: ");
			switch(auswahl)
			{
				case 1 -> {
					System.out.println("Ihr Vorname: ");
					String vorname = tastatur.nextLine();
					System.out.println("Ihr Nachname: ");
					String nachname = tastatur.nextLine();
					System.out.println("Ihre Adresse: ");
					String adresse = tastatur.nextLine();
					System.out.println("Ihr Geburtstag:");
					LocalDate geburtstag = LocalDate.parse(tastatur.nextLine());
					System.out.println("Was für ein Konto? (GIROKONTO, SPARBUCH)");
					Kontoart art = Kontoart.valueOf(tastatur.nextLine());
					Kunde wer = new Kunde(vorname, nachname, adresse, geburtstag);
					long nr = hwrBank.kontoEroeffnen(wer, art);
					System.out.println("Ihre neue Kontonummer lautet: " + nr);
				}
				case 2 -> {
					long nr = EinAusgabe.eingabeGanzzahl("Ihre Kontonummer: ");
					double betrag = EinAusgabe.eingabeKommazahl("Der Betrag: ");
					hwrBank.geldEinzahlen(nr, betrag);
				}
				case 3 -> {
					long nr = EinAusgabe.eingabeGanzzahl("Ihre Kontonummer: ");
					double betrag = EinAusgabe.eingabeKommazahl("Der Betrag: ");
					if(!hwrBank.geldAbheben(nr, betrag)) {
						System.out.println("Abhebung konnte nicht durchgeführt werden.");
					}
				}
				case 4 -> {
					long nr = EinAusgabe.eingabeGanzzahl("Ihre Kontonummer: ");
					long ziel = EinAusgabe.eingabeGanzzahl("Auf welche Kontonummer: ");
					double betrag = EinAusgabe.eingabeKommazahl("Der Betrag: ");
					System.out.println("Verwendungszweck: ");
					String zweck = tastatur.nextLine();
					if(!hwrBank.geldUeberweisen(nr, ziel, betrag, zweck)) {
						System.out.println("Überweisung konnte nicht durchgeführt werden.");
					}
				}
				case 5 -> System.out.println(hwrBank.getAlleKonten());
			}
				
		}while (auswahl != 0);

	}

}

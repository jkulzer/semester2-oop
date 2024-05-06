package spielereien;

import java.time.LocalDate;

import bankprojekt.exceptions.GesperrtException;
import bankprojekt.Girokonto;
import bankprojekt.Konto;
import bankprojekt.Kunde;
import bankprojekt.Sparbuch;
import bankprojekt.Waehrung;

/**
 * spielt ein wenig mit den Währungsmethoden des Bankprojektes herum
 * @author Doro
 *
 */
public class Waehrungsspielereien {

	/**
	 * ein kleines Programm mit 2 Konten in verschiedenen Währungen
	 * @param args wird nicht verwendet
	 */
	public static void main(String[] args)  {
		//Hier gerne verändern - ich weiß nicht, wie Ihre Konstanten heißen:
		Waehrung waehrung1 = Waehrung.ESCUDO;
		Waehrung waehrung2 = Waehrung.KRONE;
		Waehrung euro = Waehrung.EURO;
		try {
			Kunde ich = new Kunde("Dorothea", "Hubrich", "zuhause", LocalDate.parse("1976-07-13"));
			Konto meinKonto = new Girokonto(ich, 1000.0);
			
			meinKonto.waehrungswechsel(waehrung1);
			System.out.println("Nach Währungswechsel nach " + waehrung1 + ": " + meinKonto);
			meinKonto.einzahlen(1000, euro);
			System.out.println("1000 "+ euro +" eingezahlt: " + meinKonto);
			meinKonto.einzahlen(2000, waehrung2);
			System.out.println("2000 " + waehrung2 + " eingezahlt: " + meinKonto);
			
			meinKonto.waehrungswechsel(waehrung2);
			System.out.println("Nach Währungswechsel nach " + waehrung2 + ": " + meinKonto);
			boolean hatGeklappt;
			hatGeklappt = meinKonto.abheben(1000);
			System.out.println("1000 "+ waehrung2 + " abgehoben: " + hatGeklappt + System.lineSeparator() + meinKonto);
			hatGeklappt = meinKonto.abheben(1000, euro);
			System.out.println("1000 " + euro + " abgehoben: " + hatGeklappt + System.lineSeparator() + meinKonto);
			hatGeklappt = meinKonto.abheben(500,waehrung1);
			System.out.println("500 "+ waehrung1 + " abgehoben: " + hatGeklappt + System.lineSeparator() + meinKonto);
			
			meinKonto = new Sparbuch(ich, 9876);
			meinKonto.waehrungswechsel(waehrung1);
			System.out.println("Nach Währungswechsel nach " + waehrung1 + ": " + meinKonto);
			meinKonto.einzahlen(1000, euro);
			System.out.println("1000 "+ euro +" eingezahlt: " + meinKonto);
			meinKonto.einzahlen(2000, waehrung2);
			System.out.println("2000 " + waehrung2 + " eingezahlt: " + meinKonto);
			
			meinKonto.waehrungswechsel(waehrung2);
			System.out.println("Nach Währungswechsel nach " + waehrung2 + ": " + meinKonto);
			boolean hatGeklappt;
			hatGeklappt = meinKonto.abheben(1000);
			System.out.println("1000 "+ waehrung2 + " abgehoben: " + hatGeklappt + System.lineSeparator() + meinKonto);
			hatGeklappt = meinKonto.abheben(1000, euro);
			System.out.println("1000 " + euro + " abgehoben: " + hatGeklappt + System.lineSeparator() + meinKonto);
			hatGeklappt = meinKonto.abheben(500,waehrung1);
			System.out.println("500 "+ waehrung1 + " abgehoben: " + hatGeklappt + System.lineSeparator() + meinKonto);
		} catch (GesperrtException e)
		{}  //nichts tun, tritt hier nicht auf
	}

}

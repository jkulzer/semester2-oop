import bankprojekt.Konto;
import bankprojekt.Kunde;

import java.time.LocalDate;

/**
 * Testprogramm für die Klasse Konto
 * @author Dorothea Hubrich
 *
 */
public class Kontenspielerei {

	/**
	 * ein wenig einzahlen und abheben
	 * @param args
	 */
	public static void main(String[] args) {
		Kunde customerOne = new Kunde();
		Kunde customerTwo = new Kunde("Vorn", "Nachn");
		Kunde customerThree = new Kunde("Vorn", "Nachn", "Hauptstraße 3", LocalDate.now().minusYears(25));
		Kunde customerFour = new Kunde("Vorn", "Nachn", "Haupstraße 4", "January 12, 1952");


		System.out.println(customerOne);
		System.out.println(customerTwo);
		System.out.println(customerThree);
		System.out.println(customerFour);

		// Konto accountOne = new Konto(customerOne, 0);
		// Konto accountTwo = new Konto(customerTwo, 0);
		// Konto accountThree = new Konto(customerThree, 0);
		// Konto accountFour = new Konto(customerFour, 0);

		// System.out.println(accountOne);
		// System.out.println(accountTwo);
		// System.out.println(accountThree);
		// System.out.println(accountFour);

		// System.out.println(meins.getKontostand());
		// meins.kontostand = 234567897654.0;
	}

}
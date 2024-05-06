import java.time.LocalDate;

import bankprojekt.Konto;
import bankprojekt.Kunde;

/**
 * probiert die Klasse Kunde aus
 */
public class Kundenspielerei {

	/**
	 * probiert die Klasse Kunde aus
	 * @param args wird nicht verwendet
	 */
	public static void main(String[] args) {
		Kunde a = new Kunde();
		Kunde b = new Kunde("Doro", "Hubrich");
		Kunde c = new Kunde("Doro", "Hubrich", "zuhause", LocalDate.of(1976, 7, 13));
		Kunde d = new Kunde("Doro", "Hubrich", "zuhause", "13.07.1976");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(Kunde.MUSTERMANN);
		
		Konto ka = new Konto(a);
		Konto kb = new Konto(b, 100);
		Konto kc = new Konto(c);
		Konto kd = new Konto(d, 1234);
		System.out.println(ka);
		System.out.println(kb);
		System.out.println(kc);
		System.out.println(kd);

	}

}

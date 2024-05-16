import java.time.LocalDate;
import java.util.*;

import bankprojekt.Kunde;

/**
 * verwaltet eine Menge von Kunden
 * @author Doro
 */
public class Kundenmenge {
	

	/**
	 * erstellt eine Menge von Kunden und sortiert sie
	 * @param args wird nicht verwendet
	 */
	public static void main(String[] args) {
		Kunde anna = new Kunde("Anna", "Müller", "hier", LocalDate.parse("1979-05-14"));
		Kunde berta = new Kunde("Berta", "Beerenbaum", "hier", LocalDate.parse("1980-03-15"));
		Kunde chris = new Kunde("Chris", "Tall", "hier", LocalDate.parse("1979-01-07"));
		Kunde anton = new Kunde("Anton", "Meier", "hier", LocalDate.parse("1982-10-23"));
		Kunde bert = new Kunde("Bert", "Chokowski", "hier", LocalDate.parse("1970-12-24"));
		Kunde doro = new Kunde("Doro", "Hubrich", "hier", LocalDate.parse("1976-07-13"));

		TreeSet baum = new TreeSet();
		baum.add(anna);
		baum.add(berta);
		baum.add(chris);
		baum.add(anton);
		baum.add(bert);
		baum.add(doro);

		System.out.println(baum.toString());

	}

}

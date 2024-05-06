import bankprojekt.Girokonto;
import bankprojekt.Konto;
import bankprojekt.exceptions.GesperrtException;

/**
 * probiert Vererbung aus
 * @author Dorothea Hubrich
 *
 */
public class Girokontotest {

	/**
	 * probiert Girokonten und Polymorphie aus
	 * @param args wird nicht verwendet
	 */
	public static void main(String[] args) {
		System.out.println("Was für eine Kontoart wollen Sie? (g = Girokonto, s = Sparbuch, k = allgemein");
		Konto gk;
		//if(benutzer sagt g)
			gk = new Girokonto();
		//else
		//	gk = new Konto();
		gk.einzahlen(100);
		System.out.println(gk.getKontostandFormatiert());
		
		boolean hatGeklappt;
		try {
			hatGeklappt = gk.abheben(2000);
			//true - KOnto, false - Girokonto
			//Code aus Girokonto wird ausgeführt!!!
			System.out.println("Abhebung hat geklappt: " + hatGeklappt);
			System.out.println(gk.getKontostandFormatiert());
		} catch (GesperrtException e) {
		}
		
		System.out.println(gk); //automatisch: gk.toString()
		//Code aus Girokonto
		
		//System.out.println("Sie haben zur Verfügung: " 
		//				+ gk.getVerfuegbarerBetrag());
		
		if(gk instanceof Girokonto)
		{
			Girokonto umgewandelt;
			umgewandelt = (Girokonto) gk;
				//Achtung: Hier könnte eine ClassCastException auftreten...
			umgewandelt.ueberweisungEmpfangen(123, "wem auch immer", 6543,9875654, "Für dich!");
			
			System.out.println(gk.getKontostandFormatiert());
		}
	}

}

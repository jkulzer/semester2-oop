import bankprojekt.Konto;

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
		Konto meins = new Konto();
		System.out.println(meins.getKontostand());
		//meins.kontostand = 234567897654.0;
		
	}

}
import java.util.InputMismatchException;

/**
 * @author Doro
 * das Programm fordert den Benutzer zur Eingabe zweier Zahlen x
 * und y auf und berechnet dann x^y
 *
 */
public class PotenzberechnungMitExceptions {

	/**
	 * rechnet x hoch y aus
	 * @param x Basis
	 * @param y Exponent
	 * @return x hoch y
	 * @throws NullHochNullException wenn x und y beide 0 sind
	 * @throws ArithmeticException wenn versucht wird, 0 hoch eine negative Zahl zu rechnen
	 */
	public static double potenzieren(double x, int y) 
			throws NullHochNullException, ArithmeticException
	{
		if(x == 0 && y < 0)
			throw new ArithmeticException("0 hoch negativer Exponent ist nicht erlaubt");
		int gemerkt = y;
		double ergebnis;
		if (y <= 0)
        {
            y = -y;
        }
		//Keine Fehlerbehebung nötig, weil der Fehler hier nicht auftreten kann
        ergebnis = positivPotenzieren(x, y);
		if (gemerkt < 0) {
			ergebnis = 1 / ergebnis;
		}
		return ergebnis;
	}

	/**
	 * rechnet x hoch y aus
	 * @param x Basis
	 * @param y positiver Exponent
	 * @return x hoch y
	 * @throws IllegalArgumentException wenn y negativ ist
	 * @throws NullHochNullException wenn x und y beide 0 sind
	 */
	public static double positivPotenzieren(double x, int y)
			throws IllegalArgumentException, NullHochNullException
	{
		if(y < 0)
		{
			//System.out.println("Das geht nichts. Der Exponent darf nicht negativ sein");
			IllegalArgumentException ex;
			ex = new IllegalArgumentException();
			throw ex;   //Methode wird abgebrochen, weiter bei der
						//nächsten auf dem Aufrufstack
		}
		if( y == 0 && x == 0)
		{
			throw new NullHochNullException();
		}
	    double ergebnis;
		ergebnis = 1;
		for (int i = 1; i <= y; i++) {
			ergebnis = ergebnis * x;
		}
		return ergebnis;
	}

	/**
	 * Potenzberechnung
	 * @param args wird nicht benutzt
	 */
	public static void main(String[] args) {
		double x;
		double potenz;
		int eingabeExponent;

		System.out.println("Willkommen bei der Potenzberechung!");
		do {
//			try {
				x = EinAusgabe.eingabeKommazahl("Basis: ");
/*			} catch (InputMismatchException e)
			{
				x = 0;
			}
*/
            eingabeExponent = EinAusgabe.eingabeGanzzahl("Exponent: ");

            try {
				potenz = potenzieren(x, eingabeExponent);
				System.out.println(x + " hoch " + eingabeExponent + " = " + potenz);
			} catch (NullHochNullException | ArithmeticException ex) {
				System.out.println("Du hast ja keine Ahnung von Mathematik!");
				System.out.println(ex.getMessage());
			} 
/*            catch (ArithmeticException e)
            {
				System.out.println("0 hoch negative Zahl geht doch nicht...");
            }
*/
		} while (EinAusgabe.wiederholungGewuenscht());

	}

}

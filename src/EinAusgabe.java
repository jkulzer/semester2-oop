import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Praktische Methoden für Ein- und Ausgabe
 */
public class EinAusgabe {
	
	/**
	 * wandelt den Text in x in Großbuchstaben um
	 * @param x der umzuwandelnde Text
	 */
	public static void grossSchreiben(StringBuilder x)
	{
		for(int i = 0; i < x.length(); i++)
		{
			x.setCharAt(i, Character.toUpperCase(x.charAt(i)));
		}
	}
    /**
     * liest ein Zeichen vom Benutzer ein
     * @param aufforderung Text der als Eingabeaufforderung auf der Konsole
     * 	                   erscheinen soll
     * @return vom Benutzer eingegebenes Zeichen
     * @throws StringIndexOutOfBoundsException wenn der Benutzer nichts eingibt
     */
    public static char eingabeZeichen(String aufforderung)
    							throws StringIndexOutOfBoundsException
    {
		Scanner tastatur;
		tastatur = new Scanner(System.in);	
		System.out.print(aufforderung);
		char zeichen = tastatur.nextLine().charAt(0);
		return zeichen;
    }
    
    /**
     * liest eine Zahl vom Benutzer ein
     * @param aufforderung Text der als Eingabeaufforderung auf der Konsole
     * 	                   erscheinen soll
     * @return vom Benutzer eingegebene Zahl
     */
    public static double eingabeKommazahl(String aufforderung) {
		Scanner tastatur;
		double zahl;
		boolean failureReadingDouble;

		failureReadingDouble = false;
		tastatur = new Scanner(System.in);

		do {
			System.out.print(aufforderung);
			if (tastatur.hasNextDouble() == true) {
				zahl = tastatur.nextDouble();
				failureReadingDouble = false;
				return zahl;
			} else {
				failureReadingDouble = true;
				tastatur.next();
				System.out.println("Enter a valid double!");
			}
		} while (failureReadingDouble == true);
		return 0;

    }
    
    /**
     * liest eine Zahl vom Benutzer ein
     * @param aufforderung Text der als Eingabeaufforderung auf der Konsole
     * 	                   erscheinen soll
     * @return vom Benutzer eingegebene Zahl
     */
    public static int eingabeGanzzahl(String aufforderung) {
		Scanner tastatur;
		tastatur = new Scanner(System.in);
        int zahl;
		boolean failureReadingInt;

		failureReadingInt = false;


		do {
			try {
				System.out.print(aufforderung);
				zahl = tastatur.nextInt();
				return zahl;
			} catch (InputMismatchException e) {
				System.out.println("Enter a valid integer!");
				tastatur.next();
				failureReadingInt = true;
			}
		} while (failureReadingInt == true);
        return 0;
    }
 
    /**
     * fragt den Benutzer, ob eine Programmwiederholung gewünscht
     * wird.
     * @return true, wenn eine Wiederholung gewünscht wird
     */
    public static boolean wiederholungGewuenscht() {
    	char antwort;
    	do
    	{
    		try {
    			antwort = EinAusgabe.eingabeZeichen("Programmwiederholung? (y/Y/n/N)");
    		} catch (StringIndexOutOfBoundsException e)
    		{
    			return false;
    		}
    	} while (antwort != 'y' && antwort != 'n' && antwort != 'Y' && antwort != 'N');
    	return antwort == 'y' || antwort == 'Y';
    }

	/**
	 * Read Date from user
	 * @param sprache Locale to use
	 * @return
	 */
	public static LocalDate eingabeDatum(Locale sprache) {
		Scanner scanner;
		String inputDate;
		LocalDate date;
		DateTimeFormatter formatter;

		scanner = new Scanner(System.in);

		inputDate = scanner.nextLine();

		try {
			date = LocalDate.parse(inputDate);
		} catch (Exception e) {
			try {
				formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
				date = LocalDate.parse(inputDate, formatter);
			} catch (Exception e1) {
				try {
					formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
					date = LocalDate.parse(inputDate, formatter);
				} catch (Exception e2) {
					formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
					date = LocalDate.parse(inputDate, formatter);
				}
			}
		}

		return date;
	}

}

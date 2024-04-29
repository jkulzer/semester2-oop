package kommunikation;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Nützliche Methoden für Ein- und Ausgaben auf der Konsole
 */
public class EinAusgabe {
	/**
	 * liest ein Datum vom Benutzer ein
	 * @param sprache gewünschte Sprache für die Datumseingabe
	 * @return das eingegebene Datum
	 */
	public static LocalDate eingabeDatum(Locale sprache)
	{
		Scanner tastatur = new Scanner(System.in);
		do
		{
			String eingabe = tastatur.nextLine();
			LocalDate datum;
			DateTimeFormatter df = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
			df = df.withLocale(sprache);
			try {
				datum = LocalDate.parse(eingabe);
				return datum;
			} catch (DateTimeException e)
			{
				try {
					datum = LocalDate.parse(eingabe, df);
					return datum;
				} catch (DateTimeException e1)
				{
					df = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
					df = df.withLocale(sprache);
					try {
						datum = LocalDate.parse(eingabe, df);
						return datum;
					}
					catch (DateTimeException e2)
					{
						df = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
						df = df.withLocale(sprache);
						try {
							datum = LocalDate.parse(eingabe, df);
							return datum;
						} catch (DateTimeException e3)
						{
							System.out.println("Das ist kein Datum...");
						}
					}
				}
			}
			
		} while(true);
	}
	/**
	 * formatiert datum in der Form „Tag. Monatsname vierstelligesJahr“ 
	 * @param datum das zu formatierende Datum
	 * @return String mit dem formatierten Datum
	 */
	public static String datumFormatieren(LocalDate datum)
	{
		DateTimeFormatter df = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		return df.format(datum);
	}
	
	/**
	 * formatiert datum in der Form „Tag. Monatsname vierstelligesJahr“ gemäß l
	 * @param datum das zu formatierende Datum
	 * @param l gewünschte Spracheinstellungen
	 * @return String mit dem formatierten Datum
	 */
	public static String datumFormatieren(LocalDate datum, Locale l)
	{
		DateTimeFormatter df = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		df = df.withLocale(l);
		return df.format(datum);
	}
	
	/**
	 * fordert den Benutzer zur Eingabe einer positiven double-Zahl auf
	 * @param aufforderung Aufforderungstext, der auf der Konsole erscheint
	 * @param fehlermeldung Fehlermeldung bei der Eingabe einer negativen Zahl
	 * @return die eingegebenen Zahl
	 */
	public static double eingabePositiveKommazahl(String aufforderung, String fehlermeldung)
	{
		Scanner tastatur = new Scanner(System.in);
		System.out.println(aufforderung);
		double zahl;
		do {
			zahl = tastatur.nextDouble();
			if(zahl < 0)
				System.out.println(fehlermeldung);
		} while(zahl < 0);
		return zahl;
	}
	
    /**
     * liest ein Zeichen vom Benutzer ein
     * @param aufforderung Text der als Eingabeaufforderung auf der Konsole
     * 	                   erscheinen soll
     * @return vom Benutzer eingegebenes Zeichen
     */
    public static char eingabeZeichen(String aufforderung)
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
    public static double eingabeKommazahl(String aufforderung)
    {
		Scanner tastatur;
		tastatur = new Scanner(System.in);	
		System.out.print(aufforderung);
		do {
			if(tastatur.hasNextDouble()) {
				double zahl = tastatur.nextDouble();
				return zahl;
			}
			else
			{
				System.out.println("Das war keine Zahl!");
				tastatur.next();
			}
		} while(true);
    }
    
    /**
     * liest eine Zahl vom Benutzer ein
     * @param aufforderung Text der als Eingabeaufforderung auf der Konsole
     * 	                   erscheinen soll
     * @return vom Benutzer eingegebene Zahl
     */
    public static int eingabeGanzzahl(String aufforderung)
    {
		Scanner tastatur;
		tastatur = new Scanner(System.in);
		do {
			System.out.print(aufforderung);
			try {
				int zahl = tastatur.nextInt();
				return zahl;
			} catch (InputMismatchException e)
			{
				System.out.println("Das war keine ganze Zahl!");
				tastatur.next();
			}
		} while (true);
    }
 
    /**
     * fragt den Benutzer, ob eine Programmwiederholung gewünscht
     * wird.
     * @return true, wenn eine Wiederholung gewünscht wird
     */
    public static boolean wiederholungGewuenscht()
    {
    	char antwort;
    	do
    	{
    	antwort = EinAusgabe.eingabeZeichen("Programmwiederholung? (j/J/n/N)");
    	} while (antwort != 'j' && antwort != 'n' && antwort != 'J' && antwort != 'N');
    	return antwort == 'j' || antwort == 'J';
    }
	
	/**
	 * gibt eine Begrüßung aus, die den Accountnamen beinhaltet
	 */
	public static void begruessung()
	{
		String name = System.getProperty("user.name");
		System.out.println("Hallo, liebe/r " + name);
	}

}

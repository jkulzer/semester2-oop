package interfacebenutzung;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author Doro
 * 
 */
public class Interfacebenutzung {
	
	/**
	 * gibt liste auf der Konsole aus
	 * @param liste Das auszugebende Array
	 * @param formatcodetraeger Die Formatierung, die für die Ausgabe zu nutzen ist
	 */
	public static void ausgeben(KontoEinfach[] liste, 
				Formatierung formatcodetraeger)
	{
		for(int i=0; i< liste.length; i++)
		{
			System.out.println(formatcodetraeger.formatieren(liste[i]));
		}
	}

	/**
	 * sortiert x
	 * @throws NullPointerException wenn x == null
	 */
	public static void anwenden(int[] x) {
		boolean nichtFertig = true;
		int temp;
		while (nichtFertig) 
		{
			nichtFertig = false;          
			for (int i = 0; i < x.length - 1; i++) 
			{
				if (x[i] > x[i + 1]) 
				{
					temp = x[i];
					x[i] = x[i + 1];
					x[i + 1] = temp;
					nichtFertig = true; 
				}
			}
		}
	}
	
	/**
	 * sortiert x
	 * @throws NullPointerException wenn x == null
	 */
	public static void anwenden(Comparable[] x) {
		boolean nichtFertig = true;
		Comparable temp;
		while (nichtFertig) 
		{
			nichtFertig = false;          
			for (int i = 0; i < x.length - 1; i++) 
			{
				if (x[i].compareTo(x[i + 1]) > 0) 
				{
					temp = x[i];
					x[i] = x[i + 1];
					x[i + 1] = temp;
					nichtFertig = true; 
				}
			}
		}
	}
	
	/**
	 * sortiert x
	 * @throws NullPointerException wenn x == null
	 */
	public static void anwenden(Object[] x, Vergleicher vergleichscodetraeger) {
		boolean nichtFertig = true;
		Object temp;
		while (nichtFertig) 
		{
			nichtFertig = false;          
			for (int i = 0; i < x.length - 1; i++) 
			{
				if (vergleichscodetraeger.isGroesser(x[i],x[i + 1])) 
				{
					temp = x[i];
					x[i] = x[i + 1];
					x[i + 1] = temp;
					nichtFertig = true; 
				}
			}
		}
	}


	/**
	 * ruft anwenden für einige Arrays auf
	 * @param args wird nicht benutzt
	 */
	public static void main(String[] args) {
		int[] liste = { 0, 9, 4, 6, 2, 8, 5, 1, 7, 3 };
		anwenden(liste);
		System.out.println(Arrays.toString(liste));
		System.out.println();
		
		String[] liste2 = { "Physalis", "Apfel", "Orange", "Birne", "Ananas" };
		anwenden(liste2);
		System.out.println(Arrays.toString(liste2));
		System.out.println();
		
		BigDecimal[] liste3 = { new BigDecimal("123.45736"), new BigDecimal("666"),
				              new BigDecimal("100.1234567891234"), new BigDecimal("345.677"),
				              new BigDecimal("9999.9")};
		anwenden(liste3);
		System.out.println(Arrays.toString(liste3));
		System.out.println("-------------------------------");
		
		Vergleicher y = (a, b) -> ((BigDecimal) a).scale() - ((BigDecimal) b).scale();
		anwenden(liste3, y);
		System.out.println(Arrays.toString(liste3));
		System.out.println();
		
		KontoEinfach[] liste4 = { new KontoEinfach("hans", 1246734, 9999),
						   new KontoEinfach("Otto", 895975696, 456), 
						   new KontoEinfach(),
						   new KontoEinfach("Eva", 773377448, 100) };
		anwenden(liste4);
		//System.out.println(Arrays.toString(liste4));
/*		Formatierung f = new Formatierung() {

			@Override
			public String formatieren(KontoEinfach k) {
					return k.getKontonummer() + ": " + k.getKontostand()
					+ "(" + k.getInhaber()+")";
			}

		};
		*/
		Formatierung f = k -> 
			k.getKontonummer() + ": " + k.getKontostand() + "(" + k.getInhaber()+")";
		ausgeben(liste4, f);
		System.out.println();
		System.out.println("--------------------------------");
		
		KontoVergleicher x = new KontoVergleicher();
		anwenden(liste4, x);
		System.out.println(Arrays.toString(liste4));
		

	}

}

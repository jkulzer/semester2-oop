package mathematik;

import kommunikation.EinAusgabe;

/**
 * Methoden zur Bruchrechnung
 */
public class Bruchrechnen {
 
    /**
     * Erstellt ein paar Brüche und rechnet damit
     * @param args wird nicht verwendet
     */
	public static void main(String[] args) {
		int z;
		int n;
		Bruch a = null;
		Bruch b = null;
		
		z = EinAusgabe.eingabeGanzzahl("Bitte Zähler des ersten Bruches eingeben: ");
		do 
		{
			n = EinAusgabe.eingabeGanzzahl("Bitte Nenner des ersten Bruches eingeben: ");
			if(n == 0)
				System.out.println("0 im Nenner ist verboten");
		} while (n == 0);
		try {
			a = new Bruch(z, n);
		} catch (NennerIstNullException e) {
		}
		
		z = EinAusgabe.eingabeGanzzahl("Bitte Zähler des zweiten Bruches eingeben: ");
		do
		{
			n = EinAusgabe.eingabeGanzzahl("Bitte Nenner des zweiten Bruches eingeben: ");
			if(n == 0)
				System.out.println("0 im Nenner ist verboten");
		} while (n == 0);
		try {
			b = new Bruch(z, n);
		} catch (NennerIstNullException e) {
		}
		
		Bruch produkt;
		produkt = a.multiplizieren(b);
		System.out.println(a + " * " + b + " = " + produkt);
		produkt.kuerzen();
		System.out.println("Gekürzt: " + produkt);
		
		Bruch quotient;
		try {
			quotient = a.dividieren(b);
			System.out.println(a + " / " + b + " = " + quotient);		
			quotient.kuerzen();
			System.out.println("Gekürzt: " + quotient);
		} catch (NennerIstNullException e) {
			System.out.println("Durch den Bruch 0 kann man nicht teilen.");
		}
		
	}

}

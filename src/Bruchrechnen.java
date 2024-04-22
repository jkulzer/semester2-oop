/**
 * Methoden zur Bruchrechnung
 */
public class Bruchrechnen {
    /**
     * Berechnet den Gleitkommawert des Bruchs
     * @return Wert des Bruchs als Gleitkommazahl (double)
     */
    public static double ausrechnen(Bruch a){
        return (double) a.getZaehler() / a.getNenner();
    }

    /**
     * Kürzt den aufrufenden Bruch
     */
    public static void kuerzen(Bruch a){
        int ggt = ggt(a.getZaehler(), a.getNenner());
        a.setZaehler(a.getZaehler()/ggt);
        a.setNenner(a.getNenner()/ggt);
    }
    
    /**
     * Multipliziert den Bruch this mit dem übergebenen Bruch b und gibt das Ergebtnis als Bruch zurück.
     * @param b Bruch mit dem multipliziert werden soll
     * @return Ergebnis der Multiplikation als Bruch
     */
    public static Bruch multiplizieren(Bruch a, Bruch b){
        Bruch temp;
		temp = new Bruch(a.getZaehler() * b.getZaehler(), a.getNenner() * b.getNenner());
        return temp;
    }

    /**
     * Berechnet den Kehrwert des aufrufenden Bruchs und gibt diesen zurück
     * @return Kehrwert vom Typ Bruch
     */
    public static Bruch kehrwert(Bruch a) {
        if (a.getZaehler() == 0) {
            return new Bruch(0, 1);
        } else {
            return new Bruch(a.getNenner(), a.getZaehler());
        }
    }

    /**
     * Dividiert den aufrufenden Bruch durch den übergebenen Bruch b
     * @param b Bruch durch den dividiert werden soll
     * @return Ergebnis der Division als Bruch
     */
    public static Bruch dividieren(Bruch a, Bruch b) {
        return Bruchrechnen.multiplizieren(a, Bruchrechnen.kehrwert(b));
    }
    
    /**
     * Berechnet den größten gemeinsamen Teil von zwei Werten
     * @param a 1.Wert
     * @param b 2.Wert
     * @return ggT als Integer
     */
    public static int ggt(int a, int b){
        if(a == 0)
            return b;
        while(b != 0)
        {
        	if(a > b)
        		a = a - b;
        	else
        		b = b - a;
        }
        return a;
    }

    /**
     * Erstellt ein paar Brüche und rechnet damit
     * @param args wird nicht verwendet
     */
	public static void main(String[] args) {
		int z;
		int n;
		Bruch a;
		Bruch b;
        boolean invalidDenominator;
		
		z = EinAusgabe.eingabeGanzzahl("Bitte Zähler des ersten Bruches eingeben: ");
        do {
            n = EinAusgabe.eingabeGanzzahl("Bitte Nenner des ersten Bruches eingeben: ");
            if (n == 0) {
                System.out.println("Invalid denominator!");
            }
        } while (n == 0);

		a = new Bruch(z, n);
		
		z = EinAusgabe.eingabeGanzzahl("Bitte Zähler des zweiten Bruches eingeben: ");
        do {
            n = EinAusgabe.eingabeGanzzahl("Bitte Nenner des zweiten Bruches eingeben: ");
            if (n == 0) {
                System.out.println("Invalid denominator!");
            }
        } while (n == 0);
		b = new Bruch(z, n);
		
		Bruch produkt;
		produkt = Bruchrechnen.multiplizieren(a, b);
		System.out.println(a + " * " + b + " = " + produkt);
		Bruchrechnen.kuerzen(produkt);
		System.out.println("Gekürzt: " + produkt);
		
		Bruch quotient;
		quotient = Bruchrechnen.dividieren(a, b);
		System.out.println(a + " / " + b + " = " + quotient);		
		Bruchrechnen.kuerzen(quotient);
		System.out.println("Gekürzt: " + quotient);
	}

}

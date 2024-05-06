package geometrie;

/**
 * gibt die Daten einiger geonetrischer Figuren auf der Konsole aus
 */
public class GeometrieSpielereien {

	/**
	 * gibt die Daten einiger geonetrischer Figuren auf der Konsole aus
	 * @param args wird nicht verwendet
	 */
	public static void main(String[] args) {
		Rechteck r = new Rechteck(0, 0, 6, 8);
		Quadrat q = new Quadrat(0, 0, 9);

		GeoAusgabe.ausgeben(r);
		GeoAusgabe.ausgeben(q);
		//Kreis k = new Kreis(1, 7, 4);
		

	}

}

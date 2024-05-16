package interfacebenutzung;

/**
 * formatiert KontoEinfach-Objekte für die Ausgabe
 */
public interface Formatierung {
	/**
	 * auszugebende Darstellung von k
	 * @param k
	 * @return
	 */
	String formatieren(KontoEinfach k);
}

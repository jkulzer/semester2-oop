package interfacebenutzung;
/**
 * trägt den Code, um zwei Objekte miteinander zu vergleichen
 */
public interface Vergleicher {
	/**
	 * vergleicht eins und zwei
	 * @param eins
	 * @param zwei
	 * @return < 0, wenn eins < zwei, == 0, 
	 * wenn eins == zwei, > 0 , wenn eins > zwei
	 * @throws IllegalArgumentException wenn die Objekte nicht vergleichbar sind
	 */
	int vergleichen(Object eins, Object zwei);
	/**
	 * true, wenn a > b
	 * @param a
	 * @param b
	 * @return
	 * @throws IllegalArgumentException wenn die Objekte nicht vergleichbar sind
	 */
	default boolean isGroesser(Object a, Object b)
	{
		return this.vergleichen(a, b) > 0;
	}
	
	
	/**
	 * prüft, ob a kleiner b
	 * @param a erstes zu vergleichesdes Objekt
	 * @param b zweites zu vergleichendes Objekt
	 * @return a kleiner b
	 * @throws IllegalArgumentException wenn a und b nicht verglichen werden können
	 */
	default public boolean isKleiner(Object a, Object b)
	{
		return this.vergleichen(a,  b) < 0;
	}
	
	/**
	 * prüft, ob a == b
	 * @param a erstes zu vergleichesdes Objekt
	 * @param b zweites zu vergleichendes Objekt
	 * @return a == b
	 * @throws IllegalArgumentException wenn a und b nicht verglichen werden können
	 */
	default public boolean isGleich(Object a, Object b)
	{
		return this.vergleichen(a,  b) == 0;
	}

	
}

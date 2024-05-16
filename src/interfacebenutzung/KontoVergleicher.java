package interfacebenutzung;

/**Vergleicher für KontoEinfach nach dem Namen des Kontoinhabers
 * 
 */
public class KontoVergleicher implements Vergleicher {

	@Override
	public int vergleichen(Object eins, Object zwei) {
		if(eins instanceof KontoEinfach && zwei instanceof KontoEinfach )
		{
			KontoEinfach k1 = (KontoEinfach) eins;
			KontoEinfach k2 = (KontoEinfach) zwei;
			return k1.getInhaber().compareToIgnoreCase(k2.getInhaber());
		}
		else
			throw new IllegalArgumentException();
			
	}

}

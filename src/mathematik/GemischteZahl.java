package mathematik;

/**
 * Stellt eine Gemischte Zahl als der Mathematik dar, also eine Kombination
 * aus ganzer Zahl und echtem Bruch
 */
public class GemischteZahl {
	private Bruch wert;
	/**
	 * Gemischte Zahl mit dem Wert wert
	 * @param wert Wert der Gemischten Zahl
	 */
	public GemischteZahl(Bruch wert)
	{
		if(wert == null)
			throw new IllegalArgumentException();
		this.wert = wert;
	}
	
	/**
	 * Gemischte Zahl mit dem Wert zahl + rest, wenn zahl > 0 ist, 
	 * bzw. zahl - rest, wenn zahl negativ ist
	 * @param zahl der ganzzahlige Anteil an der Gemischten Zahl; zahl bestimmt über das Vorzeichen auch des Bruches
	 * @param rest der echte Bruch-Anteil der Gemischten Zahl
	 * @throws IllegalArgumentException wenn rest null ist
	 * @throws AufbauGemischteZahlFalschException wenn rest kein echter Bruch oder negativ ist
	 */
	public GemischteZahl(int zahl, Bruch rest)
	{
		if(rest == null)
			throw new IllegalArgumentException("Bruch-Rest ist null");
		if(rest.getWert() >= 1 || rest.getWert() < 0)
			throw new AufbauGemischteZahlFalschException();		
		try {
			if(zahl > 0)
				this.wert = new Bruch(zahl * rest.getNenner()+ rest.getZaehler(), rest.getNenner());
			else
				this.wert = new Bruch(zahl * rest.getNenner()- rest.getZaehler(), rest.getNenner());
		} catch (NennerIstNullException e) {}
	}

	/**
	 * stellt die Gemischte Zahl zahl zaehler/nenner dar
	 * @see GemischteZahl(int, Bruch)
	 * @param zahl der ganzzahlige Anteil an der Gemischten Zahl; zahl bestimmt über das Vorzeichen auch des Bruches
	 * @param zaehler Zähler des Bruch-Anteils
	 * @param nenner Nenner des Bruch-Anteils
	 * @throws NennerIstNullException wenn nenner 0 ist
	 * 	 * @throws AufbauGemischteZahlFalschException wenn zaehler/nenner kein echter Bruch oder negativ ist
	 */
	public GemischteZahl(int zahl, int zaehler, int nenner) throws NennerIstNullException
	{
			this(zahl, new Bruch(zaehler, nenner));
	}
	
	/**
	 * berechnet this * b
	 * @param b Faktor der Multiplikation
	 * @return this * b
	 */
	public GemischteZahl multiplizieren(GemischteZahl b)
	{
		return new GemischteZahl(this.wert.multiplizieren(b.getAlsBruch()));
	}

	/**
	 * gibt this als Bruch zurück
	 * @return Wert von this als Bruch
	 */
	public Bruch getAlsBruch() {
		return this.wert;
	}
	
	/**
	 * Wert von this als Fließkommazahl
	 * @return Wert von this
	 */
	public double getWert() {
		return this.wert.getWert();
	}
	
	/**
	 * teilt this durch b
	 * @param b Divisor
	 * @return this / b
	 * @throws NennerIstNullException wenn b den Wert 0 hat
	 */
	public GemischteZahl dividieren(GemischteZahl b) throws NennerIstNullException
	{
		return new GemischteZahl(this.wert.dividieren(b.getAlsBruch()));
	}
	
	@Override
	public String toString()
	{
		int zahl = (int) this.wert.getWert();
		int zaehler = Math.abs(this.wert.getZaehler() % this.wert.getNenner());
		return zahl + " "+zaehler+"/"+this.wert.getNenner();
	}
}

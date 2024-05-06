package bankprojekt;

import bankprojekt.exceptions.GesperrtException;

/** ein Girokonto, eine spezielle Art eines Bankkontos
 * 
 */
public class Girokonto extends Konto {
	/**
	 * Der Betrag, bis zu dem das Konto überzogen werden kann
	 */
	private double dispo;
	
	/**
	 * erstellt ein neues Girokonto von Hans Otto mit 10 € Startguthaben
	 * und einem Dispo von 555 €
	 */
	public Girokonto()
	{
		this(
				new Kunde("Hans", "Otto"),
				10,
				555
		);
	}
	
	/**
	 * erstellt ein Girokonto für den angegebenen Inhaber mit dem angegebenen Startguthaben
	 * und dem gewünschten Dispo
	 * @param inhaber Kontoinhaber
	 * @param anfang Startguthaben; darf nicht negativ sein
	 * @param dispo Dispo, darf nicht negativ sein
	 * @throws IllegalArgumentException wenn inhaber null 
	 */
	public Girokonto(Kunde inhaber, double anfang, double dispo)
	{
		super(inhaber, anfang);
		this.dispo = Math.max(0.0, dispo);
	}

	/**
	 * Dispo von this
	 * @return the dispo
	 */
	public double getDispo() {
		return dispo;
	}

	/**
	 * setzt den Dispo von this
	 * @param dispo der neue Dispo; darf nicht negativ sein
	 */
	public void setDispo(double dispo) {
		this.dispo = Math.max(0.0, dispo);
	}
	
	/**
     * bucht den angegebenen Betrag von this als Überweisung ab, 
     * falls es nicht gesperrt ist und alle kontospezifischen 
     * Regeln für die Überweisung eingehalten werden.
     * Am Empfängerkonto wird keine Änderung vorgenommen, da davon ausgegangen wird, dass dieses sich
     * bei einer anderen Bank befindet.
     * @param betrag double
     * @param empfaenger String
     * @param nachKontonr int
     * @param nachBlz int
     * @param verwendungszweck String
     * @return boolean true, wenn die Überweisungsabbuchung ausgeführt wurde,
     *                 false, wenn nicht
     * @throws IllegalArgumentException wenn der Betrag negativ bzw. NaN ist oder
     * 									empfaenger oder verwendungszweck null ist
     * @throws GesperrtException wenn this gesperrt ist
     */
    public boolean ueberweisungAbsenden(double betrag, 
    		String empfaenger, long nachKontonr, 
    		long nachBlz, String verwendungszweck) 
    				throws GesperrtException 
    {
      if (this.isGesperrt())
            throw new GesperrtException();
        if (betrag < 0 || Double.isNaN(betrag) || empfaenger == null || verwendungszweck == null)
            throw new IllegalArgumentException("Parameter fehlerhaft");
        if (getKontostand() - betrag >= - dispo)
        {
        	this.setKontostand(getKontostand() - betrag);
            return true;
        }
        else
        	return false;
    }

       /**
     * this empfängt den angegebenen betrag per Überweisung
     * @param betrag double
     * @param vonName String
     * @param vonKontonr int
     * @param vonBlz int
     * @param verwendungszweck String
     *      * @throws IllegalArgumentException wenn der Betrag negativ bzw. NaN ist oder
     * 									vonName oder verwendungszweck null ist
     */
    public void ueberweisungEmpfangen(double betrag, String vonName, 
    		long vonKontonr, long vonBlz, String verwendungszweck)
    {
        if (betrag < 0 || Double.isNaN(betrag) || vonName == null || verwendungszweck == null)
            throw new IllegalArgumentException("Parameter fehlerhaft");
        this.setKontostand(getKontostand() + betrag);
    }
    
    @Override
    public String toString()
    {
    	return "-- GIROKONTO --" + System.lineSeparator() 
    	+ super.toString() + "Dispo: " + this.dispo;
    }
    
    public double getVerfuegbarerBetrag()
    {
    	return this.dispo + this.getKontostand();
    }
	
}

/**
 * Mit der Klasse Bruch wird eine Klasse bereitgestellt die das grundlegende Arbeiten mit
 * Brüchen ermöglicht.
 */
public class Bruch{

    /**
     * Speichert den Zähler des Bruchs
     */
    private int zaehler;

    /**
     * Speichert den Nenner des Bruchs
     */
    private int nenner;

    /**
     * erstellt einen Bruch aus den übergebenen Werten
     * @param zaehler Zähler der gesetzt werden soll
     * @param nenner Nenner der gesetzt werden soll, darf nicht 0 sein
     */ 
    public Bruch(int zaehler, int nenner) {
            this.zaehler = zaehler;
            this.nenner = nenner;
    }

    /**
     * Getter für zaehler
     * @return Wert von zaehler
     */
    public int getZaehler() {
        return zaehler;
    }

    /**
     * Getter für nenner
     * @return Wert von nenner
     */
    public int getNenner() {
        return nenner;
    }

    /**
	 * Setter für den Zähler
	 * @param zaehler the zaehler to set
	 */
	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
	}

	/**
	 * Setter für den Nenner
	 * @param nenner the nenner to set
	 */
	public void setNenner(int nenner){
		this.nenner = nenner;
	}

	@Override
    public String toString(){
        return zaehler + "/" + nenner;
    }
}

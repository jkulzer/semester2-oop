package mathematik;
/**
 * Mit der Klasse Bruch wird eine Klasse bereitgestellt, 
 * die das grundlegende Arbeiten mit
 * mathematischen Brüchen ermöglicht.
 */
public class Bruch {

    /**
     * Speichert den Zähler des Bruchs
     */
    private int zaehler;

    /**
     * Speichert den Nenner des Bruchs
     */
    private int nenner;

    /**
     * Konstruktor der Klasse, bekommt den Nenner und Zähler übergeben und bringt diese in
     * die Normalform, bei der das negative Vorzeichen vor dem Zähler steht bzw. negative Vorzeichen vor Nenner und Zähler sich aufheben.
     * @param zaehler Zähler, der gesetzt werden soll
     * @param nenner Nenner, der gesetzt werden soll, darf nicht 0 sein
     * @throws NennerIstNullException wenn der nenner 0 ist
     */
    public Bruch(int zaehler, int nenner) throws NennerIstNullException {
    	if (nenner == 0)
            throw new NennerIstNullException();
        if(nenner < 0){
            this.zaehler = zaehler * -1;
            this.nenner = nenner * -1;
        }else{
            this.zaehler = zaehler;
            this.nenner = nenner;
        }
    }
    
    /**
     * Konstruktor der Klasse, bekommt den Zähler übergeben
     * @param zaehler Zähler, der gesetzt werden soll
     */
    public Bruch(int zaehler) {
    	this.zaehler = zaehler;
    	this.nenner = 1;
    }

    /**
     * Getter für Zähler
     * @return Wert von zaehler
     */
    public int getZaehler() {
        return zaehler;
    }

    /**
     * Getter für Nenner
     * @return Wert von nenner
     */
    public int getNenner() {
        return nenner;
    }

    /**
     * Multipliziert den Bruch this mit dem übergebenen Bruch b
     * @param b Bruch, mit dem multipliziert werden soll
     * @return Ergebnis der Multiplikation als Bruch
     * @throws NullPointerException wenn b == null
     */
    public Bruch multiplizieren(Bruch b){
    	try {
        Bruch temp = new Bruch(this.zaehler * b.zaehler, 
        		this.nenner * b.nenner);
        return temp;
    	} catch (NennerIstNullException e)
    	{
    		return null; //tritt nicht auf
    	}
    }
    
    /**
     * Multipliziert den Bruch this mit der übergebenen zahl
     * @param zahl Zahl, mit der multipliziert werden soll
     * @return Ergebnis der Multiplikation als Bruch
     */
    public Bruch multiplizieren(int zahl){
        return this.multiplizieren(new Bruch(zahl));
    }

    /**
     * Berechnet den Gleitkommawert des Bruchs
     * @return Wert des Bruchs als Gleitkommazahl (double)
     */
    public double getWert(){
        return (double) zaehler / nenner;
    }

    /**
     * Kürzt this
     */
    public void kuerzen(){
        int ggt = Mathealgorithmen.ggt(this.zaehler, this.nenner);
        this.zaehler /= ggt;
        this.nenner /= ggt;
    }

    /**
     * Berechnet den Kehrwert von this und gibt diesen zurück
     * @return Kehrwert vom Typ Bruch
     * @throws NennerIstNullException wenn der Zähler von this 0 ist
     */
    public Bruch kehrwert() throws NennerIstNullException{
        return new Bruch(this.nenner, this.zaehler);
    }

    /**
     * Dividiert this durch den übergebenen Bruch b
     * @param b Bruch, durch den dividiert werden soll
     * @return Quotient aus this und b
     * @throws NennerIstNullException wenn b = 0 ist
     * @throws NullPointerException wenn b == null ist
     */
    public Bruch dividieren(Bruch b) throws NennerIstNullException{
        return multiplizieren(b.kehrwert());
    }

    @Override
    public String toString(){
        return zaehler + "/" + nenner;
    }
}
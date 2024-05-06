package bankprojekt;

import bankprojekt.exceptions.GesperrtException;

public class Sparbuch extends Konto{

    private double zinssatz;

    /**
     * Creates a sparbuch with default zinssatz
     */
    public Sparbuch() {
        this.zinssatz = 1.5;
    }

    /**
     * Creates a sparbuch with defined Zinssatz
     * @param zinssatz
     */
    public Sparbuch(double zinssatz, Kunde customer) {
        this.setZinssatz(zinssatz );
        super.setKontostand(0);
        super.setInhaber(customer);
    }

    /**
     * Creates a sparbuch with a defined zinssatz and a new customer with known first and last name
     * @param zinssatz the zinssatz
     * @param firstName the first name of the customer
     * @param lastName the last name of the customer
     */
    public Sparbuch(double zinssatz, String firstName, String lastName) {
        super.setInhaber(
                new Kunde(firstName, lastName)
        );
        this.setZinssatz(zinssatz);
    }

    /**
     * Gets the fucking zinssatz
     * @return
     */
    public double getZinssatz() {
        return zinssatz;
    }

    /**
     * sets the zinssatz to a double not equals to zero
     * @param zinssatz
     * @throws IllegalArgumentException
     */
    public void setZinssatz(double zinssatz) throws IllegalArgumentException {
        if (zinssatz == 0.0) {
            throw new IllegalArgumentException();
        } else {
            this.zinssatz = zinssatz;
        };
    }

    /**
     * Gets the verfügbarer Betrag
     * @return the verfügbarer Betrag
     */
    public double getVerfuegbarerBetrag() {
        return this.getKontostand();
    }

    @Override
    public boolean abheben(double betrag) throws GesperrtException {
        if (
                (this.getKontostand() - betrag ) < 0.5
        ) {
            return false;
        } else {
            return super.abheben(betrag);
        }
    }

    public double getZinsen() {
        double kontostand;
        double zinsen;

        kontostand = super.getKontostand();
        zinsen = kontostand * (1 + this.getZinssatz() / 100) - kontostand;

        return zinsen;
    }

    /**
     *
     * @return the string created
     */
    @Override
    public String toString() {
        return super.toString() + "\nDer Zinssatz ist: "  + this.getZinssatz();
    }
}

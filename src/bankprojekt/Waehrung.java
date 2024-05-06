package bankprojekt;


public enum Waehrung {
    BGN(1.95583, "BGN"),
    DKK(7.46038, "DKK"),
    STN(24.5, "STN"),
    KMF(491.96775, "KMF"),
    EURO(1, "EUR");

    private Waehrung(double exchangerate, String shorthand) {
        this.exchangerate = exchangerate;
        this.shorthand = shorthand;
    }

    /**
     * the exchangerate
     */
    private final double exchangerate;
    /**
     * The shorthand for one one the currencies
     */
    private final String shorthand;

    /**
     * Converts a euro amount into the specified currency
     * @param euroAmount the euro amount you want to convert
     * @return the amount in the specified currency
     */
    public double euroInWaehrungUmrechnen(double euroAmount) {
        double exchangerate = this.getExchangerate();

        return euroAmount * exchangerate;
    }

    /**
     * Converts a specified amount of other currency into euros
     * @param waehrungBetrag The amount in non-euro currency to convert to euro
     * @return the amount in euros
     */
    public double waehrungInEuroUmrechnen(double waehrungBetrag) {
        double exchangerate = this.getExchangerate();

        return waehrungBetrag / exchangerate;
    }

    /**
     * Converts between two non-euro currencies
     * @param ziel the target currency
     * @param thisBetrag the amount of money in the origin currency
     * @return the amount of money in the target currency
     */
    public double vonThisInZielUmrechnen(Waehrung ziel, double thisBetrag) {
        double originExchangeRate = this.getExchangerate();
        double targetExchangeRate = ziel.getExchangerate();

        return (thisBetrag / originExchangeRate ) * targetExchangeRate;
    }

    /**
     * This is a getter, skill issue if you don't understand
     * @return
     */
    public double getExchangerate() {
        return exchangerate;
    }

    /**
     * saves the exchange rate and shorthand in a string
     * @return the string created
     */
    @Override
    public String toString() {
        return "Waehrung{" +
                "exchangerate=" + exchangerate +
                ", shorthand='" + shorthand + '\'' +
                '}';
    }
}

package geometrie;

/**
 * Basisklasse für geometrische geschlossene Flächen im 
 * zweidimensionalen Raum
 */
public class GeometrischeFigur {

    /** x-Koordinate des Mittelpunkts */
    private double xOrigin;

    /** y-Koordinate des Mittelpunkts */
    private double yOrigin;

    /**
     * Erstellt eine Fläche rund um den angegebenen Mittelpunkt
     * @param x x-Koordinate des Mittelpunktes
     * @param y y-Koordinate des Mittelpunktes
     */
    public GeometrischeFigur(double x, double y) {
        xOrigin = x;
        yOrigin = y;
    }

    /**
     * String-Darstellung des Mittelpunktes von this
     * 
     * @return Mittelpunkt in Koordinatenform
     */
    public String getMittelpunkt() {
        return ("(" + xOrigin + ", " + yOrigin + ")");
    }

    @Override
    public String toString() {
        return "Mittelpunkt bei den Koordinaten: " + getMittelpunkt();
    }

}

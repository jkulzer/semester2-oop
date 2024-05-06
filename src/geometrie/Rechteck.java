package geometrie;

public class Rechteck extends GeometrischeFigur{

    private double halfLength;
    private double halfWidth;

    /**
     *
     * @param x x-Koordinate des Mittelpunktes
     * @param y y-Koordinate des Mittelpunktes
     */
    public Rechteck(double x, double y) {
        super(x, y);
    }

    public Rechteck(int xOrigin, int yOrigin, double halfLength, double halfWidth) {
        super(xOrigin, yOrigin);
        this.halfLength = halfLength;
        this.halfWidth = halfWidth;
    }

    public double getArea() {
        return (halfLength * 2) * (halfWidth * 2);
    }

    @Override
    public String toString() {
        return "Length=" + halfLength * 2 + " Width " + halfWidth * 2;
    }
}

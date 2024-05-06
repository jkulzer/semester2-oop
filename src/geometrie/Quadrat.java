package geometrie;

public class Quadrat extends Rechteck{
    private double edgeLength;

    public Quadrat(double x, double y) {
        super(x, y);
    }

    public Quadrat(int xOrigin, int yOrigin, double halfLength) {
        super(xOrigin, yOrigin);
        this.edgeLength = halfLength * 2;
    }

    @Override
    public String toString() {
        return "edgeLength=" + edgeLength;
    }
}

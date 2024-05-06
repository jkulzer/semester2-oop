package mathematik;

import java.math.BigInteger;

/**
 * Sammlung von mathematischen Algorithmen, die man
 * immer mal wieder brauchen kann.
 * @version 1.0
 */
public class Mathealgorithmen {
    /**
     * Berechnet den größten gemeinsamen Teiler von zwei Werten
     * @param zaehler 1.Wert
     * @param nenner 2.Wert
     * @return ggT von zaehler und nenner als Integer
     * 	0, falls Zähler und Nenner = 0 sind, sollte aber beim Aufruf vermieden werden
     */
    public static int ggt(int zaehler, int nenner){
        BigInteger z = new BigInteger(zaehler + "");
        BigInteger n = new BigInteger(nenner +"");
        return z.gcd(n).intValue();
    }
}

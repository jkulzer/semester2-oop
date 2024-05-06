import bankprojekt.Kunde;
import bankprojekt.Sparbuch;
import bankprojekt.exceptions.GesperrtException;

public class Sparbuchamogus {
    public static void main(String[] args) {
        Sparbuch sp1;
        Sparbuch sp2;
        Sparbuch sp3;
        Sparbuch sp4;
        Kunde k1;

        k1 = new Kunde("Test", "test2");
        sp1 = new Sparbuch();
        sp2 = new Sparbuch(0.727, k1);
        sp3 = new Sparbuch(0.727, "amogus", "sus");

        sp1.einzahlen(727);
        sp2.einzahlen(727);
        sp3.einzahlen(727);

        try {
            if (sp1.abheben(726.8)) {
                System.out.println("Abheben von Konto mit Nummer " + sp1.getNummer() + " erfolgreich");
            } else {
                System.out.println("Abheben von Konto mit Nummer " + sp1.getNummer() + " nicht möglich");
            }
        } catch (GesperrtException e) {
            System.out.println("Sparbuch mit Nummer " + sp1.getNummer() +" gesperrt");
        }

        try {
            if (sp2.abheben(728)) {
                System.out.println("Abheben von Konto mit Nummer " + sp2.getNummer() + " erfolgreich");
            } else {
                System.out.println("Abheben von Konto mit Nummer " + sp2.getNummer() + " nicht möglich");
            }
        } catch (GesperrtException e) {
            System.out.println("Sparbuch mit Nummer " + sp2.getNummer() +" gesperrt");
        }

        try {
            if (sp3.abheben(100)) {
                System.out.println("Abheben von Konto mit Nummer " + sp3.getNummer() + " erfolgreich");
            } else {
                System.out.println("Abheben von Konto mit Nummer " + sp3.getNummer() + " nicht möglich");
            }
        } catch (GesperrtException e) {
            System.out.println("Sparbuch mit Nummer " + sp3.getNummer() +" gesperrt");
        }
    }
}

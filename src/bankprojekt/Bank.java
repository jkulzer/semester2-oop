package bankprojekt;

import bankprojekt.exceptions.AccountNotFoundException;
import bankprojekt.exceptions.GesperrtException;
import bankprojekt.exceptions.BetrugsversuchException;
import bankprojekt.exceptions.PoorCustomerException;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Bank {
    int bankleitzahl;
    String ort;

    TreeMap<Long, Konto> accounts;

    public Bank() {
        this.bankleitzahl = 0;
        this.ort = "UNKNOWN";
    }
    public Bank(int bankleitzahl, String ort) {
        if (bankleitzahl == 0 || ort.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.bankleitzahl = bankleitzahl;
            this.ort = ort;
            this.accounts = new TreeMap<>();
        }
    }

    /**
     * Opens a new konto of either sparbuch or girokonto type
     * @param inhaber
     * @param art
     * @return
     */
    public long kontoEroeffnen(Kunde inhaber, Kontoart art){
        Konto konto;

        switch (art) {
            case SPARBUCH -> konto = new Sparbuch(0,inhaber);
            case GIROKONTO -> konto = new Girokonto(inhaber, 0 , 0);
            default -> throw new IllegalStateException("Unexpected Kontotype: " + art);
        }

        this.accounts.put(konto.getNummer(),konto);

        return konto.getNummer();
    }

    /**
     * Removes a konto
     * @param nummer the long of the kontonummer to be removed
     * @return false if it failed and true if it succeeded
     */
    public boolean kontoAufloesen(long nummer) {
        if (this.accounts.get(nummer) == null) {
            return false;
        } else {
            this.accounts.remove(nummer);
        }

        return true;
    }

    public String getAlleKonten() {
        StringBuilder allAccounts = new StringBuilder();

        for (Konto k : this.accounts.values()) {
            allAccounts.append(";").append(k.getNummer()).append(",").append(k.getKontostandFormatiert());
        }

        return allAccounts.toString();
    }

    public List<Long> getAlleKontonummern() {
        return new ArrayList<Long>(this.accounts.keySet());
    }

    public double getKontostand(long accountNumber) throws AccountNotFoundException {
        if (this.accounts.get(accountNumber) != null) {
            return this.accounts.get(accountNumber).getKontostand();
        } else {
            throw new AccountNotFoundException();
        }
    }

    public void geldEinzahlen(long nummer, double betrag) throws AccountNotFoundException {
        if (this.accounts.get(nummer) != null) {
            this.accounts.get(nummer).einzahlen(betrag);
        } else {
            throw new AccountNotFoundException();
        }
    }

    public boolean geldAbheben(long nummer, double betrag) throws AccountNotFoundException, GesperrtException {
        if (this.accounts.get(nummer) != null) {
            return this.accounts.get(nummer).abheben(betrag);
        } else {
            throw new AccountNotFoundException();
        }
    }

    public boolean geldUeberweisen(long numberFrom, long numberTo, double amount, String zweck) throws AccountNotFoundException, BetrugsversuchException, PoorCustomerException {
        Konto accountFrom = this.accounts.get(numberFrom);
        Konto accountTo = this.accounts.get(numberTo);

        if (accountFrom != null && accountTo != null) {
            if (amount <= 0) {
                throw new BetrugsversuchException();
            }
            if (accountFrom.getKontostand() < amount) {
                throw new PoorCustomerException();
            }
            accountFrom.setKontostand(accountFrom.getKontostand() - amount);
            accountTo.setKontostand(accountTo.getKontostand() + amount);
            return true;
        } else {
            throw new AccountNotFoundException();
        }
    }

    public void bonusAnAlle(double betrag) {
        this.accounts.values().forEach(konto -> konto.setKontostand(konto.getKontostand() + betrag));
    }
}

package bankrechnereien;

import java.math.BigInteger;

/**
 * berechnet testweise eine IBAN
 */
public class IbanMain {
	
	/**
	 * Deutsche IBAN aus der angegebenen Kontonummer und der BLZ
	 * @param kontonummer höchstens 10-stellige Kontonummer
	 * @param blz höchstens 8-stellige Bankleitzahl
	 * @return deutsche IBAN
	 */
	public static String iban(long kontonummer, long blz)
	{
		String zusammen = String.valueOf(blz) + String.valueOf(kontonummer) + "131400";
		BigInteger alsZahl = new BigInteger(zusammen);
		BigInteger rest = alsZahl.remainder(new BigInteger("97"));
		BigInteger substrand = new BigInteger("98");
		BigInteger pruefziffern = substrand.subtract(rest);
		String iban = "DE" + String.format("%02d", pruefziffern)
						+ String.format("%08d", blz)
						+ String.format("%010d", kontonummer);
		return iban;
	}
	
	/**
	 * berechnet testweise eine IBAN
	 * @param args wird nicht verwendet
	 */
	public static void main(String[] args) {
		long kontonummer = 5736345208L;
		long  blz = 50010517;
		System.out.println(iban(kontonummer, blz));
		
	}

}
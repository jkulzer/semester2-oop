import java.util.Arrays;

/**
 * Eine kleine Spielerei mit Arrays, um den Umgang mit Interfaces 
 * zu üben
 */
public class EinigeArrays {

	/**
	 * erzeugt zwei Arrays mit Hilfe von Arrays.setAll
	 * @param args wird nicht verwendet
	 */
	public static void main(String[] args) {
		System.out.println("Die Zahlen von 1 bis 20: ");
		int[] eins = new int[20];
		for(int i = 0; i< eins.length; i++)
		{
			eins[i] = i + 1;
		}
		System.out.println(Arrays.toString(eins));
		
		System.out.println("Die Zweierpotenzen von 2 hoch 0 bis 2 hoch 19:");
		double[] zwei = new double[20];
		for(int i = 0; i< zwei.length; i++)
		{
			zwei[i] = Math.pow(2, i);
		}
		System.out.println(Arrays.toString(zwei));
	}

}

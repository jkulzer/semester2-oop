import java.awt.print.*;

/**
 * druckt ein EinText-Objekt aus
*/
public class Ausdruck {
	/**
	 * druckt ein EinText-Objekt aus
	*/
	public static void main(String[] args) throws PrinterException {
		PrinterJob pjob = PrinterJob.getPrinterJob();
		EinText zuDruckenderText = new EinText();
		pjob.setPrintable(zuDruckenderText);
		if ( pjob.printDialog() == false ) {
			return;
		}
		pjob.print();
	}
}

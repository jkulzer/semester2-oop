import java.awt.Font;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

/**
 * Text mit zwei Seiten, der ausgedruckt werden soll
*/
public class EinText implements Printable {
	/** Text für Seite 1  im Ausdruck
	*/
	private String textAufSeite1 = "Ein langer langer Text...";
	/** Text für Seite 2  im Ausdruck
	*/
	private String textAufSeite2 = "Und noch was Geschriebenes...";
	
	/**
	 * "druckt" den text in die Seite hinein, die vom übergebenen
	 * graphics-Objekt dargestellt wird
	 * @param text der zu schreibenden Text
	 * @param graphics eine auszudruckende Seite, nicht null
	*/
	private void schreiben(Graphics graphics, String text) {
		graphics.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		graphics.drawString(text, 100, 120);
	}

	public int print(Graphics graphics, PageFormat  pageFormat, int pageIndex) throws PrinterException {
		if (pageIndex > 1 || pageIndex < 0) {
			return NO_SUCH_PAGE;
		} else {
			if (pageIndex == 0) {
				schreiben(graphics, textAufSeite1);
			} else if (pageIndex == 1) {
				schreiben(graphics, textAufSeite2);
			}
			return PAGE_EXISTS;
		}
	}
}

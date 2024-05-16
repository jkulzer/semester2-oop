package interfacebenutzung;

import java.math.BigDecimal;

/**
 * vergleicht BigDecimals aufsteigend nach ihrem Scale
 */
public class BigDecimalVergleicher implements Vergleicher {

	@Override
	public int vergleichen(Object a, Object b) {
		if (a instanceof BigDecimal && b instanceof BigDecimal)
			return ((BigDecimal) a).scale() - ((BigDecimal) b).scale();
		throw new IllegalArgumentException();
	}

}

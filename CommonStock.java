package Test.JPMorgan;

import java.math.BigDecimal;

public class CommonStock extends Stock implements IStock {

	CommonStock(String symbol, BigDecimal lastDividend, BigDecimal parValue) {
		super(symbol, lastDividend, parValue);
	}
	
	public BigDecimal CalculateDividendYield(BigDecimal tickerPrice) {
		BigDecimal dividendYield = lastDividend.divide(tickerPrice);
		return dividendYield;
	}
	
	public BigDecimal CalculatePeRatio(BigDecimal tickerPrice) {
		BigDecimal dividend = lastDividend;
		BigDecimal peRatio = tickerPrice.divide(dividend);
		return peRatio;
	}
}

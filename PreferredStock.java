package Test.JPMorgan;

import java.math.BigDecimal;

public class PreferredStock extends Stock implements IStock {
	BigDecimal fixedDividend; //Assumption 1% stored as 0.01
	BigDecimal dividend;
	
	PreferredStock(String symbol, BigDecimal lastDividend, BigDecimal parValue, BigDecimal fixedDividend) {
		super(symbol, lastDividend, parValue);
		this.fixedDividend = fixedDividend;
		this.dividend = fixedDividend.multiply(parValue);
	}
	
	public BigDecimal CalculateDividendYield(BigDecimal tickerPrice) {
		BigDecimal dividendYield = dividend.divide(tickerPrice);
		return dividendYield;
	}

	public BigDecimal CalculatePeRatio(BigDecimal tickerPrice) {
		BigDecimal peRatio = tickerPrice.divide(dividend);
		return peRatio;
	}
}

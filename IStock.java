package Test.JPMorgan;

import java.math.BigDecimal;

public interface IStock {
	public BigDecimal CalculateDividendYield(BigDecimal tickerPrice);
	
	public BigDecimal CalculatePeRatio(BigDecimal tickerPrice);
	
	public void NewTrade(Trade trade);
	
	public BigDecimal CalculateStockPrice(int period);
}
